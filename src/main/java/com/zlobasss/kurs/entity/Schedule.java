package com.zlobasss.kurs.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@ToString
@Entity
@Table(name = "schedules")
public class Schedule {
    // id
    @Id
    private Date date;
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    // relations
    @OneToMany(mappedBy = "schedule")
    private Set<Training> training;
    @OneToMany(mappedBy = "schedule")
    private Set<ListFood> lists_food;
}
