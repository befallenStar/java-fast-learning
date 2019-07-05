package com.junenatte.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("controller")
public class TestController {
    @RequestMapping("test")
    public String test(Integer id, String name, String message, HttpServletRequest req) {
        req.setAttribute("id",id);
        req.setAttribute("name",name);
        req.setAttribute("message",message);
        return "test";
    }
}