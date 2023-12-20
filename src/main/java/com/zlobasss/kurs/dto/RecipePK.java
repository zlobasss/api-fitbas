package com.zlobasss.kurs.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zlobasss.kurs.entity.Food;
import com.zlobasss.kurs.entity.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class RecipePK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "food_id")
    @JsonIgnore
    private Food foodId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;
}
