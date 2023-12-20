package com.zlobasss.kurs.entity;

import com.zlobasss.kurs.dto.RecipePK;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
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
