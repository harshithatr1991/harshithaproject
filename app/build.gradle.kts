plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.harshitha_code_test"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.harshitha_code_test"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}


dependencies {
        testImplementation ("junit:junit:4.13.2")



    testImplementation ("org.mockito:mockito-core:3.9.0")

        // Coroutines test dependencies (if using coroutines)
        testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.0")

        implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
        implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")


    // Espresso for UI testing
        androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
        androidTestImplementation ("androidx.test.ext:junit:1.1.3")

        // Espresso contrib (optional, for advanced features like RecyclerView)
        androidTestImplementation ("androidx.test.espresso:espresso-contrib:3.4.0")




    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    testImplementation ("org.junit.jupiter:junit-jupiter:5.9.0")
    testImplementation ("junit:junit:4.13.2")
    testImplementation ("org.mockito:mockito-core:3.11.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation ("com.squareup.okhttp3:mockwebserver:4.10.0") // Adjust version as needed
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    implementation ("androidx.paging:paging-runtime-ktx:3.1.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")


    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("androidx.compose.ui:ui:1.5.0") // Update to the latest Compose version
    implementation ("androidx.compose.material3:material3:1.3.0") // Update to the latest Material3 version
    implementation ("androidx.activity:activity-compose:1.7.0") // Update to the latest Activity Compose versionimplementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}