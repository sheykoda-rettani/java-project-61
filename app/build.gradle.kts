plugins {
    id("java")
    id("com.github.ben-manes.versions") version "0.53.0"
    id("application")
    id("checkstyle")
    id("org.sonarqube") version "7.1.0.6387"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass = "hexlet.code.App"
}

sonar {
    properties {
        property("sonar.projectKey", "sheykoda-rettani_java-project-61")
        property("sonar.organization", "sheykoda-rettani")
    }
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}