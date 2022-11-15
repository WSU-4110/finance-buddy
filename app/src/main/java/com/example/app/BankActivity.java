package com.example.app;

import java.util.ArrayList;

public class BankActivity {
    private ArrayList<Transactions> activity = new ArrayList<Transactions>();
    private int size;
    private Calculate calc;
    private User user;

    public BankActivity(User u){
        u = user;
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
    public Transactions getTransaction(int index){
        if(index < 0 || index > 1000){
            return null;
        }
        else{
            return activity.get(index);
        }
    }
    public String getAllTransactionsString(){
        String s  = "";
        for (int i = 0; i < size; i++){
            s.concat(getTransaction(i).toStringT());
            s.concat("  ");
        }
        return s;
    }
    public ArrayList<Transactions> getAllTransactions(){
        return activity;
    }

}
