package cn.edu.njnu.dao;

import java.util.List;

import cn.edu.njnu.bean.Course;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer courseId);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer courseId);

    int updateSelective(Course record);

    List<Course> queryAll();
}