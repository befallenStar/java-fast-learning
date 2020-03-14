package com.junenatte.clientProvider.controller;

import com.junenatte.model.bean.User;
import com.junenatte.model.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserService {

    @Override
    @GetMapping("/user/{name}")
    public User getUser(@PathVariable("name") String name) {
        return new User(name);
    }
}
