package com.zlobasss.kurs.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IFoodService {
    ResponseEntity<?> readAll();
    ResponseEntity<?> read(long id);
}
