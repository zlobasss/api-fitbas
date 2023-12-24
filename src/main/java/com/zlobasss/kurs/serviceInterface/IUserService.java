package com.zlobasss.kurs.serviceInterface;

import com.zlobasss.kurs.dto.UserRequest;
import com.zlobasss.kurs.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    ResponseEntity<?> create(UserRequest dto);
    List<User> readAll();
    User read(long id);
    User update(User user);
    void delete(long id);
}
