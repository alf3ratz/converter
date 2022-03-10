import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec
import org.antlr.v4.runtime.tree.ParseTree
import java.util.Map

class AstListener(val parser: CppLangParser?) : CppLangBaseListener() {
    private val uppercaseMap = Map.of("void", "Unit", "int", "Int", "double", "Double", "float", "Float")
    private val ignoreClassNameList = listOf("std")
    private var convertedCode: StringBuilder = StringBuilder()
    val file = FileSpec.builder("", "TestWithPoet")
    var currentClassName = ""
    var currentClass: ClassEntity? = null
    var currentTypeSpec: TypeSpec.Builder? = null
    var returnTypeSpec:TypeSpec? = null

    companion object {
        const val TODO_STRING = "{\n\t// TODO\n}\n"
    }

    fun getConvertedCode(): String {
        return convertedCode.toString()
    }

    fun getConvertedCodeWithPoet(): FileSpec {
        if(returnTypeSpec == null){
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
        println("-----")
        println(ctx.parent.javaClass)
        println(ctx.parent.parent.javaClass)
        println(ctx.parent.parent.parent.javaClass)
        println(ctx.parent.parent.parent.getChild(0).getChild(1).javaClass)
        println(ctx.parent.parent.parent.getChild(0).getChild(1).text)
        println(ctx.parent.parent.parent.getChild(3).text)
        println(ctx.parent.parent.parent.getChild(3).parent.javaClass)
        println("-----")
        val classHeadName = ctx.parent.parent.parent.getChild(0).getChild(1)
        return classHeadName is CppLangParser.ClassHeadNameContext

    }

    override fun enterFunctionDefinition(ctx: CppLangParser.FunctionDefinitionContext) {
        println(ctx.childCount)
        println(ctx.getChild(0).text)
        println(ctx.getChild(1).text)
        println(ctx.declarator().text)
        println(ctx.declSpecifierSeq().text)
        val returnType = ctx.getChild(0).text.trim { it <= ' ' }
        val funName =
            if (ctx.getChild(1).text[ctx.getChild(1).text.length - 2] == '(') ctx.getChild(1).text else removeMethodParameters(
                ctx.getChild(1).text
            ).replace("()", "")
        if (checkIfMethodInClass(ctx)) {
            val function = MethodEntity()
            function.funName = funName.replace("()","")
            function.returnType = uppercaseMap.getOrDefault(returnType, "Any")
            currentClass!!.methodsInClass.add(function)
        }
        //println(ctx.parent.parent.parent.getChild(0).getChild(1).text) // Получение имени клсаа, в котором находится метод
        println("fun: $funName")
//        file.addFunction(
//            FunSpec.builder(name = funName)
//                //.addParameter("args", String::class, VARARG)
//                .returns(returnType = uppercaseMap.getOrDefault(returnType, returnType)::class)
//                //.addStatement("%T(args[0]).greet()", greeterClass)
//                .build()
//        )
//        convertedCode.append("fun ")
//        convertedCode.append(ctx.getChild(1).text)
//        val returnType = ctx.getChild(0).text.trim { it <= ' ' }
//        convertedCode.append(": " + uppercaseMap.getOrDefault(returnType, returnType) + " ")
//        //convertedCode.append(ctx.getChild(2).getText()) // - внутренности метода
//        convertedCode.append(TODO_STRING)
    }


    override fun exitFunctionBody(ctx: CppLangParser.FunctionBodyContext?) {
        val function = currentClass!!.methodsInClass.last()
        currentTypeSpec!!.addFunction(
            FunSpec.builder(function.funName)
                .returns(
                    when(function.returnType){
                        "Int"->Int::class
                        "String"->String::class
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



    override fun enterClassName(ctx: CppLangParser.ClassNameContext) {
        // Проверяем, метод какого класса используется
        // Если стандартная библиотека, то пропускаем
        if (!ignoreClassNameList.contains(ctx.getChild(0).text)) {
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
//            file.addType(
//                TypeSpec.classBuilder(ctx.getChild(0).text)
//                    .build()
////                    .primaryConstructor(
////                        FunSpec.constructorBuilder()
////                            .addParameter("name", String::class)
////                            .build()
//            )//.build()

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

    fun parseClass(ctx: CppLangParser.ClassSpecifierContext) {
        for (child in ctx.children) {
            println(child.text)
            if (child.childCount > 0) {
                parseChild(child, "\t")
            }
        }
    }

    private fun parseChild(ctx: ParseTree, level: String) {
        for (i in 0..ctx.childCount) {
            println(level + ctx.getChild(i))
            if (ctx.getChild(i).childCount > 0) {
                parseChild(ctx.getChild(i), level)
            }
        }
    }

    private fun removeMethodParameters(methodDecl: String): String {
        val firstBracketIndex: Int = methodDecl.indexOfFirst { it == '(' }
        val secondBracketIndex = methodDecl.indexOfFirst { it == ')' }
        return methodDecl.removeRange(firstBracketIndex + 1, secondBracketIndex)
    }
}


