package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/")
public class Routes {
    @Autowired
    private TaskService taskService;

    @GetMapping("/listTask")
    public Iterable<Task> listTask(@RequestParam UUID userId){
        return taskService.listTasks(userId);

    }
    @PostMapping("newTask")
    public String newTask(@RequestBody Task tempTask){
        //System.out.println("Task Data:"+tempTask);
        taskService.createTask(tempTask);
        return "Task Created Successfully";
    }
    @PutMapping("updateTask")
    public String updateTask(@RequestBody Task temp,@PathVariable UUID taskId){
       taskService.updateTask(taskId,temp);
       return "Task Updated Succesfully";
    }
    @DeleteMapping ("deleteTask")
    public String deleteTask(@RequestBody UUID taskId){
        return "Task deleted Successfully!";
    }
}
