package com.example.app;

public class Transactions {
    private double amount;
    private String type;
    private String date;

    public Transactions(double amt, String dt){
        amount = amt;
        date = dt;
    }
    public Transactions(double amt, String dt, String tp){
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
    public double getAmount(){
        return amount;
    }
    public String toStringT(){
        return Double.toString(amount) + "," + date.toString() + "," + type;
    }
}
