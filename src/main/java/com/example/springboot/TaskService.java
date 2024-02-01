package com.example.springboot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public Iterable<Task> listTasks() {
        return taskRepository.findAll();
    }

    public void createTask(Task task) {
        System.out.println("Inside create Task");
        taskRepository.save(task);
    }
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public String updateTask() {
        // Implement update logic using taskRepository
        return "Task updated successfully!";
    }

    public String deleteTask() {
        // Implement delete logic using taskRepository
        return "Task deleted successfully!";
    }
}
