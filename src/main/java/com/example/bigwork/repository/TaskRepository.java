package com.example.bigwork.repository;

import com.example.bigwork.entity.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CustomizedRepository<Task,Integer>{
    @Query("SELECT t FROM Task")
    List<Task> findAllTask();

    @Query("SELECT t FROM Task WHERE t.id=:tid")
    Task find(@Param("tid") int tid);

    @Modifying
    @Query(value = "UPDATE Task t set t=:task WHERE t.id=:tid",nativeQuery = true)
    Task update(@Param("task") Task task, @Param("tid") int tid);

}
