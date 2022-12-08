package com.example.app;

import java.util.ArrayList;

public class BankActivity {
    private ArrayList<Transactions> activity;
    private int size;
    private Calculate calc;
    private User user;

    public BankActivity(User u){
        u = user;
        activity = new ArrayList<>();
    }
    public int getSize(){
        return size;
    }
    public void setCalculation(Calculate c){
        c = calc;
    }
    public Calculate getCalculation(){
        return calc;
    }
    public void addTransaction(Transactions tran){
        activity.add(tran);
        size++;
    }
    public Transactions getTransaction(Transactions tran){
        return tran;
    }
    public ArrayList<Transactions> getAllTransactions(){
        return activity;
    }

}
