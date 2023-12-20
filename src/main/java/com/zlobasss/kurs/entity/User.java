package com.zlobasss.kurs.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // data
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private URole role = URole.U_ROLE;
    @OneToMany(mappedBy = "pk.userId",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<FoodList> foodLists;

    // relations
//    private Set<Training> schedules;
}
