package com.example.restaurant.domin;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestaurantTest {
    @Test
    public void creation(){
        Restaurant restaurant = new Restaurant("Restaurant", "Seoul");

        assertThat(restaurant.getName(), is("Restaurant"));
        assertThat(restaurant.getAddress(), is("Seoul"));
    }

    @Test
    public void information(){
        Restaurant restaurant = new Restaurant("Restaurant", "Seoul");

        assertThat(restaurant.getInformation(), is("Restaurant in Seoul"));
    }
}
