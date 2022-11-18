package com.example.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Goals {
    private double groceries, restaurants, transportation, entertainment, clothing, utilities, housing, subscriptions, other;

    public Goals() {
        groceries = 0;
        restaurants = 0;
        transportation = 0;
        entertainment = 0;
        clothing = 0;
        utilities = 0;
        housing = 0;
        subscriptions = 0;
        other = 0;
    }

    public Goals(double groceries, double restaurants, double transportation, double entertainment, double clothing, double utilities, double housing, double subscriptions, double other){
        this.groceries = groceries;
        this.restaurants = restaurants;
        this.transportation = transportation;
        this.entertainment = entertainment;
        this.clothing = clothing;
        this.utilities = utilities;
        this.housing = housing;
        this.subscriptions = subscriptions;
        this.other = other;
    }

    public void setGroceriesGoals(double groceries){
        this.groceries = groceries;
    }
    public double getGroceriesGoals(){
        return groceries;
    }

    public void setRestaurantsGoals(double restaurants){
        this.restaurants = restaurants;
    }
    public double getRestaurantsGoals(){
        return restaurants;
    }

    public void setTransportationGoals(double transportation){
        this.transportation = transportation;
    }
    public double getTransportationGoals(){
        return transportation;
    }

    public void setEntertainmentGoals(double entertainment){
        this.entertainment = entertainment;
    }
    public double getEntertainmentGoals(){
        return entertainment;
    }

    public void setClothingGoals(double clothing){
        this.clothing = clothing;
    }
    public double getClothingGoals(){
        return clothing;
    }

    public void setUtilitiesGoals(double utilities){
        this.utilities = utilities;
    }
    public double getUtilitiesGoals(){
        return utilities;
    }

    public void setHousingGoals(double housing){
        this.housing = housing;
    }
    public double getHousingGoals(){
        return housing;
    }

    public void setSubscriptionsGoals(double subscriptions){
        this.subscriptions = subscriptions;
    }
    public double getSubscriptionsGoals(){
        return subscriptions;
    }

    public void setOtherGoals(double other){
        this.other = other;
    }
    public double getOtherGoals(){
        return other;
    }

    public double total(){
        return(groceries+restaurants+transportation+entertainment+clothing+utilities+housing+subscriptions+other);
    }

}
