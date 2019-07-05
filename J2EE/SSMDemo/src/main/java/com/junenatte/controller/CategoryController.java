package com.junenatte.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.junenatte.dao.Category;
import com.junenatte.mapper.CategoryMapper;
import com.junenatte.util.ResultBean;
import com.junenatte.util.TableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryMapper mapper;

    @RequestMapping("{page}")
    public String page(@PathVariable("page") String page) {
        return "cate/" + page;
    }

    /**
     * AJAX
     */
    @RequestMapping("list")
    @ResponseBody
    public Object findall(
            Integer page,
            Integer limit,
            HttpServletRequest request) {
        //
        page = page == null ? 1 : page;
        limit = limit == null ? 2 : limit;

        PageHelper.startPage(page, limit);
        List<Category> list = mapper.selectAll();
        PageInfo<Category> info = new PageInfo<Category>(list);


        return new TableModel<Category>(info.getList(), (int) info.getTotal());
    }

    /**
     * 返回码
     */
    @RequestMapping("delete")
    @ResponseBody
    public Object delete(Integer id) {
        ResultBean bean = null;
        try {
            int rows = mapper.deleteByPrimaryKey(id);
            if (rows > 0) {
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
