package com.zlobasss.kurs.controller;

import com.zlobasss.kurs.service.IFoodService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foods")
@AllArgsConstructor
public class FoodController {

    @Autowired
    private final IFoodService foodService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return foodService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable long id) {
        return foodService.read(id);
    }
}
