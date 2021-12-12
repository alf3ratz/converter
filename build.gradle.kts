

plugins {
    kotlin("jvm") version "1.6.0"
    application
    //id("com.strumenta.antlr-kotlin") version "0.0.4"
}
application {
    mainClass.set("MainKt")
}
val group: String by project//group = "edu.hse"
//version = "1.0-SNAPSHOT"
val antlr by configurations.creating
val groupProperty = if (group.endsWith(".antlr-kotlin")) {
    group
} else {
    // just another jitpack hack
    "$group.antlr-kotlin"
}
val version: String by project
// we create an alias here...
val versionProperty = version
val antlrKotlinVersion = versionProperty
//val commonAntlr by creating {
//
//    repositories {
//        //mavenLocal()
//        mavenCentral()
//        maven(url="https://jitpack.io")
//    }
//
//    dependencies {
//        api(kotlin("stdlib-common"))
//        val antlrKotlinGroupProperty = "com.strumenta.antlr-kotlin"
//        val antlrKotlinVersion : String by project
//        api("$antlrKotlinGroupProperty:antlr-kotlin-runtime-jvm:-SNAPSHOT")
//    }
//    kotlin.srcDir("build/generated-src/commonAntlr/kotlin")
//}
repositories {
    mavenCentral()
//    maven{
//        url = uri("https://jitpack.io")
//        artifactUrls("com.strumenta/antlr-kotlin")
//    }
}
buildscript {
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
    repositories {
        mavenCentral()
        maven(url="https://jitpack.io")
    }
    //val antlrKotlinGroupProperty = "com.strumenta.antlr-kotlin"
    dependencies {
        //dependencies {
        //		implementation 'com.github.strumenta:antlr-kotlin:-SNAPSHOT'
        //	}
        classpath(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
//        classpath("com.strumenta.antlr-kotlin:antlr-kotlin-gradle-plugin:-SNAPSHOT")
//        classpath("com.strumenta.antlr-kotlin:antlr-kotlin-runtime-jvm:0.0.4")
//        classpath("com.strumenta.antlr-kotlin:antlr-kotlin-runtime-jvm:d4384e4d90")
    }
//    val version: String by project
//    // we create an alias here...
//    val versionProperty = version
//    // do the same for group
//    val group: String by project
//    val groupProperty = if (group.endsWith(".antlr-kotlin")) {
//        group
//    } else {
//        // just another jitpack hack
//        "$group.antlr-kotlin"
//    }
//
//    val antlrKotlinVersion = versionProperty
//    repositories {
//        maven {
//            url = uri("https://plugins.gradle.org/m2/")
//        }
//    }
//    dependencies {
//        classpath ("com.strumenta.antlr-kotlin:antlr-kotlin-gradle-plugin:0.0.7")
//        //classpath("com.strumenta.antlr-kotlin:com.strumenta.antlr-kotlin.gradle.plugin:0.0.7")
//
//    }

    // you can also use a jitpack version (we have to re-declare this here):
    //val antlrKotlinVersion = "86a86f1968"

//    dependencies {
//        // add the plugin to the classpath
//        classpath("$groupProperty:antlr-kotlin-gradle-plugin:$antlrKotlinVersion")
//    }
}

    //apply(plugin = "com.strumenta.antlr-kotlin")
//maven{
//    url= uri("com.strumenta:antlr-kotlin:Tag")
//    artifactUrls("com.strumenta:antlr-kotlin:Tag")
//}
dependencies {
    implementation(kotlin("stdlib"))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    //implementation("com.strumenta:antlr-kotlin:86a86f1968")
    //implementation("com.strumenta:antlr-kotlin:20add4a180")
    api("org.antlr:antlr4:4.9.3")
    //api("com.strumenta.antlr-kotlin:antlr-kotlin-runtime-jvm:86a86f1968")
    antlr("org.antlr.antlr4-runtime:4.9.1")

}
//tasks.register<com.strumenta.antlrkotlin.gradleplugin.AntlrKotlinTask>("generateKotlinGrammarSource") {
//    // the classpath used to run antlr code generation
//    antlrClasspath = configurations.detachedConfiguration(
//        // antlr itself
//        // antlr is transitive added by antlr-kotlin-target,
//        // add another dependency if you want to choose another antlr4 version (not recommended)
//        // project.dependencies.create("org.antlr:antlr4:$antlrVersion"),
//
//        // antlr target, required to create kotlin code
//        //compile 'com.strumenta.antlr-kotlin:antlr-kotlin-target:0.0.4'
//        //project.dependencies.create("com.strumenta.antlr-kotlin:antlr-kotlin-target:0.0.4")
//                //com.strumenta.antlr-kotlin:antlr-kotlin-gradle-plugin:-SNAPSHOT
//    )
//    maxHeapSize = "64m"
//    packageName = "antlr4"
//    arguments = listOf("-visitor", "-listener")
//    source = project.objects
//        .sourceDirectorySet("antlr4", "antlr4")
//        .srcDir("src/antlr4").apply {
//            include("*.g4")
//        }
//    // outputDirectory is required, put it into the build directory
//    // if you do not want to add the generated sources to version control
//    //outputDirectory = File("build/generated-src/antlr/main")
//    // use this settings if you want to add the generated sources to version control
//    outputDirectory = File("src/main/kotlin-antlr")
//}

// run generate task before build
// not required if you add the generated sources to version control
// you can call the task manually in this case to update the generated sources
//tasks.getByName("compileKotlin").dependsOn("generateKotlinGrammarSource")

//// you have to add the generated sources to kotlin compiler source directory list
//configure<SourceSetContainer> {
//    named("main") {
//        withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
//            // kotlin.srcDir("build/generated-src/antlr/main")
//            kotlin.srcDir("src/main/kotlin-antlr")
//        }
//    }
//}

//buildscript {
//    val antlr by configurations.creating
//    repositories {
//        mavenCentral()
//        maven("https://jitpack.io")
//    }
//    subprojects {
//
//        //val antlr by configurations.creating
//        dependencies {
//            //"implementation"(kotlin("stdlib")
//            //"implementation"("com.strumenta:antlr-kotlin:20add4a180")
//            //implementation(kotlin("stdlib"))
//            //implementation("com.strumenta:antlr-kotlin:Tag")
//            classpath("edu.hse:antlr-kotlin-gradle-plugin:86a86f1968")
//            antlr("org.antlr.antlr4-runtime:4.9.1")
//        }
//    }
//}
//////////////////////////////////
// a small hack: the variable must be named like the property
// jitpack will pass -Pversion=..., so `val version` is required here.


