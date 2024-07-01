package com.example.restapitest.controller;

import com.example.restapitest.domain.Users;
import com.example.restapitest.dto.UserJoinRequest;
import com.example.restapitest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/join")
    public String userJoin(UserJoinRequest request) {
        log.info("join user start");
        userService.saveUser(request);
        log.info("join user done");
        return "/home/index";
    }
//    public ResponseEntity<String> join(Users user) {
//        log.info("Join Start");
//        try {
//            userService.saveUser(user);
//            return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Failed to create user", HttpStatus.BAD_REQUEST);
//        }
//    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
