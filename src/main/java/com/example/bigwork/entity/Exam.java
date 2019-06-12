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
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String examPlace;
    private String examName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date examStart;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date examEnd;

}
