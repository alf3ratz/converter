import org.jetbrains.kotlin.nj2k.printing.JKCodeBuilder

fun main(args: Array<String>) {
    val symbolProvider = JKSymbolProvider(JKResolver(Project(), null, PsiElement()))
    val a = JKCodeBuilder(NewJ2kConverterContext(
        symbolProvider,
        JKTypeFactory(symbolProvider),
        NewJavaToKotlinConverter(Project(), null, ConverterSettings(true, true, true, true, true), EmptyJavaToKotlinServices),
        { element: PsiElement -> true },
        JKImportStorage(LanguageVersionSettingsImpl(KOTLIN_1_6, ApiVersion(MavenComparableVersion(), "")))),
        JKElementInfoStorage(),
        NewExternalCodeProcessing(EmptyReferenceSearcher, { element: PsiElement -> true }),
        true
    )
    println(a.printCodeOut(JKMethodImpl(
        JKTypeElement(JKNoType()),
        JKNameIdentifier("main"),
        listOf<JKParameter>(),
        JKBodyStub(),
        JKTypeParameterList(),
        JKAnnotationList(),
        listOf<JKTypeElement>(),
        listOf<JKOtherModifierElement>(),
        JKVisibilityModifierElement(Visibility.PUBLIC),
        JKModalityModifierElement(Modality.FINAL)
    )))
}