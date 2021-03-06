package com.example.restaurant.interfaces;

import com.example.restaurant.application.RestaurantService;
import com.example.restaurant.domin.MenuItem;
import com.example.restaurant.domin.Restaurant;
import com.example.restaurant.domin.RestaurantNotFoundException;
import com.example.restaurant.domin.Review;
import com.example.restaurant.interfaces.RestaurantController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
        restaurants.add(Restaurant.builder().id(1004L).name("Bob zip").address("Seoul").build());
        given(restaurantService.getRestaurants()).willReturn(restaurants);
       mvc.perform(get("/restaurants"))
               .andExpect(status().isOk())
               .andExpect(content().string(containsString("\"name\":\"Bob zip\"")))
               .andExpect(content().string(containsString("\"id\":1004")));
   }

   @Test
    public void detailWithExisted() throws Exception {
       Restaurant restaurant = Restaurant.builder().id(1004L).name("Bob zip").address("Seoul").build();
       restaurant.setMenuItems(Arrays.asList(MenuItem.builder().name("Kimchi").build()));
       Review review = Review.builder()
               .name("JOKER")
               .score(5)
               .description("Great!")
               .build();
       restaurant.setReviews(Arrays.asList(review));
        given(restaurantService.getRestaurant(1004L)).willReturn(restaurant);
        mvc.perform(get("/restaurants/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"name\":\"Bob zip\"")))
                .andExpect(content().string(containsString("\"id\":1004")))
            .andExpect(content().string(containsString("Kimchi")))
                    .andExpect(content().string(containsString("Great!")));
   }

    @Test
    public void detailWithNotExisted() throws Exception {
        given(restaurantService.getRestaurant(404L))
                .willThrow(new RestaurantNotFoundException(404L));
        mvc.perform(get("/restaurants/404"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("{}"));
    }


}
