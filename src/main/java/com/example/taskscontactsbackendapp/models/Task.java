package com.example.taskscontactsbackendapp.models;

public class Task {

    private Long id;
    private String name;
    private String description;
    private States state;

    public Task() {
    }

    public Task(Long id, String name, String description, States state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
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
}
