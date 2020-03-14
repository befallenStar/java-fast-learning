package com.junenatte.clientConsumer.service;

import com.junenatte.model.bean.User;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value="eureka-client-provider6001")
public interface IUserService {
    @GetMapping("/user/{name}")
public User getUser(@PathVariable("name") String name);
}
