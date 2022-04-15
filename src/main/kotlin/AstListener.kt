import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec

import org.jetbrains.kotlin.cli.common.environment.setIdeaIoUseFallback
import utils.createClassWithPoet
import utils.makeRightClassName
import java.util.Map
import java.util.logging.Level
import java.util.logging.Logger
import javax.script.ScriptEngineManager
import kotlin.reflect.full.primaryConstructor


class AstListener(val parser: CppLangParser?, val fileName: String) : CppLangBaseListener() {
    private val uppercaseMap =
        Map.of("void", "Unit", "int", "Int", "double", "Double", "float", "Float", "Object", "Any", "bool", "Boolean","uint32",
                "Int")
    private val ignoreClassNameList = listOf("std", "uint32")
    private var convertedCode: StringBuilder = StringBuilder()
    val file = FileSpec.builder("", fileName)
    var currentClass: ClassEntity? = null
    var currentTypeSpec: TypeSpec.Builder? = null
    var privateAccess: String? = null

    companion object {
        const val TODO_STRING = "{\n\t// TODO\n}\n"
    }

    fun getConvertedCode(): String {
        return convertedCode.toString()
    }

    fun getConvertedCodeWithPoet(): FileSpec {
        val LOGGER: Logger = LoggingUtils.LOGGER
        LOGGER.log(Level.INFO, "Ended conversion")
        return file.build()
    }

    private fun checkIfMethodInClass(ctx: CppLangParser.FunctionDefinitionContext): Boolean {
        val classHeadName = ctx.parent.parent.parent.getChild(0).getChild(1)
        return classHeadName is CppLangParser.ClassHeadNameContext
    }

    override fun enterFunctionDefinition(ctx: CppLangParser.FunctionDefinitionContext) {
        if (ctx.getChild(1).text.contains("operator") && ctx.getChild(0).getChild(1) != null) {// Обработка операторов
            val operatorFunction = FunctionEntity()
            operatorFunction.isFunction = false
            operatorFunction.operatorArguments =
                ctx.getChild(1).text.substring(ctx.getChild(1).text.indexOfFirst { it == '(' } + 1,
                    ctx.getChild(1).text.indexOfFirst { it == ')' })
            val operatorSign = ctx.getChild(1).text.substring(8, ctx.getChild(1).text.indexOfFirst { it == '(' })
            operatorFunction.funName = when (operatorSign) {
                "+" -> "plus"
                "-" -> "minus"
                "-=" -> "minusAssign"
                "+=" -> "plusAssign"
                "==" -> "equals"
                "!=" -> "equals"
                else -> operatorSign
            }
            val returnType = ctx.getChild(0).getChild(1).text
            operatorFunction.returnType = uppercaseMap.getOrDefault(returnType, makeRightClassName(returnType))
            operatorFunction.operatorBody = ctx.getChild(2).text
            currentClass!!.methodsInClass.add(operatorFunction)

        } else {
            val returnTypeInCpp = ctx.getChild(0).text.trim { it <= ' ' }.replace("inline", "")
            val returnType = uppercaseMap.getOrDefault(returnTypeInCpp, makeRightClassName(returnTypeInCpp))
            val funName =
                if (ctx.getChild(1).text[ctx.getChild(1).text.length - 2] == '(') ctx.getChild(1).text else removeMethodParameters(
                    ctx.getChild(1).text
                ).replace("()", "")
            if (checkIfMethodInClass(ctx)) {
                val function = FunctionEntity()
                function.funName = funName.replace("()", "")
                function.returnType = returnType
                currentClass!!.methodsInClass.add(function)
            }
        }
    }

    override fun enterParameterDeclaration(ctx: CppLangParser.ParameterDeclarationContext?) {
        var argsType = ctx!!.getChild(0).text
        if(argsType.contains("const")){
            val first = ctx.getChild(0).getChild(0).text
            argsType = ctx.getChild(0).getChild(1).text
        }
        argsType = uppercaseMap.getOrDefault(argsType, makeRightClassName(argsType))
        val argName = ctx.getChild(1).text
        currentClass!!.methodsInClass.last().arguments[argName] = argsType
    }

