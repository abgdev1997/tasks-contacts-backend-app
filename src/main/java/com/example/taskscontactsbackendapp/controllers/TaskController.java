package com.example.taskscontactsbackendapp.controllers;

import com.example.taskscontactsbackendapp.dto.MessageDTO;
import com.example.taskscontactsbackendapp.dto.TaskDTO;
import com.example.taskscontactsbackendapp.models.States;
import com.example.taskscontactsbackendapp.models.Task;
import com.example.taskscontactsbackendapp.models.User;
import com.example.taskscontactsbackendapp.repository.TaskRepository;
import com.example.taskscontactsbackendapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private States selector(TaskDTO task){
        switch (task.getState()) {
            case "NORMAL" -> {
                return States.NORMAL;
            }
            case "URGENT" -> {
                return States.URGENT;
            }
            case "ESSENTIAL" -> {
                return States.ESSENTIAL;
            }
        }
        return null;
    }
    
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Task>> findAll(){
        return ResponseEntity.ok(taskRepository.findAll());
    }
    
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Task>> findByName(@PathVariable String name){
        return ResponseEntity.ok(taskRepository.findByName(name));
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<MessageDTO> create(@PathVariable Long id, @RequestBody TaskDTO taskDto){
        if(userRepository.existsById(id)){
            User user = userRepository.getById(id);
            Task task = new Task(
                    null,
                    taskDto.getName(),
                    taskDto.getDescription(),
                    selector(taskDto),
                    user
            );

           taskRepository.save(task);

            return ResponseEntity.ok(new MessageDTO("Task created successfully"));
        }

        return ResponseEntity.notFound().build();
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<MessageDTO> update(@PathVariable Long id, @RequestBody TaskDTO task){
        Optional<Task> taskBD = taskRepository.findById(id);
        Task taskF;
        taskF = new Task();
        if(taskBD.isPresent()){
            taskF.setId(taskBD.get().getId());
            taskF.setName(task.getName());
            taskF.setDescription(task.getDescription());
            taskF.setState(selector(task));
            taskF.setUser(taskBD.get().getUser());

            taskRepository.save(taskF);

            return ResponseEntity.ok(new MessageDTO("Update task with id: " + id));
        }
        
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDTO> delete(@PathVariable Long id){
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return ResponseEntity.ok(new MessageDTO("Delete task with id: " + id));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/all")
    public ResponseEntity<MessageDTO> deleteAll(){
        taskRepository.deleteAll();
        return ResponseEntity.ok(new MessageDTO("Delete all successfully"));
    }
}
