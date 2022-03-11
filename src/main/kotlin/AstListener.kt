import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.TypeSpec
import java.util.Map

class AstListener(val parser: CppLangParser?, val fileName: String) : CppLangBaseListener() {
    private val uppercaseMap = Map.of("void", "Unit", "int", "Int", "double", "Double", "float", "Float")
    private val ignoreClassNameList = listOf("std","uint32")
    private var convertedCode: StringBuilder = StringBuilder()
    val file = FileSpec.builder("", fileName)
    var currentClassName = ""
    var currentClass: ClassEntity? = null
    var currentTypeSpec: TypeSpec.Builder? = null
    var returnTypeSpec: TypeSpec? = null
    var privateAccess: String? = null

    companion object {
        const val TODO_STRING = "{\n\t// TODO\n}\n"
    }

    fun getConvertedCode(): String {
        return convertedCode.toString()
    }

    fun getConvertedCodeWithPoet(): FileSpec {
        if (returnTypeSpec == null) {
            returnTypeSpec = currentTypeSpec!!.build()
            file.addType(
                returnTypeSpec!!
            )
        }
        val returnValue = file.build()
        println()
        return returnValue
    }

    fun checkIfMethodInClass(ctx: CppLangParser.FunctionDefinitionContext): Boolean {
//        println("-----")
//        println(ctx.parent.javaClass)
//        println(ctx.parent.parent.javaClass)
//        println(ctx.parent.parent.parent.javaClass)
//        println(ctx.parent.parent.parent.getChild(0).getChild(1).javaClass)
//        println(ctx.parent.parent.parent.getChild(0).getChild(1).text)
//        println(ctx.parent.parent.parent.getChild(3).text)
//        println(ctx.parent.parent.parent.getChild(3).parent.javaClass)
//        println("-----")
        val classHeadName = ctx.parent.parent.parent.getChild(0).getChild(1)
        return classHeadName is CppLangParser.ClassHeadNameContext

    }

    override fun enterFunctionDefinition(ctx: CppLangParser.FunctionDefinitionContext) {
        println("~~~~~~~")
//        println(ctx.childCount) //3
//        println(ctx.getChild(0).text) // inline void
//        println(ctx.getChild(1).text) // operator+=(uint32size)
        //println(ctx.declarator().text)
        //println(ctx.declSpecifierSeq().text)
        if (ctx.getChild(1).text.contains("operator") && ctx.getChild(0).getChild(1)!=null) {// Обработка операторов
            println("_operator_")
            println(ctx.getChild(0).text) // inline void
            println(ctx.getChild(0).getChild(0).text)
            //println(ctx.getChild(0).getChild(1).text)
            println(ctx.getChild(1).text) // operator+=(uint32size)
            println(ctx.getChild(1).childCount)
            println(ctx.getChild(2).text)
            println(ctx.declarator().text)
            println(ctx.declSpecifierSeq().text)
            val operatorFunction = FunctionEntity()
            operatorFunction.isFunction = false
            operatorFunction.operatorArguments =
                ctx.getChild(1).text.substring(ctx.getChild(1).text.indexOfFirst { it == '(' }+1,
                    ctx.getChild(1).text.indexOfFirst { it == ')' })
            val operatorSign = ctx.getChild(1).text.substring(8, ctx.getChild(1).text.indexOfFirst { it == '(' })
            operatorFunction.operator = when(operatorSign){
                "+"->"plus"
                "-"->"minus"
                "-="->"minusAssign"
                "+="->"plusAssign"
                "=="->"equals"
                "!="->"equals"
                else -> operatorSign
            }
            operatorFunction.returnType = uppercaseMap.getOrDefault(ctx.getChild(0).getChild(1).text, "Any?")
            operatorFunction.operatorBody = ctx.getChild(2).text
            currentClass!!.methodsInClass.add(operatorFunction)

        } else {
            println("_function_")
            println(ctx.getChild(0).text)
            println(ctx.getChild(0).getChild(0).text)
            //println(ctx.getChild(0).getChild(1).text)
            println(ctx.getChild(1).text)
            println(ctx.getChild(1).childCount)
            println(ctx.getChild(2).text)
            println(ctx.declarator().text)
            println(ctx.declSpecifierSeq().text)
            val returnType = ctx.getChild(0).text.trim { it <= ' ' }.replace("inline","")
            val funName =
                if (ctx.getChild(1).text[ctx.getChild(1).text.length - 2] == '(') ctx.getChild(1).text else removeMethodParameters(
                    ctx.getChild(1).text
                ).replace("()", "")
            if (checkIfMethodInClass(ctx)) {
                val function = FunctionEntity()
                function.funName = funName.replace("()", "")
                function.returnType = uppercaseMap.getOrDefault(returnType, "Any")
                currentClass!!.methodsInClass.add(function)
            }
            println("fun: $funName")
            println("returnType: $returnType")

        }
        println("~~~~~~~")
        //println(ctx.parent.parent.parent.getChild(0).getChild(1).text) // Получение имени клсаа, в котором находится метод

    }


