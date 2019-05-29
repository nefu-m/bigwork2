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
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String taskType;
    private String taskName;
    private String taskInfo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date taskEnd;

}
