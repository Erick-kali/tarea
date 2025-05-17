pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    // Aquí definimos las versiones de los plugins Android y Kotlin
    plugins {
        id("com.android.application") version "7.4.2"
        kotlin("android") version "1.8.21"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "bienestar_salud"
include(":app")
