package com.zlobasss.kurs.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "dimensions")
public class Dimension {
    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    // data
    @NonNull
    private String name;
    private String shortname;

    // relations
    @OneToMany(mappedBy = "dimension")
    private Set<Product> products;
}
