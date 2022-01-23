
import gen.CppLangLexer
import org.antlr.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams


//import org.antlr.v4.kotlinruntime.CharStreams




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
//    if (args.isEmpty()) {
//        printUsage("converter")
//        return
//    }
    val str = "#include <iostream>\n" +
            "\n" +
            "int main(){\n" +
            "    std::cout << \"Hello world!\" << std::endl;\n" +
            "    return 0;\n" +
            "}"//lineList.toString();
    val input = CharStreams.fromString(str)
   // input = //Char
    val lexer =  CppLangLexer(input)//ANTLRInputStream(str)
    //println(lexer.allTokens.size)
    lexer.allTokens.forEach { println("> $it") }
    //val interpreter = lexer.interpreter
    //val tokens = lexer.allTokens
    //tokens.forEach { println("> $it") }
    //val parser = CppLangParser(CommonTokenStream(lexer))

    //val root = parser.
//    val stream:ANTLRInputStream = ANTLRInputStream(input);
//    val interpreter = lexer.
//    val result = interpreter!!.match(input, 0)

    //lineList.forEach { println(">  " + it) }
}