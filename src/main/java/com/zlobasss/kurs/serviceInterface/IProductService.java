package com.zlobasss.kurs.serviceInterface;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IProductService {
    ResponseEntity<?> readAll();
    ResponseEntity<?> read(int id);
    ResponseEntity<?> readByGroup(String group);
}
