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
    @JoinColumn(name = "foodId")
    @JsonIgnore
    private Food foodId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product productId;
}
