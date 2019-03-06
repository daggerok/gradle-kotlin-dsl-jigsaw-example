import com.github.daggerok.Global.globalGradleVersion
import com.github.daggerok.Global.globalGroupId
import com.github.daggerok.Global.globalJava8Version
import com.github.daggerok.Global.globalJavaVersion
import com.github.daggerok.Global.globalJunit4Version
import com.github.daggerok.Global.globalKotlinParams
import com.github.daggerok.Global.globalLombokVersion
import com.github.daggerok.Global.globalProjectVersion
import io.franzbecker.gradle.lombok.LombokPluginExtension
import org.gradle.java.JavaModule
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    base
    id("io.franzbecker.gradle-lombok") version "2.1" apply false
    id("org.gradle.java.experimental-jigsaw") version "0.1.1" apply false
    kotlin("jvm") version "1.3.21" // id("org.jetbrains.kotlin.jvm") version "1.3.21" apply false
}

allprojects {
    apply(plugin = "idea")
    apply(plugin = "base")

    group = globalGroupId
    version = globalProjectVersion

    defaultTasks("build", "installDist")

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    configure<JavaPluginConvention> {
        sourceCompatibility = globalJavaVersion
        targetCompatibility = globalJavaVersion
    }

    apply(plugin = "java-library")
    apply(plugin = "org.gradle.java.experimental-jigsaw")
    configure<JavaModule> {
        setName(project.name)
    }

    apply(plugin = "io.franzbecker.gradle-lombok")
    configure<LombokPluginExtension> {
        version = globalLombokVersion
    }
}

val apiProject = project(":modules:api") { }

listOf("en", "ru", "sp", "ua").forEach {
    project(":modules:impl:$it") {
        dependencies {
            api(apiProject)
        }
    }
}

project(":app") {
    dependencies {
        implementation("io.vavr:vavr:0.9.2")
        testCompile("junit", "junit", globalJunit4Version)

        api(apiProject)
        implementation(project(":modules:impl:en"))
        implementation(project(":modules:impl:ru"))
        implementation(project(":modules:impl:sp"))
        implementation(project(":modules:impl:ua"))
    }

    apply(plugin = "application")
    configure<ApplicationPluginConvention> {
        mainClassName = "com.github.daggerok.App"
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    freeCompilerArgs = globalKotlinParams
    jvmTarget = "$globalJava8Version"
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    freeCompilerArgs = globalKotlinParams
    jvmTarget = "$globalJava8Version"
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs = globalKotlinParams
        jvmTarget = "$globalJava8Version"
    }
}

tasks.withType<Wrapper> {
    gradleVersion = globalGradleVersion
    distributionType = Wrapper.DistributionType.BIN
}
