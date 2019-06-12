package com.example.bigwork.service;

import com.example.bigwork.entity.Exam;
import com.example.bigwork.entity.ExamMessage;
import com.example.bigwork.entity.User;
import com.example.bigwork.repository.ExamRepository;
import com.example.bigwork.repository.ExamMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ExamService {
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private ExamMessageRepository examMessageRepository;

    //添加考试信息
    public Exam addExam(Exam e){
        return examRepository.save(e);
    }

    //添加监考信息
    public ExamMessage addExamMessage(ExamMessage e){
        return examMessageRepository.save(e);
    }

    //查找所有考试信息
    public List<Exam> findAllExam(){
        return  examRepository.findAll();
    }

    //查找指定id考试信息
    public Exam findExam(int eid){
        return examRepository.find(eid);
    }

    //查找所有监考信息
    public List<ExamMessage> findAllExamMessage(){
        return examMessageRepository.findAllEM();
    }

    //查找指定id监考信息
    public ExamMessage findExamMessage(int eid){
        return examMessageRepository.findExamMessage(eid);
    }

    //以教师id查询教师所有监考信息
    public List<ExamMessage> findTeacherExamMessage(int uid){
        return examMessageRepository.findTeacherExam(uid);
    }

    //修改指定id考试人员分配
    public ExamMessage updateExamTeacher(int eid, int number, List<User> users){
        return examMessageRepository.updateTeacher(users, number, eid);
    }

    //修改指定id监考状态信息
    public void updateExamState(int state){
        examMessageRepository.updateState(state);
    }

}
