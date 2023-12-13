package com.zlobasss.kurs.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "foods")
@RequiredArgsConstructor
@Getter
@Setter
@Data
@Builder
public class Food {
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // data
    @NonNull
    private String name;
    @NonNull
    private String description;
    private short numOfServings;

    // relation
    @OneToMany(mappedBy = "food")
    private Set<Recipe> recipes;
    @OneToMany(mappedBy = "food")
    private Set<ListFood> lists_food;
}
