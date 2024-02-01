package com.example.springboot;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;

    private String username;
    private String email;
    private String password;

    public People(UUID userId, String username, String password, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public People(String username, String password,String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public People() {

    }

    public UUID getId() {
        return userId;
    }

    public void setId(UUID userId) {
        this.userId =userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
