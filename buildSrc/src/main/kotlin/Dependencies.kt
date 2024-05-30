object Dependencies {
    const val Ktx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val Appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val Material = "com.google.android.material:material:${Versions.material}"
    const val Activity = "androidx.activity:activity-ktx:${Versions.activity}"
    const val Constraintlayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val Junit = "junit:junit:${Versions.junit}"
    const val androidxJunit = "androidx.test.ext:junit:${Versions.junitVersion}"
    const val androidxEspresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val kotlinFragment = "androidx.fragment:fragment-ktx:${Versions.fragment_version}"

    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
    const val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_version}"


    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"


    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"

    const val paging = "androidx.paging:paging-runtime:${Versions.paging_version}"


    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"
    const val featureModuleSupport = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.nav_version}"

    const val testNavigation = "androidx.navigation:navigation-testing:${Versions.nav_version}"


    const val HiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val HiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    const val classPathHilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
}