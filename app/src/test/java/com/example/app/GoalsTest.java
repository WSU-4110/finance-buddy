package com.example.app;

import static org.junit.Assert.*;

import org.junit.Test;

public class GoalsTest {
    @Test
    public void setGroceries_test() {
        Goals t = new Goals();
        t.setGroceriesGoals(100);
        assertEquals(100, t.getGroceriesGoals(), 0);
    }

    @Test
    public void setRestaurants_test() {
        Goals t = new Goals();
        t.setRestaurantsGoals(100);
        assertEquals(100, t.getRestaurantsGoals(), 0);
    }

    @Test
    public void setHousing_test() {
        Goals t = new Goals();
        t.setHousingGoals(100);
        assertEquals(100, t.getHousingGoals(), 0);
    }

    @Test
    public void setUtilities_test() {
        Goals t = new Goals();
        t.setUtilitiesGoals(100);
        assertEquals(100, t.getUtilitiesGoals(), 0);
    }

    @Test
    public void setSubscriptions_test() {
        Goals t = new Goals();
        t.setSubscriptionsGoals(100);
        assertEquals(100, t.getSubscriptionsGoals(), 0);
    }

    @Test
    public void total_test() {
        Goals t = new Goals(100,100,100,100,100,100,100,100,100);
        assertEquals(900, t.total(), 0);
    }
}