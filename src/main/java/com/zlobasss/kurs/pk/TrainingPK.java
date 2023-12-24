package com.zlobasss.kurs.pk;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zlobasss.kurs.entity.Exercise;
import com.zlobasss.kurs.entity.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Embeddable
@Getter
@Setter
public class TrainingPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User userId;
    @ManyToOne
    @JoinColumn(name = "exercise_id")
    @JsonIgnore
    private Exercise exerciseId;
    @JsonIgnore
    private Date date;
}
