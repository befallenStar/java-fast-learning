package com.junenatte.bootdemo20200227;

import com.spring4all.swagger.EnableSwagger2Doc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwagger2Doc
@SpringBootApplication
@MapperScan(basePackages = "com.junenatte.bootdemo20200227.dao")
public class Bootdemo20200227Application {

    public static void main(String[] args) {
        SpringApplication.run(Bootdemo20200227Application.class, args);
    }

}
