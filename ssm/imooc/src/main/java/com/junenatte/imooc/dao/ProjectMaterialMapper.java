package com.junenatte.imooc.dao;

import com.junenatte.imooc.bean.ProjectMaterial;

public interface ProjectMaterialMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectMaterial record);

    int insertSelective(ProjectMaterial record);

    ProjectMaterial selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectMaterial record);

    int updateByPrimaryKey(ProjectMaterial record);
}