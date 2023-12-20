package com.zlobasss.kurs.repository;

import com.zlobasss.kurs.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<Group, Short> {
}
