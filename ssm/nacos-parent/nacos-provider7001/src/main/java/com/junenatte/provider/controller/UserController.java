package com.junenatte.provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private static final Logger logger=LoggerFactory.getLogger(UserController.class);

    @GetMapping("user/test")
    public String userTest(){
        System.out.println("this is provider");
        logger.info("SERVICE","this is a provider");
        return "provider";
    }
}
