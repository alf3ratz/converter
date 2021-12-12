import antlr4.CppLangLexer
import antlr4.CppLangParser
import org.antlr.v4.kotlinruntime.CharStreams
import org.antlr.v4.kotlinruntime.CommonTokenStream
//import org.antlr.v4.runtime.CharStreams
//import org.antlr.v4.runtime.CommonTokenStream
import java.io.File
import java.io.InputStream


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
//    val inputStream: InputStream = File(args[0]).inputStream()
//    val lineList = mutableListOf<String>()
//    inputStream.bufferedReader().forEachLine { lineList.add(it) }
    var str = "#include <iostream>\n" +
            "\n" +
            "int main(){\n" +
            "    std::cout << \"Hello world!\" << std::endl;\n" +
            "    return 0;\n" +
            "}"//lineList.toString();
    val input = CharStreams.fromString(str)
    val lexer = CppLangLexer(input)//ANTLRInputStream(str)
    val interpreter = lexer.interpreter
    var tokens = lexer.allTokens
    tokens.forEach { println("> $it") }
    val parser = CppLangParser(CommonTokenStream(lexer))

    //val root = parser.
//    val stream:ANTLRInputStream = ANTLRInputStream(input);
//    val interpreter = lexer.
//    val result = interpreter!!.match(input, 0)

    //lineList.forEach { println(">  " + it) }
}