package com.junenatte.imooc;

import com.spring4all.swagger.EnableSwagger2Doc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value="com.junenatte.imooc.dao")
@EnableSwagger2Doc
public class ImoocApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImoocApplication.class, args);
    }

}
