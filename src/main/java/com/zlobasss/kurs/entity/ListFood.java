package com.zlobasss.kurs.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "lists_food")
public class ListFood {
    // id
    @Id
    @ManyToOne
    @JoinColumn(name = "food_id", referencedColumnName = "id", nullable = false)
    private Food food;
    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "sch_date", referencedColumnName = "date", nullable = false),
            @JoinColumn(name = "sch_user_id", referencedColumnName = "user_id", nullable = false)
    })
    private Schedule schedule;

    // data
    @Column(columnDefinition = "false")
    private boolean is_completed;

    // relations
    @ManyToOne
    @JoinColumn(name = "meal_id", referencedColumnName = "id", nullable = false)
    private Meal meal;
}
