package com.junenatte.clientConsumer.controller;

import com.junenatte.clientConsumer.service.IUserService;
import com.junenatte.model.bean.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private IUserService service;

    @GetMapping("/user/{name}")
    public User getUser(@PathVariable("name") String name) {
        return service.getUser(name);
    }
}
