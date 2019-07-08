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
import cn.edu.njnu.service.CategoryService;
import cn.edu.njnu.util.ResultBean;
import cn.edu.njnu.util.TableData;

import static cn.edu.njnu.controller.BaseController.getObject;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("{page}")
    public String showPage(@PathVariable String page) {
        return "category/" + page;
    }

    @RequestMapping("all")
    @ResponseBody
    public Object queryAll(Integer page, Integer limit) {
        page = page == null ? 1 : page;
        limit = limit == null ? 10 : limit;
        PageHelper.startPage(page, limit);
        List<Category> list = categoryService.queryAll();
        PageInfo<Category> info = new PageInfo<>(list);
        return new TableData<>(info.getList(), (int) info.getTotal());
    }

    @RequestMapping("update_category")
    @ResponseBody
    public Object update(Integer categoryId, String category) {
        Category record = new Category(categoryId, category);
        return getObject(categoryService.updateSelective(record));
    }

    @RequestMapping("query")
    public String queryById(Integer id, Model model) {
        Category category = categoryService.queryById(id);
        model.addAttribute("category", category);
        return "category/update";
    }

    @RequestMapping("delete")
    @ResponseBody
    public Object deleteById(Integer id) {
        return getObject(categoryService.deleteById(id));
    }

    @RequestMapping("insert_category")
    @ResponseBody
    public Object add(Integer categoryId, String category) {
        ResultBean bean;
        Category category1 = new Category(categoryId, category);
        try {
            int row = categoryService.insertCategory(category1);
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
