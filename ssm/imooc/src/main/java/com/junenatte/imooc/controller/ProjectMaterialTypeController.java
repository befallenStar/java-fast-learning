package com.junenatte.imooc.controller;

import com.junenatte.imooc.bean.ProjectMaterialType;
import com.junenatte.imooc.dao.ProjectMaterialTypeMapper;
import com.junenatte.imooc.util.ResultBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author 沈嘉豪
 */
@Api(value = "项目材料类型管理", tags = "项目材料类型管理")
@RestController
@RequestMapping("project_material_type")
public class ProjectMaterialTypeController extends BaseController {
    @Autowired
    private ProjectMaterialTypeMapper mapper;

    @ApiOperation(value = "项目材料类型查询")
    @GetMapping("findall")
    public ResultBean<List<ProjectMaterialType>> findAll() {
        ResultBean<List<ProjectMaterialType>> resultBean;
        try {
            List<ProjectMaterialType> projectMaterialTypeList = mapper.selectAll();
            if (null != projectMaterialTypeList && projectMaterialTypeList.size() > 0) {
                resultBean = new ResultBean<>(ResultBean.Code.success, "查询成功", projectMaterialTypeList);
            } else {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean<>(ResultBean.Code.exception, "查询异常" + e.getMessage());
        }
        return resultBean;
    }
}
