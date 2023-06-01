package com.m3.foodplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.m3.foodplanner.signin.view.SignInActivity;

public class OnboardingTwoActivity extends AppCompatActivity {
    Button myButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_two);

        Button myButton = findViewById(R.id.next_two_btn);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnboardingTwoActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
    }
}
