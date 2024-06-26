package com.example.restapitest.service;

import com.example.restapitest.domain.User;
import com.example.restapitest.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;

//    @Autowired
//    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }

    public User saveUser(User user) {
//        user.setPassWord(passwordEncoder.encode(user.getPassWord()));
        return userRepository.save(user);
    }


}
