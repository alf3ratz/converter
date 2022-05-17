package utils

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec
import java.io.File
import java.nio.file.Paths

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
            //.addModifiers(KModifier.DATA)
            .primaryConstructor(
                FunSpec.constructorBuilder()
                    .build()
            )
            .build()
    )

    val cls = newClass.build()
    val path = Paths.get("").toAbsolutePath().toString()
    val pathToClass = "$path\\src\\main\\kotlin\\$className.kt"
    File(pathToClass).printWriter().use { out ->
        out.println(cls.toString())
        out.flush()
        out.close()
    }
    return cls.toString()
}