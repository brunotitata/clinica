package com.eureka.zuul.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.zuul.model.User;
import com.eureka.zuul.request.LoginData;
import com.eureka.zuul.request.RegisterData;
import com.eureka.zuul.response.JwtResponse;
import com.eureka.zuul.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthRestApi {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> authenticateUser(
            @RequestBody LoginData loginData) {

        return ResponseEntity
                .ok(new JwtResponse(userService.authenticateUser(loginData)));
    }

    @PostMapping("/register")
    @CrossOrigin(origins = "*")
    public ResponseEntity<User> registerUser(
            @Valid @RequestBody RegisterData registerData) throws Exception {

        userService.registerUser(registerData);

        return ResponseEntity.ok().build();

    }

}
