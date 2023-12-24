package com.zlobasss.kurs.service;

import com.zlobasss.kurs.entity.Food;
import com.zlobasss.kurs.exception.ErrorBody;
import com.zlobasss.kurs.exception.ErrorException;
import com.zlobasss.kurs.serviceInterface.IFoodService;
import com.zlobasss.kurs.repository.FoodRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FoodService implements IFoodService {

    @Autowired
    private final FoodRepo foodRepo;

    @Override
    public ResponseEntity<?> readAll() {
        return new ResponseEntity<>(foodRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> read(long id) {
        Optional<Food> food = foodRepo.findById(id);
        if (food.isEmpty()) {
            ErrorException exp = new ErrorException(
                    new ErrorBody(HttpStatus.NOT_FOUND.value(), "Not found food"));
            return new ResponseEntity<>(exp, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(food.get(), HttpStatus.OK);
    }
}
