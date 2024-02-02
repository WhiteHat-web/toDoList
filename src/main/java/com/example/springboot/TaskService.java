package com.example.springboot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
//    public String updateTask() {
//        // Implement update logic using taskRepository
//        return "Task updated successfully!";
//    }

    public Task getTaskbyId(UUID id){
        Optional<Task> optional = taskRepository.findById(id);
        Task task = null;
        if(optional.isPresent()){
            task = optional.get();
        }
        else{
            throw new RuntimeException("Task not found");
        }
        return task;
    }

    public void saveTask(Task task){
        taskRepository.save(task);
    }

    public void deleteTask(UUID id) {
        // Implement delete logic using taskRepository
        taskRepository.deleteById(id);
    }
}
