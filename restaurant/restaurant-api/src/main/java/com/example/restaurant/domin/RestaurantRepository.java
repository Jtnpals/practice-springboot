package com.example.restaurant.domin;

import java.util.List;

public interface RestaurantRepository {
    List<Restaurant> findAll();

    Restaurant findById(Long id);

    Restaurant save(Restaurant restaurant);
}
