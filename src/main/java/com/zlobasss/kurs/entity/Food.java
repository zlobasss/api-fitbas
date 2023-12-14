package com.zlobasss.kurs.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private short num_of_servings;
    @OneToMany(mappedBy = "pk.food",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Recipe> recipes;
    @OneToMany(mappedBy = "pk.food",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<FoodList> food_lists;
}
