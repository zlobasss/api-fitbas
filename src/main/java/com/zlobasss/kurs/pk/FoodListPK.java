package com.zlobasss.kurs.pk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zlobasss.kurs.entity.Food;
import com.zlobasss.kurs.entity.FoodList;
import com.zlobasss.kurs.entity.Meal;
import com.zlobasss.kurs.entity.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Embeddable
@Getter
@Setter
public class FoodListPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User userId;
    @ManyToOne
    @JoinColumn(name = "food_id")
    @JsonIgnore
    private Food foodId;
    @ManyToOne
    @JoinColumn(name = "meal_id")
    @JsonIgnore
    private Meal mealId;
    @JsonIgnore
    private Date date;
}
