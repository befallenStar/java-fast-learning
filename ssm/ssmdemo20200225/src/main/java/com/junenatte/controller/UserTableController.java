package com.junenatte.controller;

import com.junenatte.bean.UserTable;
import com.junenatte.dao.UserTableMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserTableController {
    @Autowired
    private UserTableMapper mapper;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("reg")
    public String reg() {
        return "reg";
    }

    @GetMapping("list")
    public String list(String param, Integer id) {
        Map map = new HashMap();
        if (param != null && param.length() > 0)
            map.put("param", "%" + param + "%");
        map.put("id", id);
        List<UserTable> userTableList = mapper.selectAll(map);
        request.setAttribute("list", userTableList);
        return "user_list";
    }

    @PostMapping("regaction")
    public String regaction(UserTable userTable, @RequestParam("headimg") MultipartFile headimg) {
        saveFile(userTable, headimg);
        int rows = mapper.insertSelective(userTable);
        if (rows > 0) {
            return "redirect:/user/list";
        } else {
            return "reg";
        }
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        int rows = mapper.deleteByPrimaryKey(id);
        return "redirect:/user/list";
    }

    @GetMapping("get")
    public String getOne(Integer id) {
        UserTable userTable = mapper.selectByPrimaryKey(id);
        System.out.println(userTable.getUsername());
        request.setAttribute("user", userTable.getUsername());
        return "user_table";
    }

    @GetMapping("edit/{id}")
    public String getToEdit(@PathVariable("id") Integer id) {
        UserTable userTable = mapper.selectByPrimaryKey(id);
        request.setAttribute("user", userTable);
        return "edit";
    }

    @PostMapping("update")
    public String update(UserTable userTable, @RequestParam("headimg") MultipartFile headimg) {
        saveFile(userTable, headimg);
        int rows = mapper.updateByPrimaryKeySelective(userTable);
        if (rows > 0) {
            return "redirect:/user/list";
        } else {
            return "reg";
        }
    }

    private void saveFile(UserTable userTable, MultipartFile headimg) {
        if (null != headimg && 0 < headimg.getSize()) {
            String path = request.getServletContext().getRealPath("/static/imgs");
            String originName = headimg.getOriginalFilename();
            String newName = UUID.randomUUID().toString() + originName.substring(originName.lastIndexOf("."));
            File targetFile = new File(path, newName);
            try {
                headimg.transferTo(targetFile);
                userTable.setImg("/static/imgs/" + newName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
