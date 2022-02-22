package com.example.taskscontactsbackendapp.dto;

import com.example.taskscontactsbackendapp.models.States;

public class TaskDTO {

    private String name;
    private String description;
    private String state;

    public TaskDTO() {
    }

    public TaskDTO(String name, String description, String state) {
        this.name = name;
        this.description = description;
        this.state = state;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
