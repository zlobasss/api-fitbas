package com.zlobasss.kurs.service;

import com.zlobasss.kurs.dto.*;
import com.zlobasss.kurs.entity.*;
import com.zlobasss.kurs.exception.ErrorException;
import com.zlobasss.kurs.exception.ErrorBody;
import com.zlobasss.kurs.repository.FoodListRepo;
import com.zlobasss.kurs.repository.FoodRepo;
import com.zlobasss.kurs.repository.MealRepo;
import com.zlobasss.kurs.repository.UserRepo;
import com.zlobasss.kurs.security.JwtHelper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@AllArgsConstructor
public class FoodListService implements IFoodListService {

    @Autowired
    private final FoodListRepo foodListRepo;

    @Autowired
    private final UserRepo userRepo;

    @Autowired
    private final FoodRepo foodRepo;

    @Autowired
    private final MealRepo mealRepo;

    @Autowired
    private final JwtHelper jwtHelper;

    @Override
    public ResponseEntity<?> add(FoodDto dto, Date date, String token) {
        if (dto.getValue() < 1) {
            return new ResponseEntity<ErrorException>(new ErrorException(new ErrorBody(HttpStatus.BAD_REQUEST.value(), "Value is not correct")), HttpStatus.BAD_REQUEST);
        }

        token = token.replaceFirst("Bearer ", "");

        User user = userRepo.findByLogin(jwtHelper.getUsernameFromToken(token)).get();

        Optional<Food> food = foodRepo.findById(dto.getFoodId());
        Optional<Meal> meal = mealRepo.findById(dto.getMealId());
        String messageError = "Not found:";

        if (food.isEmpty()) {
            messageError += "\nFood";
        }
        if (meal.isEmpty()) {
            messageError += "\nMeal";
        }

        if (!messageError.endsWith(":")) {
            ErrorException exception = new ErrorException(new ErrorBody(HttpStatus.NOT_FOUND.value(), messageError));
            return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
        }

        FoodListPK pk = new FoodListPK();
        pk.setFoodId(food.get());
        pk.setUserId(user);
        pk.setMealId(meal.get());
        pk.setDate(date);

        FoodList foodList = foodListRepo.save(FoodList.builder()
                .pk(pk)
                .isCompleted(false)
                .value(dto.getValue())
                .build());

        EntryCreatedResponse response = new EntryCreatedResponse(
                pk.getDate(),
                pk.getMealId().getName(),
                pk.getFoodId().getName(),
                foodList.getValue(),
                foodList.isCompleted()
        );

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> readAll(String token) {
        token = token.replaceFirst("Bearer ", "");

        User user = userRepo.findByLogin(jwtHelper.getUsernameFromToken(token)).get();

        List<DateMealEntryResponse> response = foodListRepo.findDates(user.getId());

        for (DateMealEntryResponse date: response) {
            List<MealEntryResponse> mealEntryResponses = foodListRepo.findMeals(date.getDate(), user.getId());
            for (MealEntryResponse meal: mealEntryResponses) {
                List<EntryResponse> foods = foodListRepo.findEntryResponse(user.getId(), mealRepo.findByName(meal.getMealName()).get(), date.getDate());
                meal.setFoods(foods);
            }
            date.setMeals(mealEntryResponses);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> read(Date date, String token) {
        token = token.replaceFirst("Bearer ", "");

        User user = userRepo.findByLogin(jwtHelper.getUsernameFromToken(token)).get();

        List<MealEntryResponse> response = foodListRepo.findMeals(date, user.getId());

        for (MealEntryResponse meal: response) {
            List<EntryResponse> foods = foodListRepo.findEntryResponse(user.getId(), mealRepo.findByName(meal.getMealName()).get(), date);
            meal.setFoods(foods);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(Date date, FoodDto dto, String token) {

        token = token.replaceFirst("Bearer ", "");

        User user = userRepo.findByLogin(jwtHelper.getUsernameFromToken(token)).get();

        Optional<Food> food = foodRepo.findById(dto.getFoodId());
        Optional<Meal> meal = mealRepo.findById(dto.getMealId());
        String messageError = "Not found:";

        if (food.isEmpty()) {
            messageError += "\nFood";
        }
        if (meal.isEmpty()) {
            messageError += "\nMeal";
        }

        if (!messageError.endsWith(":")) {
            ErrorException exception = new ErrorException(new ErrorBody(HttpStatus.NOT_FOUND.value(), messageError));
            return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
        }

        FoodListPK pk = new FoodListPK();
        pk.setFoodId(food.get());
        pk.setUserId(user);
        pk.setMealId(meal.get());
        pk.setDate(date);

        Optional<FoodList> foodList = foodListRepo.findById(pk);

        if (foodList.isEmpty()) {
            DeleteResponse deleteResponse = new DeleteResponse(HttpStatus.NOT_FOUND.value(), "This entry was not found");
            return new ResponseEntity<>(deleteResponse, HttpStatus.NOT_FOUND);
        }
        foodListRepo.delete(FoodList.builder()
                        .pk(pk)
                        .isCompleted(false)
                        .value(dto.getValue())
                        .build());
        DeleteResponse deleteResponse = new DeleteResponse(HttpStatus.OK.value(), "Deleted");
        return new ResponseEntity<>(deleteResponse, HttpStatus.OK);
    }
}
