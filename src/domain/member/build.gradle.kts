import org.springframework.boot.gradle.tasks.bundling.BootJar

description = "Domain Member Module"

plugins {
}

dependencies {
    implementation("com.fasterxml.uuid:java-uuid-generator:4.0")

    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    runtimeOnly("mysql:mysql-connector-java")

    testImplementation("com.h2database:h2")
}

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true
