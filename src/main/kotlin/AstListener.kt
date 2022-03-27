import CppLangParser.*
import com.squareup.kotlinpoet.*
import utils.makeRightClassName
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

class AstListener(val parser: CppLangParser?, val fileName: String) : CppLangBaseListener() {
    private val uppercaseMap =
        mutableMapOf(Pair("void", "Unit"),
            Pair("int8_t", "Byte"), Pair("int_fast8_t", "Byte"),Pair("int_least8_t", "Byte"),
            Pair("short", "Short"), Pair("shortint", "Short"), Pair("signedshort", "Short"),
                Pair("signedshortint", "Short"), Pair("int16_t", "Short"), Pair("int_fast16_t", "Short"),
                Pair("int_least16_t", "Short"),
            Pair("int", "Int"), Pair("long", "Int"), Pair("longint", "Int"), Pair("signed", "Int"),
                Pair("signedint", "Int"), Pair("signedlongint", "Int"), Pair("signedlong", "Int"),
                Pair("int32_t", "Int"), Pair("int_fast32_t", "Int"),Pair("int_least32_t", "Int"),
            Pair("longlong", "Long"), Pair("signedlonglong", "Long"), Pair("longlongint", "Long"),
                Pair("signedlonglongint", "Long"), Pair("int64_t", "Long"), Pair("int_fast64_t", "Long"),
                Pair("int_least64_t", "Long"),
            Pair("uint8_t", "UByte"), Pair("uint_fast8_t", "UByte"),Pair("uint_least8_t", "UByte"),
            Pair("unsignedshort", "UShort"), Pair("usignedshortint", "UShort"), Pair("uint16_t", "UShort"),
                Pair("uint_fast16_t", "UShort"), Pair("uint_least16_t", "UShort"),
            Pair("unsigned", "UInt"), Pair("unsignedint", "UInt"), Pair("unsignedlong", "UInt"),
                Pair("unsignedlongint", "UInt"), Pair("uint32_t", "UInt"), Pair("uint_fast32_t", "UInt"),Pair("uint_least32_t", "UInt"),
            Pair("unsignedlonglong", "ULong"), Pair("unsignedlonglongint", "ULong"), Pair("uint64_t", "ULong"),
                Pair("uint_fast64_t", "ULong"),Pair("uint_least64_t", "ULong"),
            Pair("double", "Double"),
            Pair("float", "Float"),
            Pair("Object", "Any"),
            Pair("bool", "Boolean"))
    private val ignoreClassNameList = listOf("std", "uint32")
    private var convertedCode: StringBuilder = StringBuilder()
    val file = FileSpec.builder("", fileName)
    private var currentClass: ClassEntity? = null
    private var currentTypeSpec: TypeSpec.Builder? = null
    private var privateAccess: String? = null
    private var currentFunction: FunSpec.Builder? = null

    class NotFound {}

    fun getConvertedCode(): String {
        return convertedCode.toString()
    }

    fun getConvertedCodeWithPoet(): FileSpec {
        return file.build()
    }

    private fun checkIfMethodInClass(ctx: FunctionDefinitionContext): Boolean {
        val classHeadName = ctx.parent.parent.parent.getChild(0).getChild(1)
        return classHeadName is ClassHeadNameContext
    }

    private fun typeToType(type: KClass<*>, str: String) =
        if (type == NotFound::class) createType(str) else type.asTypeName()

    private fun stringToType(str: String) = typeToType(when (str) {
        "Byte" -> Byte::class
        "Short" -> Short::class
        "Int" -> Int::class
        "Long" -> Long::class
        "UByte" -> UByte::class
        "UShort" -> UShort::class
        "UInt" -> UInt::class
        "ULong" -> ULong::class
        "String" -> String::class
        "Float" -> Float::class
        "Double" -> Double::class
        "Boolean" -> Boolean::class
        "Unit" -> Unit::class
        "Any" -> Any::class
        else -> NotFound::class
    }, str)

    override fun enterDeclSpecifier(ctx: DeclSpecifierContext) {
        if (ctx.text == "typedef")
            uppercaseMap[ctx.parent.parent.getChild(1).text] = uppercaseMap[ctx.parent.getChild(1).text]!!
    }

