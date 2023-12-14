package com.zlobasss.kurs.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table(name = "exercises")
public class Exercise {
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // data
    @NonNull
    private String name;
    @NonNull
    private String description;

    // relations
    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;
}
