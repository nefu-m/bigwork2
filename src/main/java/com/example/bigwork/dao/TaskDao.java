package com.example.bigwork.dao;

import com.example.bigwork.entity.Task;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TaskDao {
    @PersistenceContext
    EntityManager entityManager=null;

    /**
     * 创建任务
     */
    public void createTask(Task task) {
        Task task2 = new Task();
        task2.setTaskType(task.getTaskType());
        task2.setTaskName(task.getTaskName());
        task2.setTaskInfo(task.getTaskInfo());
        task2.setTaskEnd(task.getTaskEnd());

        entityManager.persist(task2);
    }
}
