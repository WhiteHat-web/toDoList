package com.example.springboot;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Routes {
    @GetMapping("/listTask")
    public String listTask(){
        return "These are tasks";
    }
    @PostMapping("newTask")
    public String newTask(){
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
