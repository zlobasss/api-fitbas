package com.zlobasss.kurs.entity;

import com.zlobasss.kurs.pk.RecipePK;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "recipes")
@ToString
@Table(name = "recipes")
public class Recipe {
    @EmbeddedId
    private RecipePK pk;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dimensionId", nullable = false)
    private Dimension dimension;
    private BigDecimal value;
}
