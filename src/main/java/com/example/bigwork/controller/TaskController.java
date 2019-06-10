package com.example.bigwork.controller;

import com.example.bigwork.entity.Task;
import com.example.bigwork.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public void createTask(Task task){
        taskService.createTask(task);
    }
}
