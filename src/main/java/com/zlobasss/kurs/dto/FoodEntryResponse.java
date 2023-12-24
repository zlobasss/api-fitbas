package com.zlobasss.kurs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FoodEntryResponse {
    private String foodName;
    private short value;
    private boolean isCompleted;
}
