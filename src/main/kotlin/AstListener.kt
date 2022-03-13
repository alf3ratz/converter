import com.squareup.kotlinpoet.*
import java.util.Map
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder

class AstListener(val parser: CppLangParser?, val fileName: String) : CppLangBaseListener() {
    private val uppercaseMap = Map.of("void", "Unit", "int", "Int", "double", "Double", "float", "Float","Object","Any")
    private val ignoreClassNameList = listOf("std","uint32")
    private var convertedCode: StringBuilder = StringBuilder()
    val file = FileSpec.builder("", fileName)
    var currentClassName = ""
    var currentClass: ClassEntity? = null
    var currentTypeSpec: TypeSpec.Builder? = null
    var returnTypeSpec: TypeSpec? = null
    var privateAccess: String? = null

    companion object {
        const val TODO_STRING = "{\n\t// TODO\n}\n"
    }

    fun getConvertedCode(): String {
        return convertedCode.toString()
    }

    fun getConvertedCodeWithPoet(): FileSpec {
//        if (returnTypeSpec == null) {
//            returnTypeSpec = currentTypeSpec!!.build()
//            file.addType(
//                returnTypeSpec!!
//            )
//        }
        val returnValue = file.build()
        println("записал все в файл")
        return returnValue
    }

    fun checkIfMethodInClass(ctx: CppLangParser.FunctionDefinitionContext): Boolean {
        val classHeadName = ctx.parent.parent.parent.getChild(0).getChild(1)
        return classHeadName is CppLangParser.ClassHeadNameContext

    }

    override fun enterFunctionDefinition(ctx: CppLangParser.FunctionDefinitionContext) {
        if (ctx.getChild(1).text.contains("operator") && ctx.getChild(0).getChild(1)!=null) {// Обработка операторов
            println("_operator_")
//            println(ctx.getChild(0).text) // inline void
//            println(ctx.getChild(0).getChild(0).text)
//            //println(ctx.getChild(0).getChild(1).text)
//            println(ctx.getChild(1).text) // operator+=(uint32size)
//            println(ctx.getChild(1).childCount)
//            println(ctx.getChild(2).text)
//            println(ctx.declarator().text)
//            println(ctx.declSpecifierSeq().text)
            println(ctx.getChild(1).getChild(0).text)
            val operatorFunction = FunctionEntity()
            operatorFunction.isFunction = false
            operatorFunction.operatorArguments =
                ctx.getChild(1).text.substring(ctx.getChild(1).text.indexOfFirst { it == '(' }+1,
                    ctx.getChild(1).text.indexOfFirst { it == ')' })
            val operatorSign = ctx.getChild(1).text.substring(8, ctx.getChild(1).text.indexOfFirst { it == '(' })
            operatorFunction.funName = when(operatorSign){
                "+"->"plus"
                "-"->"minus"
                "-="->"minusAssign"
                "+="->"plusAssign"
                "=="->"equals"
                "!="->"equals"
                else -> operatorSign
            }
            val returnType  = ctx.getChild(0).getChild(1).text
            operatorFunction.returnType = uppercaseMap.getOrDefault(returnType, returnType)
            operatorFunction.operatorBody = ctx.getChild(2).text
            currentClass!!.methodsInClass.add(operatorFunction)

        } else {
            println("_function_")
//            println(ctx.getChild(0).text)
//            println(ctx.getChild(0).getChild(0).text)
//            println(ctx.getChild(1).text)
//            println(ctx.getChild(1).childCount)
//            println(ctx.getChild(2).text)
//            println(ctx.declarator().text)
//            println(ctx.declSpecifierSeq().text)
            val returnType = ctx.getChild(0).text.trim { it <= ' ' }.replace("inline","")
            val funName =
                if (ctx.getChild(1).text[ctx.getChild(1).text.length - 2] == '(') ctx.getChild(1).text else removeMethodParameters(
                    ctx.getChild(1).text
                ).replace("()", "")
            if (checkIfMethodInClass(ctx)) {
                val function = FunctionEntity()
                function.funName = funName.replace("()", "")
                function.returnType = uppercaseMap.getOrDefault(returnType, returnType)//"Any"
                currentClass!!.methodsInClass.add(function)
            }
            println("fun: $funName")
            println("returnType: $returnType")

        }
        //println(ctx.parent.parent.parent.getChild(0).getChild(1).text) // Получение имени клсаа, в котором находится метод

    }



