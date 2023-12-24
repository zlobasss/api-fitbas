package com.zlobasss.kurs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zlobasss.kurs.pk.FoodListPK;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "food_lists")
@ToString
@Table(name = "food_lists")
@Data
public class FoodList {
    @EmbeddedId
    @JsonIgnore
    private FoodListPK pk;
    private boolean isCompleted;
    private short value;
}
