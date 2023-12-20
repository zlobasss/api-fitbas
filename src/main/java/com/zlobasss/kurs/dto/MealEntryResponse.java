package com.zlobasss.kurs.dto;

import jakarta.persistence.Entity;
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
public class MealEntryResponse {
    private String mealName;
    private List<EntryResponse> foods;

    public MealEntryResponse (String mealName) {
        this.mealName = mealName;
        foods = new ArrayList<>();
    }
}
