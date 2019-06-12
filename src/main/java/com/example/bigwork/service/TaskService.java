package com.example.bigwork.service;

import com.example.bigwork.entity.Task;
import com.example.bigwork.entity.TaskMessage;
import com.example.bigwork.repository.TaskMessageRepository;
import com.example.bigwork.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskMessageRepository taskMessageRepository;

    //添加任务
    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    //修改指定id任务
    public Task updateTask(Task t,int tid){
        return taskRepository.update(t,tid);
    }

    //查询所有任务
    public List<Task> findAllTask(){
        return taskRepository.findAllTask();
    }

    //查询指定id任务
    public Task findTask(int tid){
        return taskRepository.find(tid);
    }

    //删除指定id任务
    public void deleteTask(int id){
        taskRepository.deleteById(id);
    }

    //添加任务信息
    public TaskMessage adddTaskMessage(TaskMessage t){
        return taskMessageRepository.save(t);
    }

    //查找所有任务信息
    public List<TaskMessage> findAllTaskMesage(){
        return taskMessageRepository.findAll();
    }

    //查找指定id任务信息
    public TaskMessage findTaskMessageById(int id){
        return taskMessageRepository.find(id);
    }

    //修改指定id任务信息
    public TaskMessage updateTaskMessageById(TaskMessage task, int id){
        return taskMessageRepository.update(task, id);
    }

    //回复任务消息
    public TaskMessage respondTaskMessage(int id, String response){
        return taskMessageRepository.respond(response, id);
    }
}
