package com.zlobasss.kurs.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "recommendations")
public class Recommendation {
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // data
    @NonNull
    private String description;
}
