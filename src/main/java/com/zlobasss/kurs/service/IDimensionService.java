package com.zlobasss.kurs.service;

import com.zlobasss.kurs.entity.Dimension;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDimensionService {
    ResponseEntity<?> readAll();
    ResponseEntity<?> read(short id);
}
