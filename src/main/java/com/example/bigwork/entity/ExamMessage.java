package com.example.bigwork.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ExamMessage {
    private static final int STATE_UNAPPOINTED = 0;
    private static final int STATE_APPOINTED = 1;
    private static final int STATE_ACCOMPLISHED = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int examNumber;
    private int examState = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    private Exam exam;
    @ManyToOne(fetch = FetchType.LAZY)
    private List<User> users;

}
