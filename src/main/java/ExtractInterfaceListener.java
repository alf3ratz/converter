//import org.antlr.v4.runtime.ParserRuleContext;
//import org.antlr.v4.runtime.tree.TerminalNode;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Map;
//
//public class ExtractInterfaceListener extends CppLangBaseListener {
//    private CppLangParser parser;
//    private FileWriter writer;
//    private static final Map<String, String> uppercaseMap= Map.of("int","Int","double","Double","float","Float");
//    private static final String TODO_STRING = "{\n\t//TODO\n}\n";
//
//    public ExtractInterfaceListener(CppLangParser parser) throws IOException {
//        this.setParser(parser);
//        this.setWriter(new FileWriter("C:\\Users\\User1337\\IdeaProjects\\converterw\\resultdata\\testKt.kt", false));
//    }
//
//    /**
//     * Listen to matches of classDeclaration
//     */
//    @Override
//    public void enterClassName(CppLangParser.ClassNameContext ctx) {
//        // System.out.println("enterClassName: "+ctx.getText());
//    }
//
//    @Override
//    public void enterClassHeadName(CppLangParser.ClassHeadNameContext ctx) {
//        System.out.println("enterClassHeadName: " + ctx.getText());
//    }
//
//    @Override
//    public void enterNewTypeId(CppLangParser.NewTypeIdContext ctx) {
//        //System.out.println("enterNewTypeId: "+ctx.getText()); // int[2]
//    }
//
//    @Override
//    public void enterNewDeclarator(CppLangParser.NewDeclaratorContext ctx) {
//        //System.out.println("enterNewDeclarator: "+ctx.getText()); // [2]
//    }
//
//    @Override
//    public void enterNewInitializer(CppLangParser.NewInitializerContext ctx) {
//        System.out.println("enterNewInitializer: " + ctx.getText());
//    }
//
//    @Override
//    public void enterPointerMemberExpression(CppLangParser.PointerMemberExpressionContext ctx) {
//        //System.out.println("enterPointerMemberExpression: "+ctx.getText()); // 2, 10 , 0
//    }
//
//    @Override
//    public void enterAssignmentExpression(CppLangParser.AssignmentExpressionContext ctx) {
//        //System.out.println("enterAssignmentExpression: "+ctx.getText()); // newint[2], 2, 10 , 0
//    }
//
//    @Override
//    public void enterAssignmentOperator(CppLangParser.AssignmentOperatorContext ctx) {
//        System.out.println("enterAssignmentOperator: " + ctx.getText());
//    }
//
//    @Override
//    public void enterExpression(CppLangParser.ExpressionContext ctx) {
//        //.out.println("enterExpression: "+ctx.getText()); //stdout, 2 ,10 ,0
//    }
//
//    @Override
//    public void exitExpression(CppLangParser.ExpressionContext ctx) {
//        //System.out.println("exitExpression: "+ctx.getText()); //stdout, 2 ,10 ,0
//    }
//
//    //    @Override
////    public void exitClassName(CppLangParser.ClassNameContext ctx) {
////        System.out.println("}");
////    }
//    @Override
//    public void enterTranslationUnit(CppLangParser.TranslationUnitContext ctx) {
//        System.out.println("Translation unit enter: " + ctx.declarationseq().declaration());
//    }
//    @Override
//    public void exitTranslationUnit(CppLangParser.TranslationUnitContext ctx){
//        try {
//            getWriter().close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void enterPrimaryExpression(CppLangParser.PrimaryExpressionContext ctx) {
//        //System.out.println("Primary expression enter: "+ctx.getText());
//    }
//
//    @Override
//    public void enterIdExpression(CppLangParser.IdExpressionContext ctx) {
//        // System.out.println("Id expression enter: "+ctx.getText());
//    }
//
//    @Override
//    public void enterConversionFunctionId(CppLangParser.ConversionFunctionIdContext ctx) {
//        System.out.println("enterConversionFunctionId " + ctx.getText());
//    }
//
//    @Override
//    public void exitConversionFunctionId(CppLangParser.ConversionFunctionIdContext ctx) {
//        //System.out.println(ctx.getText());
//    }
//
//    @Override
//    public void enterOperatorFunctionId(CppLangParser.OperatorFunctionIdContext ctx) {
//        //System.out.println(ctx.getText());
//    }
//
//    @Override
//    public void enterEveryRule(ParserRuleContext ctx) {
//        //System.out.println(ctx.getText());
//    }
//
//    @Override
//    public void visitTerminal(TerminalNode node) {
//        //System.out.println("Terminal: "+node.getText());
//    }
//
//    @Override
//    public void enterQualifiedId(CppLangParser.QualifiedIdContext ctx) {
//        //System.out.println("Enter qualified id: "+ ctx.getText());
//    }
//
//    @Override
//    public void enterNestedNameSpecifier(CppLangParser.NestedNameSpecifierContext ctx) {
//        // System.out.println("Enter nested specifier: "+ ctx.getText()); //Enter nested specifier: std::
//    }
//
//    @Override
//    public void enterTypedefName(CppLangParser.TypedefNameContext ctx) {
//        System.out.println("enterTypedefName: " + ctx.getText());
//    }
//
//    @Override
//    public void enterTheTypeName(CppLangParser.TheTypeNameContext ctx) {
//        //System.out.println("enterTheTypeName: "+ ctx.getText()); //std
//    }
//
//    @Override
//    public void enterNamespaceName(CppLangParser.NamespaceNameContext ctx) {
//        //System.out.println("enterNamespaceName: "+ ctx.getText()); // std
//    }
//
//    @Override
//    public void enterOriginalNamespaceName(CppLangParser.OriginalNamespaceNameContext ctx) {
//        // System.out.println("enterOriginalNamespaceName: "+ ctx.getText()); // std
//    }
//
//    @Override
//    public void enterStatement(CppLangParser.StatementContext ctx) {
//        System.out.println("Enter statement: " + ctx.getText());
//        //System.out.println(ctx);
//        //System.out.println("\t"+ctx.getRuleContext().getChild(0).getChild(0).getText());// labeledStatement().getText());
//    }
//
//    @Override
//    public void enterLabeledStatement(CppLangParser.LabeledStatementContext ctx) {
//        System.out.println("Enter labeled statement: " + ctx.getText());
//    }
//
//    @Override
//    public void enterExpressionStatement(CppLangParser.ExpressionStatementContext ctx) {
//        System.out.println("Enter expression statement: " + ctx.getText()); //std::cout<<"Hello world!"<<std::endl;
//    }
//
//    @Override
//    public void enterDeclaration(CppLangParser.DeclarationContext ctx) {
//        System.out.println("Enter declaration statement: " + ctx.getText());
//    }
//
//    /**
//     * Listen to matches of methodDeclaration
//     */
//    @Override
//    public void exitFunctionSpecifier(CppLangParser.FunctionSpecifierContext ctx) {
//        System.out.println("exitFunctionSpecifier: " + ctx.getText());
//    }
//
//    @Override
//    public void enterFunctionSpecifier(CppLangParser.FunctionSpecifierContext ctx) {
//        System.out.println("enterFunctionSpecifier: " + ctx.getText());
//    }
//
//
//    @Override
//    public void enterFunctionDefinition(CppLangParser.FunctionDefinitionContext ctx) {
//        System.out.println("enterFunctionDefinition: " + ctx.getText());
//        System.out.println("\t" + ctx.getChild(0).getText() + " " + ctx.getChild(1).getText() + " " + ctx.getChild(2).getText());
//        try {
//            getWriter().write("fun ");
//            getWriter().write(ctx.getChild(1).getText());
//            var returnType = ctx.getChild(0).getText().trim();
//            getWriter().write(": " + uppercaseMap.getOrDefault(returnType, returnType) + " ");
//            //getWriter().write(ctx.getChild(2).getText()); // - внутренности метода
//            getWriter().write(TODO_STRING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void exitFunctionDefinition(CppLangParser.FunctionDefinitionContext ctx) {
//        System.out.println("exitFunctionDefinition: " + ctx.getText());
//    }
//
//    @Override
//    public void enterFunctionBody(CppLangParser.FunctionBodyContext ctx) {
//        System.out.println("enterFunctionBody: " + ctx.getText());
//    }
//
//    @Override
//    public void exitFunctionBody(CppLangParser.FunctionBodyContext ctx) {
//        System.out.println("exitFunctionBody: " + ctx.getText());
//    }
//
//
//    public CppLangParser getParser() {
//        return parser;
//    }
//
//    public void setParser(CppLangParser parser) {
//        this.parser = parser;
//    }
//
//    public FileWriter getWriter() {
//        return writer;
//    }
//
//    public void setWriter(FileWriter writer) {
//        this.writer = writer;
//    }
//}