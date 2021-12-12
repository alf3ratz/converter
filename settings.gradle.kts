rootProject.name = "converter"
//include(
//    "antlr-kotlin-runtime",
//    "antlr-kotlin-target",
//    "antlr-kotlin-gradle-plugin"
//)
pluginManagement {
    repositories {
        // used for local development and while building by travis ci and jitpack.io
        mavenLocal()
        //mavenCentral()
        // used to download antlr-kotlin gradle plugin
        gradlePluginPortal()
        // used to download antlr-kotlin-gradle-plugin
        maven("https://jitpack.io")
    }
}