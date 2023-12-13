package com.zlobasss.kurs.entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@Data
@Entity
@Table(name = "users")
@ToString
public class User {
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // data
    @NonNull
    @Column(unique = true)
    private String login;
    @NonNull
    private String password;
    @NonNull
    private String first_name;
    @NonNull
    private String last_name;
    private URole role = URole.U_ROLE;

    // relations
    @OneToMany(mappedBy = "user")
    private Set<Schedule> schedules;
}
