package com.zlobasss.kurs.service;

import com.zlobasss.kurs.entity.Group;
import com.zlobasss.kurs.exception.ErrorBody;
import com.zlobasss.kurs.exception.ErrorException;
import com.zlobasss.kurs.repository.GroupRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GroupService implements IGroupService{

    @Autowired
    private final GroupRepo groupRepo;

    @Override
    public ResponseEntity<?> readAll() {
        return new ResponseEntity<>(groupRepo.findAll(), HttpStatus.OK);
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

        Optional<Group> group = groupRepo.findById(id);
        if (group.isPresent()) {
            return new ResponseEntity<>(group.get(), HttpStatus.OK);
        }
        ErrorException exception = new ErrorException(new ErrorBody(HttpStatus.NOT_FOUND.value(), "Not found group"));
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }
}
