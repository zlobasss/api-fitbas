package com.zlobasss.kurs.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
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
