package com.example.app;

import java.util.Date;

public class Transactions {
    private double amount;
    private String type;
    private Date date;

    public Transactions(double amt, Date dt){
        amount = amt;
        date = dt;
    }
    public Transactions(double amt, Date dt, String tp){
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
    public void setAmount(double amt) { amount = amt; }
    public double getAmount(){return amount;}
    public Date getDate() { return date;}
    @Override
    public String toString() {

        return "";
    }
}
