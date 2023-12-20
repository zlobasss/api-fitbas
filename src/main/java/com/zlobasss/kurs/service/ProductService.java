package com.zlobasss.kurs.service;

import com.zlobasss.kurs.entity.Group;
import com.zlobasss.kurs.entity.Product;
import com.zlobasss.kurs.exception.ErrorException;
import com.zlobasss.kurs.exception.ErrorBody;
import com.zlobasss.kurs.repository.GroupRepo;
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

    @Autowired
    private final GroupRepo groupRepo;

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

    @Override
    public ResponseEntity<?> readByGroup(String strId) {
        short id;
        try {
            id = Short.parseShort(strId);
        } catch (Exception e) {
            ErrorException exception = new ErrorException(new ErrorBody(HttpStatus.BAD_REQUEST.value(), "Id is not number"));
            return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
        }

        Optional<Group> group = groupRepo.findById(id);
        if (group.isEmpty()) {
            ErrorException exception = new ErrorException(new ErrorBody(HttpStatus.NOT_FOUND.value(), "Not found group"));
            return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
        }

        Optional<List<Product>> products = productRepo.findByGroup(group.get());
        return new ResponseEntity<>(products.get(), HttpStatus.OK);
    }
}
