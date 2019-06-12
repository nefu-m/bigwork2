package com.example.bigwork.repository;

import com.example.bigwork.entity.Exam;
import com.example.bigwork.entity.ExamMessage;
import com.example.bigwork.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamMessageRepository extends CustomizedRepository<ExamMessage, Integer>{
    @Query("SELECT e FROM ExamMEssage ")
    List<ExamMessage> findAllEM();

    @Query("SELECT e FROM ExamMessage WHERE e.id=:eid")
    ExamMessage findExamMessage(@Param("eid") int eid);

    @Modifying
    @Query(value = "UPDATE ExamMessage e set e.users=:users,e.examNumber=:number WHERE e.id=:eid",nativeQuery = true)
    ExamMessage updateTeacher(@Param("users") List<User> users, @Param("number") int number, @Param("eid") int eid);

    @Modifying
    @Query(value = "UPDATE ExmaMessage e set e.examState=:state WHERE e.id=:eid",nativeQuery = true)
    ExamMessage updateState(@Param("state") int state);

    @Query(value = "SELECT e FROM ExamMessage e WHERE e.users.id=:uid")
    List<ExamMessage> findTeacherExam(@Param("uid") int uid);
}
