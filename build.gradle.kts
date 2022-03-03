plugins {
    kotlin("jvm") version "1.6.0"
    application
    antlr
    idea
    `java-library`
}
application {
    mainClass.set("MainKt")
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")

}
var antlrDir: File? = null

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.4")
    implementation("com.github.ajalt.clikt:clikt:3.4.0")
    antlr("org.antlr:antlr4:4.9.3")
    implementation("com.squareup:kotlinpoet:1.10.2")
    //testImplementation(kotlin("test-junit5"))
}

tasks.generateGrammarSource {
    maxHeapSize = "64m"
    arguments = arguments + listOf("-visitor", "-long-messages")
    //outputDirectory = file("${project.buildDir}/generated-sources/antlr")//file("${projectDir}/src/generated").///main/kotlin
    outputDirectory = file("${projectDir}/src/main/java")///main/kotlin
}
project.ext{
    antlrDir = file("${project.buildDir}/generated-sources/antlr")
}
//sourceSets{
//    main{
//        java.plus(antlrDir)
//    }
//
//}
idea {
    module {
        //excludeDirs.minusAssign(file("${project.buildDir}/generated-sources/antlr"))
        //generatedSourceDirs.add(antlrDir)

        //generatedSourceDirs.plusAssign(file("${projectDir}/src/generated"))
        //sourceDirs.plusAssign(file("${projectDir}/src/generated"))
        //sourceDirs.plusAssign(file("${project.buildDir}/generated-sources/antlr"))

    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}
tasks.compileKotlin {
    dependsOn(tasks.generateGrammarSource)
}
val jar by tasks.getting(Jar::class) {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
}





