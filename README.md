# DishDash Android App

DishDash is an Android mobile application that helps users plan their weekly meals. The app provides various features such as searching for meals based on country, ingredient, and category, viewing popular meals from different countries, saving favorite meals, and planning meals for the current week. With authentication options, including the ability to reset the password, DishDash offers a convenient and secure experience for users.

## Features

- Search for meals based on country, ingredient, and category.
- View a list of available categories and choose between them.
- Explore popular meals from different countries.
- Add meals to favorites or remove them (using Room for local storage).
- Plan and view meals for the current week.
- Offline access to favorite meals and weekly meal plan.
- Authentication with login, signup, and password reset options, including social networking authentication (Google).
- Seamless retrieval of archived data from the server after successful login (using local SharedPreferences).
- Detailed meal view, including name, image, origin country, ingredients, steps, and an embedded video.
- Ability to add or remove a meal from favorites.

## Architecture

The DishDash Android app follows the MVP (Model-View-Presenter) pattern for organizing its components and implements the repository pattern for data management. It also utilizes the Navigation component from the Android Jetpack library for navigation between different screens and fragments.

## Screenshots

Insert relevant screenshots here.

## Installation

To run the DishDash Android app on your device, follow these steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/username/dishdash.git
   ```

2. Open the project in Android Studio.

3. Build and run the app on an Android device or emulator.

## Dependencies

The DishDash Android app uses the following dependencies:

```groovy
dependencies {
    implementation 'com.google.firebase:firebase-auth-ktx:22.0.0'
    implementation 'com.google.firebase:firebase-auth:22.0.0'
    implementation 'com.google.firebase:firebase-database:20.2.2'
    def nav_version = "2.5.3"

    // Java language implementation
    implementation "androidx.navigation:navigation-fragment:$nav_version"
    implementation "androidx.navigation:navigation-ui:$nav_version"
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.9.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'

    implementation 'com.airbnb.android:lottie:6.0.0'

    // Import the BoM for the Firebase platform
    implementation platform('com.google.firebase:firebase-bom:32.1.0')

    // Also add the dependency for the Google Play services library and specify its version
    implementation 'com.google.android.gms:play-services-auth:20.5.0'

    implementation "androidx.room:room-runtime:$room_version"
    annotationProcessor "androidx.room:room-compiler:$room_version"

    implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'

    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:4.

9.1'
    implementation 'com.pierfrancescosoffritti.androidyoutubeplayer:chromecast-sender:0.28'

    // Navigation component
    def nav_version = "2.5.3"
    implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
    implementation "androidx.navigation:navigation-ui-ktx:$nav_version"
}
```

## Acknowledgments

- This app uses data from [MealDB API](https://www.themealdb.com/api.php).
- Special thanks to the open-source community for their contributions.

---

Note: Please make sure to replace the placeholders (`username`, `demo.gif`, screenshots, etc.) with actual values and files specific to your DishDash Android app repository.