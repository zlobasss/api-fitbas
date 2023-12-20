package com.zlobasss.kurs.service;

import com.zlobasss.kurs.dto.FoodDto;
import com.zlobasss.kurs.dto.FoodListPK;
import com.zlobasss.kurs.dto.FoodListResponse;
import com.zlobasss.kurs.dto.MealResponse;
import com.zlobasss.kurs.entity.Food;
import com.zlobasss.kurs.entity.FoodList;
import com.zlobasss.kurs.entity.Meal;
import com.zlobasss.kurs.entity.User;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        if (dto.getValue() < 1)
            return new ResponseEntity<ErrorException>(new ErrorException(new ErrorBody(400, "Value is negative")), HttpStatus.BAD_REQUEST);

        User user;
        Food food;
        Meal meal;

        token = token.replaceFirst("Bearer ", "");

        try {
            user = userRepo.findByLogin(jwtHelper.getUsernameFromToken(token)).get();
            food = foodRepo.findById(dto.getFoodId()).get();
            meal = mealRepo.findById(dto.getMealId()).get();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        FoodListPK pk = new FoodListPK();
        pk.setFoodId(food);
        pk.setUserId(user);
        pk.setMealId(meal);

        foodListRepo.save(FoodList.builder()
                .pk(pk)
                .date(date)
                .isCompleted(false)
                .value(dto.getValue())
                .build()
        );
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

        return new ResponseEntity<FoodListResponse>(
                new FoodListResponse(
                        HttpStatus.CREATED.value(),
                        simpleDateFormat.format(date),
                        food.getName(),
                        meal.getName(),
                        dto.getValue()
                ),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> copy(Date from, Date to) {
        return null;
    }

    @Override
    public ResponseEntity<?> readAll() {
        return null;
    }

//    @Override
//    public FoodListResponse read(Date date) {
//        FoodListResponse response = new FoodListResponse();
//        List<MealResponse> mealsRes = new ArrayList<>();
//        List<Meal> meals = mealRepo.findAll();
//        for (int i = 0; i < (long) meals.size(); ++i)
//        {
//            MealResponse temp = new MealResponse();
//            temp.setMealName(meals.get(i).getName());
//            mealsRes.add(temp);
//
//            Optional<List<FoodList>> foods = foodListRepo.findByDateAndMealId(date, meals.get(i).getId());
//        }
//        return response;
//    }

    @Override
    public FoodList switchStatus(FoodDto dto) {
        return null;
    }

    @Override
    public void deleteList(Date date) {

    }

    @Override
    public void deleteFood(FoodDto dto, Date date) {

    }
}
