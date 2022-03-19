package utils

fun makeRightClassName(className:String):String{
    var str = className
    if(className[0].isLowerCase()){
        str = className.replaceRange(0,1,className[0].toString().uppercase())
    }
    return str
}