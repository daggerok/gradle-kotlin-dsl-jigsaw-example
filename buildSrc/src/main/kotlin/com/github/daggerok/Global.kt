package com.github.daggerok

import org.gradle.api.JavaVersion

object Global {
    const val globalProjectVersion = "1.0-SNAPSHOT"
    const val globalGroupId = "com.github.daggerok"
    const val globalLombokVersion = "1.18.6"
    const val globalJunit4Version = "4.12"
    const val globalGradleVersion = "5.2.1"
    val globalJavaVersion = JavaVersion.VERSION_11
    val globalJava8Version = JavaVersion.VERSION_1_8
    val globalKotlinParams = mutableListOf("-Xjsr305=strict")
}
