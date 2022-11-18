package com.example.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Date;

class TransactionsTest {

    @Test
    void setType(){
        Date firstDate = new Date(2022, 11, 18);
        Transactions t = new Transactions(10.0,firstDate );
        t.setType("Food");
        assertEquals("Food", t.getType());

    }

    @Test
    void getType() {
        Date firstDate = new Date(2022, 11, 18);
        Transactions t = new Transactions(10.0,firstDate , "Car Payment");
        t.setType("Food");
        assertEquals("Food", t.getType());
    }

    @org.junit.jupiter.api.Test
    void setAmount() {
        Date firstDate = new Date(2022, 11, 18);
        Transactions t = new Transactions(10.0,firstDate , "Car Payment");
        t.setAmount(20.0);
        assertEquals(20.0, t.getAmount());
    }

    @org.junit.jupiter.api.Test
    void getAmount() {
        Date firstDate = new Date(2022, 11, 18);
        Transactions t = new Transactions(10.0,firstDate , "Car Payment");
        assertEquals(10.0, t.getAmount());
    }

    @org.junit.jupiter.api.Test
    void getDate() {
        Date firstDate = new Date(2022, 11, 18);
        Date similarDate = new Date(2022, 11, 18);
        Transactions t = new Transactions(10.0,firstDate , "Car Payment");
        assertEquals(similarDate, t.getDate());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Date firstDate = new Date(2022, 11, 18);
        Transactions t = new Transactions(10.0,firstDate , "Car Payment");
        assertEquals("Date: " + t.getDate() + " " + "Type: " + t.getType() + "Amount: " + t.getAmount(), t.toString());

    }
}