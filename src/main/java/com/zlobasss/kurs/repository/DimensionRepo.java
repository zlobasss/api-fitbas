package com.zlobasss.kurs.repository;

import com.zlobasss.kurs.entity.Dimension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DimensionRepo extends JpaRepository<Dimension, Short> {
}
