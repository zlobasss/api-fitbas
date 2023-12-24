package com.zlobasss.kurs.repository;

import com.zlobasss.kurs.dto.*;
import com.zlobasss.kurs.entity.Meal;
import com.zlobasss.kurs.entity.Training;
import com.zlobasss.kurs.pk.TrainingPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TrainingRepo extends JpaRepository<Training, TrainingPK> {
    @Query("SELECT new com.zlobasss.kurs.dto.DateTrainingEntryResponse(t.pk.date) FROM trainings t where t.pk.userId.id = :user GROUP BY t.pk.date, t.pk.userId")
    List<DateTrainingEntryResponse> findDates(@Param("user") long user);

    @Query("SELECT new com.zlobasss.kurs.dto.TrainingEntryResponse(e.name, t.isCompleted) FROM trainings t join exercises e on e.id = t.pk.exerciseId.id where t.pk.userId.id = :user and t.pk.date = :date")
    List<TrainingEntryResponse> findEntryResponse(@Param("user") long user, @Param("date") Date date);
}
