package com.junenatte.imooc.controller;

import com.junenatte.imooc.bean.TagsPage;
import com.junenatte.imooc.dao.TagsPageMapper;
import com.junenatte.imooc.util.ResultBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "标签导航", tags = "标签导航")
@RestController
@RequestMapping("tags_page")
public class TagsPageController extends BaseController {
    @Autowired
    private TagsPageMapper mapper;

    @ApiOperation(value = "标签查询")
    @GetMapping("findall")
    public ResultBean<List<TagsPage>> findAll() {
        ResultBean<List<TagsPage>> resultBean;
        try {
            List<TagsPage> tagsPages = mapper.selectAll();
            resultBean = new ResultBean<>(ResultBean.Code.success, "查询成功", tagsPages);
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean<>(ResultBean.Code.exception, "查询异常");
        }
        return resultBean;
    }
}
