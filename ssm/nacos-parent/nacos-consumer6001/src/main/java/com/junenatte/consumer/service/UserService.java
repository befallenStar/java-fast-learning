package com.junenatte.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value="nacos-provider7001")
public interface UserService {
    @GetMapping("user/test")
    public String userTest();
}
