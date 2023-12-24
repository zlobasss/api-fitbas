package com.zlobasss.kurs.service;

import com.zlobasss.kurs.entity.Dimension;
import com.zlobasss.kurs.exception.ErrorBody;
import com.zlobasss.kurs.exception.ErrorException;
import com.zlobasss.kurs.serviceInterface.IDimensionService;
import com.zlobasss.kurs.repository.DimensionRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class DimensionService implements IDimensionService {
    @Autowired
    private final DimensionRepo dimensionRepo;

    @Override
    public ResponseEntity<?> readAll() {
        return new ResponseEntity<>(dimensionRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> read(String strId) {

        short id;
        try {
            id = Short.parseShort(strId);
        } catch (Exception e) {
            ErrorException exception = new ErrorException(new ErrorBody(HttpStatus.BAD_REQUEST.value(), "Id is not number"));
            return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
        }
        Optional<Dimension> dimension = dimensionRepo.findById(id);
        if (dimension.isPresent()) {
            return new ResponseEntity<>(dimension.get(), HttpStatus.OK);
        }
        ErrorException exception = new ErrorException(new ErrorBody(HttpStatus.NOT_FOUND.value(), "Dimension not found"));
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }
}
