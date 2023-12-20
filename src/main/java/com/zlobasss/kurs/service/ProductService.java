package com.zlobasss.kurs.service;

import com.zlobasss.kurs.entity.Product;
import com.zlobasss.kurs.exception.ErrorException;
import com.zlobasss.kurs.exception.ErrorBody;
import com.zlobasss.kurs.repository.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    @Autowired
    private final ProductRepo productRepo;

    @Override
    public ResponseEntity<?> readAll() {
        return new ResponseEntity<>(productRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> read(int id) {
        Optional<Product> product = productRepo.findById(id);
        if (product.isEmpty()) {
            ErrorException exp = new ErrorException(new ErrorBody(HttpStatus.NOT_FOUND.value(), "Not found product"));
            return new ResponseEntity<>(exp, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product.get(), HttpStatus.OK);
    }
}
