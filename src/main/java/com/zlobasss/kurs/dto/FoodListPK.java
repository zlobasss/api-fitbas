package com.zlobasss.kurs.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zlobasss.kurs.entity.Food;
import com.zlobasss.kurs.entity.Meal;
import com.zlobasss.kurs.entity.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class FoodListPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
    @ManyToOne
    @JoinColumn(name = "food_id")
    @JsonIgnore
    private Food food;
    @ManyToOne
    @JoinColumn(name = "meal_id")
    @JsonIgnore
    private Meal meal;


}
