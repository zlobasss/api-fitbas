package com.zlobasss.kurs.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IProductService {
    ResponseEntity<?> readAll();
    ResponseEntity<?> read(int id);
}
