package com.example.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GoalsTest {
    @Test
    void setGroceries_test() {
        Goals t = new Goals();
        t.setGroceriesGoals(100);
        assertEquals(100, t.getGroceriesGoals());
    }

    @Test
    void setRestaurants_test() {
        Goals t = new Goals();
        t.setRestaurantsGoals(100);
        assertEquals(100, t.getRestaurantsGoals());
    }

    @Test
    void setHousing_test() {
        Goals t = new Goals();
        t.setHousingGoals(100);
        assertEquals(100, t.getHousingGoals());
    }

    @Test
    void setUtilities_test() {
        Goals t = new Goals();
        t.setUtilitiesGoals(100);
        assertEquals(100, t.getUtilitiesGoals());
    }

    @Test
    void setHousing_test() {
        Goals t = new Goals();
        t.setHousingGoals(100);
        assertEquals(100, t.getHousingGoals());
    }

    @Test
    void setUtilities_test() {
        Goals t = new Goals(100,100,100,100,100,100,100,100,100);
        assertEquals(100, t.total());
    }
}