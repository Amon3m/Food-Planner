package com.m3.foodplanner.signup.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.m3.foodplanner.MainActivity;
import com.m3.foodplanner.R;
import com.m3.foodplanner.signin.view.SignInActivity;
import com.m3.foodplanner.signup.presenter.SignUpPresenter;

public class SignUpActivity extends AppCompatActivity implements SignUpView {
     EditText usernameEdit;
     EditText emailEdit;
     EditText passwordEdit;
     Button signupBtn;
     ProgressDialog progressDialog;
     TextView toSignIn;
     SignUpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        usernameEdit = findViewById(R.id.sign_up_username_edit_text);
        emailEdit = findViewById(R.id.sign_up_email_edit_text);
        passwordEdit = findViewById(R.id.sign_up_password_edit_text);
        signupBtn = findViewById(R.id.signup_btn);
        toSignIn = findViewById(R.id.to_sign_in_txt);
        progressDialog = new ProgressDialog(this);

        presenter = new SignUpPresenter(this,this);

        toSignIn.setOnClickListener(v -> presenter.onSignInClicked());

        signupBtn.setOnClickListener(v -> {
            String username = usernameEdit.getText().toString();
            String email = emailEdit.getText().toString();
            String password = passwordEdit.getText().toString();
            presenter.onSignUpClicked(username, email, password);
        });
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        if(errorMessage=="Enter a valid username"){
            usernameEdit.setError(errorMessage);}
        else if (errorMessage=="Enter a valid email"){
            emailEdit.setError(errorMessage);
        }else if (errorMessage=="- At least 8 characters.\n" +
                "- At least one letter (uppercase or lowercase).\n" +
                "- At least one digit."){
            passwordEdit.setError(errorMessage);
        }
    }

    @Override
    public void showProgressDialog() {
        progressDialog.setMessage("Registration...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        progressDialog.dismiss();
    }

    @Override
    public void showRegistrationSuccess() {
        Toast.makeText(this, "Sign up is successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToSignIn() {
        Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


}
