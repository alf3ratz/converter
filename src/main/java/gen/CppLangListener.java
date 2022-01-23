package gen;// Generated from C:/Users/User1337/IdeaProjects/converterw/src/antlr4\CppLang.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CppLangParser}.
 */
public interface CppLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CppLangParser#translationUnit}.
	 * @param ctx the parse tree
	 */
	void enterTranslationUnit(CppLangParser.TranslationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#translationUnit}.
	 * @param ctx the parse tree
	 */
	void exitTranslationUnit(CppLangParser.TranslationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(CppLangParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(CppLangParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#idExpression}.
	 * @param ctx the parse tree
	 */
	void enterIdExpression(CppLangParser.IdExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#idExpression}.
	 * @param ctx the parse tree
	 */
	void exitIdExpression(CppLangParser.IdExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#unqualifiedId}.
	 * @param ctx the parse tree
	 */
	void enterUnqualifiedId(CppLangParser.UnqualifiedIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#unqualifiedId}.
	 * @param ctx the parse tree
	 */
	void exitUnqualifiedId(CppLangParser.UnqualifiedIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#qualifiedId}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedId(CppLangParser.QualifiedIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#qualifiedId}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedId(CppLangParser.QualifiedIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#nestedNameSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterNestedNameSpecifier(CppLangParser.NestedNameSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#nestedNameSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitNestedNameSpecifier(CppLangParser.NestedNameSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpression(CppLangParser.LambdaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpression(CppLangParser.LambdaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#lambdaIntroducer}.
	 * @param ctx the parse tree
	 */
	void enterLambdaIntroducer(CppLangParser.LambdaIntroducerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#lambdaIntroducer}.
	 * @param ctx the parse tree
	 */
	void exitLambdaIntroducer(CppLangParser.LambdaIntroducerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#lambdaCapture}.
	 * @param ctx the parse tree
	 */
	void enterLambdaCapture(CppLangParser.LambdaCaptureContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#lambdaCapture}.
	 * @param ctx the parse tree
	 */
	void exitLambdaCapture(CppLangParser.LambdaCaptureContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#captureDefault}.
	 * @param ctx the parse tree
	 */
	void enterCaptureDefault(CppLangParser.CaptureDefaultContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#captureDefault}.
	 * @param ctx the parse tree
	 */
	void exitCaptureDefault(CppLangParser.CaptureDefaultContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#captureList}.
	 * @param ctx the parse tree
	 */
	void enterCaptureList(CppLangParser.CaptureListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#captureList}.
	 * @param ctx the parse tree
	 */
	void exitCaptureList(CppLangParser.CaptureListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#capture}.
	 * @param ctx the parse tree
	 */
	void enterCapture(CppLangParser.CaptureContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#capture}.
	 * @param ctx the parse tree
	 */
	void exitCapture(CppLangParser.CaptureContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#simpleCapture}.
	 * @param ctx the parse tree
	 */
	void enterSimpleCapture(CppLangParser.SimpleCaptureContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#simpleCapture}.
	 * @param ctx the parse tree
	 */
	void exitSimpleCapture(CppLangParser.SimpleCaptureContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#initcapture}.
	 * @param ctx the parse tree
	 */
	void enterInitcapture(CppLangParser.InitcaptureContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#initcapture}.
	 * @param ctx the parse tree
	 */
	void exitInitcapture(CppLangParser.InitcaptureContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#lambdaDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterLambdaDeclarator(CppLangParser.LambdaDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#lambdaDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitLambdaDeclarator(CppLangParser.LambdaDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(CppLangParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(CppLangParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#typeIdOfTheTypeId}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdOfTheTypeId(CppLangParser.TypeIdOfTheTypeIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#typeIdOfTheTypeId}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdOfTheTypeId(CppLangParser.TypeIdOfTheTypeIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(CppLangParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(CppLangParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#pseudoDestructorName}.
	 * @param ctx the parse tree
	 */
	void enterPseudoDestructorName(CppLangParser.PseudoDestructorNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#pseudoDestructorName}.
	 * @param ctx the parse tree
	 */
	void exitPseudoDestructorName(CppLangParser.PseudoDestructorNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(CppLangParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(CppLangParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(CppLangParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(CppLangParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(CppLangParser.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(CppLangParser.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#newPlacement}.
	 * @param ctx the parse tree
	 */
	void enterNewPlacement(CppLangParser.NewPlacementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#newPlacement}.
	 * @param ctx the parse tree
	 */
	void exitNewPlacement(CppLangParser.NewPlacementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#newTypeId}.
	 * @param ctx the parse tree
	 */
	void enterNewTypeId(CppLangParser.NewTypeIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#newTypeId}.
	 * @param ctx the parse tree
	 */
	void exitNewTypeId(CppLangParser.NewTypeIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#newDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterNewDeclarator(CppLangParser.NewDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#newDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitNewDeclarator(CppLangParser.NewDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#noPointerNewDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterNoPointerNewDeclarator(CppLangParser.NoPointerNewDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#noPointerNewDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitNoPointerNewDeclarator(CppLangParser.NoPointerNewDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#newInitializer}.
	 * @param ctx the parse tree
	 */
	void enterNewInitializer(CppLangParser.NewInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#newInitializer}.
	 * @param ctx the parse tree
	 */
	void exitNewInitializer(CppLangParser.NewInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#deleteExpression}.
	 * @param ctx the parse tree
	 */
	void enterDeleteExpression(CppLangParser.DeleteExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#deleteExpression}.
	 * @param ctx the parse tree
	 */
	void exitDeleteExpression(CppLangParser.DeleteExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#noExceptExpression}.
	 * @param ctx the parse tree
	 */
	void enterNoExceptExpression(CppLangParser.NoExceptExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#noExceptExpression}.
	 * @param ctx the parse tree
	 */
	void exitNoExceptExpression(CppLangParser.NoExceptExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpression(CppLangParser.CastExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpression(CppLangParser.CastExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#pointerMemberExpression}.
	 * @param ctx the parse tree
	 */
	void enterPointerMemberExpression(CppLangParser.PointerMemberExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#pointerMemberExpression}.
	 * @param ctx the parse tree
	 */
	void exitPointerMemberExpression(CppLangParser.PointerMemberExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(CppLangParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(CppLangParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(CppLangParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(CppLangParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(CppLangParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(CppLangParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#shiftOperator}.
	 * @param ctx the parse tree
	 */
	void enterShiftOperator(CppLangParser.ShiftOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#shiftOperator}.
	 * @param ctx the parse tree
	 */
	void exitShiftOperator(CppLangParser.ShiftOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(CppLangParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(CppLangParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(CppLangParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(CppLangParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(CppLangParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(CppLangParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveOrExpression(CppLangParser.ExclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveOrExpression(CppLangParser.ExclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveOrExpression(CppLangParser.InclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveOrExpression(CppLangParser.InclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(CppLangParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(CppLangParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(CppLangParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(CppLangParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(CppLangParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(CppLangParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(CppLangParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(CppLangParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(CppLangParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(CppLangParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CppLangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CppLangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(CppLangParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(CppLangParser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CppLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CppLangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatement(CppLangParser.LabeledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatement(CppLangParser.LabeledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(CppLangParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(CppLangParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(CppLangParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(CppLangParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#statementSeq}.
	 * @param ctx the parse tree
	 */
	void enterStatementSeq(CppLangParser.StatementSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#statementSeq}.
	 * @param ctx the parse tree
	 */
	void exitStatementSeq(CppLangParser.StatementSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectionStatement(CppLangParser.SelectionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectionStatement(CppLangParser.SelectionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(CppLangParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(CppLangParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterIterationStatement(CppLangParser.IterationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitIterationStatement(CppLangParser.IterationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#forInitStatement}.
	 * @param ctx the parse tree
	 */
	void enterForInitStatement(CppLangParser.ForInitStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#forInitStatement}.
	 * @param ctx the parse tree
	 */
	void exitForInitStatement(CppLangParser.ForInitStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#forRangeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterForRangeDeclaration(CppLangParser.ForRangeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#forRangeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitForRangeDeclaration(CppLangParser.ForRangeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#forRangeInitializer}.
	 * @param ctx the parse tree
	 */
	void enterForRangeInitializer(CppLangParser.ForRangeInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#forRangeInitializer}.
	 * @param ctx the parse tree
	 */
	void exitForRangeInitializer(CppLangParser.ForRangeInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStatement(CppLangParser.JumpStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStatement(CppLangParser.JumpStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#declarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationStatement(CppLangParser.DeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#declarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationStatement(CppLangParser.DeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#declarationseq}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationseq(CppLangParser.DeclarationseqContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#declarationseq}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationseq(CppLangParser.DeclarationseqContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(CppLangParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(CppLangParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#blockDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterBlockDeclaration(CppLangParser.BlockDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#blockDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitBlockDeclaration(CppLangParser.BlockDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#aliasDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAliasDeclaration(CppLangParser.AliasDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#aliasDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAliasDeclaration(CppLangParser.AliasDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#simpleDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSimpleDeclaration(CppLangParser.SimpleDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#simpleDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSimpleDeclaration(CppLangParser.SimpleDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#staticAssertDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStaticAssertDeclaration(CppLangParser.StaticAssertDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#staticAssertDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStaticAssertDeclaration(CppLangParser.StaticAssertDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#emptyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEmptyDeclaration(CppLangParser.EmptyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#emptyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEmptyDeclaration(CppLangParser.EmptyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#attributeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAttributeDeclaration(CppLangParser.AttributeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#attributeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAttributeDeclaration(CppLangParser.AttributeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#declSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterDeclSpecifier(CppLangParser.DeclSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#declSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitDeclSpecifier(CppLangParser.DeclSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#declSpecifierSeq}.
	 * @param ctx the parse tree
	 */
	void enterDeclSpecifierSeq(CppLangParser.DeclSpecifierSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#declSpecifierSeq}.
	 * @param ctx the parse tree
	 */
	void exitDeclSpecifierSeq(CppLangParser.DeclSpecifierSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#storageClassSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterStorageClassSpecifier(CppLangParser.StorageClassSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#storageClassSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitStorageClassSpecifier(CppLangParser.StorageClassSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#functionSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterFunctionSpecifier(CppLangParser.FunctionSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#functionSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitFunctionSpecifier(CppLangParser.FunctionSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#typedefName}.
	 * @param ctx the parse tree
	 */
	void enterTypedefName(CppLangParser.TypedefNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#typedefName}.
	 * @param ctx the parse tree
	 */
	void exitTypedefName(CppLangParser.TypedefNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifier(CppLangParser.TypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifier(CppLangParser.TypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#trailingTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTrailingTypeSpecifier(CppLangParser.TrailingTypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#trailingTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTrailingTypeSpecifier(CppLangParser.TrailingTypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#typeSpecifierSeq}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifierSeq(CppLangParser.TypeSpecifierSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#typeSpecifierSeq}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifierSeq(CppLangParser.TypeSpecifierSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#trailingTypeSpecifierSeq}.
	 * @param ctx the parse tree
	 */
	void enterTrailingTypeSpecifierSeq(CppLangParser.TrailingTypeSpecifierSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#trailingTypeSpecifierSeq}.
	 * @param ctx the parse tree
	 */
	void exitTrailingTypeSpecifierSeq(CppLangParser.TrailingTypeSpecifierSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#simpleTypeLengthModifier}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTypeLengthModifier(CppLangParser.SimpleTypeLengthModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#simpleTypeLengthModifier}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTypeLengthModifier(CppLangParser.SimpleTypeLengthModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#simpleTypeSignednessModifier}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTypeSignednessModifier(CppLangParser.SimpleTypeSignednessModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#simpleTypeSignednessModifier}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTypeSignednessModifier(CppLangParser.SimpleTypeSignednessModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#simpleTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTypeSpecifier(CppLangParser.SimpleTypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#simpleTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTypeSpecifier(CppLangParser.SimpleTypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#theTypeName}.
	 * @param ctx the parse tree
	 */
	void enterTheTypeName(CppLangParser.TheTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#theTypeName}.
	 * @param ctx the parse tree
	 */
	void exitTheTypeName(CppLangParser.TheTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#decltypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterDecltypeSpecifier(CppLangParser.DecltypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#decltypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitDecltypeSpecifier(CppLangParser.DecltypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#elaboratedTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterElaboratedTypeSpecifier(CppLangParser.ElaboratedTypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#elaboratedTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitElaboratedTypeSpecifier(CppLangParser.ElaboratedTypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#enumName}.
	 * @param ctx the parse tree
	 */
	void enterEnumName(CppLangParser.EnumNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#enumName}.
	 * @param ctx the parse tree
	 */
	void exitEnumName(CppLangParser.EnumNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#enumSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterEnumSpecifier(CppLangParser.EnumSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#enumSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitEnumSpecifier(CppLangParser.EnumSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#enumHead}.
	 * @param ctx the parse tree
	 */
	void enterEnumHead(CppLangParser.EnumHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#enumHead}.
	 * @param ctx the parse tree
	 */
	void exitEnumHead(CppLangParser.EnumHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#opaqueEnumDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterOpaqueEnumDeclaration(CppLangParser.OpaqueEnumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#opaqueEnumDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitOpaqueEnumDeclaration(CppLangParser.OpaqueEnumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#enumkey}.
	 * @param ctx the parse tree
	 */
	void enterEnumkey(CppLangParser.EnumkeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#enumkey}.
	 * @param ctx the parse tree
	 */
	void exitEnumkey(CppLangParser.EnumkeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#enumbase}.
	 * @param ctx the parse tree
	 */
	void enterEnumbase(CppLangParser.EnumbaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#enumbase}.
	 * @param ctx the parse tree
	 */
	void exitEnumbase(CppLangParser.EnumbaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#enumeratorList}.
	 * @param ctx the parse tree
	 */
	void enterEnumeratorList(CppLangParser.EnumeratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#enumeratorList}.
	 * @param ctx the parse tree
	 */
	void exitEnumeratorList(CppLangParser.EnumeratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#enumeratorDefinition}.
	 * @param ctx the parse tree
	 */
	void enterEnumeratorDefinition(CppLangParser.EnumeratorDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#enumeratorDefinition}.
	 * @param ctx the parse tree
	 */
	void exitEnumeratorDefinition(CppLangParser.EnumeratorDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#enumerator}.
	 * @param ctx the parse tree
	 */
	void enterEnumerator(CppLangParser.EnumeratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#enumerator}.
	 * @param ctx the parse tree
	 */
	void exitEnumerator(CppLangParser.EnumeratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#namespaceName}.
	 * @param ctx the parse tree
	 */
	void enterNamespaceName(CppLangParser.NamespaceNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#namespaceName}.
	 * @param ctx the parse tree
	 */
	void exitNamespaceName(CppLangParser.NamespaceNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#originalNamespaceName}.
	 * @param ctx the parse tree
	 */
	void enterOriginalNamespaceName(CppLangParser.OriginalNamespaceNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#originalNamespaceName}.
	 * @param ctx the parse tree
	 */
	void exitOriginalNamespaceName(CppLangParser.OriginalNamespaceNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#namespaceDefinition}.
	 * @param ctx the parse tree
	 */
	void enterNamespaceDefinition(CppLangParser.NamespaceDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#namespaceDefinition}.
	 * @param ctx the parse tree
	 */
	void exitNamespaceDefinition(CppLangParser.NamespaceDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#namespaceAlias}.
	 * @param ctx the parse tree
	 */
	void enterNamespaceAlias(CppLangParser.NamespaceAliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#namespaceAlias}.
	 * @param ctx the parse tree
	 */
	void exitNamespaceAlias(CppLangParser.NamespaceAliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#namespaceAliasDefinition}.
	 * @param ctx the parse tree
	 */
	void enterNamespaceAliasDefinition(CppLangParser.NamespaceAliasDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#namespaceAliasDefinition}.
	 * @param ctx the parse tree
	 */
	void exitNamespaceAliasDefinition(CppLangParser.NamespaceAliasDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#qualifiednamespacespecifier}.
	 * @param ctx the parse tree
	 */
	void enterQualifiednamespacespecifier(CppLangParser.QualifiednamespacespecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#qualifiednamespacespecifier}.
	 * @param ctx the parse tree
	 */
	void exitQualifiednamespacespecifier(CppLangParser.QualifiednamespacespecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#usingDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterUsingDeclaration(CppLangParser.UsingDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#usingDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitUsingDeclaration(CppLangParser.UsingDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#usingDirective}.
	 * @param ctx the parse tree
	 */
	void enterUsingDirective(CppLangParser.UsingDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#usingDirective}.
	 * @param ctx the parse tree
	 */
	void exitUsingDirective(CppLangParser.UsingDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#asmDefinition}.
	 * @param ctx the parse tree
	 */
	void enterAsmDefinition(CppLangParser.AsmDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#asmDefinition}.
	 * @param ctx the parse tree
	 */
	void exitAsmDefinition(CppLangParser.AsmDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#linkageSpecification}.
	 * @param ctx the parse tree
	 */
	void enterLinkageSpecification(CppLangParser.LinkageSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#linkageSpecification}.
	 * @param ctx the parse tree
	 */
	void exitLinkageSpecification(CppLangParser.LinkageSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#attributeSpecifierSeq}.
	 * @param ctx the parse tree
	 */
	void enterAttributeSpecifierSeq(CppLangParser.AttributeSpecifierSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#attributeSpecifierSeq}.
	 * @param ctx the parse tree
	 */
	void exitAttributeSpecifierSeq(CppLangParser.AttributeSpecifierSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#attributeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterAttributeSpecifier(CppLangParser.AttributeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#attributeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitAttributeSpecifier(CppLangParser.AttributeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#alignmentspecifier}.
	 * @param ctx the parse tree
	 */
	void enterAlignmentspecifier(CppLangParser.AlignmentspecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#alignmentspecifier}.
	 * @param ctx the parse tree
	 */
	void exitAlignmentspecifier(CppLangParser.AlignmentspecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#attributeList}.
	 * @param ctx the parse tree
	 */
	void enterAttributeList(CppLangParser.AttributeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#attributeList}.
	 * @param ctx the parse tree
	 */
	void exitAttributeList(CppLangParser.AttributeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(CppLangParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(CppLangParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#attributeNamespace}.
	 * @param ctx the parse tree
	 */
	void enterAttributeNamespace(CppLangParser.AttributeNamespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#attributeNamespace}.
	 * @param ctx the parse tree
	 */
	void exitAttributeNamespace(CppLangParser.AttributeNamespaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#attributeArgumentClause}.
	 * @param ctx the parse tree
	 */
	void enterAttributeArgumentClause(CppLangParser.AttributeArgumentClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#attributeArgumentClause}.
	 * @param ctx the parse tree
	 */
	void exitAttributeArgumentClause(CppLangParser.AttributeArgumentClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#balancedTokenSeq}.
	 * @param ctx the parse tree
	 */
	void enterBalancedTokenSeq(CppLangParser.BalancedTokenSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#balancedTokenSeq}.
	 * @param ctx the parse tree
	 */
	void exitBalancedTokenSeq(CppLangParser.BalancedTokenSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#balancedtoken}.
	 * @param ctx the parse tree
	 */
	void enterBalancedtoken(CppLangParser.BalancedtokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#balancedtoken}.
	 * @param ctx the parse tree
	 */
	void exitBalancedtoken(CppLangParser.BalancedtokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclaratorList(CppLangParser.InitDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclaratorList(CppLangParser.InitDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclarator(CppLangParser.InitDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclarator(CppLangParser.InitDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#declarator}.
	 * @param ctx the parse tree
	 */
	void enterDeclarator(CppLangParser.DeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#declarator}.
	 * @param ctx the parse tree
	 */
	void exitDeclarator(CppLangParser.DeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#pointerDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterPointerDeclarator(CppLangParser.PointerDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#pointerDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitPointerDeclarator(CppLangParser.PointerDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#noPointerDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterNoPointerDeclarator(CppLangParser.NoPointerDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#noPointerDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitNoPointerDeclarator(CppLangParser.NoPointerDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#parametersAndQualifiers}.
	 * @param ctx the parse tree
	 */
	void enterParametersAndQualifiers(CppLangParser.ParametersAndQualifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#parametersAndQualifiers}.
	 * @param ctx the parse tree
	 */
	void exitParametersAndQualifiers(CppLangParser.ParametersAndQualifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#trailingReturnType}.
	 * @param ctx the parse tree
	 */
	void enterTrailingReturnType(CppLangParser.TrailingReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#trailingReturnType}.
	 * @param ctx the parse tree
	 */
	void exitTrailingReturnType(CppLangParser.TrailingReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#pointerOperator}.
	 * @param ctx the parse tree
	 */
	void enterPointerOperator(CppLangParser.PointerOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#pointerOperator}.
	 * @param ctx the parse tree
	 */
	void exitPointerOperator(CppLangParser.PointerOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#cvqualifierseq}.
	 * @param ctx the parse tree
	 */
	void enterCvqualifierseq(CppLangParser.CvqualifierseqContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#cvqualifierseq}.
	 * @param ctx the parse tree
	 */
	void exitCvqualifierseq(CppLangParser.CvqualifierseqContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#cvQualifier}.
	 * @param ctx the parse tree
	 */
	void enterCvQualifier(CppLangParser.CvQualifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#cvQualifier}.
	 * @param ctx the parse tree
	 */
	void exitCvQualifier(CppLangParser.CvQualifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#refqualifier}.
	 * @param ctx the parse tree
	 */
	void enterRefqualifier(CppLangParser.RefqualifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#refqualifier}.
	 * @param ctx the parse tree
	 */
	void exitRefqualifier(CppLangParser.RefqualifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#declaratorid}.
	 * @param ctx the parse tree
	 */
	void enterDeclaratorid(CppLangParser.DeclaratoridContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#declaratorid}.
	 * @param ctx the parse tree
	 */
	void exitDeclaratorid(CppLangParser.DeclaratoridContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#theTypeId}.
	 * @param ctx the parse tree
	 */
	void enterTheTypeId(CppLangParser.TheTypeIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#theTypeId}.
	 * @param ctx the parse tree
	 */
	void exitTheTypeId(CppLangParser.TheTypeIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#abstractDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterAbstractDeclarator(CppLangParser.AbstractDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#abstractDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitAbstractDeclarator(CppLangParser.AbstractDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#pointerAbstractDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterPointerAbstractDeclarator(CppLangParser.PointerAbstractDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#pointerAbstractDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitPointerAbstractDeclarator(CppLangParser.PointerAbstractDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#noPointerAbstractDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterNoPointerAbstractDeclarator(CppLangParser.NoPointerAbstractDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#noPointerAbstractDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitNoPointerAbstractDeclarator(CppLangParser.NoPointerAbstractDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#abstractPackDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterAbstractPackDeclarator(CppLangParser.AbstractPackDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#abstractPackDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitAbstractPackDeclarator(CppLangParser.AbstractPackDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#noPointerAbstractPackDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterNoPointerAbstractPackDeclarator(CppLangParser.NoPointerAbstractPackDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#noPointerAbstractPackDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitNoPointerAbstractPackDeclarator(CppLangParser.NoPointerAbstractPackDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#parameterDeclarationClause}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclarationClause(CppLangParser.ParameterDeclarationClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#parameterDeclarationClause}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclarationClause(CppLangParser.ParameterDeclarationClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#parameterDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclarationList(CppLangParser.ParameterDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#parameterDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclarationList(CppLangParser.ParameterDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclaration(CppLangParser.ParameterDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclaration(CppLangParser.ParameterDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(CppLangParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(CppLangParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(CppLangParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(CppLangParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(CppLangParser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(CppLangParser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#braceOrEqualInitializer}.
	 * @param ctx the parse tree
	 */
	void enterBraceOrEqualInitializer(CppLangParser.BraceOrEqualInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#braceOrEqualInitializer}.
	 * @param ctx the parse tree
	 */
	void exitBraceOrEqualInitializer(CppLangParser.BraceOrEqualInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#initializerClause}.
	 * @param ctx the parse tree
	 */
	void enterInitializerClause(CppLangParser.InitializerClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#initializerClause}.
	 * @param ctx the parse tree
	 */
	void exitInitializerClause(CppLangParser.InitializerClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#initializerList}.
	 * @param ctx the parse tree
	 */
	void enterInitializerList(CppLangParser.InitializerListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#initializerList}.
	 * @param ctx the parse tree
	 */
	void exitInitializerList(CppLangParser.InitializerListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#bracedInitList}.
	 * @param ctx the parse tree
	 */
	void enterBracedInitList(CppLangParser.BracedInitListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#bracedInitList}.
	 * @param ctx the parse tree
	 */
	void exitBracedInitList(CppLangParser.BracedInitListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#className}.
	 * @param ctx the parse tree
	 */
	void enterClassName(CppLangParser.ClassNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#className}.
	 * @param ctx the parse tree
	 */
	void exitClassName(CppLangParser.ClassNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#classSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterClassSpecifier(CppLangParser.ClassSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#classSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitClassSpecifier(CppLangParser.ClassSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#classHead}.
	 * @param ctx the parse tree
	 */
	void enterClassHead(CppLangParser.ClassHeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#classHead}.
	 * @param ctx the parse tree
	 */
	void exitClassHead(CppLangParser.ClassHeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#classHeadName}.
	 * @param ctx the parse tree
	 */
	void enterClassHeadName(CppLangParser.ClassHeadNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#classHeadName}.
	 * @param ctx the parse tree
	 */
	void exitClassHeadName(CppLangParser.ClassHeadNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#classVirtSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterClassVirtSpecifier(CppLangParser.ClassVirtSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#classVirtSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitClassVirtSpecifier(CppLangParser.ClassVirtSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#classKey}.
	 * @param ctx the parse tree
	 */
	void enterClassKey(CppLangParser.ClassKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#classKey}.
	 * @param ctx the parse tree
	 */
	void exitClassKey(CppLangParser.ClassKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#memberSpecification}.
	 * @param ctx the parse tree
	 */
	void enterMemberSpecification(CppLangParser.MemberSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#memberSpecification}.
	 * @param ctx the parse tree
	 */
	void exitMemberSpecification(CppLangParser.MemberSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#memberdeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMemberdeclaration(CppLangParser.MemberdeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#memberdeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMemberdeclaration(CppLangParser.MemberdeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#memberDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterMemberDeclaratorList(CppLangParser.MemberDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#memberDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitMemberDeclaratorList(CppLangParser.MemberDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#memberDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterMemberDeclarator(CppLangParser.MemberDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#memberDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitMemberDeclarator(CppLangParser.MemberDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#virtualSpecifierSeq}.
	 * @param ctx the parse tree
	 */
	void enterVirtualSpecifierSeq(CppLangParser.VirtualSpecifierSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#virtualSpecifierSeq}.
	 * @param ctx the parse tree
	 */
	void exitVirtualSpecifierSeq(CppLangParser.VirtualSpecifierSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#virtualSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterVirtualSpecifier(CppLangParser.VirtualSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#virtualSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitVirtualSpecifier(CppLangParser.VirtualSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#pureSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterPureSpecifier(CppLangParser.PureSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#pureSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitPureSpecifier(CppLangParser.PureSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#baseClause}.
	 * @param ctx the parse tree
	 */
	void enterBaseClause(CppLangParser.BaseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#baseClause}.
	 * @param ctx the parse tree
	 */
	void exitBaseClause(CppLangParser.BaseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#baseSpecifierList}.
	 * @param ctx the parse tree
	 */
	void enterBaseSpecifierList(CppLangParser.BaseSpecifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#baseSpecifierList}.
	 * @param ctx the parse tree
	 */
	void exitBaseSpecifierList(CppLangParser.BaseSpecifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#baseSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterBaseSpecifier(CppLangParser.BaseSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#baseSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitBaseSpecifier(CppLangParser.BaseSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#classOrDeclType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrDeclType(CppLangParser.ClassOrDeclTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#classOrDeclType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrDeclType(CppLangParser.ClassOrDeclTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#baseTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterBaseTypeSpecifier(CppLangParser.BaseTypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#baseTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitBaseTypeSpecifier(CppLangParser.BaseTypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#accessSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterAccessSpecifier(CppLangParser.AccessSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#accessSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitAccessSpecifier(CppLangParser.AccessSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#conversionFunctionId}.
	 * @param ctx the parse tree
	 */
	void enterConversionFunctionId(CppLangParser.ConversionFunctionIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#conversionFunctionId}.
	 * @param ctx the parse tree
	 */
	void exitConversionFunctionId(CppLangParser.ConversionFunctionIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#conversionTypeId}.
	 * @param ctx the parse tree
	 */
	void enterConversionTypeId(CppLangParser.ConversionTypeIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#conversionTypeId}.
	 * @param ctx the parse tree
	 */
	void exitConversionTypeId(CppLangParser.ConversionTypeIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#conversionDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterConversionDeclarator(CppLangParser.ConversionDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#conversionDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitConversionDeclarator(CppLangParser.ConversionDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#constructorInitializer}.
	 * @param ctx the parse tree
	 */
	void enterConstructorInitializer(CppLangParser.ConstructorInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#constructorInitializer}.
	 * @param ctx the parse tree
	 */
	void exitConstructorInitializer(CppLangParser.ConstructorInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#memInitializerList}.
	 * @param ctx the parse tree
	 */
	void enterMemInitializerList(CppLangParser.MemInitializerListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#memInitializerList}.
	 * @param ctx the parse tree
	 */
	void exitMemInitializerList(CppLangParser.MemInitializerListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#memInitializer}.
	 * @param ctx the parse tree
	 */
	void enterMemInitializer(CppLangParser.MemInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#memInitializer}.
	 * @param ctx the parse tree
	 */
	void exitMemInitializer(CppLangParser.MemInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#meminitializerid}.
	 * @param ctx the parse tree
	 */
	void enterMeminitializerid(CppLangParser.MeminitializeridContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#meminitializerid}.
	 * @param ctx the parse tree
	 */
	void exitMeminitializerid(CppLangParser.MeminitializeridContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#operatorFunctionId}.
	 * @param ctx the parse tree
	 */
	void enterOperatorFunctionId(CppLangParser.OperatorFunctionIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#operatorFunctionId}.
	 * @param ctx the parse tree
	 */
	void exitOperatorFunctionId(CppLangParser.OperatorFunctionIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#literalOperatorId}.
	 * @param ctx the parse tree
	 */
	void enterLiteralOperatorId(CppLangParser.LiteralOperatorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#literalOperatorId}.
	 * @param ctx the parse tree
	 */
	void exitLiteralOperatorId(CppLangParser.LiteralOperatorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#templateDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTemplateDeclaration(CppLangParser.TemplateDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#templateDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTemplateDeclaration(CppLangParser.TemplateDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#templateparameterList}.
	 * @param ctx the parse tree
	 */
	void enterTemplateparameterList(CppLangParser.TemplateparameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#templateparameterList}.
	 * @param ctx the parse tree
	 */
	void exitTemplateparameterList(CppLangParser.TemplateparameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#templateParameter}.
	 * @param ctx the parse tree
	 */
	void enterTemplateParameter(CppLangParser.TemplateParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#templateParameter}.
	 * @param ctx the parse tree
	 */
	void exitTemplateParameter(CppLangParser.TemplateParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(CppLangParser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(CppLangParser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#simpleTemplateId}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTemplateId(CppLangParser.SimpleTemplateIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#simpleTemplateId}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTemplateId(CppLangParser.SimpleTemplateIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#templateId}.
	 * @param ctx the parse tree
	 */
	void enterTemplateId(CppLangParser.TemplateIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#templateId}.
	 * @param ctx the parse tree
	 */
	void exitTemplateId(CppLangParser.TemplateIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#templateName}.
	 * @param ctx the parse tree
	 */
	void enterTemplateName(CppLangParser.TemplateNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#templateName}.
	 * @param ctx the parse tree
	 */
	void exitTemplateName(CppLangParser.TemplateNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#templateArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterTemplateArgumentList(CppLangParser.TemplateArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#templateArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitTemplateArgumentList(CppLangParser.TemplateArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#templateArgument}.
	 * @param ctx the parse tree
	 */
	void enterTemplateArgument(CppLangParser.TemplateArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#templateArgument}.
	 * @param ctx the parse tree
	 */
	void exitTemplateArgument(CppLangParser.TemplateArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#typeNameSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeNameSpecifier(CppLangParser.TypeNameSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#typeNameSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeNameSpecifier(CppLangParser.TypeNameSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#explicitInstantiation}.
	 * @param ctx the parse tree
	 */
	void enterExplicitInstantiation(CppLangParser.ExplicitInstantiationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#explicitInstantiation}.
	 * @param ctx the parse tree
	 */
	void exitExplicitInstantiation(CppLangParser.ExplicitInstantiationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#explicitSpecialization}.
	 * @param ctx the parse tree
	 */
	void enterExplicitSpecialization(CppLangParser.ExplicitSpecializationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#explicitSpecialization}.
	 * @param ctx the parse tree
	 */
	void exitExplicitSpecialization(CppLangParser.ExplicitSpecializationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#tryBlock}.
	 * @param ctx the parse tree
	 */
	void enterTryBlock(CppLangParser.TryBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#tryBlock}.
	 * @param ctx the parse tree
	 */
	void exitTryBlock(CppLangParser.TryBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#functionTryBlock}.
	 * @param ctx the parse tree
	 */
	void enterFunctionTryBlock(CppLangParser.FunctionTryBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#functionTryBlock}.
	 * @param ctx the parse tree
	 */
	void exitFunctionTryBlock(CppLangParser.FunctionTryBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#handlerSeq}.
	 * @param ctx the parse tree
	 */
	void enterHandlerSeq(CppLangParser.HandlerSeqContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#handlerSeq}.
	 * @param ctx the parse tree
	 */
	void exitHandlerSeq(CppLangParser.HandlerSeqContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#handler}.
	 * @param ctx the parse tree
	 */
	void enterHandler(CppLangParser.HandlerContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#handler}.
	 * @param ctx the parse tree
	 */
	void exitHandler(CppLangParser.HandlerContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#exceptionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExceptionDeclaration(CppLangParser.ExceptionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#exceptionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExceptionDeclaration(CppLangParser.ExceptionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#throwExpression}.
	 * @param ctx the parse tree
	 */
	void enterThrowExpression(CppLangParser.ThrowExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#throwExpression}.
	 * @param ctx the parse tree
	 */
	void exitThrowExpression(CppLangParser.ThrowExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#exceptionSpecification}.
	 * @param ctx the parse tree
	 */
	void enterExceptionSpecification(CppLangParser.ExceptionSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#exceptionSpecification}.
	 * @param ctx the parse tree
	 */
	void exitExceptionSpecification(CppLangParser.ExceptionSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#dynamicExceptionSpecification}.
	 * @param ctx the parse tree
	 */
	void enterDynamicExceptionSpecification(CppLangParser.DynamicExceptionSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#dynamicExceptionSpecification}.
	 * @param ctx the parse tree
	 */
	void exitDynamicExceptionSpecification(CppLangParser.DynamicExceptionSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#typeIdList}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdList(CppLangParser.TypeIdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#typeIdList}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdList(CppLangParser.TypeIdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#noeExceptSpecification}.
	 * @param ctx the parse tree
	 */
	void enterNoeExceptSpecification(CppLangParser.NoeExceptSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#noeExceptSpecification}.
	 * @param ctx the parse tree
	 */
	void exitNoeExceptSpecification(CppLangParser.NoeExceptSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#theOperator}.
	 * @param ctx the parse tree
	 */
	void enterTheOperator(CppLangParser.TheOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#theOperator}.
	 * @param ctx the parse tree
	 */
	void exitTheOperator(CppLangParser.TheOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CppLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(CppLangParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CppLangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(CppLangParser.LiteralContext ctx);
}