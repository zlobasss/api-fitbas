package com.zlobasss.kurs.controller;

import com.zlobasss.kurs.service.IDimensionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/dimension")
@AllArgsConstructor
public class DimensionController {
    @Autowired
    private final IDimensionService dimensionService;

    @GetMapping
    public ResponseEntity<?> readAll() {
        return dimensionService.readAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable short id) {
        return dimensionService.read(id);
    }

}
