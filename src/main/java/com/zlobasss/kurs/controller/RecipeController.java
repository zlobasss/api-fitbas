package com.zlobasss.kurs.controller;

import com.zlobasss.kurs.service.IRecipeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
@AllArgsConstructor
public class RecipeController {

    @Autowired
    private final IRecipeService recipeService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getRecipe(@PathVariable long foodId) {
        return recipeService.readByFood(foodId);
    }
}
