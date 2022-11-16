package com.example.app;

import static java.sql.DriverManager.println;

import android.util.Log;

import java.util.ArrayList;

public class BankActivity {
    private ArrayList<Transactions> activity = new ArrayList<Transactions>();
    private int size;
    private Calculate calc;
    private User user;

    public BankActivity(User u){
        user = u;
    }
    public void setUser(User u){
        user = u;
    }
    public String getUser(){
        return user.getName();
    }
    public int getSize(){
        return size;
    }
    public void setCalculation(Calculate c){
        calc = c;
    }
    public Calculate getCalculation(){
        return calc;
    }
    public void addTransaction(Transactions tran){
        activity.add(tran);
        size++;
    }
    public void removeTransaction(Transactions tran){
        if(activity.contains(tran)){
            activity.remove(tran);
            size--;
        }

    }
    public Transactions getTransaction(int index){
        if(index < 0 || index > size){
            return null;
        }
        else{
            return activity.get(index);
        }
    }
    public String getAllTransactionsString(){
        String res = "";
        for (int i = 0; i < size; i++){
            String s = getTransaction(i).toStringT();
             res = res.concat(s) + "  ";
        }
        return res;
    }
    public ArrayList<Transactions> getAllTransactions(){
        return activity;
    }

}
