package cn.edu.njnu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.njnu.bean.Course;
import cn.edu.njnu.bean.Remark;
import cn.edu.njnu.bean.User;
import cn.edu.njnu.dao.CourseMapper;
import cn.edu.njnu.dao.UserMapper;
import cn.edu.njnu.service.RemarkService;
import cn.edu.njnu.util.TableData;

@Controller
@RequestMapping("remark")
public class RemarkController {

    @Autowired
    RemarkService service;
    @Autowired
    UserMapper userMapper;
    @Autowired
    CourseMapper courseMapper;

    @RequestMapping("query_all")
    @ResponseBody
    public Object list(Integer page, Integer limit) {
        page = page == null ? 1 : page;
        limit = limit == null ? 2 : limit;
        PageHelper.startPage(page, limit);
        List<Remark> categories = service.queryAll();
        PageInfo<Remark> info = new PageInfo<>(categories);
        return new TableData<>(info.getList(), (int) info.getTotal());
    }

    @RequestMapping("insert")
    public String insert(String userId, String courseId, String content, HttpSession session) {
        if (courseId == null || courseId.equals("") || content == null || content.equals("")) {
            session.setAttribute("msg", "信息错误！");
            return "remark/update";
        }
        User user = userMapper.selectByPrimaryKey(Integer.parseInt(userId));
        Course course = courseMapper.selectByPrimaryKey(Integer.parseInt(courseId));
        service.insert(user, course, content);
        return "remark/list";
    }
}
