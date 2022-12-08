package com.example.app;

import java.time.LocalDate;
import java.util.Date;

public class Transactions {
    private double amount;
    private String type;
    private LocalDate date;

    public Transactions(double amt, LocalDate dt){
        amount = amt;
        date = dt;
    }
    public Transactions(double amt, LocalDate dt, String tp){
        amount = amt;
        date = dt;
        type = tp;
    }
    public void setType(String tp){
        type = tp;
    }
    public String getType(){
        return type;
    }
    public void setAmount(Double amt) {
        amount = amt;
    }
    public double getAmount(){
        return amount;
    }
    public LocalDate getDate() {
        return date;
    }
    @Override
    public String toString() {

        return "Date: " + date + " " + "Type: " + type + "Amount: " + amount;
    }
}
