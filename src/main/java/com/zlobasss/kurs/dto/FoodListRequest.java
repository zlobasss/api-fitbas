package com.zlobasss.kurs.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FoodListRequest {
    private long foodId;
    private short mealId;
    private short value = 1;
}
