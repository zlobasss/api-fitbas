package com.zlobasss.kurs.serviceInterface;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ITypeService {
    ResponseEntity<?> readAll();
    ResponseEntity<?> read(String id);
}
