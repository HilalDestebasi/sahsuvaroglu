plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    alias(libs.plugins.google.gms.google.services) // Room için kapt desteği
}

android {
    namespace = "com.sahsuvaroglu.kgm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sahsuvaroglu.kgm"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation("com.intuit.sdp:sdp-android:1.1.1")
    implementation("com.intuit.ssp:ssp-android:1.1.1")
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation("com.github.bumptech.glide:glide:4.16.0") {
        exclude(group = "com.intellij", module = "annotations")
        exclude(group = "org.jetbrains", module = "annotations")
    }
    implementation(libs.firebase.database.ktx)
    annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("androidx.viewpager2:viewpager2:1.1.0")
    implementation("com.google.android.gms:play-services-maps:19.0.0") {
        exclude(group = "com.intellij", module = "annotations")
        exclude(group = "org.jetbrains", module = "annotations")
    }

    // Firebase BOM ile Firebase bağımlılıkları
    implementation(platform("com.google.firebase:firebase-bom:33.3.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-firestore")
    implementation("com.google.firebase:firebase-database")

    // Room bağımlılıkları
    implementation("androidx.room:room-runtime:2.6.1")

    // Diğer bağımlılıklar
    implementation("com.google.code.gson:gson:2.11.0")
}

// Çakışmaları önlemek için dependency resolution strategy
configurations.all {
    resolutionStrategy {
        force("org.jetbrains:annotations:23.0.0")
    }
}
