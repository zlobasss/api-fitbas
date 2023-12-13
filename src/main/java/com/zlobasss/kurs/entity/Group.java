package com.zlobasss.kurs.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "groups")
public class Group {
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    // data
    @NonNull
    private String name;

    // relations
    @OneToMany(mappedBy = "group")
    private Set<Product> products;
}
