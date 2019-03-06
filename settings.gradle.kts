pluginManagement {
    repositories {
        gradlePluginPortal() // required by shadow plugin
    }
}

rootProject.name = "gradle-kotlin-dsl-jigsaw-example"

include(
    ":modules:api",
    ":modules:impl:ua",
    ":modules:impl:ru",
    ":modules:impl:sp",
    ":modules:impl:en",
    ":app"
)
