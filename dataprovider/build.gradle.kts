plugins {
    id ("com.android.library")
    kotlin ("android")
    kotlin ("kapt")
}

android {
    compileSdk = 31
    buildToolsVersion = "30.0.3"
}

dependencies {
    implementation(project(":model"))
    implementation(project(":utils"))
    implementation(project(":database"))

    //Kotlin
    implementation (Dependencies.KOTLIN_STD_DEP)

    // Retrofit 2
    implementation (Dependencies.RETROFIT2_DEP)
    implementation (Dependencies.RETROFIT2_GSON_CONVERTER_DEP)
    implementation (Dependencies.INTERCEPTOR_DEP)
    implementation (Dependencies.RETROFIT2_RXJAVA2_ADAPTER_DEP)

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