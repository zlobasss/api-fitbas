package com.zlobasss.kurs.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
    private String login;
    private String password;
    private String first;
    private String last;
}
