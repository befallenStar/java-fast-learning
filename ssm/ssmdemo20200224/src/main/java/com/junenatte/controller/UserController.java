package com.junenatte.controller;

import com.junenatte.bean.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @GetMapping("toreg")
    public String toreg(User user) {
        return "reg";
    }

    @Autowired
    HttpServletRequest request;

    @PostMapping("regaction")
    public String regaction(@Validated User user, BindingResult bindingResult, @RequestParam("headimg") MultipartFile headimg) {
        if (bindingResult.hasErrors())
            return "reg";

        if (null != headimg && 0 < headimg.getSize()) {
            String path = request.getServletContext().getRealPath("/static/imgs");
            String originName = headimg.getOriginalFilename();
            String newName = UUID.randomUUID().toString() + originName.substring(originName.lastIndexOf("."));
            File targetFile = new File(path, newName);
            try {
                headimg.transferTo(targetFile);
                user.setImg(newName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "hello";
    }
}
