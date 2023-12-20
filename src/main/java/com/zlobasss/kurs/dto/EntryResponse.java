package com.zlobasss.kurs.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EntryResponse {
    private String foodName;
    private short value;
    private boolean isCompleted;
}
