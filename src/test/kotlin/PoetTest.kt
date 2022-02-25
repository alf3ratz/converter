import kotlin.test.Test
import kotlin.test.assertEquals
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy

class PoetTest {
    @Test
    fun poetTests() {
        val file = FileSpec.builder("", "HelloWorld")
            .addFunction(
                FunSpec.builder("main")
                    .addParameter("args", (Array::class).parameterizedBy(String::class))
                    .addStatement("println(%P)", "Main created successful")
                    .build())
            .build()
        val str = StringBuilder()
        file.writeTo(str)
        assertEquals(str.toString(), "import kotlin.Array\n" +
                "import kotlin.String\n" +
                "import kotlin.Unit\n" +
                "\n" +
                "public fun main(args: Array<String>): Unit {\n" +
                "  println(\"\"\"Main created successful\"\"\")\n" +
                "}\n")
    }
}