package com.junenatte.imooc.controller;

import com.junenatte.imooc.bean.ImoocUser;
import com.junenatte.imooc.util.SessionKeyUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BaseController {
    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpSession session;

    public ImoocUser getCurrentImoocUser() {
        return (ImoocUser) session.getAttribute(SessionKeyUtil.USER);
    }
}
