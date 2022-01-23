
plugins {
    kotlin("jvm") version "1.6.0"
    application
    //id("com.strumenta.antlr-kotlin") version "0.0.7"
}
application {
    mainClass.set("MainKt")
}
//val group: String by project//group = "edu.hse"
//version = "1.0-SNAPSHOT"
val antlr by configurations.creating



repositories {
    mavenCentral()
    maven("https://jitpack.io")

}


dependencies {
    implementation(kotlin("stdlib"))
    //implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.0")

    // implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.0")

    //implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("reflect"))
    //testImplementation(kotlin("test-junit5"))
    api("org.antlr:antlr4:4.9.3")
    antlr("org.antlr.antlr4-runtime:4.9.1")
    implementation("com.strumenta.antlr-kotlin:antlr-kotlin-gradle-plugin:160bc0b70f")
    implementation("com.strumenta.antlr-kotlin:antlr-kotlin-runtime:160bc0b70f")
}
val version: String by project
// we create an alias here...
val versionProperty = version
// do the same for group
val group: String by project
val groupProperty = if (group.endsWith(".antlr-kotlin")) {
    group
} else {
    // just another jitpack hack
    "$group.antlr-kotlin"
}

//val antlrVersion = "4.7.1"
val antlrKotlinVersion = versionProperty
// you can also use a jitpack version:
//val antlrKotlinVersion = "86a86f1968"

buildscript {
    // we have to re-declare this here :-(

    // a small hack: the variable must be named like the property
    // jitpack will pass -Pversion=..., so `val version` is required here.
    val version: String by project
    // we create an alias here...
    val versionProperty = version
    // do the same for group
    val group: String by project
    val groupProperty = if (group.endsWith(".antlr-kotlin")) {
        group
    } else {
        // just another jitpack hack
        "$group.antlr-kotlin"
    }

    val antlrKotlinVersion = versionProperty
    // you can also use a jitpack version (we have to re-declare this here):
    //val antlrKotlinVersion = "86a86f1968"

    dependencies {
        // add the plugin to the classpath
        classpath("com.strumenta.antlr-kotlin:antlr-kotlin-gradle-plugin:160bc0b70f")
        //classpath("$groupProperty:antlr-kotlin-gradle-plugin:$antlrKotlinVersion")
    }
}

// in antlr-kotlin-plugin <0.0.5, the configuration was applied by the plugin.
// starting from verison 0.0.5, you have to apply it manually:
//tasks.register<com.strumenta.antlrkotlin.gradleplugin.AntlrKotlinTask>("generateKotlinGrammarSource") {
//    // the classpath used to run antlr code generation
//    antlrClasspath = configurations.detachedConfiguration(
//        // antlr itself
//        // antlr is transitive added by antlr-kotlin-target,
//        // add another dependency if you want to choose another antlr4 version (not recommended)
//        // project.dependencies.create("org.antlr:antlr4:$antlrVersion"),
//
//        // antlr target, required to create kotlin code
//        project.dependencies.create("com.strumenta.antlr-kotlin:antlr-kotlin-target:160bc0b70f")
//    )
//    maxHeapSize = "64m"
//    packageName = "edu.hse"//"com.strumenta.antlrkotlin.examples"
//    arguments = listOf("-no-visitor", "-no-listener")
//    source = project.objects
//        .sourceDirectorySet("antlr", "antlr")
//        .srcDir("src/antlr4").apply {
//            include("*.g4")
//        }
//    // outputDirectory is required, put it into the build directory
//    // if you do not want to add the generated sources to version control
//    //outputDirectory = File("build/generated-src/antlr/main")
//    // use this settings if you want to add the generated sources to version control
//    outputDirectory = File("src/main/kotlin-antlr")
//}
//
//// run generate task before build
//// not required if you add the generated sources to version control
//// you can call the task manually in this case to update the generated sources
//tasks.getByName("compileKotlin").dependsOn("generateKotlinGrammarSource")
//
//// you have to add the generated sources to kotlin compiler source directory list
//configure<SourceSetContainer> {
//    named("main") {
//        withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
//            // kotlin.srcDir("build/generated-src/antlr/main")
//            kotlin.srcDir("src/main/kotlin-antlr")
//        }
//    }
//}
//
//
//// to allow -x jsIrBrowserTest -x jsLegacyBrowserTest, see .ci.sh
//tasks.register("jsIrBrowserTest")
//tasks.register("jsLegacyBrowserTest")



