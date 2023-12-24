package com.zlobasss.kurs.repository;

import com.zlobasss.kurs.dto.DateMealFoodEntryResponse;
import com.zlobasss.kurs.dto.FoodEntryResponse;
import com.zlobasss.kurs.pk.FoodListPK;
import com.zlobasss.kurs.dto.MealFoodEntryResponse;
import com.zlobasss.kurs.entity.FoodList;
import com.zlobasss.kurs.entity.Meal;
import com.zlobasss.kurs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FoodListRepo extends JpaRepository<FoodList, FoodListPK> {
    @Query("SELECT new com.zlobasss.kurs.dto.DateMealFoodEntryResponse(fl.pk.date) FROM food_lists fl GROUP BY fl.pk.date, fl.pk.userId having fl.pk.userId.id = :user")
    List<DateMealFoodEntryResponse> findDates(@Param("user") long user);
    @Query("SELECT new com.zlobasss.kurs.dto.MealFoodEntryResponse(m.name) FROM food_lists fl join meals m ON m.id = fl.pk.mealId.id where fl.pk.date = :date and fl.pk.userId.id = :user GROUP BY m.name")
    List<MealFoodEntryResponse> findMeals(@Param("date") Date date, @Param("user") long user);

    @Query("SELECT new com.zlobasss.kurs.dto.FoodEntryResponse(f.name, fl.value, fl.isCompleted) FROM food_lists fl join meals m ON m.id = fl.pk.mealId.id join foods f on f.id = fl.pk.foodId.id where fl.pk.userId.id = :user and fl.pk.mealId = :meal and fl.pk.date = :date")
    List<FoodEntryResponse> findEntryResponse(@Param("user") long user, @Param("meal") Meal meal, @Param("date") Date date);
}
