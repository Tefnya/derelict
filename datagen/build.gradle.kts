import java.nio.file.Files
import java.nio.file.Path

plugins {
  kotlin("jvm") version Versions.KOTLIN
  id("application")
}

group = "dev.mim1q.derelict"

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")
  implementation(files("libs/tada.jar"))
  implementation("com.google.code.gson:gson:2.10.1")
  implementation("blue.endless:jankson:1.2.3")
}

kotlin {
  jvmToolchain(11)
}

application {
  mainClass.set("datagen.MainKt")
}

fun deleteDir(directory: Path) {
  Files.walk(directory)
    .sorted(Comparator.reverseOrder())
    .map { it.toFile() }
    .forEach { it.delete() }
}

val generatedDir = projectDir.resolve("../src/main/generated")
val resourceDir = projectDir.resolve("src/main/resources/")
val langDir = projectDir.resolve("../src/main/resources/assets/derelict/lang")
val langHelperDir = projectDir.resolve("../lang")
val datagenImgDir = projectDir.resolve("img")

tasks {
  withType<JavaExec> {
    doFirst {
      try {
        deleteDir(generatedDir.toPath())
      } catch (_: Exception) {
        println("Datagen output directory hasn't been generated yet")
      }
    }
    args = listOf(generatedDir.path, resourceDir.path, langDir.path, langHelperDir.path)
  }
}