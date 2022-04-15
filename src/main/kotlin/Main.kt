import com.github.ajalt.clikt.core.UsageError
import com.github.ajalt.clikt.output.TermUi
import kotlinx.cli.*
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import utils.makeRightClassName
import java.io.File
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.util.logging.Level
import java.util.logging.Logger
import kotlin.io.path.exists

val LOGGER: Logger = LoggingUtils.LOGGER

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

private fun runWithoutArguments(): List<String> {
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

fun main(args: Array<String>) {
    try {
        startConversion(args)
    } catch (ex: Exception) {
        LOGGER.log(Level.WARNING, "Conversion exception");
        return
    }
}

fun startConversion(args: Array<String>) {
    LOGGER.log(Level.INFO, "Getting arguments");
    val argsParser = ArgParser("c2k")
    val input by argsParser.option(ArgType.String, shortName = "i", description = "Input file").required()
    val output by argsParser.option(ArgType.String, shortName = "o", description = "Output file name").required()
    val isDirectory by argsParser.option(ArgType.Boolean, shortName = "d", description = "Is input path a directory?")
        .default(false)
    argsParser.parse(args)
    var pathToFiles = listOf(input, output)
    if (output.toString().isEmpty() && input.toString().isEmpty()) {
        pathToFiles = runWithoutArguments()
    }

    if (isDirectory) {
        val dir = File(pathToFiles[0])
        for (file in dir.listFiles()) {
            val cppCodeAsString = Files.readString(
                Path.of(file.absolutePath).toAbsolutePath(),
                StandardCharsets.US_ASCII
            )
            val parser = createParser(cppCodeAsString)
            var sourceFileName = Path.of(pathToFiles[0]).fileName.toString().replace(".cpp", "")
            sourceFileName = makeRightClassName(sourceFileName)
            writeToFileWithPoet(pathToFiles[1], sourceFileName, parser)
        }
    } else {
        var cppCodeAsString: String
        try {
            cppCodeAsString = Files.readString(
                Path.of(pathToFiles[0]).toAbsolutePath(),
                StandardCharsets.US_ASCII
            )
        } catch (e: Exception) {
            LOGGER.log(Level.WARNING, "Wrong path to file");
            return
        }
        val parser = createParser(cppCodeAsString)
        var sourceFileName = Path.of(pathToFiles[0]).fileName.toString().replace(".cpp", "")
        sourceFileName = makeRightClassName(sourceFileName)
        LOGGER.log(Level.INFO, "Starting conversion");
        writeToFileWithPoet(pathToFiles[1], sourceFileName, parser)
    }
}

fun createParser(cppCodeAsString: String): CppLangParser {
    val lexer = CppLangLexer(ANTLRInputStream(cppCodeAsString))
    val tokens = CommonTokenStream(lexer)
    return CppLangParser(tokens)
}

fun writeToFileWithPoet(pathToKtFile: String?, sourceFileName: String?, parser: CppLangParser) {
    val tree = parser.translationUnit()
    val walker = ParseTreeWalker()
    val extractor = AstListener(parser, sourceFileName!!)
    try {
        walker.walk(extractor, tree)
    } catch (ex: Exception) {
        LOGGER.log(Level.WARNING, "Conversion exception. Wrong input code");
        return
    }
    val file = extractor.getConvertedCodeWithPoet()
    val f = File(pathToKtFile + sourceFileName)
    try {
        file.writeTo(Path.of(pathToKtFile!!))
    } catch (ex: Exception) {
        LOGGER.log(Level.WARNING, "Exception while writing to file");
        return
    }
    LOGGER.log(Level.INFO, "Conversion done");
}

