package com.zlobasss.kurs.service;

import com.zlobasss.kurs.dto.FoodRecipeResponse;
import com.zlobasss.kurs.dto.RecipeResponse;
import com.zlobasss.kurs.entity.Food;
import com.zlobasss.kurs.entity.Recipe;
import com.zlobasss.kurs.exception.ErrorBody;
import com.zlobasss.kurs.exception.ErrorException;
import com.zlobasss.kurs.serviceInterface.IRecipeService;
import com.zlobasss.kurs.repository.FoodRepo;
import com.zlobasss.kurs.repository.RecipeRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RecipeService implements IRecipeService {

    @Autowired
    private final RecipeRepo recipeRepo;

    @Autowired
    private final FoodRepo foodRepo;

    @Override
    public ResponseEntity<?> readByFood(long food_id) {
        Optional<Food> food = foodRepo.findById(food_id);
        if (food.isEmpty()) {
            ErrorException exception = new ErrorException(
                    new ErrorBody(HttpStatus.NOT_FOUND.value(), "Food not exist"));
            return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
        }
        FoodRecipeResponse response = new FoodRecipeResponse();
        List<RecipeResponse> recipes = recipeRepo.findRecipe(food.get());
        response.setFoodName(food.get().getName());
        response.setProducts(recipes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
