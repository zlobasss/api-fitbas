package com.zlobasss.kurs.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Getter
@Setter
@Table(name = "trainings")
@ToString
public class Training {
    // data
    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "sch_date", referencedColumnName = "date", nullable = false),
            @JoinColumn(name = "sch_user_id", referencedColumnName = "user_id", nullable = false)
    })
    private Schedule schedule;
    @Id
    @ManyToOne
    @JoinColumn(name = "exercise_id", referencedColumnName = "id", nullable = false)
    private Exercise exercise;
    @Column(columnDefinition = "false")
    private boolean is_completed;
    private Instant time_start;
}
