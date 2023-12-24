package com.zlobasss.kurs.controller;

import com.zlobasss.kurs.dto.FoodListRequest;
import com.zlobasss.kurs.dto.TrainingRequest;
import com.zlobasss.kurs.serviceInterface.IFoodListService;
import com.zlobasss.kurs.serviceInterface.ITrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/trainings")
public class TrainingController {
    @Autowired
    private ITrainingService trainingService;

    @GetMapping
    public ResponseEntity<?> readAll (@RequestHeader(value = "Authorization") String token) {
        return trainingService.readAll(token);
    }

    @GetMapping("/{date}")
    public ResponseEntity<?> read (@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date date, @RequestHeader(value = "Authorization") String token) {
        return trainingService.read(date, token);
    }

    @PostMapping("/{date}")
    public ResponseEntity<?> add (@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date date, @RequestBody TrainingRequest dto, @RequestHeader(value = "Authorization") String token) {
        return trainingService.add(dto, date, token);
    }

    @DeleteMapping("/{date}")
    public ResponseEntity<?> delete (@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date date, @RequestBody TrainingRequest dto, @RequestHeader(value = "Authorization") String token) {
        return trainingService.delete(date, dto, token);
    }

    @PatchMapping("/{date}")
    public ResponseEntity<?> switchStatus (@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date date, @RequestBody TrainingRequest dto, @RequestHeader(value = "Authorization") String token) {
        return trainingService.switchStatus(date, dto, token);
    }
}
