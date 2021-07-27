description = "Application API Module"

plugins {
    id("org.asciidoctor.convert") version "1.5.8"
}

val snippetsDir by extra { file("build/generated-snippets") }
extra["testcontainersVersion"] = "1.15.3"

dependencies {
    // :domain:member
    implementation(project(":domain:member"))
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
    testImplementation("org.testcontainers:junit-jupiter")
}

dependencyManagement {
    imports {
        mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
    }
}
