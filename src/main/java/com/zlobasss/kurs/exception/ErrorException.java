package com.zlobasss.kurs.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class ErrorException implements Serializable {
    @JsonSerialize
    public ErrorBody error;
}
