package com.example.bigwork.controller;

import com.example.bigwork.entity.User;
import com.example.bigwork.service.UserService;
import com.example.bigwork.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UpdateController {
    @Autowired
    private UserService userService;

    @PostMapping("/editpassword")
    public Map<String, String> editPassword(String password, HttpSession session){
        User user=(User) session.getAttribute("user");
        user.setPassword(MD5Utils.md5(password));
        Map<String, String> map=new HashMap<>();
        map.put("count", String.valueOf(userService.updateUser(user, user.getId())));
        return map;
    }

    @RequestMapping("/selectteachers")
    public List<User> selectteachers(){
        //	Map<String, Object> map=new HashMap<>();
        List<User> users=new ArrayList<>();
        users=	userService.findAllUsers();
        return users;
    }

    @RequestMapping("/selectonlyteachers")
    public List<User> selectonlyteachers(){
        //	Map<String, Object> map=new HashMap<>();
        List<User> users=new ArrayList<>();
        users=	userService.findAllTeachers();
        return users;
    }

    @RequestMapping("/selectmanagers")
    public List<User> selectmanagers(){
        //	Map<String, Object> map=new HashMap<>();
        List<User> users=new ArrayList<>();
        users=	userService.findAllManagers();
        return users;
    }

    @RequestMapping("/removeuser/{id}")
    public void removeuser(@PathVariable String id){
        String[] ids=id.split(",");
        for(int i=0;i<ids.length;i++){
            userService.deleteUser(Integer.parseInt(ids[i]));
        }

    }

    @RequestMapping("/removeadmin/{id}")
    public void removeadmin(@PathVariable String id){
        String[] ids=id.split(",");
        for(int i=0;i<ids.length;i++){
            userService.deleteUser(Integer.parseInt(ids[i]));
        }

    }


    @RequestMapping("/update")
    public void updateuser(User user){
        userService.updateUser(user,user.getId());
    }


    @RequestMapping("/setadmin/{id}")
    public void setadmin(@PathVariable String id){
        String[] ids=id.split(",");
        for(int i=0;i<ids.length;i++){
            userService.setAuthority(Integer.parseInt(ids[i]));
        }
    }
}
