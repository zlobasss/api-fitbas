package com.zlobasss.kurs.repository;

import com.zlobasss.kurs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String username);
    Boolean existsByLogin(String username);
}
