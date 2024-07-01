package com.example.restapitest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserJoinRequest {

    private String email;
    private String password;
    private String name;

}
