package com.zlobasss.kurs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zlobasss.kurs.pk.TrainingPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "trainings")
@ToString
@Table(name = "trainings")
@Data
public class Training {
    @EmbeddedId
    @JsonIgnore
    private TrainingPK pk;
    private boolean isCompleted;
}
