package com.example.app;



//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

import java.util.Date;


class BankActivityTest {
    @Test
    void removeTransaction(){
        //Setup test
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        User TestUser = new User("Andy Jones", "34","andyjj@gmail.com",true);
        BankActivity TestBank = new BankActivity(TestUser);
        Transactions tr1 = new Transactions(2655.25, date,"income");
        Transactions tr2 = new Transactions(-1255.25, date,"travel");
        TestBank.addTransaction(tr1);
        TestBank.addTransaction(tr2);

        //Test
        TestBank.removeTransaction(tr2);
        assertEquals(1,TestBank.getSize());
    }
    @Test
    void getUser(){
        //Setup test
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        User TestUser = new User("Bob Reynolds", "64","bobbyr@gmail.com",true);
        BankActivity TestBank = new BankActivity(TestUser);
        String result = TestBank.getUser();
        String expected = "Bob Reynolds";
        assertEquals(expected,result);
    }

    @Test
    void getSize() {
        //Setup test
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        User TestUser = new User("Andy Jones", "34","andyjj@gmail.com",true);
        BankActivity TestBank = new BankActivity(TestUser);
        Transactions tr1 = new Transactions(455.25, date,"income");
        Transactions tr2 = new Transactions(-85.65, date,"shopping");
        Transactions tr3 = new Transactions(-13.98, date,"membership");
        TestBank.addTransaction(tr1);
        TestBank.addTransaction(tr2);
        TestBank.addTransaction(tr3);

        //Test
        int result = TestBank.getSize();
        int expected = 3;
        assertEquals(expected,result);

    }

    @Test
    void setCalculation() {
        //Setup test
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        User TestUser = new User("Andy Jones", "34","andyjj@gmail.com",true);
        BankActivity TestBank = new BankActivity(TestUser);
        Transactions tr1 = new Transactions(455.25, date,"income");
        Transactions tr2 = new Transactions(-85.65, date,"shopping");
        Transactions tr3 = new Transactions(-13.98, date,"membership");
        Transactions tr4 = new Transactions(-38.33, date,"food");
        TestBank.addTransaction(tr1);
        TestBank.addTransaction(tr2);
        TestBank.addTransaction(tr3);
        TestBank.addTransaction(tr4);

        Calculate shop = new ShoppingExpenses();
        TestBank.setCalculation(shop);
        Double result = shop.sumExpenses(TestBank);
        Double expected = -85.65;
        assertEquals(expected,result);
    }


    @Test
    void addTransaction() {
        //Setup test
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        User TestUser = new User("Andy Jones", "34","andyjj@gmail.com",true);
        BankActivity TestBank = new BankActivity(TestUser);
        Transactions tr1 = new Transactions(255.25, date,"income");

        //Test
        TestBank.addTransaction(tr1);
        assertEquals(tr1,TestBank.getTransaction(0));

    }


    @Test
    void getAllTransactionsString() {
        //Setup test
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        User TestUser = new User("Andy Jones", "34","andyjj@gmail.com",true);
        BankActivity TestBank = new BankActivity(TestUser);

        Transactions tr1 = new Transactions(-34.98, date,"membership");
        Transactions tr2 = new Transactions(-38.33, date,"travel");
        TestBank.addTransaction(tr1);
        TestBank.addTransaction(tr2);

        //Test
        String result = TestBank.getAllTransactionsString();
        String expected = "-34.98,2022-11-15,membership  -38.33,2022-11-15,travel  ";
        assertEquals(expected,result);
    }
}