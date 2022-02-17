package com.example.taskscontactsbackendapp.models;

import javax.persistence.*;

@Entity
@Table(name = "app_tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private States state;

    @ManyToOne()
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public Task() {
    }

    public Task(Long id, String name, String description, States state, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
