package com.zlobasss.kurs.repository;

import com.zlobasss.kurs.dto.FoodListPK;
import com.zlobasss.kurs.entity.FoodList;
import com.zlobasss.kurs.entity.Meal;
import com.zlobasss.kurs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface FoodListRepo extends JpaRepository<FoodList, FoodListPK> {

}
