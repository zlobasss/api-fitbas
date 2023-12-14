package com.zlobasss.kurs.service;

import com.zlobasss.kurs.dto.UserDto;
import com.zlobasss.kurs.dto.JwtResponse;
import com.zlobasss.kurs.entity.Schedule;
import com.zlobasss.kurs.entity.URole;
import com.zlobasss.kurs.entity.User;
import com.zlobasss.kurs.repository.UserRepo;
import com.zlobasss.kurs.security.JwtHelper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    @Autowired
    private final UserRepo userRepo;
    @Autowired
    private final PasswordEncoder encoder;
    @Autowired
    private final JwtHelper jwtHelper;
    @Autowired
    private final UserDetailsService userDetailsService;

    @Override
    public ResponseEntity<?> create(UserDto dto) {
        if (userRepo.existsByLogin(dto.getLogin())) {
            return new ResponseEntity<>("User is exist!!!", HttpStatus.FORBIDDEN);
        }
        userRepo.save(User.builder()
                .login(dto.getLogin())
                .password(encoder.encode(dto.getPassword()))
                .first_name(dto.getFirst())
                .last_name(dto.getLast())
                .role(URole.U_ROLE)
                .schedules(new HashSet<Schedule>())
                .build()
        );
        String token = jwtHelper.generateToken(userDetailsService.loadUserByUsername(dto.getLogin()));
        return new ResponseEntity<JwtResponse>(new JwtResponse(token, dto.getLogin()), HttpStatus.CREATED);
    }

    @Override
    public List<User> readAll() {
        return new ArrayList<>(userRepo.findAll());
    }

    @Override
    public User read(long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public User update(User user) {
        return userRepo.save(user);
    }

    @Override
    public void delete(long id) {
        userRepo.deleteById(id);
    }


}
