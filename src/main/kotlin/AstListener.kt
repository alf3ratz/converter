import CppLangParser.ParameterDeclarationContext
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec
import utils.makeRightClassName
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.reflect.full.primaryConstructor

class AstListener(val parser: CppLangParser?, val fileName: String) : CppLangBaseListener() {
    private val uppercaseMap =
        mapOf(Pair("void", "Unit"), Pair("int", "Int"), Pair("double", "Double"),
            Pair("float", "Float"), Pair("Object", "Any"), Pair("bool", "Boolean"),
            Pair("long", "Int"), Pair("int32_t", "Int"), Pair("int64_t", "Long"))
    private val ignoreClassNameList = listOf("std", "uint32")
    private var convertedCode: StringBuilder = StringBuilder()
    val file = FileSpec.builder("", fileName)
    var currentClass: ClassEntity? = null
    var currentTypeSpec: TypeSpec.Builder? = null
    var privateAccess: String? = null
    var currentFunction: FunSpec.Builder? = null

    companion object {
        const val TODO_STRING = "{\n\t// TODO\n}\n"
    }

    fun getConvertedCode(): String {
        return convertedCode.toString()
    }

    fun getConvertedCodeWithPoet(): FileSpec {
        val returnValue = file.build()
        return returnValue
    }

    private fun checkIfMethodInClass(ctx: CppLangParser.FunctionDefinitionContext): Boolean {
        val classHeadName = ctx.parent.parent.parent.getChild(0).getChild(1)
        return classHeadName is CppLangParser.ClassHeadNameContext
    }

    private fun stringToType(str: String) = when (str) {
        "Int" -> Int::class
        "Long" -> Long::class
        "String" -> String::class
        "Float" -> Float::class
        "Double" -> Double::class
        "Boolean" -> Boolean::class
        "Unit" -> Unit::class
        else -> Any::class
    }

    private fun parseType(str: String): String = uppercaseMap.getOrDefault(str, makeRightClassName(str))

    override fun enterParameterDeclaration(ctx: ParameterDeclarationContext) {
        val type = parseType(ctx.getChild(0).text)
        val name = ctx.getChild(1).text
        if (currentClass != null && currentClass!!.methodsInClass.size > 0)
            currentClass!!.methodsInClass.last().arguments += Pair(type, name)
        else
            currentFunction!!.addParameter(name, stringToType(type))
    }

    override fun exitParameterDeclaration(ctx: ParameterDeclarationContext) {}

    override fun enterFunctionDefinition(ctx: CppLangParser.FunctionDefinitionContext) {
        if (ctx.getChild(1).text.contains("operator") && ctx.getChild(0) != null) {
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
            val returnType = ctx.getChild(0).text
            operatorFunction.returnType = parseType(returnType)
            operatorFunction.operatorBody = ctx.getChild(2).text
            currentClass!!.methodsInClass.add(operatorFunction)
        } else {
            val returnTypeInCpp = ctx.getChild(0).text.trim { it <= ' ' }.replace("inline", "")
            val returnType = parseType(returnTypeInCpp)
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
            else {
                currentFunction = FunSpec.builder(funName.replace("()", "")).returns(stringToType(returnType))
            }
        }
    }

    override fun exitFunctionBody(ctx: CppLangParser.FunctionBodyContext?) {
        if (currentClass != null && currentClass!!.methodsInClass.size > 0) {
            val function = currentClass!!.methodsInClass.last()
            if (function.isFunction) {
                var func = FunSpec.builder(function.funName)
                    .returns(stringToType(function.returnType))
                function.arguments.forEach {
                    func = func.addParameter(it.value, stringToType(it.key))
                }
                currentTypeSpec!!.addFunction(func.build())
            } else {
                var func = FunSpec.builder(function.funName)
                        //.addStatement("\t//returns ${function.returnType}\n//${function.operatorBody!!}", String::class)
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
                                    val obj = ClassLoader.getSystemClassLoader().loadClass(function.returnType).kotlin.primaryConstructor!!.call()
                                    obj.javaClass.kotlin
                                } catch (e: ClassNotFoundException) {
                                    Any::class
                                }
                            }
                        )
                function.arguments.forEach {
                    func = func.addParameter(it.value, stringToType(it.key))
                }
                currentTypeSpec!!.addFunction(func.build())
            }
            privateAccess = null
        }
        else {
            file.addFunction(currentFunction!!.build())
            currentFunction = null
        }
    }

    private fun createClassWithPoet(className: String) {
        val newClass = FileSpec.builder("", className)
        newClass.addType(
            TypeSpec.classBuilder(className)
                //.addModifiers(KModifier.DATA)
                .primaryConstructor(
                    FunSpec.constructorBuilder()
                        .build()
                )
                .build()
        )
        val cls = newClass.build()
        val path = Paths.get("").toAbsolutePath().toString()
        cls.writeTo(Path.of("$path\\src\\main\\kotlin"))
//        var tmp = cls.toString()*
//        cls.
//        cls.writeTo(StringBuilder().append(cls.toString()))
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
        currentClass = null
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


