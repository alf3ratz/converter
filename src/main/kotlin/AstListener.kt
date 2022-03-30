import CppLangParser.*
import com.squareup.kotlinpoet.*
import utils.makeRightClassName
import java.util.*
import kotlin.reflect.KClass

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
                Pair("unsignedlongint", "UInt"), Pair("uint32_t", "UInt"), Pair("uint_fast32_t", "UInt"),
                Pair("uint_least32_t", "UInt"),
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
    private var accessModifier = KModifier.PUBLIC
    private var code = Stack<String>()

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

    override fun enterAssignmentExpression(ctx: AssignmentExpressionContext) {
        //code.clear()
    }

    override fun enterLiteral(ctx: LiteralContext) {
        code.add(ctx.text)
    }

    override fun exitShiftExpression(ctx: ShiftExpressionContext) {
        if (ctx.childCount == 3) {
            val secondArg = code.pop()
            val firstArg = code.pop()
            val op = if (ctx.getChild(1).text == ">>") "rightShift" else "leftShift"
            code.push("$firstArg $op $secondArg")
        }
    }

    override fun exitMultiplicativeExpression(ctx: MultiplicativeExpressionContext) {
        if (ctx.childCount == 3) {
            val secondArg = code.pop()
            val firstArg = code.pop()
            code.push("$firstArg ${ctx.getChild(1).text} $secondArg")
        }
    }

    override fun exitAdditiveExpression(ctx: AdditiveExpressionContext) {
        if (ctx.childCount == 3) {
            val secondArg = code.pop()
            val firstArg = code.pop()
            code.push("$firstArg ${ctx.getChild(1).text} $secondArg")
        }
    }

    override fun exitJumpStatement(ctx: JumpStatementContext) {
        if (ctx.getChild(0).text == "return")
            currentFunction!!.addStatement("return ${code.pop()}")
    }

    override fun exitAssignmentExpression(ctx: AssignmentExpressionContext) {
        val ctx1 = ctx.parent.parent
        if (ctx1.childCount == 2 && ctx1.getChild(0).text == "=") {
            val ctxType = ctx1.parent.parent.parent.parent.getChild(0)
            val type = stringToType(parseType(ctxType.text.replace("const", "")))
            val constness = if (ctxType.text.contains("const")) "val" else "var"

            val ctxName = ctx1.parent.parent
            val name = ctxName.getChild(0).text.replace("*", "")

            currentFunction!!.addStatement("$constness $name: %T = ${code.pop()}", type)
        }
    }

    override fun exitPrimaryExpression(ctx: PrimaryExpressionContext) {
        if (ctx.childCount == 3)
            code.push("(${code.pop()})")
    }

    override fun enterParameterDeclaration(ctx: ParameterDeclarationContext) {
        val type = stringToType(parseType(ctx.getChild(0).text
            .replace("const", "")))
        val name = ctx.getChild(1).text.replace("&", "")
        if (ctx.getChild(0).text.contains("const")) {
            val constName = "$name\$\$const"
            currentFunction!!.addParameter(constName, type)
            currentFunction!!.addStatement("var $name: %T = `$constName`", type)
        }
        else
            currentFunction!!.addParameter(name, type)
    }

    override fun enterFunctionDefinition(ctx: FunctionDefinitionContext) {
        if (ctx.getChild(1).text.contains("operator") && ctx.getChild(0) != null) {
            val operatorSign = ctx.getChild(1).text.substring(8, ctx.getChild(1).text.indexOfFirst { it == '(' })
            val name = when (operatorSign) {
                "+" -> "plus"
                "-" -> "minus"
                "-=" -> "minusAssign"
                "+=" -> "plusAssign"
                "==" -> "equals"
                "!=" -> "notEquals"
                ">>" -> "rightShift"
                "<<" -> "leftShift"
                else -> operatorSign
            }
            val operatorFunction = FunSpec.builder(name)
            val returnType = ctx.getChild(0).text.replace("inline", "")
            if (name == "rightShift" || name == "leftShift")
                operatorFunction.addModifiers(KModifier.INFIX)
            operatorFunction.returns(stringToType(parseType(returnType)))
            currentClass!!.methodsInClass.add(operatorFunction)
            currentFunction = operatorFunction
        } else {
            val returnTypeInCpp = ctx.getChild(0).text.trim { it <= ' ' }.replace("inline", "")
            val returnType = parseType(returnTypeInCpp)
            val funName =
                if (ctx.getChild(1).text[ctx.getChild(1).text.length - 2] == '(')
                    ctx.getChild(1).text
                else
                    removeMethodParameters(ctx.getChild(1).text).replace("()", "")
            currentFunction = if (checkIfMethodInClass(ctx)) {
                val function = FunSpec.builder(funName.replace("()", ""))
                function.returns(stringToType(returnType))
                currentClass!!.methodsInClass.add(function)
                function
            } else
                FunSpec.builder(funName.replace("()", "")).returns(stringToType(returnType))
        }
    }

    override fun exitFunctionBody(ctx: FunctionBodyContext?) {
        if (currentClass != null && currentClass!!.methodsInClass.size > 0) {
            val function = currentClass!!.methodsInClass.last()
            currentTypeSpec!!.addFunction(function.addModifiers(accessModifier).build())
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

    private fun notEqualsCheck(arr: MutableList<FunSpec>): FunSpec? {
        var containsEq = false
        var notEq: FunSpec? = null
        arr.forEach { func ->
            run {
                if (func.name == "equals")
                    containsEq = true
                if (func.name == "notEquals")
                    notEq = func
            }
        }
        if (containsEq)
            return null
        return notEq
    }

    override fun exitClassSpecifier(ctx: ClassSpecifierContext?) {
        accessModifier = KModifier.PUBLIC
        val notEq = notEqualsCheck(currentTypeSpec!!.funSpecs)
        if (notEq != null) {
            var func = FunSpec.builder("equals").returns(Boolean::class)
            notEq.parameters.forEach { func = func.addParameter(ParameterSpec(it.name, it.type)) }
            currentTypeSpec!!.addFunction(func.build())
        }
        file.addType(currentTypeSpec!!.build())
        currentClass = null
    }

    override fun enterClassHead(ctx: ClassHeadContext) {// TODO: ctx.classKey().text
    }

    override fun enterConstructorInitializer(ctx: ConstructorInitializerContext?) {
        super.enterConstructorInitializer(ctx)
    }

    override fun enterAccessSpecifier(ctx: AccessSpecifierContext) {
        super.enterAccessSpecifier(ctx)
        accessModifier = when (ctx.text) {
            "private" -> KModifier.PRIVATE
            "public"  -> KModifier.PUBLIC
            else      -> KModifier.PROTECTED
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


