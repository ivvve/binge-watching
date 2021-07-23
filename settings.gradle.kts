rootProject.name = "binge-watching"
rootProject.children.forEach { project ->
    project.buildFileName = "${project.name}.gradle.kts"
}

// domain modules
include("domain:member")
project(":domain:member").projectDir = file("src/domain/member")
