package com.zlobasss.kurs.dto;

import jakarta.annotation.Nullable;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FoodDto {
    private long foodId;
    private short mealId;
    private short value = 1;
}