    override fun exitFunctionBody(ctx: CppLangParser.FunctionBodyContext?) {
        if (currentClass!!.methodsInClass.size > 0) {
            val function = currentClass!!.methodsInClass.last()
            if (function.isFunction) {
                val function = FunSpec.builder(function.funName)
                    .returns(
                        when (function.returnType) {
                            "Int" -> Int::class
                            "String" -> String::class
                            "Float" -> Float::class
                            "Double" -> Double::class
                            "Boolean" -> Boolean::class
                            "Unit" -> Unit::class
                            else -> Any::class
                        }
                    )
                    .build()
                val str = function.toString()
                currentTypeSpec!!.addFunction(
                    function
                )
            } else {
                currentTypeSpec!!.addFunction(
                    FunSpec.builder(function.funName)
                        .addParameter(
                            function.arguments.keys.first().replace("&",""),
                            when (function.arguments[function.arguments.keys.first()]) {
                                "Int" -> Int::class
                                "String" -> String::class
                                "Float" -> Float::class
                                "Double" -> Double::class
                                "Boolean" -> Boolean::class
                                "Unit" -> Unit::class
                                "Any" -> Any::class
                                else -> tryToResolveType(function.arguments[function.arguments.keys.first()]!!).kotlin
                            }
                        )
                        .addStatement("\t//returns ${function.returnType}\n//${function.operatorBody!!}", String::class)
                        .returns(
                            when (function.returnType) {
                                "Int" -> Int::class
                                "String" -> String::class
                                "Float" -> Float::class
                                "Double" -> Double::class
                                "Boolean" -> Boolean::class
                                "Unit" -> Unit::class
                                "Any" -> Any::class
                                else -> try {
                                    val obj = ClassLoader.getSystemClassLoader()
                                        .loadClass("${function.returnType}").kotlin.primaryConstructor!!.call()
                                    obj.javaClass.kotlin
                                } catch (e: ClassNotFoundException) {
                                    val classAsString = createClassWithPoet(function.returnType).replace("public", "")
                                    val classLoader = Thread.currentThread().contextClassLoader
                                    val engineManager = ScriptEngineManager(classLoader)
                                    setIdeaIoUseFallback()
                                    val ktsEngine: javax.script.ScriptEngine? =
                                        engineManager.getEngineByExtension("kts")
                                    ktsEngine!!.eval(classAsString)
                                    val ret = ktsEngine.eval("${function.returnType}()")
                                    ret::class
                                }
                            }
                        )
                        .build()
                )
            }
            privateAccess = null
        }
    }

    private fun tryToResolveType(type:String):Class<*> {
        try {
            val obj = ClassLoader.getSystemClassLoader()
                .loadClass(type).kotlin.primaryConstructor!!.call()
            return obj.javaClass
        } catch (e: ClassNotFoundException) {
            val classAsString = createClassWithPoet(type).replace("public", "")
            val classLoader = Thread.currentThread().contextClassLoader
            val engineManager = ScriptEngineManager(classLoader)
            setIdeaIoUseFallback()
            val ktsEngine: javax.script.ScriptEngine? =
                engineManager.getEngineByExtension("kts")
            ktsEngine!!.eval(classAsString)
            val ret = ktsEngine.eval("${type}()")
            return ret.javaClass
        }
    }

    override fun enterClassSpecifier(ctx: CppLangParser.ClassSpecifierContext) {
        val className = makeRightClassName(ctx.getChild(0).getChild(1).text)
        if (!ignoreClassNameList.contains(className)) {
            currentClass = ClassEntity()
            currentClass!!.name = className
            currentTypeSpec = TypeSpec.classBuilder(className)
        }
    }

    override fun exitClassSpecifier(ctx: CppLangParser.ClassSpecifierContext?) {
        file.addType(
            currentTypeSpec!!.build()
        )
    }

    override fun enterAccessSpecifier(ctx: CppLangParser.AccessSpecifierContext?) {
        if (ctx!!.text == "private") {
            privateAccess = "private"
        }
    }



    private fun removeMethodParameters(methodDecl: String): String {
        if (methodDecl.contains("(") and methodDecl.contains(")") and !methodDecl.contains("operator")) {
            val firstBracketIndex: Int = methodDecl.indexOfFirst { it == '(' }
            val secondBracketIndex = methodDecl.indexOfFirst { it == ')' }
            return methodDecl.removeRange(firstBracketIndex + 1, secondBracketIndex)
        }
        return ""
    }
}


