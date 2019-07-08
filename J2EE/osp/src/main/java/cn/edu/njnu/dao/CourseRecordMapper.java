package cn.edu.njnu.dao;

import cn.edu.njnu.bean.CourseRecord;

import java.util.List;

public interface CourseRecordMapper {
    int insert(CourseRecord record);

    int insertSelective(CourseRecord record);

    List<CourseRecord> queryAll();

    List<CourseRecord> queryByUserId(Integer userId);

    List<CourseRecord> queryUnselectedByUserId(Integer userId);

    int delete(CourseRecord record);
}