package com.zlobasss.kurs.controller;

import com.zlobasss.kurs.serviceInterface.IExerciseService;
import com.zlobasss.kurs.serviceInterface.IProductService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    @Autowired
    private IExerciseService exerciseService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam @Nullable String type) {
        if (type != null) {
            return exerciseService.readByType(type);
        }
        return exerciseService.readAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<?> get(@PathVariable int id) {
        return exerciseService.read(id);
    }
}
