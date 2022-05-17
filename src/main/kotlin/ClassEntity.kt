import com.squareup.kotlinpoet.FunSpec

class ClassEntity {
    var name: String = ""
    var methodsInClass = arrayListOf<FunSpec.Builder>()
}