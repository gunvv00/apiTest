package com.example.restapitest.config;

import jakarta.servlet.DispatcherType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> request
                .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                .requestMatchers("/home/join").permitAll()
                .anyRequest().authenticated()
        )
        .formLogin(login -> login
                .loginPage("/home/login")
                .loginProcessingUrl("/user/login")
                .usernameParameter("loginId")
                .passwordParameter("passWord")
                .defaultSuccessUrl("/home/index")
                .permitAll()
        )
        .logout(Customizer.withDefaults());

        return http.build();
    }
}
