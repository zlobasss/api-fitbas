package com.zlobasss.kurs.controller;

import com.zlobasss.kurs.dto.FoodDto;
import com.zlobasss.kurs.dto.FoodListResponse;
import com.zlobasss.kurs.entity.FoodList;
import com.zlobasss.kurs.repository.FoodListRepo;
import com.zlobasss.kurs.service.IFoodListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/foodlist")
public class FoodListController {
    @Autowired
    private FoodListRepo foodListRepo;

    @Autowired
    private IFoodListService foodListService;

    private SimpleDateFormat simpleDateFormat;

    @PostMapping(value = "/lists")
    public ResponseEntity<?> add(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date date, @RequestBody FoodDto dto, @RequestHeader(value = "Authorization") String token) {
        return foodListService.add(dto, date, token);
    }

//    @GetMapping(value = "/lists")
//    public FoodListResponse read(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
//        return foodListService.read(date);
//    }
}
