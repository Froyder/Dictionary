object Versions {
    const val KOTLIN_VERSION = "1.5.31"
    const val ANDROID_CORE_KTX_VERSION = "1.7.0"
    const val APPCOMPAT_VERSION = "1.3.1"
    const val MATERIAL_VERSION = "1.4.0"
    const val CONSTRAINTLAYOUT_VERSION = "2.1.1"
    const val NAVIGATION_VERSION = "2.3.5"
    const val SWIPEREFRESHLAYOUT_VERSION = "1.1.0"

    const val JUNIT_VERSION = ""
    const val JUNIT_TEST_EXT_VERSION = "1.1.3"
    const val ESPRESSO_CORE_VERSION = "3.4.0"

    const val KOIN_VERSION = "3.1.2"
    const val COIL_VERSION = "0.11.0"
    const val ROOM_VERSION = "2.3.0"
    const val DAGGER_VERSION = "2.37"
    const val COROUTINES_VERSION = "1.5.1"
    const val COROUTINES_RETROFIT2_ADAPTER_VERSION = "0.9.2"
    const val TIMBER_VERSION = "5.0.1"
    const val RETROFIT2_VERSION = "2.9.0"
    const val INTERCEPTOR_VERSION = "4.9.1"
    const val RETROFIT2_RXJAVA2_ADAPTER = "1.0.0"
    const val RXJAVA2_VERSION = "2.2.20"
    const val RXJAVA2_RXANDROID_VERSION = "2.1.1"

    const val SUPPORT_LIB_VERSION = "24.2.1"
}

object Dependencies {
    const val ANDROID_CORE_KTX_DEP = "androidx.core:core-ktx:${Versions.ANDROID_CORE_KTX_VERSION}"
    const val KOTLIN_STD_DEP = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_VERSION}"
    const val APPCOMPAT_DEP = "androidx.appcompat:appcompat:${Versions.APPCOMPAT_VERSION}"
    const val MATERIAL_DEP = "com.google.android.material:material:${Versions.MATERIAL_VERSION}"
    const val CONSTRAINTLAYOUT_DEP = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINTLAYOUT_VERSION}"
    const val NAVIGATION_FRAGMENT_DEP = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION_VERSION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION_VERSION}"
    const val SWIPEREFRESHLAYOUT_DEP = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.SWIPEREFRESHLAYOUT_VERSION}"

    const val JUNIT_DEP = "junit:junit:${Versions.JUNIT_VERSION}"
    const val JUNIT_TEST_EXT_DEP = "androidx.test.ext:junit:${Versions.JUNIT_TEST_EXT_VERSION}"
    const val ESPRESSO_CORE_DEP = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE_VERSION}"

    const val KOIN_CORE_DEP = "io.insert-koin:koin-core:${Versions.KOIN_VERSION}"
    const val KOIN_ANDROID_DEP = "io.insert-koin:koin-android:${Versions.KOIN_VERSION}"
    const val KOIN_ANDROID_COMPAT_DEP = "io.insert-koin:koin-android-compat:${Versions.KOIN_VERSION}"

    const val ROOM_RUNTIME_DEP = "androidx.room:room-runtime:${Versions.ROOM_VERSION}"
    const val ROOM_COMPILER_DEP = "androidx.room:room-compiler:${Versions.ROOM_VERSION}"
    const val ROOM_KTX_DEP = "androidx.room:room-ktx:${Versions.ROOM_VERSION}"

    const val DAGGER_DEP = "com.google.dagger:dagger:${Versions.DAGGER_VERSION}"
    const val DAGGER_ANDROID_DEP = "com.google.dagger:dagger-android:${Versions.DAGGER_VERSION}"
    const val DAGGER_ANDROID_SUPPORT_DEP = "com.google.dagger:dagger-android-support:${Versions.DAGGER_VERSION}"
    const val DAGGER_COMPILER_DEP = "com.google.dagger:dagger-compiler:${Versions.DAGGER_VERSION}"
    const val DAGGER_ANDROID_PROCESSOR = "com.google.dagger:dagger-android-processor:${Versions.DAGGER_VERSION}"

    const val COROUTINES_CORE_DEP = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES_VERSION}"
    const val COROUTINES_ANDROID_DEP = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_VERSION}"
    const val COROUTINES_RETROFIT2_ADAPTER_DEP =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.COROUTINES_RETROFIT2_ADAPTER_VERSION}"

    const val RETROFIT2_DEP = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT2_VERSION}"
    const val RETROFIT2_GSON_CONVERTER_DEP = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT2_VERSION}"
    const val INTERCEPTOR_DEP = "com.squareup.okhttp3:logging-interceptor:${Versions.INTERCEPTOR_VERSION}"
    const val RETROFIT2_RXJAVA2_ADAPTER_DEP =
        "com.jakewharton.retrofit:retrofit2-rxjava2-adapter:${Versions.RETROFIT2_RXJAVA2_ADAPTER}"

    const val RXJAVA2_DEP = "io.reactivex.rxjava2:rxjava:${Versions.RXJAVA2_VERSION}"
    const val RXJAVA2_RXANDROID_DEP = "io.reactivex.rxjava2:rxandroid:${Versions.RXJAVA2_RXANDROID_VERSION}"

    const val TIMBER_DEP = "com.jakewharton.timber:timber:${Versions.TIMBER_VERSION}"
    const val COIL_DEP = "io.coil-kt:coil:${Versions.COIL_VERSION}"

    const val SUPPORT_APPCOMPAT_DEP = "com.android.support:appcompat-v7:${Versions.SUPPORT_LIB_VERSION}"
    const val SUPPORT_DESIGN_DEP = "com.android.support:design:${Versions.SUPPORT_LIB_VERSION}"

}