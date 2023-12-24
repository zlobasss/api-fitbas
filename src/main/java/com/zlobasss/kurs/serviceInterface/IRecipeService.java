package com.zlobasss.kurs.serviceInterface;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IRecipeService {

    ResponseEntity<?> readByFood(long foodId);
}
