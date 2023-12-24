package com.zlobasss.kurs.serviceInterface;

import com.zlobasss.kurs.dto.FoodListRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface IFoodListService {
    ResponseEntity<?> add(FoodListRequest dto, Date date, String token);
    ResponseEntity<?> readAll(String token);
    ResponseEntity<?> read(Date date, String token);
    ResponseEntity<?> delete(Date date, FoodListRequest dto, String token);
    ResponseEntity<?> switchStatus(Date date, FoodListRequest dto, String token);
}
