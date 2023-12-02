package com.zlobasss.kurs.entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "users")
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    @Column(unique = true)
    private String login;
    @NonNull
    private String password;
    @NonNull
    private String firstname;
    @NonNull
    private String secondname;
    private URole role = URole.U_ROLE;
}
