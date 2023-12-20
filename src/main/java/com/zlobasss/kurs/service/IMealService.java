package com.zlobasss.kurs.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IMealService {
    ResponseEntity<?> readAll();
    ResponseEntity<?> read(String id);
}
