package com.zlobasss.kurs.dto;

import jakarta.persistence.Entity;
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
public class DateMealEntryResponse {
    private Timestamp date;
    private List<MealEntryResponse> meals;

    public DateMealEntryResponse(Timestamp date) {
        this.date = date;
        meals = new ArrayList<>();
    }
}
