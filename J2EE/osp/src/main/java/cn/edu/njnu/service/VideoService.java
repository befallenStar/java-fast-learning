package cn.edu.njnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.edu.njnu.bean.Video;
import cn.edu.njnu.dao.VideoMapper;

@Service
public class VideoService {
    @Autowired
    private VideoMapper videoMapper;

    public void uploadFile(Video video) {
        videoMapper.insertSelective(video);
    }

    public List<Video> queryVideoByCourseId(Integer courseId) {
        return videoMapper.selectByCourseId(courseId);
    }
}
