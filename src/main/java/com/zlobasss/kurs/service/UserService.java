package com.zlobasss.kurs.service;

import com.zlobasss.kurs.dto.UserRequest;
import com.zlobasss.kurs.dto.JwtResponse;
import com.zlobasss.kurs.entity.URole;
import com.zlobasss.kurs.entity.User;
import com.zlobasss.kurs.exception.ErrorBody;
import com.zlobasss.kurs.exception.ErrorException;
import com.zlobasss.kurs.serviceInterface.IUserService;
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
import java.util.Arrays;
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

    public static String format(String str, char[] chars) {
        str = str.toLowerCase();
        for (char sym: chars) {
            str = str.replaceAll(String.valueOf(sym), "");
        }
        return str;
    }

    @Override
    public ResponseEntity<?> create(UserRequest dto) {
        ErrorException exception = new ErrorException(
                new ErrorBody(HttpStatus.CONFLICT.value(), ""));
        int lengthLogin = dto.getLogin().length();
        int lengthPass = dto.getPassword().length();
        char[] symLogin = "qwertyuiopasdfghjklzxcvbnm1234567890_".toCharArray();
        char[] symPassword = "qwertyuiopasdfghjklzxcvbnm1234567890_!@#%&.".toCharArray();
        char[] symData = "qwertyuiopasdfghjklzxcvbnmйцукенгшщзхъфывапролджэячсмитьбюё".toCharArray();

        String login = format(dto.getLogin(), symLogin);
        String password = format(dto.getPassword(), symPassword);
        String first = format(dto.getFirst(), symData);
        String second = format(dto.getPassword(), symData);
        if  (lengthLogin < 3 ||
            lengthLogin > 31 ||
            dto.getLogin().startsWith("_") ||
            !login.isEmpty()) {

            exception.error.setMessage("Login is incorrect");
            return new ResponseEntity<>(exception, HttpStatus.CONFLICT);
        }

        if (userRepo.existsByLogin(dto.getLogin())) {
            exception.error.setMessage("A user with this login already exists");
            return new ResponseEntity<>(exception, HttpStatus.CONFLICT);
        }

        if (lengthPass < 3 || lengthPass > 31 || !password.isEmpty()) {
            exception.error.setMessage("Password is incorrect");
            return new ResponseEntity<>(exception, HttpStatus.CONFLICT);
        }

        if (dto.getFirst().length() > 63 || dto.getLast().length() > 63 || !second.isEmpty() || !first.isEmpty()) {
            exception.error.setMessage("Data is incorrect");
            return new ResponseEntity<>(exception, HttpStatus.CONFLICT);
        }

        userRepo.save(User.builder()
                .login(dto.getLogin())
                .password(encoder.encode(dto.getPassword()))
                .firstName(dto.getFirst())
                .lastName(dto.getLast())
                .role(URole.U_ROLE)
                .foodLists(new HashSet<>())
                .build()
        );
        String token = jwtHelper.generateToken(
                userDetailsService.loadUserByUsername(dto.getLogin()));
        return new ResponseEntity<JwtResponse>(
                new JwtResponse(token, dto.getLogin()), HttpStatus.CREATED);
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
