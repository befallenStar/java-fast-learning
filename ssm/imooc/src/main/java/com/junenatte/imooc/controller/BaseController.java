package com.junenatte.imooc.controller;

import com.junenatte.imooc.bean.ImoocUser;
import com.junenatte.imooc.util.SessionKeyUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author 沈嘉豪
 */
@Api(value = "基类",tags = "基类")
@Controller
public class BaseController {
    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpSession session;

    @ApiOperation(value="获取当前用户")
    public ImoocUser getCurrentImoocUser() {
        return (ImoocUser) session.getAttribute(SessionKeyUtil.USER);
    }

    @ApiOperation(value = "注销当前用户")
    public void logout(){
        session.setAttribute(SessionKeyUtil.USER,"");
    }
}
