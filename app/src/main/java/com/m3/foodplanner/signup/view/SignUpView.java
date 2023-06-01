package com.m3.foodplanner.signup.view;

import android.content.Context;

public interface SignUpView {
    void showErrorMessage(String errorMessage);
    void showProgressDialog();
    void dismissProgressDialog();
    void showRegistrationSuccess();
    void navigateToSignIn();
    void navigateToHome();
  //  Context getContext();
}
