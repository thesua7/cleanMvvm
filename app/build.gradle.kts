plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt") // Apply the Kotlin Kapt plugin using the Kotlin DSL

    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.thesua7.cleanmvvm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.thesua7.cleanmvvm"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    buildFeatures{
        viewBinding = true
    }

}

dependencies {

    implementation(Dependencies.Ktx)
    implementation(Dependencies.Appcompat)
    implementation(Dependencies.Material)
    implementation(Dependencies.Activity)
    implementation(Dependencies.Constraintlayout)
    implementation(Dependencies.kotlinFragment)

    implementation(Dependencies.lifecycleViewModel)
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.lifecycleLivedata)

    implementation(Dependencies.coroutine)

    implementation(Dependencies.retrofit)
    implementation(Dependencies.gsonConverter)
    implementation(Dependencies.coil)
    implementation(Dependencies.paging)


    implementation(Dependencies.navigationUi)
    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.featureModuleSupport)



    testImplementation(Dependencies.Junit)
    androidTestImplementation(Dependencies.androidxJunit)
    androidTestImplementation(Dependencies.androidxEspresso)
    androidTestImplementation(Dependencies.testNavigation)

    implementation(Dependencies.HiltAndroid) // Add this line for Hilt Android
    kapt(Dependencies.HiltCompiler) // Add this line for Hilt Compiler

}

apply(plugin = "dagger.hilt.android.plugin")