package com.junenatte.bootdemo20200227.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.junenatte.bootdemo20200227.bean.UserTable;
import com.junenatte.bootdemo20200227.dao.UserTableMapper;
import com.junenatte.bootdemo20200227.util.ResultBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "用户管理", tags = "用户展示")
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserTableMapper mapper;

    @ApiOperation(value = "查询用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "index", value = "页数", defaultValue = "1", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示数量", defaultValue = "10", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "param", value = "姓名手机号模糊查询", dataType = "String", paramType = "query"),

    })
    @GetMapping("findall")
    public Object findAll(Integer index, Integer size, String param) {
        index = null == index ? 1 : index;
        size = null == size ? 10 : size;
        Map map = new HashMap();
        if (param != null && param.length() > 0) {
            map.put("param", "%" + param + "%");
        }
        PageHelper.startPage(index, size);
        List<UserTable> userTables = mapper.selectAll(map);
        PageInfo<UserTable> pageInfo = new PageInfo<>(userTables);
        return pageInfo;
    }

    @ApiOperation(value = "查询某一用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户编号", dataType = "Integer", paramType = "path")
    })
    @GetMapping("findone/{id}")
    public ResultBean<UserTable> findOne(@PathVariable("id") Integer id) {
        ResultBean<UserTable> resultBean;
        UserTable userTable = mapper.selectByPrimaryKey(id);
        try {
            if (null != userTable) {
                resultBean = new ResultBean<>(ResultBean.Code.success, "查询成功", userTable);
            } else {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "查询失败");
            }
        } catch (Exception e) {
            resultBean = new ResultBean<>(ResultBean.Code.exception, "查询异常" + e.getMessage());
        }
        return resultBean;
    }

    @ApiOperation(value = "添加新用户")
    @PostMapping("insert")
    public Object insert(UserTable userTable) {
        ResultBean<UserTable> resultBean;
        int rows = mapper.insertSelective(userTable);
        try {
            if (rows > 0) {
                resultBean = new ResultBean<>(ResultBean.Code.success, "添加成功", userTable);
            } else {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "添加失败", userTable);
            }
        } catch (Exception e) {
            resultBean = new ResultBean<>(ResultBean.Code.exception, "添加异常" + e.toString(), userTable);
        }
        return resultBean;
    }

    @ApiOperation(value = "更新用户")
    @PostMapping("update")
    public Object update(UserTable userTable) {
        ResultBean<UserTable> resultBean;
        int rows = mapper.updateByPrimaryKeySelective(userTable);
        try {
            if (rows > 0) {
                resultBean = new ResultBean<>(ResultBean.Code.success, "更新成功", userTable);
            } else {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "更新失败", userTable);
            }
        } catch (Exception e) {
            resultBean = new ResultBean<>(ResultBean.Code.exception, "更新异常" + e.toString(), userTable);
        }
        return resultBean;
    }

    @ApiOperation(value = "删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户编号", dataType = "Integer", paramType = "path"),
    })
    @GetMapping("delete/{id}")
    public Object delete(@PathVariable("id") Integer id) {
        ResultBean<UserTable> resultBean;
        int rows = mapper.deleteByPrimaryKey(id);
        try {
            if (rows > 0) {
                resultBean = new ResultBean<>(ResultBean.Code.success, "删除成功");
            } else {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "删除失败");
            }
        } catch (Exception e) {
            resultBean = new ResultBean<>(ResultBean.Code.exception, "删除异常" + e.toString());
        }
        return resultBean;
    }
}
