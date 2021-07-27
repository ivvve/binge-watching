import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.21"
    kotlin("plugin.spring") version "1.5.21"
    id("io.gitlab.arturbosch.detekt").version("1.18.0-RC2")
}

java.sourceCompatibility = JavaVersion.VERSION_11

allprojects {
    group = "com.tistory.devs0n"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply {
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("io.gitlab.arturbosch.detekt")
    }

    dependencies {
        // Kotlin
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        // Spring
        implementation("org.springframework.boot:spring-boot-starter")
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

        // Dev
        developmentOnly("org.springframework.boot:spring-boot-devtools")

        // Testing
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("io.kotest:kotest-runner-junit5:4.6.1")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

detekt {
    // Detekt Configuration - See https://detekt.github.io/detekt/gradle.html#kotlin-dsl-3
    input = files("src/main/kotlin", "src/test/kotlin")
    debug = false
    parallel = true
    ignoreFailures = false
    config.setFrom(files("$rootDir/project-config/convention/detekt-config.yml"))

    reports {
        xml {
            enabled = false
            destination = file("build/reports/detekt.xml")
        }
        html {
            enabled = false
            destination = file("build/reports/detekt.html")
        }
    }
}

tasks.create("buildApiApplication") {
    dependsOn(":application:api:build")
}
