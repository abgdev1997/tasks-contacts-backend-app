package com.example.taskscontactsbackendapp.models;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class User {

    private Long id;
    private String username;
    private String email;
    private String password;
    private List<Task> tasks;

    public User() {
    }

    public User(Long id, String username, String email, String password, List<Task> tasks) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.tasks = tasks;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
