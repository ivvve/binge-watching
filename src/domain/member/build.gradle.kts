description = "Domain Member Module"

plugins {
}

dependencies {
    implementation("com.fasterxml.uuid:java-uuid-generator:4.0")

    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    runtimeOnly("mysql:mysql-connector-java")
}
