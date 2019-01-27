package edu.njnu.helloboot.controller;

import edu.njnu.helloboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 能够进行服务端页面渲染的controller
 */
@Controller
public class PageController {
    @RequestMapping("/hello/{userId}")
    public ModelAndView hello(@PathVariable("userId") String userId){
        User user=new User(userId,"张三","1234","女",12);
        //创建modelandview对象
        ModelAndView modelAndView = new ModelAndView();
        //将user传入modelandview
        //request.setAttribute("user",user);
        modelAndView.addObject("user",user);
        //指定返回到哪个页面
        //springboot默认情况下帮你省略了后缀名.html以及前缀完整路径
        modelAndView.setViewName("Hello");
        return modelAndView;
    }
}
