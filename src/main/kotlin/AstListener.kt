import com.lordcodes.turtle.shellRun
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.TypeSpec

import org.jetbrains.kotlin.cli.common.environment.setIdeaIoUseFallback
import org.jetbrains.kotlin.utils.addToStdlib.safeAs
import utils.createClassWithPoet
import utils.makeRightClassName
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.util.Map
import javax.script.ScriptEngineManager
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType


class AstListener(val parser: CppLangParser?, val fileName: String) : CppLangBaseListener() {
    private val uppercaseMap =
        Map.of("void", "Unit", "int", "Int", "double", "Double", "float", "Float", "Object", "Any", "bool", "Boolean")
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
        return file.build()
    }

    fun checkIfMethodInClass(ctx: CppLangParser.FunctionDefinitionContext): Boolean {
        val classHeadName = ctx.parent.parent.parent.getChild(0).getChild(1)
        return classHeadName is CppLangParser.ClassHeadNameContext

    }

    override fun enterFunctionDefinition(ctx: CppLangParser.FunctionDefinitionContext) {
        if (ctx.getChild(1).text.contains("operator") && ctx.getChild(0).getChild(1) != null) {// Обработка операторов
            //println("_operator_")
//            println(ctx.getChild(0).text) // inline void
//            println(ctx.getChild(0).getChild(0).text)
//            //println(ctx.getChild(0).getChild(1).text)
//            println(ctx.getChild(1).text) // operator+=(uint32size)
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
            //  println("_function_")
            val returnTypeInCpp = ctx.getChild(0).text.trim { it <= ' ' }.replace("inline", "")
            val returnType = uppercaseMap.getOrDefault(returnTypeInCpp, makeRightClassName(returnTypeInCpp))
            val funName =
                if (ctx.getChild(1).text[ctx.getChild(1).text.length - 2] == '(') ctx.getChild(1).text else removeMethodParameters(
                    ctx.getChild(1).text
                ).replace("()", "")
            if (checkIfMethodInClass(ctx)) {
                val function = FunctionEntity()
                function.funName = funName.replace("()", "")
                function.returnType = returnType//"Any"
                currentClass!!.methodsInClass.add(function)
            }
            //  println("fun: $funName")
            //  println("returnType: $returnType")

        }
        //println(ctx.parent.parent.parent.getChild(0).getChild(1).text) // Получение имени клсаа, в котором находится метод

    }

    override fun enterSimpleDeclaration(ctx: CppLangParser.SimpleDeclarationContext?) {
//                println("~~~~ enterSimpleDeclaration ~~~~")// w=w+size; w=w+size; // TODO: распарсить тело метода здесь!!!
//        println(ctx!!.text)
//        println(ctx.getChild(0).text)
//        println("~~~~~~~~")
    }

    override fun enterParameterDeclaration(ctx: CppLangParser.ParameterDeclarationContext?) {
        println("~~~~ enterParameterDeclaration ~~~~")
        println(ctx!!.text)
        println(ctx.getChild(0).text)
        println(ctx.getChild(1).text)
        //println(ctx.parent::class)
        println("~~~~~~~~")
    }


    override fun enterDeclarationStatement(ctx: CppLangParser.DeclarationStatementContext?) {
//                println("~~~~ enterDeclarationStatement ~~~~") // w=w+size; w=w+size; // TODO: распарсить тело метода здесь!!!
//        println(ctx!!.text)
//        println(ctx.getChild(0).text)
//        println("~~~~~~~~")
    }

    override fun enterFunctionBody(ctx: CppLangParser.FunctionBodyContext?) {
//        println("~~~~fun body ~~~~")
//        println(ctx!!.text)
//        println(ctx.getChild(0).text)

    }

    override fun exitFunctionBody(ctx: CppLangParser.FunctionBodyContext?) {
        if (currentClass!!.methodsInClass.size > 0) {
            val function = currentClass!!.methodsInClass.last()
            if (function.isFunction) {
                //  println("добавил функцию")
                val function = FunSpec.builder(function.funName)
//                        .addModifiers(
//                            when (privateAccess) {
//                                "private" -> KModifier.PRIVATE
//                                else -> KModifier.PUBLIC
//                            }
//                        )
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
            } else { // Если оператор
                //  println("добавил оператор")
                //val cls: Class<*> = Class.forName(function.returnType);
                //val stringClass: KClass<out String> = cls
                val contentToString = MemberName("kotlin.collections", "contentToString")
                currentTypeSpec!!.addFunction(
                    FunSpec.builder(function.funName)
                        .addParameter(function.operatorArguments!!, String::class)
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
                                    val classAsString = createClassWithPoet(function.returnType).replace("public","")
                                    val classLoader = Thread.currentThread().contextClassLoader
                                    val engineManager = ScriptEngineManager(classLoader)
                                    setIdeaIoUseFallback()
                                    val ktsEngine: javax.script.ScriptEngine? = engineManager.getEngineByExtension("kts")
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



    override fun enterClassName(ctx: CppLangParser.ClassNameContext) {
//        // Проверяем, метод какого класса используется
//        // Если стандартная библиотека, то пропускаем
//        if (!ignoreClassNameList.contains(ctx.getChild(0).text)) { // TODO: проходит проверку, если объект небиблиотечного класса указан как параметр метода/оператора
//            if (currentClass != null) {
//                returnTypeSpec = currentTypeSpec!!.build()
//                file.addType(
//                    returnTypeSpec!!
//                )
//            }
//            currentClass = ClassEntity()
//            val name = ctx.getChild(0).text
//            currentClass!!.name = name
//            currentTypeSpec = TypeSpec.classBuilder(currentClass!!.name)
//
//
//            println("className: " + ctx.getChild(0).text)
//            println(ctx.getChild(0).childCount)
//        }
    }

    override fun enterClassSpecifier(ctx: CppLangParser.ClassSpecifierContext) {
        // println("~~~~~~~~ classSpecifier ~~~~~~~~~~")
        //  println("header ${ctx.getChild(0).getChild(1).text}")
        // Проверяем, метод какого класса используется
        // Если стандартная библиотека, то пропускаем
        val className = makeRightClassName(ctx.getChild(0).getChild(1).text)
        if (!ignoreClassNameList.contains(className)) { // TODO: проходит проверку, если объект небиблиотечного класса указан как параметр метода/оператора
            currentClass = ClassEntity()
            currentClass!!.name = className
            currentTypeSpec = TypeSpec.classBuilder(className)
        }
    }

    override fun exitClassSpecifier(ctx: CppLangParser.ClassSpecifierContext?) {
        file.addType(
            currentTypeSpec!!.build()
        )
        // println("добавил класс")
        //  println("~~~~~~~~ exit classSpecifier ~~~~~~~~")
    }

    override fun enterClassHead(ctx: CppLangParser.ClassHeadContext) {// TODO: ctx.classKey().text
        //println("classHead: "+ )
    }

    override fun enterConstructorInitializer(ctx: CppLangParser.ConstructorInitializerContext?) {
        super.enterConstructorInitializer(ctx)
//        println("constr Init: ${ctx!!.text}")
//        println("constr Init 0: ${ctx.getChild(0).text}")
//        println("constr Init 1: ${ctx.getChild(1).text}")
    }

    override fun enterAccessSpecifier(ctx: CppLangParser.AccessSpecifierContext?) {
        super.enterAccessSpecifier(ctx)
        //println("AccessSpecifier: ${ctx!!.text}")
        if (ctx!!.text == "private") {
            privateAccess = "private"
        }
    }

    override fun enterOperatorFunctionId(ctx: CppLangParser.OperatorFunctionIdContext?) {
        super.enterOperatorFunctionId(ctx)
//        println("OperatorFunctionId: ${ctx!!.text}")
//        println("OperatorFunctionId 0: ${ctx.getChild(0).text}")
//        println("OperatorFunctionId 1: ${ctx.getChild(1).text}")

    }


    private fun removeMethodParameters(methodDecl: String): String {
        if (methodDecl.contains("(") and methodDecl.contains(")") and !methodDecl.contains("operator")) {
            //println("method decl: $methodDecl")
            val firstBracketIndex: Int = methodDecl.indexOfFirst { it == '(' }
            val secondBracketIndex = methodDecl.indexOfFirst { it == ')' }
            return methodDecl.removeRange(firstBracketIndex + 1, secondBracketIndex)
        }
        return ""
    }
}


