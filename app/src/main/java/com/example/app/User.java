package com.example.app;

public class User {

    public String fullName, age, email;
    public boolean bankSetup;
    public User() {
    }

    public User(String fullName, String age, String email, boolean bankSetup) {
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.bankSetup = bankSetup;
    }

}