package com.example.taskscontactsbackendapp.repository;

import com.example.taskscontactsbackendapp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
