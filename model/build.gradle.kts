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

    implementation (Dependencies.ROOM_RUNTIME_DEP)
    kapt (Dependencies.ROOM_COMPILER_DEP)
    implementation (Dependencies.ROOM_KTX_DEP)
    implementation (Dependencies.RETROFIT2_GSON_CONVERTER_DEP)

    implementation (Dependencies.ANDROID_CORE_KTX_DEP)
    implementation (Dependencies.APPCOMPAT_DEP)
    implementation (Dependencies.MATERIAL_DEP)
    testImplementation (Dependencies.JUNIT_DEP)
    androidTestImplementation (Dependencies.JUNIT_TEST_EXT_DEP)
    androidTestImplementation (Dependencies.ESPRESSO_CORE_DEP)

}