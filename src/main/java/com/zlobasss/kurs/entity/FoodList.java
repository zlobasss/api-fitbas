package com.zlobasss.kurs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zlobasss.kurs.dto.FoodListPK;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "food_lists")
public class FoodList {
    @EmbeddedId
    private FoodListPK pk;
    private boolean is_completed;
}
