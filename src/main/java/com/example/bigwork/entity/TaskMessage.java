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
    private static final int INTIME = 1;
    private static final int OUTOFTIME  = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String response;
    private int taskState = 0;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date taskFinish;

    @ManyToOne
    private User user;
    @OneToOne
    private Task task;
}
