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
    implementation(kotlin("reflect"))
    implementation(kotlin("script-runtime"))
    implementation(kotlin("compiler-embeddable"))
    implementation(kotlin("script-util"))
    implementation(kotlin("scripting-compiler-embeddable"))
    implementation("com.lordcodes.turtle:turtle:0.5.0")
}

tasks.generateGrammarSource {
    maxHeapSize = "64m"
    arguments = arguments + listOf("-visitor", "-long-messages")
    outputDirectory = file("${projectDir}/src/main/java")
}
project.ext{
    antlrDir = file("${project.buildDir}/generated-sources/antlr")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "16"
    }
}
tasks.compileKotlin {
    dependsOn(tasks.generateGrammarSource)
}

tasks.register<Jar>("c2k") {
    //archiveClassifier.set("jar")
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
    from(sourceSets.main.get().output)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
        //exclude("main/kotlin/preparation/**")
    })
}
//tasks.register<Jar>("prepare-c2k"){
//    manifest {
//        attributes["Main-Class"] = "MainPrepareKt"
//    }
//    from(sourceSets["main/kotlin/preparation"].output)
//    dependsOn(configurations.runtimeClasspath)
//}





