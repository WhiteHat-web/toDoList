package com.example.springboot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Iterable<Task> listTasks() {
        return taskRepository.findAll();
    }

    public String createTask(Task task) {
        System.out.println("Inside create Task");
        taskRepository.save(task);
        return "Task created successfully!";
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
