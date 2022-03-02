import kotlinx.cli.*
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
}//C:\\Users\\User1337\\IdeaProjects\\converterw\\testdata\\test.cpp
//C:\\Users\\User1337\\IdeaProjects\\converterw\\resultdata\\testKt.kt

fun main(args: Array<String>) {
    //val argsParser = ArgParser("converter")
    //val input by argsParser.option(ArgType.String, shortName = "i", description = "Input file").required()
    //val output by argsParser.option(ArgType.String, shortName = "o", description = "Output file name")
    //var res = argsParser.parse(args)
    //println(res.commandName)
    if (args.isEmpty()) {
        printUsage("converter")
        return
    }
    val cppCodeAsString = Files.readString(
        Path.of(args[0]),
        StandardCharsets.US_ASCII
    )
    val parser = createParser(cppCodeAsString)
    //writeToFile(args[1], parser)
    writeToFileWithPoet(args[1], parser)
}


fun createParser(cppCodeAsString: String): CppLangParser {
    val lexer = CppLangLexer(org.antlr.v4.runtime.ANTLRInputStream(cppCodeAsString))
    val tokens = CommonTokenStream(lexer)
    return CppLangParser(tokens)
}

fun writeToFile(pathToKtFile: String?, parser: CppLangParser) {
    val writer = FileWriter(pathToKtFile!!, false)
    val tree = parser.translationUnit()
    val walker = ParseTreeWalker()
    val extractor = AstListener(parser)
    walker.walk(extractor, tree)
    writer.write(extractor.getConvertedCode())
    writer.close()
}

fun writeToFileWithPoet(pathToKtFile: String?, parser: CppLangParser) {
    val tree = parser.translationUnit()
    val walker = ParseTreeWalker()
    val extractor = AstListener(parser)
    walker.walk(extractor, tree)
    val file = extractor.getConvertedCodeWithPoet()

    file.writeTo(Path.of(pathToKtFile!!))
}