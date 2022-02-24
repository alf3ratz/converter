import org.antlr.v4.runtime.tree.ParseTree
import java.util.Map

class AstListener(val parser: CppLangParser?) : CppLangBaseListener() {
    private val uppercaseMap = Map.of("void","Unit","int", "Int", "double", "Double", "float", "Float")
    private val ignoreClassNameList  = listOf("std")
    private var convertedCode:StringBuilder = StringBuilder()

    companion object {
        const val TODO_STRING = "{\n\t//TODO\n}\n"
    }

    fun getConvertedCode():String{
        return convertedCode.toString()
    }

    override fun enterFunctionDefinition(ctx: CppLangParser.FunctionDefinitionContext) {
        convertedCode.append("fun ")
        convertedCode.append(ctx.getChild(1).text)
        val returnType = ctx.getChild(0).text.trim { it <= ' ' }
        convertedCode.append(": " + uppercaseMap.getOrDefault(returnType, returnType) + " ")
        //convertedCode.append(ctx.getChild(2).getText()) // - внутренности метода
        convertedCode.append(TODO_STRING)
    }
    override fun enterClassName(ctx: CppLangParser.ClassNameContext) {
        // Проверяем, метод какого класса используется
        // Если стандартная библиотека, то пропускаем
        if(!ignoreClassNameList.contains(ctx.getChild(0).text)){
            println("className: "+ctx.getChild(0).text)
            println(ctx.getChild(0).childCount)
        }
    }
    override fun enterClassSpecifier(ctx: CppLangParser.ClassSpecifierContext) {
        println("classSpecifier: "+ctx.text)
        //parseClass(ctx)
        println("Head child count: "+ctx.childCount)
        println("\tchild 0 text: "+ctx.getChild(0).text)
        println("\tchild 1 text: "+ctx.getChild(1).text)
        println("\tchild 2 text: "+ctx.getChild(2).text)
        println("\t\tchild: "+ctx.getChild(2).getChild(0).text)
        //println("\t\tchild: "+ctx.getChild(2).getChild(1) .text) == null
        println("\tchild 3 text: "+ctx.getChild(3).text)
//        println(ctx.getChild(2).toStringTree(this.parser))
    }
    override fun enterClassHead(ctx: CppLangParser.ClassHeadContext) {// TODO: ctx.classKey().text
        //println("classHead: "+ )
    }

    fun parseClass(ctx: CppLangParser.ClassSpecifierContext){
        for(child in ctx.children){
            println(child.text)
            if(child.childCount>0){
                parseChild(child,"\t")
            }
        }
    }
    private fun parseChild(ctx: ParseTree, level:String){
        for(i in 0..ctx.childCount){
            println(level+ctx.getChild(i))
            if(ctx.getChild(i).childCount>0){
                parseChild(ctx.getChild(i),level)
            }
        }
    }
}

