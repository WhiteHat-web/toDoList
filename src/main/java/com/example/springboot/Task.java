package com.example.springboot;
import jakarta.persistence.*;

// import javax.persistence.Entity;
// import javax.persistence.Id;
// import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table  // Specify the table name
public class Task {

    @Id
    private UUID taskId = UUID.randomUUID();
    private String title;
    private String description;
    private String dueDate;
    private String priority;
    public Task (String title, String descripton, String dueDate, String priority){
        this.taskId=UUID.randomUUID();
        this.title=title;
        this.description=descripton;
        this.dueDate=dueDate;
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

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getPriority() {
        return priority;
    }

    // Setters and other methods
    // ...
}
