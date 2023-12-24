package com.zlobasss.kurs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "exercises")
@ToString
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "typeId", nullable = false)
    @JsonIgnore
    private Type type;
    @JsonIgnore
    @OneToMany(mappedBy = "pk.exerciseId",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Training> trainings;
}
