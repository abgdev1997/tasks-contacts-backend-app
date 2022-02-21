package com.example.taskscontactsbackendapp.dto;

import com.example.taskscontactsbackendapp.models.States;

public class TaskDTO {

    String name;
    String description;
    States state;

    public TaskDTO() {
    }

    public TaskDTO(String name, String description, States state) {
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

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }
}
