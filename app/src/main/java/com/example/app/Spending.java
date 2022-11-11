package com.example.app;

public class Spending {
    public static Spending spend = new Spending();
    private double totalSpending;
    private Spending(){}

    public static Spending getSpending() {
        return spend;
    }

    public void totalSpending(double s) {
        totalSpending = s + totalSpending;

    }

    public double getTotalSpending() {
        return totalSpending;
    }
}
