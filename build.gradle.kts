

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

    maven { url = uri("https://jitpack.io") }
    maven("https://packages.jetbrains.team/maven/p/ij/intellij-dependencies")
    maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-ide/")
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-dependencies")
    maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-ide-plugin-dependencies")
    maven("https://dl.google.com/dl/android/maven2")
    maven("https://download.jetbrains.com/teamcity-repository/")
}


dependencies {
    implementation(kotlin("stdlib"))
    implementation(fileTree(mapOf("dir" to "lib", "include" to listOf("*.jar"))))
    runtimeOnly("org.jetbrains.kotlin:kotlin-compiler-for-ide:1.7.0-dev-1132")
    implementation("org.jetbrains.kotlin:kotlin-compiler:1.3.70")
    implementation("org.junit.jupiter:junit-jupiter:5.8.2")
    //---------------------------------------------------------
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    //implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.10")
    //implementation("org.jetbrains.kotlin:util:1.6.10")
    //implementation("org.jetbrains.kotlin:config:1.6.10")
    //implementation("org.jetbrains.kotlin:config.jvm:1.6.10")
    //implementation("org.jetbrains.kotlin:container:1.6.10")
    //implementation("org.jetbrains.kotlin:resolution.common:1.6.10-release-949")
    //implementation("org.jetbrains.kotlin:ir.interpreter:1.6.10-release-949")
    //implementation("org.jetbrains.kotlin:kotlin-script-runtime:1.6.10")
    runtimeOnly("org.jetbrains.kotlin:idea:213-1.6.10-release-949-IJ6461.79")
    implementation("org.jetbrains.kotlin:kotlin-scripting-compiler:1.6.10")
    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:1.6.10")
    runtimeOnly("org.jetbrains.kotlin:idea:213-1.6.10-release-949-IJ6461.79")
    runtimeOnly("org.jetbrains.kotlin:common:213-1.6.10-release-949-IJ6461.79")
    implementation("com.github.JetBrains:intellij-community:+")
    //implementation("com.github.JetBrains:kotlin:1.6.10")
    //-------------------------------------------------------
}
