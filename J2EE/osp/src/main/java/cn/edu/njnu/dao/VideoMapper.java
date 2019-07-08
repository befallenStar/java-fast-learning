package cn.edu.njnu.dao;

import java.util.List;

import cn.edu.njnu.bean.Video;

public interface VideoMapper {
    int deleteByPrimaryKey(Integer videoId);

    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(Integer videoId);

    //    int updateByPrimaryKeySelective(Video record);
    //    int updateByPrimaryKey(Video record);

    List<Video> selectByCourseId(Integer courseId);
}