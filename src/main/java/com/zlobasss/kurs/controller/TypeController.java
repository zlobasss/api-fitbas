package com.zlobasss.kurs.controller;

import com.zlobasss.kurs.serviceInterface.ITypeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/types")
@AllArgsConstructor
public class TypeController {

    @Autowired
    private final ITypeService typeService;

    @GetMapping
    public ResponseEntity<?> readAll() {
        return typeService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable String id) {
        return typeService.read(id);
    }
}