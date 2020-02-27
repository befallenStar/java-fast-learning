package com.junenatte.bootdemo20200227.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.junenatte.bootdemo20200227.bean.UserTable;
import com.junenatte.bootdemo20200227.dao.UserTableMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    private UserTableMapper mapper;

    @GetMapping("test")
    public String test() {
        return "spring boot";
    }

    @GetMapping("list")
    public Object list(String param, Integer id) {
        Map map = new HashMap();
        if (param != null && param.length() > 0) {
            map.put("param", "%" + param + "%");
        }
        map.put("id", id);
        PageHelper.startPage(1, 10);
        List<UserTable> userTables = mapper.selectAll(map);
        PageInfo<UserTable> pageInfo = new PageInfo<>(userTables);
        return pageInfo;
    }
}
