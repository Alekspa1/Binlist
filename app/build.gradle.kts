plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
}

android {
    namespace = "com.drag0n.binlist"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.drag0n.binlist"
        minSdk = 24
        targetSdk = 35
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
            kapt {
                arguments {arg("room.schemaLocation", "$projectDir/schemas")}
            }
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
        viewBinding = true
    }
}

dependencies {

    //Room
    implementation (libs.androidx.room.runtime) // Библиотека "Room"
    kapt (libs.androidx.room.compiler) // Кодогенератор
    implementation (libs.androidx.room.ktx) // Дополнительно для Kotlin Coroutines, Kotlin Flows
    //Picasso
    implementation (libs.picasso)
    //Live Data для фрагментов
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.fragment.ktx)
    //Retrofit
    implementation(libs.logging.interceptor)
    implementation(libs.okhttp)
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.converter.simplexml)
    // Dagger
    implementation (libs.hilt.android)
    kapt (libs.hilt.compiler)
    //

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}