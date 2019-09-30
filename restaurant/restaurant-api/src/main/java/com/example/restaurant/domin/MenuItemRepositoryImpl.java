package com.example.restaurant.domin;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MenuItemRepositoryImpl implements MenuItemRepository {

    private List<MenuItem> menuItems = new ArrayList<>();;

    @Override
    public List<MenuItem> findAllByRestaurantId(Long id) {
        menuItems.add(new MenuItem("Kimchi"));
        return menuItems;
    }
}
