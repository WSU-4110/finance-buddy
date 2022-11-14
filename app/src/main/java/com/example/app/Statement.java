package com.example.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Statement {
    private double groceries, restaurants, transportation, entertainment, clothing, utilities, housing, subscriptions, other;
    private String date;

    public Statement() {
        groceries = 0;
        restaurants = 0;
        transportation = 0;
        entertainment = 0;
        clothing = 0;
        utilities = 0;
        housing = 0;
        subscriptions = 0;
        other = 0;
        date = "";
    }

    public Statement(double groceries, double restaurants, double transportation, double entertainment, double clothing, double utilities, double housing, double subscriptions, double other, String date){
        this.groceries = groceries;
        this.restaurants = restaurants;
        this.transportation = transportation;
        this.entertainment = entertainment;
        this.clothing = clothing;
        this.utilities = utilities;
        this.housing = housing;
        this.subscriptions = subscriptions;
        this.other = other;
        this.date = date;
    }

    public Statement(String path){
        try {
            File Doc = new File(path);
            Scanner scan = new Scanner(Doc);


            //Skip irrelevant info
            for(int i = 0; i < 6; i++){
                scan.nextLine();
            }
            scan.next();
            scan.next();

            this.date = scan.next();

            scan.next();
            scan.next();
            scan.next();
            while (scan.next() != "TOTAL") {
                switch (scan.next()) {
                    case "GROCERIES":  this.groceries = Double.parseDouble(scan.next());
                        break;
                    case "RESTAURANTS":  this.restaurants = Double.parseDouble(scan.next());
                        break;
                    case "TRANSPORTATION":  this.transportation = Double.parseDouble(scan.next());
                        break;
                    case "ENTERTAINMENT":  this.entertainment = Double.parseDouble(scan.next());
                        break;
                    case "CLOTHING":  this.clothing = Double.parseDouble(scan.next());
                        break;
                    case "UTILITIES":  this.utilities = Double.parseDouble(scan.next());
                        break;
                    case "HOUSING":  this.housing = Double.parseDouble(scan.next());
                        break;
                    case "SUBSCRIPTIONS":  this.subscriptions = Double.parseDouble(scan.next());
                        break;
                    default: this.other = Double.parseDouble(scan.next());
                        break;
                }
            }

            scan.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void setGroceries(double groceries){
        this.groceries = groceries;
    }
    public double getGroceries(){
        return groceries;
    }

    public void setRestaurants(double restaurants){
        this.restaurants = restaurants;
    }
    public double getRestaurants(){
        return restaurants;
    }

    public void setTransportation(double transportation){
        this.transportation = transportation;
    }
    public double getTransportation(){
        return transportation;
    }

    public void setEntertainment(double entertainment){
        this.entertainment = entertainment;
    }
    public double getEntertainment(){
        return entertainment;
    }

    public void setClothing(double clothing){
        this.clothing = clothing;
    }
    public double getClothing(){
        return clothing;
    }

    public void setUtilities(double utilities){
        this.utilities = utilities;
    }
    public double getUtilities(){
        return utilities;
    }

    public void setHousing(double housing){
        this.housing = housing;
    }
    public double getHousing(){
        return housing;
    }

    public void setSubscriptions(double subscriptions){
        this.subscriptions = subscriptions;
    }
    public double getSubscriptions(){
        return subscriptions;
    }

    public void setOther(double other){
            this.other = other;
    }
    public double getOther(){
        return other;
    }

    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return date;
    }

    public double total(){
        return(groceries+restaurants+transportation+entertainment+clothing+utilities+housing+subscriptions+other);
    }

}
