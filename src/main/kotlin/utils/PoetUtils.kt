package utils

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec

fun makeRightClassName(className: String): String {
    var str = className
    if (className[0].isLowerCase()) {
        str = className.replaceRange(0, 1, className[0].toString().uppercase())
    }
    return str
}

fun createClassWithPoet(className: String): String {
    val newClass = FileSpec.builder("", className)
    newClass.addType(
        TypeSpec.classBuilder(className)
            .primaryConstructor(
                FunSpec.constructorBuilder()
                    .build()
            )
            .build()
    )
    val cls = newClass.build()
    return cls.toString()
}