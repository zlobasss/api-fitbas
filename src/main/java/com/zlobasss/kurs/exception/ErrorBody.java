package com.zlobasss.kurs.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class ErrorBody implements Serializable {
    private int code;
    private String message;
}
