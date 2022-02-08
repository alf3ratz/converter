import org.antlr.runtime.tree.CommonTree;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
//        var str = "#include <iostream>\n" +
//                "\n" +
//                "int main() {\n" +
//                "    int a = 10;"+
//                "    std::cout << \"Hello world!\" << std::endl;\n" +
//                "    return 0;\n" +
//                "}";
        var str =  Files.readString(Path.of("C:\\Users\\User1337\\IdeaProjects\\converterw\\testdata\\test.cpp"), StandardCharsets.US_ASCII);
        var lexer = new  CppLangLexer(new ANTLRInputStream(str));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CppLangParser parser = new CppLangParser(tokens);

        var tree = parser.translationUnit();// compilationUnit(); // parse
        System.out.println(tree.getChildCount());

        ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
        ExtractInterfaceListener extractor = new ExtractInterfaceListener(parser);
        walker.walk(extractor, tree); // initiate walk of tree with listener
//
        var visit = new CppLangBaseVisitor();
        var result = visit.visit(tree);

    }
}
