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
    testImplementation(kotlin("test"))
    //testRuntime("org.junit.jupiter:junit-jupiter-engine:5.4.2")
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

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}
