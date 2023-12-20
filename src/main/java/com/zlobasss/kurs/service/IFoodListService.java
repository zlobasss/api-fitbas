package com.zlobasss.kurs.service;

import com.zlobasss.kurs.dto.FoodDto;
import com.zlobasss.kurs.dto.FoodListResponse;
import com.zlobasss.kurs.entity.FoodList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface IFoodListService {
    ResponseEntity<?> add(FoodDto dto, Date date, String token);
    ResponseEntity<?> copy(Date from, Date to);
    ResponseEntity<?> readAll();
//    FoodListResponse read(Date date);
    FoodList switchStatus(FoodDto dto);
    void deleteList(Date date);
    void deleteFood(FoodDto dto, Date date);
}
