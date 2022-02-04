import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;















public class Main {
    public static void main(String[] args) {
        var str = "#include <iostream>\n" +
                "\n" +
                "int main(){\n" +
                "    std::cout << \"Hello world!\" << std::endl;\n" +
                "    return 0;\n" +
                "}";
        var input = CharStreams.fromString(str);
        var lexer =  new CppLangLexer(new ANTLRInputStream(str));
        var parser = new CppLangParser(new CommonTokenStream(lexer));
        for(Token token : lexer.getAllTokens()){
            System.out.println(token.toString());
        }

    }
}
