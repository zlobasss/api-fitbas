package com.zlobasss.kurs.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class ErrorBody implements Serializable {
    private int code;
    private String message;
}
