package com.example.springboot;
import jakarta.persistence.*;

// import javax.persistence.Entity;
// import javax.persistence.Id;
// import javax.persistence.Table;
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

    private Date dueDate=new Date();
    private String priority;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Task (String title, String description, Date dueDate, String priority, UUID userId){
        this.taskId=UUID.randomUUID();
        this.userId=userId;
        this.title=title;
        this.description= description;
        this.dueDate=dueDate;
        this.priority=priority;
    };
    public Task (String title, String description, String priority,UUID userId){
        this.taskId=UUID.randomUUID();
        this.userId=userId;
        this.title=title;
        this.description= description;
        this.dueDate=new Date();
        this.priority=priority;
    };
    public Task() {
        this.taskId = UUID.randomUUID();
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getPriority() {
        return priority;
    }

    // Setters and other methods
    // ...
}
