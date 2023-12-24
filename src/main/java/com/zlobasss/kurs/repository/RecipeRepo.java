package com.zlobasss.kurs.repository;

import com.zlobasss.kurs.dto.RecipeResponse;
import com.zlobasss.kurs.pk.RecipePK;
import com.zlobasss.kurs.entity.Food;
import com.zlobasss.kurs.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RecipeRepo extends JpaRepository<Recipe, RecipePK> {
    @Query("SELECT new com.zlobasss.kurs.dto.RecipeResponse(p.name, r.value, d.name) FROM recipes r join products p on p.id = r.pk.productId.id join dimensions d on d.id = r.dimension.id where r.pk.foodId = :food")
    List<RecipeResponse> findRecipe(Food food);
}
