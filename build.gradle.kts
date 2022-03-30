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

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.squareup:kotlinpoet:1.10.2")
    implementation("org.junit.jupiter:junit-jupiter:5.8.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")
    testImplementation("org.assertj:assertj-core:3.12.2")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.4")
    implementation("com.github.ajalt.clikt:clikt:3.4.0")
    implementation("com.squareup:kotlinpoet:1.10.2")
    testImplementation(kotlin("test"))
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

        jvmTarget = "11"
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
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





