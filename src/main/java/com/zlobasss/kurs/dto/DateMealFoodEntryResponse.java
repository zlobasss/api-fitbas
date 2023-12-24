package com.zlobasss.kurs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DateMealFoodEntryResponse {
    private Timestamp date;
    private List<MealFoodEntryResponse> meals;

    public DateMealFoodEntryResponse(Timestamp date) {
        this.date = date;
        meals = new ArrayList<>();
    }
}
