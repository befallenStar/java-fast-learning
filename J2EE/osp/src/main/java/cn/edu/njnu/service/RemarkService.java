package cn.edu.njnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import cn.edu.njnu.bean.Course;
import cn.edu.njnu.bean.Remark;
import cn.edu.njnu.bean.User;
import cn.edu.njnu.dao.CourseMapper;
import cn.edu.njnu.dao.RemarkMapper;
import cn.edu.njnu.dao.UserMapper;

@Service
public class RemarkService {
    @Autowired
    RemarkMapper remarkMapper;

    @Autowired
    UserMapper userMapper;
    @Autowired
    CourseMapper courseMapper;

    public List<Remark> queryAll() {
        List<Remark> remarks = remarkMapper.query();
        for (Remark r : remarks) {
            r.setUser(userMapper.selectByPrimaryKey(r.getUser().getUserId()));
            r.setCourse(courseMapper.selectByPrimaryKey(r.getCourse().getCourseId()));
        }
        return remarks;
    }

    public void insert(User user, Course course, String content) {
        Remark remark = new Remark(user, course, content, new Date());
        remarkMapper.insertSelective(remark);
    }
}
