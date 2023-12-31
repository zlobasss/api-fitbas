package com.zlobasss.kurs.controller;

import com.zlobasss.kurs.serviceInterface.IProductService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam @Nullable String group) {
        if (group != null) {
            return productService.readByGroup(group);
        }
        return productService.readAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<?> get(@PathVariable int id) {
        return productService.read(id);
    }
}
