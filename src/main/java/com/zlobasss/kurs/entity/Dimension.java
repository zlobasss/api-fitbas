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
@Table(name = "dimensions")
public class Dimension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    private String name;
    private String shortName;
    @OneToMany(mappedBy = "dimension")
    private Set<Recipe> recipes;
}
