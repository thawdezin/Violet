buildscript {
    val kotlinVersion by extra("1.5.0")
    repositories {
        google()
        mavenCentral()
        //maven { url = uri("https://jitpack.io") }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.2.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        //classpath("com.google.gms:google-services:4.3.8")
        classpath("android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.5")
        // Add the Crashlytics Gradle plugin (be sure to add version
        // 2.0.0 or later if you built your app with Android Studio 4.1).
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.7.1")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}