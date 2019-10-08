package com.example.restaurant.domin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class MenuItem {
    @Id
    @GeneratedValue
    private Long id;

    private Long restaurantId;
    private String name;
}
