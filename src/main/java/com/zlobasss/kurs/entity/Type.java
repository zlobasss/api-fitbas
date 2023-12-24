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
@Entity
@ToString
@Table(name = "types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    private String name;
    @OneToMany(mappedBy = "type")
    @JsonIgnore
    private Set<Exercise> exercises;
}
