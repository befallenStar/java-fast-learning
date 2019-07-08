package cn.edu.njnu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import cn.edu.njnu.bean.Category;
import cn.edu.njnu.bean.Course;
import cn.edu.njnu.service.CategoryService;
import cn.edu.njnu.service.CourseService;
import cn.edu.njnu.util.ResultBean;
import cn.edu.njnu.util.TableData;

import static cn.edu.njnu.controller.BaseController.getObject;

@Controller
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("{page}")
    public String showPage(@PathVariable String page) {
        return "course/" + page;
    }

    @RequestMapping("query_all")
    @ResponseBody
    public Object queryAllNoLimit() {
        return courseService.queryAll();
    }

    @RequestMapping("all")
    @ResponseBody
    public Object queryAll(Integer page, Integer limit) {
        page = page == null ? 1 : page;
        limit = limit == null ? 3 : limit;
        PageHelper.startPage(page, limit);
        List<Course> list = courseService.queryAll();
        PageInfo<Course> info = new PageInfo<>(list);
        return new TableData<>(info.getList(), (int) info.getTotal());
    }

    @RequestMapping("query")
    public String queryById(Integer id, Model model) {
        Course course = courseService.queryById(id);
        List<Category> categories = categoryService.queryAll();
        model.addAttribute("course", course);
        model.addAttribute("categories", categories);
        return "/course/update";
    }

    @RequestMapping("insertquery")
    public String queryById(Model model) {
        List<Category> categories = categoryService.queryAll();
        model.addAttribute("categories", categories);
        return "course/insert";
    }


    @RequestMapping("update_course")
    @ResponseBody
    public Object update(Integer courseId, String courseName, String introduction, String note, Integer categoryId, Integer state) {
        Course course = new Course(courseId, courseName, new Category(categoryId, null), introduction, note, null, state);
        return getObject(courseService.updateSelective(course));
    }

    @RequestMapping("delete")
    @ResponseBody
    public Object deleteById(Integer id) {
        return getObject(courseService.deleteById(id));
    }

    @RequestMapping("insert_course")
    @ResponseBody
    public Object add(Integer courseId, String courseName, String introduction, String note, Integer categoryId, Integer state) {
        ResultBean bean;
        Course course = new Course(courseId, courseName, new Category(categoryId, null), introduction, note, 0, state);
        try {
            int row = courseService.insertCourse(course);
            if (row > 0) {
                bean = new ResultBean(ResultBean.CODE.SUCCESS);
            } else {
                bean = new ResultBean(ResultBean.CODE.FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            bean = new ResultBean(ResultBean.CODE.EXCEPTION);
        }
        return bean;
    }

}
