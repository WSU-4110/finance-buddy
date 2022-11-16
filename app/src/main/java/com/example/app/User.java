package com.example.app;
import java.util.*;
import java.io.*;

public class User {

    public String fullName, age, email;
    public Stack<Statement> statements;
    public boolean bankSetup;
    public User() {
    }

    public User(String fullName, String age, String email, boolean bankSetup) {
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.bankSetup = bankSetup;
        this.statements = new Stack<>();
    }
    public String getName(){
        return fullName;
    }

}