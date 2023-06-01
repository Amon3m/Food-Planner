package com.m3.foodplanner.signup.model;

public class SignUpModel {
    public SignUpModel(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public SignUpModel() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String userName;
    private String email;
}
