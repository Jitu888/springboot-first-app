package com.javaguides.springbootfirstapp.controller;

import com.javaguides.springbootfirstapp.model.Task;
import com.javaguides.springbootfirstapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
     TaskService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){
        return service.addTask(task);
    }

    @GetMapping
    public List<Task> getAllTask(){
        return service.findAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable String id){
        return service.getTaskById(id);
    }

    @GetMapping("/severity/{severity}")
    public List<Task> getTaskBySeverity(@PathVariable int severity){
        return service.getTaskBySeverity(severity);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Task> getTaskByAssignee(@PathVariable String assignee){
        return service.getTaskByAssignee(assignee);
    }

    @PutMapping
    public Task modifyTask(@RequestBody Task TaskData){
        return service.updateTask(TaskData);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable String taskId){
        return service.deleteTask(taskId);
    }


}
