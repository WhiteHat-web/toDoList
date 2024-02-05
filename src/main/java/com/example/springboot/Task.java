package com.example.springboot;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

// import javax.persistence.Entity;
// import javax.persistence.Id;
// import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table  // Specify the table name
public class Task {

    @Id
    private UUID taskId = UUID.randomUUID();
    private UUID userId;
    private String title;
    private String description;
    private LocalDate dueDate;
    private String priority;
    public Task (String title, String description, LocalDate dueDate, String priority,UUID userId){
        this.title=title;
        this.description=description;
        this.dueDate=dueDate;
        this.priority=priority;
        this.userId=userId;
    };

    public Task(UUID taskId, String title, String description, LocalDate dueDate, String priority,UUID userId) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.userId=userId;
    }

    public Task() {
       // this.taskId = UUID.randomUUID();
        // Additional initialization if needed
    };
    // Constructors, getters, and setters
    // ...

    public UUID getTaskId() {
        return taskId;
    }

    public void setTaskId(UUID taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    // Setters and other methods
    // ...
}
