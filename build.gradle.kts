plugins {
    kotlin("jvm") version "1.5.31"
    application

}
application {
    mainClass.set("MainKt")
}
group = "edu.hse"
version = "1.0-SNAPSHOT"
val antlr by configurations.creating

repositories {
    mavenCentral()
}
//sourceSets {
//    main {
//        java.srcDir("edu.hse.main.mainKt")
//    }
//}
//tasks.withType<Jar> {
//    manifest {
//        attributes["Main-Class"] = "edu.hse.main.main"
//    }
//}


dependencies {
    implementation(kotlin("stdlib"))
    antlr("org.antlr.antlr4-runtime:4.9.1")
}