    override fun exitFunctionBody(ctx: CppLangParser.FunctionBodyContext?) {
        if (currentClass!!.methodsInClass.size > 0) {
            val function = currentClass!!.methodsInClass.last()
            if(function.isFunction){
                println("добавил функцию")
                currentTypeSpec!!.addFunction(
                    FunSpec.builder(function.funName)
                        .addModifiers(
                            when (privateAccess) {
                                "private" -> KModifier.PRIVATE
                                else -> KModifier.PUBLIC
                            }
                        )
                        .returns(
                            when (function.returnType) {
                                "Int" -> Int::class
                                "String" -> String::class
                                "Float" -> Float::class
                                "Double" -> Double::class
                                "Boolean" -> Boolean::class
                                "Unit" -> Unit::class
                                else -> Any::class
                            }
                        )
                        .build()
                )
            }else{ // Если оператор
                println("добавил оператор")
                //val cls: Class<*> = Class.forName(function.returnType);
                //val stringClass: KClass<out String> = cls
                currentTypeSpec!!.addFunction(
                    FunSpec.builder(function.funName)
                        .addParameter(function.operatorArguments!!,String::class)
                        .addStatement("\t//returns ${function.returnType}\n//${function.operatorBody!!}", String::class)
                        .returns(
                            when (function.returnType) {
                                "Int" -> Int::class
                                "String" -> String::class
                                "Float" -> Float::class
                                "Double" -> Double::class
                                "Boolean" -> Boolean::class
                                "Unit" -> Unit::class
                                "Any" -> Any::class
                                else ->try{
                                    Class.forName("edu.hse.${function.returnType}").kotlin.objectInstance!!::class
                                //Class.forName("edu.hse.${function.returnType}").kotlin.objectInstance!!::class;//Any::class  Class<?> cls = Class.forName(className);
                                }catch(e:RuntimeException){
                                    createClassWithPoet(function.returnType)
                                }
                            }
                        )
                        .build()
                )
            }
            privateAccess = null
        }
    }
private fun createClassWithPoet(className:String){
    val newClass = FileSpec.builder("", className)
    newClass.addType(
        TypeSpec.classBuilder(className).build()
    ).build()
    newClass.
}

    override fun enterClassName(ctx: CppLangParser.ClassNameContext) {
//        // Проверяем, метод какого класса используется
//        // Если стандартная библиотека, то пропускаем
//        if (!ignoreClassNameList.contains(ctx.getChild(0).text)) { // TODO: проходит проверку, если объект небиблиотечного класса указан как параметр метода/оператора
//            if (currentClass != null) {
//                returnTypeSpec = currentTypeSpec!!.build()
//                file.addType(
//                    returnTypeSpec!!
//                )
//            }
//            currentClass = ClassEntity()
//            val name = ctx.getChild(0).text
//            currentClass!!.name = name
//            currentTypeSpec = TypeSpec.classBuilder(currentClass!!.name)
//
//
//            println("className: " + ctx.getChild(0).text)
//            println(ctx.getChild(0).childCount)
//        }
    }

    override fun enterClassSpecifier(ctx: CppLangParser.ClassSpecifierContext) {
        println("~~~~~~~~ classSpecifier ~~~~~~~~~~")
        println("header ${ctx.getChild(0).getChild(1).text}")
        // Проверяем, метод какого класса используется
        // Если стандартная библиотека, то пропускаем
        val className = ctx.getChild(0).getChild(1).text
        if (!ignoreClassNameList.contains(className)) { // TODO: проходит проверку, если объект небиблиотечного класса указан как параметр метода/оператора
            currentClass = ClassEntity()
            currentClass!!.name = className
            currentTypeSpec = TypeSpec.classBuilder(className)
        }
    }

    override fun exitClassSpecifier(ctx: CppLangParser.ClassSpecifierContext?) {
        returnTypeSpec = currentTypeSpec!!.build()
        file.addType(
            returnTypeSpec!!
        )
        println("добавил класс")
        println("~~~~~~~~ exit classSpecifier ~~~~~~~~")
    }

    override fun enterClassHead(ctx: CppLangParser.ClassHeadContext) {// TODO: ctx.classKey().text
        //println("classHead: "+ )
    }

    override fun enterConstructorInitializer(ctx: CppLangParser.ConstructorInitializerContext?) {
        super.enterConstructorInitializer(ctx)
//        println("constr Init: ${ctx!!.text}")
//        println("constr Init 0: ${ctx.getChild(0).text}")
//        println("constr Init 1: ${ctx.getChild(1).text}")
    }

    override fun enterAccessSpecifier(ctx: CppLangParser.AccessSpecifierContext?) {
        super.enterAccessSpecifier(ctx)
        //println("AccessSpecifier: ${ctx!!.text}")
        if (ctx!!.text == "private") {
            privateAccess = "private"
        }
    }

    override fun enterOperatorFunctionId(ctx: CppLangParser.OperatorFunctionIdContext?) {
        super.enterOperatorFunctionId(ctx)
//        println("OperatorFunctionId: ${ctx!!.text}")
//        println("OperatorFunctionId 0: ${ctx.getChild(0).text}")
//        println("OperatorFunctionId 1: ${ctx.getChild(1).text}")

    }


    private fun removeMethodParameters(methodDecl: String): String {
        if (methodDecl.contains("(") and methodDecl.contains(")") and !methodDecl.contains("operator")) {
            //println("method decl: $methodDecl")
            val firstBracketIndex: Int = methodDecl.indexOfFirst { it == '(' }
            val secondBracketIndex = methodDecl.indexOfFirst { it == ')' }
            return methodDecl.removeRange(firstBracketIndex + 1, secondBracketIndex)
        }
        return ""
    }
}


