package com.example.app;

import java.util.ArrayList;

/*
Strategy Design pattern
Aidan Van Gessel Assignment 4
*/
interface Calculate {
    public double sumExpenses(BankActivity ba);
}
class FoodExpenses implements Calculate{
    @Override
    public double sumExpenses(BankActivity ba){
        double sum = 0;
        ArrayList<Transactions> a = ba.getAllTransactions();
        for(int i = 0; i < ba.getSize(); i++){
            Transactions t = a.get(i);
            if(t.getType().equals("food")){
                sum += t.getAmount();
            }
        }
        return sum;
    }
}
class TravelExpenses implements Calculate{
    @Override
    public double sumExpenses(BankActivity ba){
        double sum = 0;
        ArrayList<Transactions> a = ba.getAllTransactions();
        for(int i = 0; i < ba.getSize(); i++){
            Transactions t = a.get(i);
            if(t.getType().equals("travel")){
                sum += t.getAmount();
            }
        }
        return sum;
    }
}
class MembershipExpenses implements Calculate{
    @Override
    public double sumExpenses(BankActivity ba){
        double sum = 0;
        ArrayList<Transactions> a = ba.getAllTransactions();
        for(int i = 0; i < ba.getSize(); i++){
            Transactions t = a.get(i);
            if(t.getType().equals("membership")){
                sum += t.getAmount();
            }
        }
        return sum;
    }
}
class ShoppingExpenses implements Calculate{
    @Override
    public double sumExpenses(BankActivity ba){
        double sum = 0;
        ArrayList<Transactions> a = ba.getAllTransactions();
        for(int i = 0; i < ba.getSize(); i++){
            Transactions t = a.get(i);
            if(t.getType().equals("shopping")){
                sum += t.getAmount();
            }
        }
        return sum;
    }
}
class TotalExpenses implements Calculate{
    @Override
    public double sumExpenses(BankActivity ba){
        double sum = 0;
        ArrayList<Transactions> a = ba.getAllTransactions();
        for(int i = 0; i < ba.getSize(); i++){
            Transactions t = a.get(i);
            if(t.getAmount() < 0){
                sum += t.getAmount();
            }
        }
        return sum;
    }
}
class TotalSavings implements Calculate{
    private double income;
    private double expenses;
    @Override
    public double sumExpenses(BankActivity ba){
        double sum = 0;
        ArrayList<Transactions> a = ba.getAllTransactions();
        for(int i = 0; i < ba.getSize(); i++){
            Transactions t = a.get(i);
            if(t.getAmount() < 0){
                sum += t.getAmount();
            }
        }
        return sum;
    }
    public double sumIncome(BankActivity ba){
        double sum = 0;
        ArrayList<Transactions> a = ba.getAllTransactions();
        for(int i = 0; i < ba.getSize(); i++){
            Transactions t = a.get(i);
            if(t.getAmount() >= 0){
                sum += t.getAmount();
            }
        }
        return sum;
    }
    public double sumSavings(BankActivity ba){
        return sumIncome(ba) - sumExpenses(ba);
    }
}
