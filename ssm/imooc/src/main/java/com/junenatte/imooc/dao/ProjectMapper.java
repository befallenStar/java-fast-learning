package com.junenatte.imooc.dao;

import com.junenatte.imooc.bean.Project;

import java.util.List;
import java.util.Map;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    /**
     * 根据条件查询
     * @param map "keyword" : 关键字模糊查询
     *            "param" : 查询参数
     *            "ordercol" : 排序列名
     *            "orderdesc" : 排序顺序
     * @return 返回查询结果
     */
    List<Project> selectByParam(Map<String,String> map);
}