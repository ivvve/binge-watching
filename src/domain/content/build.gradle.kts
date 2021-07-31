import org.springframework.boot.gradle.tasks.bundling.BootJar

description = "Domain Content Module"

plugins {
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

    testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo")
}

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true
