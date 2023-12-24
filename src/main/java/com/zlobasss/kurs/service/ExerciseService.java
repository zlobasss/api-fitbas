package com.zlobasss.kurs.service;

import com.zlobasss.kurs.entity.Exercise;
import com.zlobasss.kurs.entity.Group;
import com.zlobasss.kurs.entity.Product;
import com.zlobasss.kurs.entity.Type;
import com.zlobasss.kurs.exception.ErrorBody;
import com.zlobasss.kurs.exception.ErrorException;
import com.zlobasss.kurs.repository.ExerciseRepo;
import com.zlobasss.kurs.repository.TypeRepo;
import com.zlobasss.kurs.serviceInterface.IExerciseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExerciseService implements IExerciseService {

    @Autowired
    private final ExerciseRepo exerciseRepo;

    @Autowired
    private final TypeRepo typeRepo;

    @Override
    public ResponseEntity<?> readAll() {
        return new ResponseEntity<>(exerciseRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> read(int id) {
        Optional<Exercise> exercise = exerciseRepo.findById(id);
        if (exercise.isEmpty()) {
            ErrorException exp = new ErrorException(
                    new ErrorBody(HttpStatus.NOT_FOUND.value(), "Not found exercise"));
            return new ResponseEntity<>(exp, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(exercise.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> readByType(String strId) {
        short id;
        try {
            id = Short.parseShort(strId);
        } catch (Exception e) {
            ErrorException exception = new ErrorException(
                    new ErrorBody(HttpStatus.BAD_REQUEST.value(), "Id is not number"));
            return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
        }

        Optional<Type> type = typeRepo.findById(id);
        if (type.isEmpty()) {
            ErrorException exception = new ErrorException(
                    new ErrorBody(HttpStatus.NOT_FOUND.value(), "Not found type"));
            return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
        }

        List<Exercise> exercises = exerciseRepo.findByType(type.get());
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }
}
