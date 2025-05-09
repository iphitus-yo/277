pluginManagement {
    repositories {
<<<<<<< HEAD
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        // Versions are defined in the root build.gradle.kts
    }
}

=======
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
>>>>>>> d3bca4a (Primeiro commit)
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

<<<<<<< HEAD
rootProject.name = "ParanalogNovo"
include(":app")

=======
rootProject.name = "TruckCheck"
include(":app")
>>>>>>> d3bca4a (Primeiro commit)
