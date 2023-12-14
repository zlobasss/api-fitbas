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
@Table(name = "meals")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    private String name;
    @OneToMany(mappedBy = "pk.meal",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<FoodList> food_lists;
}
