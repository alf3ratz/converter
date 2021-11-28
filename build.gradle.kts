plugins {
    kotlin("jvm") version "1.5.31"
}

group = "edu.hse"
version = "1.0-SNAPSHOT"
val antlr by configurations.creating

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    antlr("org.antlr.antlr4-runtime:4.9.1")
}