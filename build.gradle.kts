import org.jetbrains.kotlin.gradle.dsl.Coroutines
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kodein_version: String by project

plugins {
    kotlin("jvm") version "1.3.70"
}

allprojects {
    apply(plugin = "kotlin")
    group = "me.freedom4live.blog"
    version = "0.0.1"

    repositories {
        mavenLocal()
        jcenter()
        maven { url = uri("https://kotlin.bintray.com/ktor") }
    }

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation("org.kodein.di:kodein-di-generic-jvm:$kodein_version")
    }

    val compileKotlin: KotlinCompile by tasks
    compileKotlin.kotlinOptions {
        jvmTarget = "1.8"
    }
    val compileTestKotlin: KotlinCompile by tasks
    compileTestKotlin.kotlinOptions {
        jvmTarget = "1.8"
    }
}

