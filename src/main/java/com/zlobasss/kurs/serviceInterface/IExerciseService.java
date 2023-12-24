package com.zlobasss.kurs.serviceInterface;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IExerciseService {
    ResponseEntity<?> readAll();
    ResponseEntity<?> read(int id);
    ResponseEntity<?> readByType(String group);
}
