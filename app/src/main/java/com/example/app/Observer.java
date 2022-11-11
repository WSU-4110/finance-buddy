package com.example.app;

interface Observer
{
    public void update(double groceries, double restaurants, double transportation, double entertainment, double clothing, double utilities, double housing, double subscriptions, double other, String date);
}
