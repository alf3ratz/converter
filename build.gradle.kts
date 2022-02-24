plugins {
    kotlin("jvm") version "1.6.0"
    application
    antlr
}
application {
    mainClass.set("MainKt")
}
val group: String by project //group = "edu.hse"
//val antlr: FileCollection by configurations.creating

repositories {
    mavenCentral()
    maven("https://jitpack.io")

}


dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.0")
    //api("org.antlr:antlr4:4.9.3")
    antlr("org.antlr:antlr4:4.9.3")
    //testImplementation(kotlin("test-junit5"))
}

tasks.generateGrammarSource {
    maxHeapSize = "64m"
    arguments = arguments + listOf("-visitor", "-long-messages")
    outputDirectory = file("${projectDir}/src/main/kotlin/generated")
}





