rootProject.name = "binge-watching"
rootProject.children.forEach { project ->
    project.buildFileName = "build.gradle.kts"
}

// application modules
include("application:api")
project(":application:api").projectDir = file("src/application/api")

// domain modules
include("domain:member")
project(":domain:member").projectDir = file("src/domain/member")
