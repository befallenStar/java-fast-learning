package com.junenatte.imooc.dao;

import com.junenatte.imooc.bean.ProjectMaterialType;

public interface ProjectMaterialTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectMaterialType record);

    int insertSelective(ProjectMaterialType record);

    ProjectMaterialType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectMaterialType record);

    int updateByPrimaryKey(ProjectMaterialType record);
}