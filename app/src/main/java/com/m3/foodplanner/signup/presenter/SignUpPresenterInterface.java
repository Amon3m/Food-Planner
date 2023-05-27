package com.m3.foodplanner.signup.presenter;

public interface SignUpPresenterInterface {
    void signUp(String userName, String email, String password);
    void detachView();
}
