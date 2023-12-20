package com.zlobasss.kurs.repository;

import com.zlobasss.kurs.dto.DateMealEntryResponse;
import com.zlobasss.kurs.dto.EntryResponse;
import com.zlobasss.kurs.dto.FoodListPK;
import com.zlobasss.kurs.dto.MealEntryResponse;
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
    List<FoodList> findByPk_DateAndPk_UserId(Date date, User user);
    List<FoodList> findByPk_UserId(User user);
    @Query("SELECT new com.zlobasss.kurs.dto.DateMealEntryResponse(fl.pk.date) FROM food_lists fl GROUP BY fl.pk.date, fl.pk.userId having fl.pk.userId.id = :user")
    List<DateMealEntryResponse> findDates(@Param("user") long user);
    @Query("SELECT new com.zlobasss.kurs.dto.MealEntryResponse(m.name) FROM food_lists fl join meals m ON m.id = fl.pk.mealId.id where fl.pk.date = :date and fl.pk.userId.id = :user GROUP BY m.name")
    List<MealEntryResponse> findMeals(@Param("date") Date date, @Param("user") long user);

    @Query("SELECT new com.zlobasss.kurs.dto.EntryResponse(f.name, fl.value, fl.isCompleted) FROM food_lists fl join meals m ON m.id = fl.pk.mealId.id join foods f on f.id = fl.pk.foodId.id where fl.pk.userId.id = :user and fl.pk.mealId = :meal and fl.pk.date = :date")
    List<EntryResponse> findEntryResponse(@Param("user") long user, @Param("meal") Meal meal, @Param("date") Date date);
}
