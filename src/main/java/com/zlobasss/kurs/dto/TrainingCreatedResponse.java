package com.zlobasss.kurs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class TrainingCreatedResponse {
    private Date date;
    private String exerciseName;
    private boolean isCompleted;
}
