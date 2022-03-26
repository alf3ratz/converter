import java.util.Collections.emptyMap

class FunctionEntity {
    var isFunction:Boolean = true
    var funName:String = ""
    var returnType:String = ""

    var operator:String? = ""
    var operatorArguments:String? = ""
    var operatorBody:String? = ""

    var arguments:MutableMap<String,String> = mutableMapOf()
}