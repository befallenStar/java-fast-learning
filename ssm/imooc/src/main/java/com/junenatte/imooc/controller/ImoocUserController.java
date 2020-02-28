package com.junenatte.imooc.controller;

import com.junenatte.imooc.bean.ImoocUser;
import com.junenatte.imooc.dao.ImoocUserMapper;
import com.junenatte.imooc.util.ResultBean;
import com.junenatte.imooc.util.SessionKeyUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("imooc_user")
@Api(value = "用户管理", tags = "用户管理")
public class ImoocUserController {
    @Autowired
    private ImoocUserMapper mapper;

    @Autowired
    private HttpSession session;

    @ApiOperation(value = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "loginCode", value = "图形验证码", dataType = "String", paramType = "query"),
    })
    @PostMapping("login")
    public ResultBean<ImoocUser> login(String phone, String password, String loginCode) {
        ResultBean<ImoocUser> resultBean;
        try {
            String code = (String) session.getAttribute(SessionKeyUtil.CODE);
            if (null == code) {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "验证码已失效");
                return resultBean;
            }
            if (!loginCode.equalsIgnoreCase(code)) {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "验证码错误");
                return resultBean;
            }
            Map<String, String> map = new HashMap<>();
            map.put("phone", phone);
            map.put("password", password);
            ImoocUser imoocUser = mapper.selectByPhone(map);
            if (null != imoocUser) {
                imoocUser.setPassword("");
                resultBean = new ResultBean<>(ResultBean.Code.success, "登陆成功", imoocUser);
                session.setAttribute(SessionKeyUtil.USER, imoocUser);
            } else {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "登录失败");
            }
        } catch (Exception e) {
            resultBean = new ResultBean<>(ResultBean.Code.exception, "登录异常" + e.getMessage());
        }
        return resultBean;
    }

    @ApiOperation(value = "用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nickname", value = "昵称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "phone", value = "手机号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "loginCode", value = "短信验证码", dataType = "String", paramType = "query"),
    })
    @PostMapping("signup")
    public ResultBean<ImoocUser> signup(String nickname, String phone, String password, String loginCode) {
        ResultBean<ImoocUser> resultBean;
        try {
            String code = (String) session.getAttribute(SessionKeyUtil.MSGCODE);
            if (null == code) {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "验证码已失效");
                return resultBean;
            }
            if (!loginCode.equalsIgnoreCase(code)) {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "验证码错误");
                return resultBean;
            }
            Map<String, String> map = new HashMap<>();
            map.put("phone", phone);
            ImoocUser imoocUser = mapper.selectByPhone(map);
            if (null != imoocUser) {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "用户已存在，请直接登录！");
            } else {
                imoocUser = new ImoocUser();
                imoocUser.setRickname(nickname);
                imoocUser.setPhone(phone);
                imoocUser.setPassword(password);
                imoocUser.setCreateTime(new Date());
                imoocUser.setLastUpdate(new Date());
                int rows = mapper.insertSelective(imoocUser);
                if (rows > 0) {
                    resultBean = new ResultBean<>(ResultBean.Code.success, "注册成功", imoocUser);
                } else {
                    resultBean = new ResultBean<>(ResultBean.Code.failure, "注册失败，请重试！");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean<>(ResultBean.Code.exception, "注册异常！" + e.getMessage());
        }
        return resultBean;
    }


    @ApiOperation(value = "查询单一用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "Integer", paramType = "path")
    })
    @GetMapping("findById/{id}")
    public Object findById(@PathVariable("id") Integer id) {
        ResultBean<ImoocUser> resultBean;
        ImoocUser imoocUser = mapper.selectByPrimaryKey(id);
        try {
            if (null != imoocUser) {
                resultBean = new ResultBean<>(ResultBean.Code.success, "查询成功", imoocUser);
            } else {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "查询失败");
            }
        } catch (Exception e) {
            resultBean = new ResultBean<>(ResultBean.Code.exception, "查询异常" + e.getMessage());
        }
        return resultBean;
    }
}
