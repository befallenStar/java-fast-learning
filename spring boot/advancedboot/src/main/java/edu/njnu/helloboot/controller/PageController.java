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
        User user=new User();
    }
}
