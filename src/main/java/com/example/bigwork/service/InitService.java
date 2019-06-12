package com.example.bigwork.service;

import com.example.bigwork.entity.User;
import com.example.bigwork.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Slf4j
@Component
@Transactional
public class InitService implements InitializingBean {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (userRepository.count() == 0) {
            User user = new User();
            user.setAuthority(User.ADMIN_AUTHORITY);
            user.setNumber("1001");
            user.setPassword(passwordEncoder.encode(user.getNumber()));
            user.setUserName("BO");
            userRepository.save(user);
        }
    }
}
