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

    implementation(project(":model"))
    implementation(project(":utils"))
    implementation(project(":dataprovider"))
    implementation(project(":database"))

    implementation (Dependencies.ANDROID_CORE_KTX_DEP)
    implementation (Dependencies.APPCOMPAT_DEP)
    implementation (Dependencies.MATERIAL_DEP)
    implementation (Dependencies.CONSTRAINTLAYOUT_DEP)
    implementation (Dependencies.NAVIGATION_FRAGMENT_DEP)
    implementation (Dependencies.NAVIGATION_UI)
    implementation (Dependencies.SWIPEREFRESHLAYOUT_DEP)
    testImplementation (Dependencies.JUNIT_DEP)
    androidTestImplementation (Dependencies.JUNIT_TEST_EXT_DEP)
    androidTestImplementation (Dependencies.ESPRESSO_CORE_DEP)

    //Kotlin
    implementation (Dependencies.KOTLIN_STD_DEP)

    // Rx-Java
    implementation (Dependencies.RXJAVA2_DEP)
    implementation (Dependencies.RXJAVA2_RXANDROID_DEP)

    //Dagger
    implementation (Dependencies.DAGGER_DEP)
    implementation (Dependencies.DAGGER_ANDROID_DEP)
    implementation (Dependencies.DAGGER_ANDROID_SUPPORT_DEP)
    kapt (Dependencies.DAGGER_COMPILER_DEP)
    kapt (Dependencies.DAGGER_ANDROID_PROCESSOR)

    //Timber
    implementation (Dependencies.TIMBER_DEP)

    //Koin
    implementation (Dependencies.KOIN_CORE_DEP)
    implementation (Dependencies.KOIN_ANDROID_DEP)
    implementation (Dependencies.KOIN_ANDROID_COMPAT_DEP)

    //Coroutines
    implementation (Dependencies.COROUTINES_CORE_DEP)
    implementation (Dependencies.COROUTINES_ANDROID_DEP)
    implementation (Dependencies.COROUTINES_RETROFIT2_ADAPTER_DEP)

    //Coil
    implementation (Dependencies.COIL_DEP)

    //Room
    implementation (Dependencies.ROOM_RUNTIME_DEP)
    kapt (Dependencies.ROOM_COMPILER_DEP)
    implementation (Dependencies.ROOM_KTX_DEP)
}