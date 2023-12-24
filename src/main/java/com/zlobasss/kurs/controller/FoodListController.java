package com.zlobasss.kurs.controller;

import com.zlobasss.kurs.dto.FoodListRequest;
import com.zlobasss.kurs.serviceInterface.IFoodListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/foodlists")
public class FoodListController {
    @Autowired
    private IFoodListService foodListService;

    @GetMapping
    public ResponseEntity<?> readAll (@RequestHeader(value = "Authorization") String token) {
        return foodListService.readAll(token);
    }

    @GetMapping("/{date}")
    public ResponseEntity<?> read (@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date date, @RequestHeader(value = "Authorization") String token) {
        return foodListService.read(date, token);
    }

    @PostMapping("/{date}")
    public ResponseEntity<?> add (@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date date, @RequestBody FoodListRequest dto, @RequestHeader(value = "Authorization") String token) {
        return foodListService.add(dto, date, token);
    }

    @DeleteMapping("/{date}")
    public ResponseEntity<?> delete (@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date date, @RequestBody FoodListRequest dto, @RequestHeader(value = "Authorization") String token) {
        return foodListService.delete(date, dto, token);
    }

    @PatchMapping("/{date}")
    public ResponseEntity<?> switchStatus (@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date date, @RequestBody FoodListRequest dto, @RequestHeader(value = "Authorization") String token) {
        return foodListService.switchStatus(date, dto, token);
    }
}
