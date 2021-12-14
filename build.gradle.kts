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
    maven(url = "https://mvnrepository.com/artifact")
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
    runtimeOnly("org.jetbrains.kotlin:kotlin-compiler-for-ide:1.5.10-release-891")
    implementation("org.jetbrains.kotlin:kotlin-compiler:1.3.70")
}