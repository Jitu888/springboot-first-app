package com.javaguides.springbootfirstapp.service;

import com.javaguides.springbootfirstapp.model.Task;
import com.javaguides.springbootfirstapp.repository.NewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private NewRepo newRepo;


    public TaskService(NewRepo newRepo) {
        this.newRepo = newRepo;
    }
//   ___________________________________________   CRUD OPERATION ________________________________________________________________-
//     1. -------------------------------------------- CREATE ---------------------------------------------------------
    public Task addTask(@org.jetbrains.annotations.NotNull Task task){
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return newRepo.save(task);
    }

//    2.-------------------------------------------------- READ ---------------------------------------------------------
    public List<Task> findAllTasks (){
       return newRepo.findAll();
    }

    public Task getTaskById(String taskId){
        return newRepo.findById(taskId).get();
    }

    public List<Task> getTaskBySeverity(int severity){
        return newRepo.findBySeverity(severity);
    }

//    get data by query
    public List<Task> getTaskByAssignee(String assignee){
        return newRepo.getTaskByAssignee(assignee);
    }

    public Task updateTask(Task taskRequest){
       Task existingTask = newRepo.findById(taskRequest.getTaskId()).get();
       existingTask.setDescription(taskRequest.getDescription());
       existingTask.setSeverity(taskRequest.getSeverity());
       existingTask.setAssignee(taskRequest.getAssignee());
       existingTask.setStoryPoint(taskRequest.getStoryPoint());
        return newRepo.save(existingTask);
    }

    public String deleteTask (String taskId){
        newRepo.deleteById(taskId);
        return "task deleted successfully";
    }
}
