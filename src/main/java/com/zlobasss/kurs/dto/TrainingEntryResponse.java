package com.zlobasss.kurs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TrainingEntryResponse {
    private String exerciseName;
    private boolean isCompleted;
}
