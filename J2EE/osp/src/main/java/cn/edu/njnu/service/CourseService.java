package cn.edu.njnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.edu.njnu.bean.Course;
import cn.edu.njnu.dao.CourseMapper;

@Service
public class CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public Course queryById(Integer courseId) {
        return courseMapper.selectByPrimaryKey(courseId);
    }

    public List<Course> queryAll() {
        return courseMapper.queryAll();
    }

    public int deleteById(Integer id) {
        return courseMapper.updateSelective(
                new Course(id, null, null, null, null, null, 0));
    }

    public int updateSelective(Course course) {
        return courseMapper.updateSelective(course);
    }

    public int insertCourse(Course course) {
        return courseMapper.insertSelective(course);
    }
}
