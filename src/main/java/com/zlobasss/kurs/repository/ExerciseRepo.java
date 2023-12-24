package com.zlobasss.kurs.repository;

import com.zlobasss.kurs.entity.Exercise;
import com.zlobasss.kurs.entity.Group;
import com.zlobasss.kurs.entity.Product;
import com.zlobasss.kurs.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepo extends JpaRepository<Exercise, Integer> {
    List<Exercise> findByType(Type type);
}
