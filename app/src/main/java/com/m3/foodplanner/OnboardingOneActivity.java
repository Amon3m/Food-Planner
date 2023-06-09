package com.m3.foodplanner;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OnboardingOneActivity extends AppCompatActivity {
    Button myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_one);

        Button myButton = findViewById(R.id.next_one_btn);
       SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);

        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);
        if (isLoggedIn) {
            // User is already logged in
            goToHome();
            finish(); // Optional: Close the SignInActivity
        }
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnboardingOneActivity.this, OnboardingTwoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void goToHome() {
        Intent intent = new Intent( this, MainActivity.class);
        startActivity(intent);
    }
}
