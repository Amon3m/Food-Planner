package com.m3.foodplanner.signup.presenter;


import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.m3.foodplanner.signup.model.SignUpModel;
import com.m3.foodplanner.signup.view.SignUpView;

public class SignUpPresenter implements SignUpPresenterInterface {
         SignUpView view;
         Context context;
         FirebaseAuth firebaseAuth;
         FirebaseDatabase db;
         DatabaseReference reference;
         SharedPreferences sharedPreferences;
         String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
         String userRegex = "^(?![0-9])[a-zA-Z0-9_]{3,15}$";
         String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";



    public SignUpPresenter(SignUpView view,Context context) {
            this.view = view;
            this.context=context;

        }

        public void onSignInClicked() {
            view.navigateToSignIn();
        }

        public void onSignUpClicked(String username, String email, String password) {
            firebaseAuth = FirebaseAuth.getInstance();
            db = FirebaseDatabase.getInstance();
            reference = db.getReference("Users");
            sharedPreferences = context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);

            if (!username.matches(userRegex)) {
                view.showErrorMessage("Enter a valid username");
            } else if (!email.matches(emailRegex)) {
                view.showErrorMessage("Enter a valid email");
            } else if (!password.matches(passwordRegex)) {
                view.showErrorMessage("- At least 8 characters.\n" +
                        "- At least one letter (uppercase or lowercase).\n" +
                        "- At least one digit.");
            } else {
                view.showProgressDialog();

                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username", username);
                        editor.putString("email", email);
                        editor.putString("password", password);
                        editor.putBoolean("isLoggedIn", true);
                        editor.apply();

                        SignUpModel user = new SignUpModel(username, email);
                        reference.child(username).setValue(user);

                        view.dismissProgressDialog();
                        view.showRegistrationSuccess();
                        view.navigateToHome();
                    } else {
                        view.dismissProgressDialog();
                        view.showErrorMessage(task.getException().getLocalizedMessage());
                    }
                });
            }
        }
    }