    override fun exitFunctionBody(ctx: CppLangParser.FunctionBodyContext?) {
        if (currentClass!!.methodsInClass.size > 0) {
            val function = currentClass!!.methodsInClass.last()
            if(function.isFunction){
                currentTypeSpec!!.addFunction(
                    FunSpec.builder(function.funName)
                        .addModifiers(
                            when (privateAccess) {
                                "private" -> KModifier.PRIVATE
                                else -> KModifier.PUBLIC
                            }
                        )
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
                )
            }else{ // Если оператор
                currentTypeSpec!!.addFunction(
                    FunSpec.builder(function.funName)
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
                )
            }
            privateAccess = null
        }
    }


    override fun enterClassName(ctx: CppLangParser.ClassNameContext) {
        // Проверяем, метод какого класса используется
        // Если стандартная библиотека, то пропускаем
        if (!ignoreClassNameList.contains(ctx.getChild(0).text)) { // TODO: проходит проверку, если объект небиблиотечного класса указан как параметр метода/оператора
            if (currentClass != null) {
                returnTypeSpec = currentTypeSpec!!.build()
                file.addType(
                    returnTypeSpec!!
                )
            }
            currentClass = ClassEntity()
            val name = ctx.getChild(0).text
            currentClass!!.name = name
            currentTypeSpec = TypeSpec.classBuilder(currentClass!!.name)


            println("className: " + ctx.getChild(0).text)
            println(ctx.getChild(0).childCount)
        }
    }

    override fun enterClassSpecifier(ctx: CppLangParser.ClassSpecifierContext) {
        println("classSpecifier: " + ctx.text)
        //parseClass(ctx)
//        println("Head child count: " + ctx.childCount)
//        println("\tchild 0 text: " + ctx.getChild(0).text)
//        println("\tchild 1 text: " + ctx.getChild(1).text)
//        println("\tchild 2 text: " + ctx.getChild(2).text)
//        println("\t\tchild: " + ctx.getChild(2).getChild(0).text)
//        //println("\t\tchild: "+ctx.getChild(2).getChild(1) .text) == null
//        println("\tchild 3 text: " + ctx.getChild(3).text)
//        println(ctx.getChild(2).toStringTree(this.parser))
    }

    override fun enterClassHead(ctx: CppLangParser.ClassHeadContext) {// TODO: ctx.classKey().text
        //println("classHead: "+ )
    }

    override fun enterConstructorInitializer(ctx: CppLangParser.ConstructorInitializerContext?) {
        super.enterConstructorInitializer(ctx)
        println("constr Init: ${ctx!!.text}")
        println("constr Init 0: ${ctx.getChild(0).text}")
        println("constr Init 1: ${ctx.getChild(1).text}")
    }

    override fun enterAccessSpecifier(ctx: CppLangParser.AccessSpecifierContext?) {
        super.enterAccessSpecifier(ctx)
        println("AccessSpecifier: ${ctx!!.text}")
        if (ctx.text == "private") {
            privateAccess = "private"
        }
    }

    override fun enterOperatorFunctionId(ctx: CppLangParser.OperatorFunctionIdContext?) {
        super.enterOperatorFunctionId(ctx)
        println("OperatorFunctionId: ${ctx!!.text}")
        println("OperatorFunctionId 0: ${ctx.getChild(0).text}")
        println("OperatorFunctionId 1: ${ctx.getChild(1).text}")

    }


    private fun removeMethodParameters(methodDecl: String): String {
        if (methodDecl.contains("(") and methodDecl.contains(")") and !methodDecl.contains("operator")) {
            println("method decl: $methodDecl")
            val firstBracketIndex: Int = methodDecl.indexOfFirst { it == '(' }
            val secondBracketIndex = methodDecl.indexOfFirst { it == ')' }
            return methodDecl.removeRange(firstBracketIndex + 1, secondBracketIndex)
        }
        return ""
    }
}


