package com.example.restaurant.domin;

import com.example.restaurant.domin.MenuItem;

import java.util.List;

public interface MenuItemRepository {
    List<MenuItem> findAllByRestaurantId(Long id);
}
