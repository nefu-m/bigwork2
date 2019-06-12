package com.example.bigwork.repository;

import com.example.bigwork.entity.Exam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends CustomizedRepository<Exam, Integer>{
    @Query("SELECT e FROM Exam e")
    List<Exam> findAllExam();

    @Query("SELECT e FROM Exam e WHERE e.user.id=uid")
    List<Exam> list(@Param("uid") int id);

    @Query("FROM Exam e WHERE e.id=:eid")
    Exam find(@Param("eid") int eid);

}
