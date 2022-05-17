import com.github.ajalt.clikt.core.UsageError
import com.github.ajalt.clikt.output.TermUi
import kotlinx.cli.*
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import utils.makeRightClassName
import java.io.File
import java.io.FileOutputStream
import java.io.FileWriter
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.exists


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

fun runWithoutArguments(): List<String> {
    val inputPath = TermUi.prompt("Enter input cpp/h file path: ") {
        when (Path.of(it).exists()) {
            true -> it
            false -> throw UsageError("File should exist!")
        }
    }
    val outputPath = TermUi.prompt("Enter output kotlin file path: ") {
        when (it.isNotEmpty() && it.isNotBlank()) {
            true -> it
            false -> throw UsageError("Path shouldn't be empty!")
        }
    }
    return listOf(inputPath!!, outputPath!!)
}

// TODO: првоерить работу на новой машинке
fun main(args: Array<String>) {

    val argsParser = ArgParser("c2k")
    val input by argsParser.option(ArgType.String, shortName = "i", description = "Input file").required()
    val output by argsParser.option(ArgType.String, shortName = "o", description = "Output file name").required()
    argsParser.parse(args)
    var pathToFiles = listOf(input, output)
    if(output.isEmpty() && input.isEmpty()){
        pathToFiles = runWithoutArguments()
    }

    val cppCodeAsString = Files.readString(
        Path.of(pathToFiles[0]).toAbsolutePath(), // TODO: решить проблему с абсолютным и относительным путём
        StandardCharsets.US_ASCII
    )
    val parser = createParser(cppCodeAsString)
    var sourceFileName = Path.of(pathToFiles[0]).fileName.toString().replace(".cpp","")
    sourceFileName = makeRightClassName(sourceFileName)
    writeToFileWithPoet(pathToFiles[1], sourceFileName, parser)
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
    val extractor = AstListener(parser, "")
    walker.walk(extractor, tree)
    writer.write(extractor.getConvertedCode())
    writer.close()
}

fun writeToFileWithPoet(pathToKtFile: String?, sourceFileName: String?, parser: CppLangParser) {
    val tree = parser.translationUnit()
    val walker = ParseTreeWalker()
    val extractor = AstListener(parser, sourceFileName!!)
    walker.walk(extractor, tree)
    val file = extractor.getConvertedCodeWithPoet()
    val f = File(pathToKtFile+sourceFileName)
//    var app = StringBuilder(f.toString())
//    val res = FileOutputStream(f, true).bufferedWriter().use { writer ->
//        writer.write(file.toString())
//        writer.flush()
//        writer.close()
//    }
    file.writeTo(Path.of(pathToKtFile!!))
    println(file.toString())
    println("\n~~~ DONE ~~~")
}

