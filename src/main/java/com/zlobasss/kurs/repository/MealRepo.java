package com.zlobasss.kurs.repository;

import com.zlobasss.kurs.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepo extends JpaRepository<Meal, Short> {
}
