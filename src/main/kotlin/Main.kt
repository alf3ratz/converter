//import gen.CppLangLexer
//import org.antlr.v4.runtime.CommonTokenStream
//import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import java.io.FileWriter
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path


private fun printUsage(program: String) {
    println(
        """
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Usage: $program [<options>] <cpp.h files>
В наше время можно встретить множество заброшенных открытых проектов на C/C++ для неактуальных платформ. 
Один вариант восстановления таких проектов – переписать их на высокоуровневый язык вроде Kotlin, 
поддерживающий компиляцию во множество современных платформ (JVM, Web, Mobile, Desktop) из коробки.
Кроме содержательной работы вроде перехода на современные фреймворки, 
такое портирование включает большое количество монотонной работы вроде непосредственно переписывания синтаксиса и подходов изначального языка на новый язык. 
Такие задачи можно было бы автоматизировать, создав специальный конвертер, что и предлагается сделать в рамках работы. 
Это не только увеличит скорость портирования проектов, но уменьшит количество монотонных и неинтересных задач у участвующих программистов.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
""".trimIndent()
    )
}

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        printUsage("converter")
        return
    }
    val str = Files.readString(
        Path.of(args[0]),
        StandardCharsets.US_ASCII
    )
    val writer: FileWriter =
        FileWriter(args[1], false)
    val lexer = CppLangLexer(org.antlr.v4.runtime.ANTLRInputStream(str))
    val tokens = CommonTokenStream(lexer)
    val parser = CppLangParser(tokens)
    val tree = parser.translationUnit()
    val walker = ParseTreeWalker()
    val extractor = AstListener(parser)
    walker.walk(extractor, tree)
    writer.write(extractor.getConvertedCode())
    writer.close()


}