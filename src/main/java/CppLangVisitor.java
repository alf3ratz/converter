// Generated from CppLang.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CppLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CppLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CppLangParser#translationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslationUnit(CppLangParser.TranslationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpression(CppLangParser.PrimaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#idExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpression(CppLangParser.IdExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#unqualifiedId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnqualifiedId(CppLangParser.UnqualifiedIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#qualifiedId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedId(CppLangParser.QualifiedIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#nestedNameSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedNameSpecifier(CppLangParser.NestedNameSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#lambdaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpression(CppLangParser.LambdaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#lambdaIntroducer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaIntroducer(CppLangParser.LambdaIntroducerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#lambdaCapture}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaCapture(CppLangParser.LambdaCaptureContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#captureDefault}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaptureDefault(CppLangParser.CaptureDefaultContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#captureList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaptureList(CppLangParser.CaptureListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#capture}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCapture(CppLangParser.CaptureContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#simpleCapture}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleCapture(CppLangParser.SimpleCaptureContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#initcapture}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitcapture(CppLangParser.InitcaptureContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#lambdaDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaDeclarator(CppLangParser.LambdaDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(CppLangParser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#typeIdOfTheTypeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdOfTheTypeId(CppLangParser.TypeIdOfTheTypeIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(CppLangParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#pseudoDestructorName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPseudoDestructorName(CppLangParser.PseudoDestructorNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(CppLangParser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#unaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOperator(CppLangParser.UnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#newExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpression(CppLangParser.NewExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#newPlacement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewPlacement(CppLangParser.NewPlacementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#newTypeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewTypeId(CppLangParser.NewTypeIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#newDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewDeclarator(CppLangParser.NewDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#noPointerNewDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoPointerNewDeclarator(CppLangParser.NoPointerNewDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#newInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewInitializer(CppLangParser.NewInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#deleteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteExpression(CppLangParser.DeleteExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#noExceptExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoExceptExpression(CppLangParser.NoExceptExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#castExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastExpression(CppLangParser.CastExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#pointerMemberExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointerMemberExpression(CppLangParser.PointerMemberExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(CppLangParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(CppLangParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(CppLangParser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#shiftOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftOperator(CppLangParser.ShiftOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(CppLangParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(CppLangParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#andExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(CppLangParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveOrExpression(CppLangParser.ExclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusiveOrExpression(CppLangParser.InclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(CppLangParser.LogicalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression(CppLangParser.LogicalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#conditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(CppLangParser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#assignmentExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(CppLangParser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(CppLangParser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CppLangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#constantExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantExpression(CppLangParser.ConstantExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CppLangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#labeledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeledStatement(CppLangParser.LabeledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(CppLangParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(CppLangParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#statementSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementSeq(CppLangParser.StatementSeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#selectionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectionStatement(CppLangParser.SelectionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(CppLangParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationStatement(CppLangParser.IterationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#forInitStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInitStatement(CppLangParser.ForInitStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#forRangeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForRangeDeclaration(CppLangParser.ForRangeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#forRangeInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForRangeInitializer(CppLangParser.ForRangeInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpStatement(CppLangParser.JumpStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#declarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationStatement(CppLangParser.DeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#declarationseq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationseq(CppLangParser.DeclarationseqContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(CppLangParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#blockDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockDeclaration(CppLangParser.BlockDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#aliasDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAliasDeclaration(CppLangParser.AliasDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#simpleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleDeclaration(CppLangParser.SimpleDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#staticAssertDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticAssertDeclaration(CppLangParser.StaticAssertDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#emptyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyDeclaration(CppLangParser.EmptyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#attributeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeDeclaration(CppLangParser.AttributeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#declSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclSpecifier(CppLangParser.DeclSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#declSpecifierSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclSpecifierSeq(CppLangParser.DeclSpecifierSeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#storageClassSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageClassSpecifier(CppLangParser.StorageClassSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#functionSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionSpecifier(CppLangParser.FunctionSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#typedefName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedefName(CppLangParser.TypedefNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#typeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpecifier(CppLangParser.TypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#trailingTypeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrailingTypeSpecifier(CppLangParser.TrailingTypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#typeSpecifierSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpecifierSeq(CppLangParser.TypeSpecifierSeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#trailingTypeSpecifierSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrailingTypeSpecifierSeq(CppLangParser.TrailingTypeSpecifierSeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#simpleTypeLengthModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTypeLengthModifier(CppLangParser.SimpleTypeLengthModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#simpleTypeSignednessModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTypeSignednessModifier(CppLangParser.SimpleTypeSignednessModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#simpleTypeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTypeSpecifier(CppLangParser.SimpleTypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#theTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTheTypeName(CppLangParser.TheTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#decltypeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecltypeSpecifier(CppLangParser.DecltypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#elaboratedTypeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElaboratedTypeSpecifier(CppLangParser.ElaboratedTypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#enumName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumName(CppLangParser.EnumNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#enumSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumSpecifier(CppLangParser.EnumSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#enumHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumHead(CppLangParser.EnumHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#opaqueEnumDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpaqueEnumDeclaration(CppLangParser.OpaqueEnumDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#enumkey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumkey(CppLangParser.EnumkeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#enumbase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumbase(CppLangParser.EnumbaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#enumeratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumeratorList(CppLangParser.EnumeratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#enumeratorDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumeratorDefinition(CppLangParser.EnumeratorDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#enumerator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerator(CppLangParser.EnumeratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#namespaceName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespaceName(CppLangParser.NamespaceNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#originalNamespaceName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOriginalNamespaceName(CppLangParser.OriginalNamespaceNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#namespaceDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespaceDefinition(CppLangParser.NamespaceDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#namespaceAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespaceAlias(CppLangParser.NamespaceAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#namespaceAliasDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespaceAliasDefinition(CppLangParser.NamespaceAliasDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#qualifiednamespacespecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiednamespacespecifier(CppLangParser.QualifiednamespacespecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#usingDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingDeclaration(CppLangParser.UsingDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#usingDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUsingDirective(CppLangParser.UsingDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#asmDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsmDefinition(CppLangParser.AsmDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#linkageSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLinkageSpecification(CppLangParser.LinkageSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#attributeSpecifierSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeSpecifierSeq(CppLangParser.AttributeSpecifierSeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#attributeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeSpecifier(CppLangParser.AttributeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#alignmentspecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlignmentspecifier(CppLangParser.AlignmentspecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#attributeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeList(CppLangParser.AttributeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(CppLangParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#attributeNamespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeNamespace(CppLangParser.AttributeNamespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#attributeArgumentClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeArgumentClause(CppLangParser.AttributeArgumentClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#balancedTokenSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBalancedTokenSeq(CppLangParser.BalancedTokenSeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#balancedtoken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBalancedtoken(CppLangParser.BalancedtokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitDeclaratorList(CppLangParser.InitDeclaratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#initDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitDeclarator(CppLangParser.InitDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarator(CppLangParser.DeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#pointerDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointerDeclarator(CppLangParser.PointerDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#noPointerDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoPointerDeclarator(CppLangParser.NoPointerDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#parametersAndQualifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametersAndQualifiers(CppLangParser.ParametersAndQualifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#trailingReturnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrailingReturnType(CppLangParser.TrailingReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#pointerOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointerOperator(CppLangParser.PointerOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#cvqualifierseq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCvqualifierseq(CppLangParser.CvqualifierseqContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#cvQualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCvQualifier(CppLangParser.CvQualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#refqualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRefqualifier(CppLangParser.RefqualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#declaratorid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaratorid(CppLangParser.DeclaratoridContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#theTypeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTheTypeId(CppLangParser.TheTypeIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#abstractDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbstractDeclarator(CppLangParser.AbstractDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#pointerAbstractDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointerAbstractDeclarator(CppLangParser.PointerAbstractDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#noPointerAbstractDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoPointerAbstractDeclarator(CppLangParser.NoPointerAbstractDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#abstractPackDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbstractPackDeclarator(CppLangParser.AbstractPackDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#noPointerAbstractPackDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoPointerAbstractPackDeclarator(CppLangParser.NoPointerAbstractPackDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#parameterDeclarationClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclarationClause(CppLangParser.ParameterDeclarationClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#parameterDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclarationList(CppLangParser.ParameterDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclaration(CppLangParser.ParameterDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(CppLangParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(CppLangParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#initializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializer(CppLangParser.InitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#braceOrEqualInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBraceOrEqualInitializer(CppLangParser.BraceOrEqualInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#initializerClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerClause(CppLangParser.InitializerClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#initializerList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerList(CppLangParser.InitializerListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#bracedInitList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracedInitList(CppLangParser.BracedInitListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#className}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassName(CppLangParser.ClassNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#classSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassSpecifier(CppLangParser.ClassSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#classHead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassHead(CppLangParser.ClassHeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#classHeadName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassHeadName(CppLangParser.ClassHeadNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#classVirtSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassVirtSpecifier(CppLangParser.ClassVirtSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#classKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassKey(CppLangParser.ClassKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#memberSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberSpecification(CppLangParser.MemberSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#memberdeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberdeclaration(CppLangParser.MemberdeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#memberDeclaratorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberDeclaratorList(CppLangParser.MemberDeclaratorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#memberDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberDeclarator(CppLangParser.MemberDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#virtualSpecifierSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVirtualSpecifierSeq(CppLangParser.VirtualSpecifierSeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#virtualSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVirtualSpecifier(CppLangParser.VirtualSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#pureSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPureSpecifier(CppLangParser.PureSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#baseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseClause(CppLangParser.BaseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#baseSpecifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseSpecifierList(CppLangParser.BaseSpecifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#baseSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseSpecifier(CppLangParser.BaseSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#classOrDeclType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassOrDeclType(CppLangParser.ClassOrDeclTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#baseTypeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseTypeSpecifier(CppLangParser.BaseTypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#accessSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessSpecifier(CppLangParser.AccessSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#conversionFunctionId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConversionFunctionId(CppLangParser.ConversionFunctionIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#conversionTypeId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConversionTypeId(CppLangParser.ConversionTypeIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#conversionDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConversionDeclarator(CppLangParser.ConversionDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#constructorInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorInitializer(CppLangParser.ConstructorInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#memInitializerList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemInitializerList(CppLangParser.MemInitializerListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#memInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemInitializer(CppLangParser.MemInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#meminitializerid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeminitializerid(CppLangParser.MeminitializeridContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#operatorFunctionId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorFunctionId(CppLangParser.OperatorFunctionIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#literalOperatorId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralOperatorId(CppLangParser.LiteralOperatorIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#templateDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateDeclaration(CppLangParser.TemplateDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#templateparameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateparameterList(CppLangParser.TemplateparameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#templateParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateParameter(CppLangParser.TemplateParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(CppLangParser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#simpleTemplateId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleTemplateId(CppLangParser.SimpleTemplateIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#templateId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateId(CppLangParser.TemplateIdContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#templateName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateName(CppLangParser.TemplateNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#templateArgumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateArgumentList(CppLangParser.TemplateArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#templateArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateArgument(CppLangParser.TemplateArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#typeNameSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeNameSpecifier(CppLangParser.TypeNameSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#explicitInstantiation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitInstantiation(CppLangParser.ExplicitInstantiationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#explicitSpecialization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitSpecialization(CppLangParser.ExplicitSpecializationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#tryBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryBlock(CppLangParser.TryBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#functionTryBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionTryBlock(CppLangParser.FunctionTryBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#handlerSeq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandlerSeq(CppLangParser.HandlerSeqContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#handler}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandler(CppLangParser.HandlerContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#exceptionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionDeclaration(CppLangParser.ExceptionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#throwExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowExpression(CppLangParser.ThrowExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#exceptionSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExceptionSpecification(CppLangParser.ExceptionSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#dynamicExceptionSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDynamicExceptionSpecification(CppLangParser.DynamicExceptionSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#typeIdList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdList(CppLangParser.TypeIdListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#noeExceptSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoeExceptSpecification(CppLangParser.NoeExceptSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#theOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTheOperator(CppLangParser.TheOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CppLangParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(CppLangParser.LiteralContext ctx);
}