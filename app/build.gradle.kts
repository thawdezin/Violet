plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    //id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.thawdezin.snowdrop"
        minSdk = 26
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        buildTypes.all { isCrunchPngs = false }
        getByName("release") {
            // Enables code shrinking, obfuscation, and optimization for only
            // your project's release build type.
            isMinifyEnabled = true
            // Enables resource shrinking, which is performed by the
            // Android Gradle plugin.
            isShrinkResources = true
            // Includes the default ProGuard rules files that are packaged with
            // the Android Gradle plugin. To learn more, go to the section about
            // R8 configuration files.
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            ext.set("enableCrashlytics", false)
            ext.set("alwaysUpdateBuildId", false)
            ext.set("enableStability", false)
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        //viewBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerVersion = "1.4.32"
        kotlinCompilerExtensionVersion = "1.0.0-beta07"
    }
}

dependencies {
    //implementation(fileTree(mapOf("dir":"libs", "include":listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.5.10")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.activity:activity-ktx:1.3.0-rc02")
    implementation("androidx.fragment:fragment-ktx:1.3.5")
    // View
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.cardview:cardview:1.0.0")
    //Material Design Theme
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.preference:preference-ktx:1.1.1")
    //Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    implementation("com.android.support:multidex:1.0.3")

    /*********************************************************
     *       Navigation
     *********************************************************/
    val navVersion by extra("2.3.5")
    implementation("android.arch.navigation:navigation-fragment-ktx:1.0.0")
    implementation("android.arch.navigation:navigation-ui-ktx:1.0.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")
    //Navigation // Kotlin
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")
    // Dynamic Feature Module Support
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$navVersion")
    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:$navVersion")

    /************************************************************************
     *           Lifecycle
     ************************************************************************/
    val lifecycleVersion by extra("2.3.1")
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    //Extension
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    // Lifecycles only (without ViewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    // Saved state module for ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.3.1")
    /** Annotation processor **/
    // alternately - if using Java8, use the following instead of lifecycle-compiler
    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion")
    // optional - helpers for implementing LifecycleOwner in a Service
    implementation("androidx.lifecycle:lifecycle-service:$lifecycleVersion")
    // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
    implementation("androidx.lifecycle:lifecycle-process:$lifecycleVersion")
    // optional - ReactiveStreams support for LiveData
    implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:$lifecycleVersion")
    // optional - Test helpers for LiveData
    testImplementation("androidx.arch.core:core-testing:2.1.0")

    /*************************************************************************
     *          Firebase
     **************************************************************************/
    // Import the BoM for the Firebase platform
    implementation(platform("com.google.firebase:firebase-bom:26.1.1"))
    //Add Firebase Core//
    implementation("com.google.firebase:firebase-core:19.0.0")
    //Messaging
    implementation("com.google.firebase:firebase-messaging:22.0.0")
    //realtime database
    implementation("com.google.firebase:firebase-database:20.0.0")
    implementation("com.google.firebase:firebase-database-ktx:20.0.0")
    //Firebase storage is for picture and photos
    implementation("com.google.firebase:firebase-storage:20.0.0")
    // Import the BoM for the Firebase platform
    implementation(platform("com.google.firebase:firebase-bom:25.12.0"))
    // Declare the dependency for the Cloud Storage library
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-storage-ktx")
    // Add the Firebase SDK for Google Analytics
    implementation("com.google.firebase:firebase-analytics:19.0.0")
    // Add the dependencies for any other Firebase products you want to use in your app
    // For example, to also use Firebase Authentication
    implementation("com.google.firebase:firebase-auth:21.0.1")
    implementation("com.google.firebase:firebase-auth-ktx")
    //Firestore
    implementation("com.google.firebase:firebase-firestore:23.0.2")
    //Firebase RecyclerView UI
    implementation("com.firebaseui:firebase-ui-auth:7.1.1")
    implementation("com.firebaseui:firebase-ui-firestore:7.1.1")
    implementation("com.firebaseui:firebase-ui-database:7.1.1")
    // Declare the dependencies for the In-App Messaging and Analytics libraries
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-inappmessaging-display-ktx")
    implementation("com.google.firebase:firebase-analytics-ktx")
    // Declare the dependencies for the Crashlytics and Analytics libraries
    // When using the BoM, you don't specify versions in Firebase library dependencies
    implementation("com.google.firebase:firebase-crashlytics")
    implementation("com.google.firebase:firebase-analytics")

    /*************************************************************************
     *  Retrofit
     **************************************************************************/
//    val retrofit by extra("2.9.0")
//    implementation("com.google.code.gson:gson:2.8.6")
//    implementation("com.squareup.retrofit2:$retrofit")
//    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
//    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

    // Getting a "Could not find" error? Make sure that you've added
    // Google's Maven repository to your root-level build.gradle file

    /**
     * Google Photo API
     */
    //implementation 'com.google.photos.library:google-photos-library-client:1.5.0'
    /*************************************************************************
     *  CameraX
     **************************************************************************/
    // CameraX core library using camera2 implementation
    implementation("androidx.camera:camera-camera2:1.1.0-alpha06")
    // CameraX Lifecycle Library
    implementation("androidx.camera:camera-lifecycle:1.1.0-alpha06")
    // CameraX View class
    implementation("androidx.camera:camera-view:1.0.0-alpha26")
    // CameraX Extensions
    implementation("androidx.camera:camera-extensions:1.0.0-alpha26")

    /**
     *      Photo View
     */
    implementation("io.coil-kt:coil:1.2.1")
    implementation("com.google.accompanist:accompanist-coil:0.10.0")

    /*************************************************************************
     *  Jetpack Compose
     **************************************************************************/
    val composeVersion by extra("1.0.0-rc02")
    implementation("androidx.activity:activity-compose:1.3.0-rc02")
    implementation("androidx.compose.ui:ui:1.0.0-rc02") // composeVersion
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:$composeVersion")
    implementation("androidx.compose.foundation:foundation-layout:$composeVersion")
    // Material Design
    implementation("androidx.compose.material:material:$composeVersion")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:$composeVersion")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
    // Integration with observables
    implementation("androidx.compose.runtime:runtime:$composeVersion")
    implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")
    implementation("androidx.compose.runtime:runtime-rxjava2:$composeVersion")
    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    // Navigation
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha04")
    //
    implementation("com.google.android.material:compose-theme-adapter:$composeVersion")

}