package com.example.restapitest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/home/index")
    public String main(){
        log.info("move to index page");
        return "/home/index";
    }

    @GetMapping("/home/login")
    public String login() {
        log.info("move to login page");
        return "/user/login";
    }
    @GetMapping("/home/join")
    public String join() {
        log.info("move to join page");
        return "/user/join";
    }

}
