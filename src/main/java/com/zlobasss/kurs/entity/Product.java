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
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "groupId", nullable = false)
    @JsonIgnore
    private Group group;
    @JsonIgnore
    @OneToMany(mappedBy = "pk.productId",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Recipe> recipes;
}
