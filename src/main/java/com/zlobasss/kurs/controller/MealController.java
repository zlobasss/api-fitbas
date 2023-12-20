package com.zlobasss.kurs.controller;

import com.zlobasss.kurs.service.IGroupService;
import com.zlobasss.kurs.service.IMealService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meals")
@AllArgsConstructor
public class MealController {

    @Autowired
    private final IMealService mealService;

    @GetMapping
    public ResponseEntity<?> readAll() {
        return mealService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable String id) {
        return mealService.read(id);
    }
}
