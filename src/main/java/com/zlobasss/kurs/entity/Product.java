package com.zlobasss.kurs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.jackson.JsonComponent;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "products")
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
