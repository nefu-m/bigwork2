package com.example.bigwork.service;


import com.example.bigwork.entity.ExamMessage;
import com.example.bigwork.entity.User;
import com.example.bigwork.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
@Transactional
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    //添加用户信息
    public User addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    //显示所有用户信息
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
    //按id查找用户信息
    public User findUser(int uid){
        return userRepository.findId(uid);
    }

    //按姓名查找用户信息
    public User findUser(String name){
        return userRepository.findName(name);
    }

    //修改用户信息
    public User updateUser(User user,int uid){
        user.setId(uid);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.update(user, uid);
    }

    //删除用户信息
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }


}
