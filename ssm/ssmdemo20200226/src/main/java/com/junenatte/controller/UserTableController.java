package com.junenatte.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
import com.junenatte.bean.UserTable;
import com.junenatte.dao.UserTableMapper;
import com.junenatte.util.ResultBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
        if (param != null && param.length() > 0) {
            map.put("param", "%" + param + "%");
        }
        map.put("id", id);
        List<UserTable> userTableList = mapper.selectAll(map);
        request.setAttribute("list", userTableList);
        return "user_list";
    }

    @GetMapping("json")
    @ResponseBody
    public Object listJson(Integer index, Integer size,
                           String param, Integer id) {
        index = null == index ? 1 : index;
        size = null == size ? 10 : size;
        Map map = new HashMap();
        if (param != null && param.length() > 0) {
            map.put("param", "%" + param + "%");
        }
        map.put("id", id);
        PageHelper.startPage(index, size);
        List<UserTable> userTableList = mapper.selectAll(map);
        PageInfo<UserTable> pageInfo = new PageInfo<>(userTableList);
        return pageInfo;
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

    @GetMapping("delete/json")
    @ResponseBody
    public Object delete(Integer id) {
        ResultBean result;
        try {
            int rows = mapper.deleteByPrimaryKey(id);
            if (rows > 0) {
                result = new ResultBean();
            } else {
                result = new ResultBean("10086", "删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultBean("10001", "删除异常");
        }
        return result;
    }

    @GetMapping("get/json")
    @ResponseBody
    public Object getOne(Integer id) {
        UserTable userTable = mapper.selectByPrimaryKey(id);
        return userTable;
    }

    @GetMapping("edit/{id}")
    public String getToEdit(@PathVariable("id") Integer id) {
        request.setAttribute("id", id);
        return "edit";
    }

    @PostMapping("update/json")
    @ResponseBody
    public Object update(UserTable userTable) {
        ResultBean result;
        int rows = mapper.updateByPrimaryKeySelective(userTable);
        try {
            if (rows > 0) {
                result = new ResultBean();
            } else {
                result = new ResultBean("10086", "更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultBean("10001", "更新异常");
        }
        return result;
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
