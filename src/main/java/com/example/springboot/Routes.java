package com.example.springboot;

//import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.UUID;

@Controller
//@RequestMapping("/")
public class Routes {
    @Autowired
    private TaskService taskService;

//    @GetMapping("/listTask")
//    public Iterable<Task> listTask(){
//        return taskService.listTasks();
//    }

    @GetMapping("/tasksdisp")
    public String showTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasksdisp";
    }
    @GetMapping("/showTaskForm")
    public String showHomePage(Model model){
     //   Task Task = new Task();
        model.addAttribute("Task", new Task());
        return "home";
    }
    @PostMapping("/newTask")
    public String newTask(@ModelAttribute("Task") Task task){
        System.out.println(task.getDueDate());
        System.out.println(task.getTitle());
        System.out.println(task.getDescription());
        System.out.println(task.getPriority());
        taskService.createTask(task);
        return "home";
    }

    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute("existingTask") Task task){
        System.out.println(task.getTaskId());
        taskService.saveTask(task);
        return "updateTask";
    }

    @GetMapping("/updateTasks/{id}")
    public String updateTasks(@PathVariable ( value = "id") UUID id, Model model) {
        Task task = taskService.getTaskbyId(id);
        System.out.println(task.getTaskId());
        System.out.println(task.getPriority());
        model.addAttribute("existingTask", task);
        return "updateTask";
    }
//    @PutMapping("updateTask")
//    public String updateTask(){
//        return "Task Updated Succesfully";
//    }
//    @DeleteMapping ("deleteTask")
//    public String deleteTask(){
//        return "Task deleted Succesfully!";
//    }
}
