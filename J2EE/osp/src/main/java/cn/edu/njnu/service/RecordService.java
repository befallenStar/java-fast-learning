package cn.edu.njnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.edu.njnu.bean.Course;
import cn.edu.njnu.bean.CourseRecord;
import cn.edu.njnu.bean.User;
import cn.edu.njnu.dao.CourseMapper;
import cn.edu.njnu.dao.CourseRecordMapper;
import cn.edu.njnu.dao.UserMapper;

@Service
public class RecordService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CourseRecordMapper courseRecordMapper;

    @Autowired
    private CourseMapper courseMapper;

    public List<CourseRecord> querySelectedByUserId(Integer userId) {
        return courseRecordMapper.queryByUserId(userId);
    }

    public List<CourseRecord> queryUnSelectedByUserId(Integer userId) {
        return courseRecordMapper.queryUnselectedByUserId(userId);
    }

    public int selectCourse(Integer userId, Integer courseId) {
        User user = userMapper.selectByPrimaryKey(userId);
        Course course = courseMapper.selectByPrimaryKey(courseId);
        course.setStuNum(course.getStuNum() + 1);
        courseMapper.updateSelective(course);
        return courseRecordMapper.insertSelective(new CourseRecord(user, course));
    }

    public List<CourseRecord> queryAll() {
        return courseRecordMapper.queryAll();
    }

    public int unselectCourse(Integer userId, Integer courseId) {
        User user = new User();
        user.setUserId(userId);
        Course course = courseMapper.selectByPrimaryKey(courseId);
        course.setStuNum(course.getStuNum() - 1);
        courseMapper.updateSelective(course);
        return courseRecordMapper.delete(new CourseRecord(user, course));
    }
}
