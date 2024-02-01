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

    public List<Task> listTasks(UUID userId) {
        System.out.println("User id "+userId);
        return taskRepository.findByUserId(userId);
    }

    public void createTask(Task task) {
        System.out.println("Inside create Task");
        System.out.println("Task Data:"+task.getTaskId()+" "+task.getDueDate()+" "+task.getUserId());
        taskRepository.save(task);
    }

    public String updateTask(UUID taskId,Task newTask) {
        try {
            Task oldTask = taskRepository.findById(taskId).get();
            if(newTask.getDescription()!=null) {
                oldTask.setDescription(newTask.getDescription());
            }
            if(newTask.getTitle()!=null) {
                oldTask.setTitle(newTask.getTitle());
            }
            if(newTask.getPriority()!=null) {
                oldTask.setPriority(newTask.getPriority());
            }
            if(newTask.getDueDate()!=null) {
                oldTask.setDueDate(newTask.getDueDate());
            }
           taskRepository.save(oldTask);
        }
        catch(Exception e){
            return ("task does not exist");
        }

        return "Task updated successfully!";
    }

    public String deleteTask(UUID taskId) {
        taskRepository.deleteById(taskId);
        return "Task deleted successfully!";
    }
}
