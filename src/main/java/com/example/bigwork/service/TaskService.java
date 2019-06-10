package com.example.bigwork.service;

import com.example.bigwork.dao.TaskDao;
import com.example.bigwork.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TaskService {
    @Autowired
    private TaskDao taskDao;

    public void createTask(Task task){
        taskDao.createTask(task);
    }
}
