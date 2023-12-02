package com.zlobasss.kurs.service;

import com.zlobasss.kurs.dto.UserDto;
import com.zlobasss.kurs.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    ResponseEntity<?> create(UserDto dto);
    List<User> readAll();
    User read(long id);
    User update(User user);
    void delete(long id);
}
