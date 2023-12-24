package com.zlobasss.kurs.repository;

import com.zlobasss.kurs.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepo extends JpaRepository<Type, Short> {
}
