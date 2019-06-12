package com.example.bigwork.repository;

import com.example.bigwork.entity.TaskMessage;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskMessageRepository extends CustomizedRepository<TaskMessage,Integer> {
    @Query("SELECT t FROM TaskMessage ")
    List<TaskMessage> findAll();

    @Query("SELECT t FROM TaskMessage WHERE t.id=:tid")
    TaskMessage find(@Param("tid") int tid);

    @Modifying
    @Query(value = "UPDATE TaskMessage t set t=:task WHERE t.id=tid")
    TaskMessage update(@Param("task") TaskMessage task, @Param("tid") int tid);

    @Modifying
    @Query(value = "UPDATE TaskMessage t set t.response=:r WHERE t.id=:tid")
    TaskMessage respond(@Param("r")  String response,@Param("tid") int id);
}
