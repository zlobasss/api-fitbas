package com.zlobasss.kurs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class MealFoodEntryResponse {
    private String mealName;
    private List<FoodEntryResponse> foods;

    public MealFoodEntryResponse(String mealName) {
        this.mealName = mealName;
        foods = new ArrayList<>();
    }
}
