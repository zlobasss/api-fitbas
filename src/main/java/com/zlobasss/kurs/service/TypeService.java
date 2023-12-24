package com.zlobasss.kurs.service;

import com.zlobasss.kurs.entity.Type;
import com.zlobasss.kurs.exception.ErrorBody;
import com.zlobasss.kurs.exception.ErrorException;
import com.zlobasss.kurs.serviceInterface.ITypeService;
import com.zlobasss.kurs.repository.TypeRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TypeService implements ITypeService {

    @Autowired
    private final TypeRepo typeRepo;

    @Override
    public ResponseEntity<?> readAll() {
        return new ResponseEntity<>(typeRepo.findAll(), HttpStatus.OK);
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

        Optional<Type> type = typeRepo.findById(id);
        if (type.isPresent()) {
            return new ResponseEntity<>(type.get(), HttpStatus.OK);
        }
        ErrorException exception = new ErrorException(new ErrorBody(HttpStatus.NOT_FOUND.value(), "Not found group"));
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }
}
