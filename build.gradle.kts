import org.jetbrains.kotlin.gradle.plugin.statistics.ReportStatisticsToElasticSearch.url

plugins {
    kotlin("jvm") version "1.6.10"
    `kotlin-dsl`
    application
}
application {
    mainClass.set("MainKt")
}
group = "edu.hse"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}


dependencies {
    implementation(kotlin("stdlib"))
    implementation(fileTree(mapOf("dir" to "lib", "include" to listOf("*.jar"))))
    runtimeOnly("org.jetbrains.kotlin:kotlin-compiler-for-ide:1.6.20-dev-6927")
    implementation("org.jetbrains.kotlin:kotlin-compiler:1.3.70")
    implementation("com.github.JetBrains:intellij-community:webstorm~193.4099.10")
}
