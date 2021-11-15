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

    implementation (Dependencies.RETROFIT2_GSON_CONVERTER_DEP)
    
    implementation (Dependencies.ROOM_RUNTIME_DEP)
    kapt (Dependencies.ROOM_COMPILER_DEP)
    implementation (Dependencies.ROOM_KTX_DEP)
}