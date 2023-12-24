package com.zlobasss.kurs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class FoodCreatedResponse {
    private Date date;
    private String mealName;
    private String foodName;
    private int value;
    private boolean isCompleted;
}
