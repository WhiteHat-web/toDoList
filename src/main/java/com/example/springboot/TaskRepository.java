package com.example.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID; // Add this import
@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

    List<Task> findTaskByUserId(UUID userId);
    // Define custom queries or methods if needed
}
