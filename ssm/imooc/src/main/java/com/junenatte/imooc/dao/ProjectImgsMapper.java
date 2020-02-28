package com.junenatte.imooc.dao;

import com.junenatte.imooc.bean.ProjectImgs;

public interface ProjectImgsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectImgs record);

    int insertSelective(ProjectImgs record);

    ProjectImgs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectImgs record);

    int updateByPrimaryKey(ProjectImgs record);
}