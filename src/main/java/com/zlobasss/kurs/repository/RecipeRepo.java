package com.zlobasss.kurs.repository;

import com.zlobasss.kurs.dto.RecipePK;
import com.zlobasss.kurs.entity.Food;
import com.zlobasss.kurs.entity.FoodList;
import com.zlobasss.kurs.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RecipeRepo extends JpaRepository<Recipe, RecipePK> {
    Optional<List<Recipe>> findByPk_FoodId(Food food);
}