    private fun parseType(str: String): String = uppercaseMap.getOrDefault(str, makeRightClassName(str))

    private fun createType(type: String): ClassName = ClassName("", type)

    override fun enterParameterDeclaration(ctx: ParameterDeclarationContext) {
        val type = parseType(ctx.getChild(0).text.replace("const", ""))
        val name = ctx.getChild(1).text
        if (currentClass != null && currentClass!!.methodsInClass.size > 0)
            currentClass!!.methodsInClass.last().arguments += Pair(name, type)
        else {
            val typeClass = stringToType(type)
            currentFunction!!.addParameter(name, typeClass)
        }
    }

    override fun exitParameterDeclaration(ctx: ParameterDeclarationContext) {}

    override fun enterFunctionDefinition(ctx: FunctionDefinitionContext) {
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
                "!=" -> "notEquals"
                else -> operatorSign
            }
            val returnType = ctx.getChild(0).text.replace("inline", "")
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
                val typeClass = stringToType(returnType)
                currentFunction = FunSpec.builder(funName.replace("()", "")).returns(typeClass)
            }
        }
    }

    override fun exitFunctionBody(ctx: FunctionBodyContext?) {
        if (currentClass != null && currentClass!!.methodsInClass.size > 0) {
            val function = currentClass!!.methodsInClass.last()
            val type = when (function.returnType) {
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
                    NotFound::class
                }
            }
            var func = FunSpec.builder(function.funName)
            func = if (type == NotFound::class)
                func.returns(createType(function.returnType))
            else
                func.returns(type)
            function.arguments.forEach {
                val typeClass = stringToType(it.value)
                func = func.addParameter(it.key, typeClass)
            }
            currentTypeSpec!!.addFunction(func.build())
            privateAccess = null
        }
        else {
            file.addFunction(currentFunction!!.build())
            currentFunction = null
        }
    }

    override fun enterClassName(ctx: ClassNameContext) {
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

    override fun enterClassSpecifier(ctx: ClassSpecifierContext) {
        // Проверяем, метод какого класса используется
        // Если стандартная библиотека, то пропускаем
        val className = makeRightClassName(ctx.getChild(0).getChild(1).text)
        if (!ignoreClassNameList.contains(className)) { // TODO: проходит проверку, если объект небиблиотечного класса указан как параметр метода/оператора
            currentClass = ClassEntity()
            currentClass!!.name = className
            currentTypeSpec = TypeSpec.classBuilder(className)
        }
    }

    private fun notEqualsCheck(arr: ArrayList<FunctionEntity>): FunctionEntity? {
        var containsEq = false
        var notEq: FunctionEntity? = null
        arr.forEach { func ->
            run {
                if (func.funName == "equals")
                    containsEq = true
                if (func.funName == "notEquals")
                    notEq = func
            }
        }
        if (containsEq)
            return null
        return notEq
    }

    override fun exitClassSpecifier(ctx: ClassSpecifierContext?) {
        val notEq = notEqualsCheck(currentClass!!.methodsInClass)
        if (notEq != null) {
            var func = FunSpec.builder("equals").returns(Boolean::class)
            notEq.arguments.forEach { (s, s2) -> func = func.addParameter(ParameterSpec(s, stringToType(s2))) }
            currentTypeSpec!!.addFunction(func.build())
        }
        file.addType(
            currentTypeSpec!!.build()
        )
        currentClass = null
    }

    override fun enterClassHead(ctx: ClassHeadContext) {// TODO: ctx.classKey().text
    }

    override fun enterConstructorInitializer(ctx: ConstructorInitializerContext?) {
        super.enterConstructorInitializer(ctx)
    }

    override fun enterAccessSpecifier(ctx: AccessSpecifierContext?) {
        super.enterAccessSpecifier(ctx)
        if (ctx!!.text == "private") {
            privateAccess = "private"
        }
    }

    override fun enterOperatorFunctionId(ctx: OperatorFunctionIdContext?) {
        super.enterOperatorFunctionId(ctx)
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


