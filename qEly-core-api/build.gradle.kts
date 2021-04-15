group = "com.elouyi.qely"
version = Versions.qEly

plugins {
    kotlin("multiplatform")
    id("com.android.application")
    id("kotlin-android-extensions")
}

repositories {
    google()
    gradlePluginPortal()
    jcenter()
}

kotlin {

    jvm("jvm") {

    }

    js("js",LEGACY) {
        browser()
        nodejs()
    }

    linuxX64("linux")

    macosX64("mac")

    mingwX64("windows")

    android("android")

    sourceSets {

        val commonMain by getting

        val jvmMain by getting {

        }

        val jsMain by getting

        val nativeMain by creating {
            dependsOn(commonMain)
        }

        val linuxMain by getting {
            dependsOn(nativeMain)
        }

        val macMain by getting {
            dependsOn(nativeMain)
        }

        val windowsMain by getting {
            dependsOn(nativeMain)
        }
    }
}

android {
    compileSdkVersion(29)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        applicationId = "com.elouyi.mainModule"
        minSdkVersion(24)
        targetSdkVersion(29)
    }
}