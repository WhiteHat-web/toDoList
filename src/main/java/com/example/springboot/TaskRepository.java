package com.example.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID; // Add this import
@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    // Define custom queries or methods if needed
}
