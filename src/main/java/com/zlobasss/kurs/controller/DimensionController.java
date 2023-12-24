package com.zlobasss.kurs.controller;

import com.zlobasss.kurs.serviceInterface.IDimensionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dimensions")
@AllArgsConstructor
public class DimensionController {
    @Autowired
    private final IDimensionService dimensionService;

    @GetMapping
    public ResponseEntity<?> readAll() {
        return dimensionService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable String id) {
        System.out.println("'" + id + "'");
        return dimensionService.read(id);
    }

}
