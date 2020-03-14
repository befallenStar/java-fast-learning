package com.junenatte.nacos.config.center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValueController {
    @Value("${server.url}")
    private String serverUrl;
    @Autowired
    private ConfigurableApplicationContext configurableApplicationContext;

    @GetMapping("test")
    public String test() {
        return "configurableApplicationContext get: " + configurableApplicationContext.getEnvironment().getProperty("server.url");
//        return "server-url: "+serverUrl;
    }
}
