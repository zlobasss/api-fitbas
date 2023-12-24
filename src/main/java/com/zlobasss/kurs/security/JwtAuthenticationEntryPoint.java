package com.zlobasss.kurs.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zlobasss.kurs.exception.ErrorException;
import com.zlobasss.kurs.exception.ErrorBody;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        ErrorException error = new ErrorException(new ErrorBody(HttpStatus.FORBIDDEN.value(), "Login Failed"));
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        OutputStream outputStream = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(outputStream, error);
        outputStream.flush();
    }
}
