package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Routes {
    @Autowired
    private TaskService taskService;

    @GetMapping("/listTask")
    public Iterable<Task> listTask(){
        return taskService.listTasks();
    }
    @PostMapping("newTask")
    public String newTask(@RequestBody Task tempTask){
        System.out.println(tempTask.getTaskId());
        System.out.println(tempTask.getTitle());
        System.out.println(tempTask.getDescription());
        System.out.println(tempTask.getDueDate());
        System.out.println(tempTask.getPriority());
        taskService.createTask(tempTask);
        return "Task Created Succesfully";
    }
    @PutMapping("updateTask")
    public String updateTask(){
        return "Task Updated Succesfully";
    }
    @DeleteMapping ("deleteTask")
    public String deleteTask(){
        return "Task deleted Succesfully!";
    }
}
