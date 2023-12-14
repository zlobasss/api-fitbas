package com.zlobasss.kurs.entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
@Table(name = "recipes")
public class Recipe {
    // id
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private Product product;
    @Id
    @ManyToOne
    @JoinColumn(name = "food_id", referencedColumnName = "id", nullable = false)
    private Food food;

    // data
    private int value;
}
