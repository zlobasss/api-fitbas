package com.zlobasss.kurs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class DeleteResponse {
    private int code;
    private String message;

    public ResponseEntity<DeleteResponse> returnNotFound() {
        code = HttpStatus.NOT_FOUND.value();
        message = "This entry was not found";
        return new ResponseEntity<>(this, HttpStatus.NOT_FOUND);
    }
}
