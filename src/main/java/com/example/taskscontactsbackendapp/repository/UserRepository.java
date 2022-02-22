package com.example.taskscontactsbackendapp.repository;

import com.example.taskscontactsbackendapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<Object> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
