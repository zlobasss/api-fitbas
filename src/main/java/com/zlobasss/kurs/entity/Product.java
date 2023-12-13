package com.zlobasss.kurs.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Builder
@Table(name = "products")
@RequiredArgsConstructor
@Setter
@Getter
@Data
public class Product {
    // id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    // data
    private String name;

    // relations
    @ManyToOne
    @JoinColumn(name = "dimension_id", referencedColumnName = "id", nullable = false)
    private Dimension dimension;
    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable = false)
    private Group group;
    @OneToMany(mappedBy = "product")
    private Set<Recipe> recipes;
}
