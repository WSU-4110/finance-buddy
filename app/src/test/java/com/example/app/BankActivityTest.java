package com.example.app;



//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

import java.util.Date;


class BankActivityTest {



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
    }

    @Test
    void getCalculation() {
    }

    @Test
    void addTransaction() {



    }

    @Test
    void getTransaction() {
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

        //Test
        String result = TestBank.getTransaction(2).toStringT();
        String expected = "-13.98,2022-11-15,membership";
        assertEquals(expected,result);
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