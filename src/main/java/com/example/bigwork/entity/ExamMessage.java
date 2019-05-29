package com.example.bigwork.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ExamMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
