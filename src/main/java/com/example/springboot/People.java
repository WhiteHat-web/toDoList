package com.example.springboot;
import jakarta.persistence.*;
@Entity
@Table
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    public People(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public People(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public People() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
