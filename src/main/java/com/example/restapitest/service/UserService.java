package com.example.restapitest.service;

import com.example.restapitest.domain.Users;
import com.example.restapitest.dto.UserJoinRequest;
import com.example.restapitest.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long saveUser(UserJoinRequest dto) {
        return userRepository.save(Users.builder()
                        .name(dto.getName())
                        .email(dto.getEmail())
                        .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getId();
    }


}
