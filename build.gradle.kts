plugins {
    kotlin("jvm") version "1.5.31"
    application

}
application {
    mainClass.set("MainKt")
}
group = "edu.hse"
version = "1.0-SNAPSHOT"

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
}