package cn.edu.njnu.dao;

import java.util.List;

import cn.edu.njnu.bean.Resource;

public interface ResourceMapper {
    int deleteByPrimaryKey(Integer resourceId);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer resourceId);

    List<Resource> selectByCourseId(Integer courseId);
}