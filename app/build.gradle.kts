plugins {
    id ("com.android.application")
    kotlin ("android")
    kotlin ("kapt")
}

android {
    compileSdk = 31
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.example.dictionary"
        minSdk = 29
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments(mapOf("room.schemaLocation" to "$projectDir/schemas"))
            }
        }

        buildTypes {
            getByName("release") {
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
        viewBinding {
            android.buildFeatures.viewBinding = true
        }
    }
}

dependencies {
    implementation ("androidx.core:core-ktx:1.7.0")
    implementation ("androidx.appcompat:appcompat:1.3.1")
    implementation ("com.google.android.material:material:1.4.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.1")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation ("androidx.navigation:navigation-ui-ktx:2.3.5")
    implementation ("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    testImplementation ("junit:junit:")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")

    //Kotlin
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.5.31")

    // Rx-Java
    implementation ("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation ("io.reactivex.rxjava2:rxjava:2.2.20")

    // Retrofit 2
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.1")
    implementation ("com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0")

    //Dagger
    implementation ("com.google.dagger:dagger:2.37")
    implementation ("com.google.dagger:dagger-android:2.37")
    implementation ("com.google.dagger:dagger-android-support:2.37")
    kapt ("com.google.dagger:dagger-compiler:2.37")
    kapt ("com.google.dagger:dagger-android-processor:2.37")

    implementation ("com.jakewharton.timber:timber:5.0.1")

    implementation ("io.insert-koin:koin-core:3.1.2")
    implementation ("io.insert-koin:koin-android:3.1.2")
    implementation ("io.insert-koin:koin-android-compat:3.1.2")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")
    implementation ("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")

    //Coil
    implementation ("io.coil-kt:coil:0.11.0")

    //Room
    implementation ("androidx.room:room-runtime:2.3.0")
    kapt ("androidx.room:room-compiler:2.3.0")
    implementation ("androidx.room:room-ktx:2.3.0")

    implementation ("android.arch.persistence.room:runtime:1.1.1")
    kapt ("android.arch.persistence.room:compiler:1.1.1")
}