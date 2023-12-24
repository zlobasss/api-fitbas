package com.zlobasss.kurs.controller;

import com.zlobasss.kurs.dto.UserRequest;
import com.zlobasss.kurs.dto.JwtRequest;
import com.zlobasss.kurs.dto.JwtResponse;
import com.zlobasss.kurs.exception.ErrorBody;
import com.zlobasss.kurs.exception.ErrorException;
import com.zlobasss.kurs.repository.UserRepo;
import com.zlobasss.kurs.security.JwtHelper;
import com.zlobasss.kurs.serviceInterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private IUserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private JwtHelper helper;

    @PostMapping(value = "/sign-in", consumes = "application/json")
    public ResponseEntity<JwtResponse> signin(@RequestBody JwtRequest request) {

        this.doAuthenticate(request.getLogin(), request.getPassword());

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLogin());
        String token = this.helper.generateToken(userDetails);

        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);
        } catch (Exception e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @PostMapping(value = "/sign-up", consumes = "application/json")
    public ResponseEntity<?> register(@RequestBody UserRequest dto) {
        return userService.create(dto);
    }


    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorException> exceptionHandler() {
        return new ResponseEntity<>(new ErrorException(new ErrorBody(HttpStatus.CONFLICT.value(), "Credentials Invalid!!")), HttpStatus.CONFLICT);
    }
}
