package com.zlobasss.kurs.repository;

import com.zlobasss.kurs.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepo extends JpaRepository<Food, Long> {
}
