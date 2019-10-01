package com.example.restaurant.interfaces;

import com.example.restaurant.application.RestaurantService;
import com.example.restaurant.domin.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private RestaurantService restaurantService;

    @Test
    public void list() throws Exception {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1004L, "Bob zip", "Seoul"));
        given(restaurantService.getRestaurants()).willReturn(restaurants);
       mvc.perform(get("/restaurants"))
               .andExpect(status().isOk())
               .andExpect(content().string(containsString("\"name\":\"Bob zip\"")))
               .andExpect(content().string(containsString("\"id\":1004")));
   }

   @Test
    public void detail() throws Exception {
       Restaurant restaurant = new Restaurant(1004L, "Bob zip", "Seoul");
       Restaurant restaurant2 = new Restaurant(2020L, "Cyber food", "Seoul");
       restaurant.addMenuItem(new MenuItem("Kimchi"));
        given(restaurantService.getRestaurant(1004L)).willReturn(restaurant);
        given(restaurantService.getRestaurant(2020L)).willReturn(restaurant2);
        mvc.perform(get("/restaurant/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"Bob zip\"")))
                .andExpect(content().string(containsString("\"id\":1004")))
            .andExpect(content().string(containsString("Kimchi")));

       mvc.perform(get("/restaurant/2020"))
               .andExpect(status().isOk())
               .andExpect(content().string(containsString("\"name\":\"Cyber food\"")))
               .andExpect(content().string(containsString("\"id\":2020")));
   }
}
