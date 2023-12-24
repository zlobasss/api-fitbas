package com.zlobasss.kurs.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@Setter
public class FoodRecipeResponse {
    private String foodName;
    private List<RecipeResponse> products;
}
