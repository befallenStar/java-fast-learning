package cn.edu.njnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.edu.njnu.bean.User;
import cn.edu.njnu.service.LoginService;
import cn.edu.njnu.util.LoginResult;
import cn.edu.njnu.util.SignUpResult;

@Controller
public class LoginController {

    @Autowired
    private LoginService service;

    @RequestMapping("login")
    public String signIn(User user, HttpSession session, Model model) {
        LoginResult result = service.signIn(user);
        if (result.getType().equals("success")) {
            result.setUsername(user.getUsername());
            session.setAttribute("loginResult", result);
            if (result.getPower() == 0)
                return "main/teacher";
            else
                return "main/student";
        }
        model.addAttribute("msg", result.getMsg());
        return "signIn";
    }

    @RequestMapping("signUp")
    public String signUp(HttpServletRequest request, HttpSession session, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String reInputPwd = request.getParameter("reInputPwd");
        if(username==null&&password==null&&reInputPwd==null)
            return "signUp";
        SignUpResult result = service.signUp(username, password, reInputPwd);
        session.setAttribute("signUpResult", result);
        model.addAttribute("msg", result.getMsg());
        if (result.getType().equals("fail"))
            return "signUp";
        return "signIn";
    }
}