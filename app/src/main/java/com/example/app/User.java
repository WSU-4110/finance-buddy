package com.example.app;
import java.util.*;
import java.io.*;

public class User {

    public String fullName, age, email;
    public Stack<Statement> statements;
    public double totalStatements, goal;
    public boolean bankSetup;

    public User() {
    }

    public User(String fullName, String age, String email, boolean bankSetup, double totalStatements, double goal) {
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.bankSetup = bankSetup;
        this.statements = new Stack<Statement>();
        Statement statement = new Statement(0, 0, 0, 0, 0, 0, 0, 0, 0, "0/0/00");
        this.statements.push(statement);
        this.totalStatements = totalStatements;
        this.goal = goal;
    }

    public String getFullName() {
        return fullName;
    }
}