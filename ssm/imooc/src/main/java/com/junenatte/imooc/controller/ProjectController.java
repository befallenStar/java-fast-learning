package com.junenatte.imooc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.junenatte.imooc.bean.Project;
import com.junenatte.imooc.dao.ProjectMapper;
import com.junenatte.imooc.util.ResultBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "项目管理", tags = "项目管理")
@RestController
@RequestMapping("project")
public class ProjectController {
    @Autowired
    private ProjectMapper mapper;

    @ApiOperation(value="项目查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name="keyword",value="关键字",dataType = "String",paramType = "path"),
            @ApiImplicitParam(name="param",value="模糊查询",dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name="ordercol",value="排序列名",dataType = "Intger",paramType = "path"),
            @ApiImplicitParam(name="orderdesc",value="排序顺序",dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name="index",value="分页开始页面",dataType = "Integer",paramType = "path"),
            @ApiImplicitParam(name="size",value="分页大小",dataType = "Integer",paramType = "path"),
    })
    @GetMapping("find")
    public ResultBean<PageInfo<Project>> find(String keyword, String param, String ordercol, String orderdesc, Integer index, Integer size) {
        ResultBean<PageInfo<Project>> resultBean;
        try {
            Map<String, String> map = new HashMap<>();
            if (null != keyword) {
                map.put("keyword", "%" + keyword + "%");
            }
            if (null != param) {
                map.put("param", "%" + param + "%");
            }
            map.put("ordercol", ordercol);
            map.put("orderdesc", orderdesc);
            index = null == index ? 1 : index;
            size = null == size ? 10 : size;
            PageHelper.startPage(index,size);
            List<Project> projects = mapper.selectByParam(map);
            PageInfo<Project> projectPageInfo=new PageInfo<>(projects);
            resultBean=new ResultBean<>(ResultBean.Code.success,"查询成功",projectPageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean<>(ResultBean.Code.exception, "查询异常");
        }
        return resultBean;
    }
}
