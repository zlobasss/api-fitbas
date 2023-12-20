package com.zlobasss.kurs.repository;

import com.zlobasss.kurs.entity.Group;
import com.zlobasss.kurs.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    Optional<List<Product>> findByGroup(Group group);
}
