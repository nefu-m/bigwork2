package com.example.bigwork.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class TaskMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String response;
    private int taskState = 0;//任务状态。1按时完成；0未按时完成；
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date taskFinish;

    @ManyToOne
    private User user;
    @ManyToOne
    private Task task;
}
