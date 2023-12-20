package com.zlobasss.kurs.controller;

import com.zlobasss.kurs.service.IProductService;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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
