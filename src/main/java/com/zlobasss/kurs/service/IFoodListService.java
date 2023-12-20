package com.zlobasss.kurs.service;

import com.zlobasss.kurs.dto.FoodDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface IFoodListService {
    ResponseEntity<?> add(FoodDto dto, Date date, String token);
    ResponseEntity<?> readAll(String token);
    ResponseEntity<?> read(Date date, String token);
    ResponseEntity<?> delete(Date date, FoodDto dto, String token);
}
