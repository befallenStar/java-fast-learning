package cn.edu.njnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.edu.njnu.bean.CourseRecord;
import cn.edu.njnu.bean.User;
import cn.edu.njnu.dao.CourseRecordMapper;
import cn.edu.njnu.dao.UserMapper;
import cn.edu.njnu.util.LoginResult;
import cn.edu.njnu.util.SignUpResult;

@Service
public class LoginService {

    @Autowired
    private UserMapper userDao;

    @Autowired
    private CourseRecordMapper courseRecordDao;

    public LoginResult signIn(User user) {
        User tmp = userDao.queryUserByUsername(user.getUsername());
        LoginResult result = new LoginResult();
        if (user.getUsername() == null && user.getPassword() == null) {
            result.setType("");
            result.setMsg("");
        } else if (tmp == null) {
            result.setType("fail");
            result.setMsg("用户名密码不正确");
        } else {
            result.setUserId(tmp.getUserId());
            result.setUsername(user.getUsername());
            result.setType("success");
            if (tmp.getRole() == 0)
                result.setPower(0);
            else {
                result.setPower(1);
                List<CourseRecord> courseRecord = courseRecordDao.queryByUserId(tmp.getUserId());
                if (courseRecord != null)
                    result.setCourses(courseRecord);
            }
        }
        return result;
    }

    public SignUpResult signUp(String username, String password, String reInputPwd) {
        SignUpResult result;
        if (username == null || password == null || reInputPwd == null||"".equals(username)||"".equals(password)||"".equals(reInputPwd))
            result = new SignUpResult("fail", "请完成表单");
        else if (!password.equals(reInputPwd))
            result = new SignUpResult("fail", "两次密码输入不一致,注册失败");
        else {
            if (userDao.queryUserByUsername(username) != null)
                result = new SignUpResult("fail", "用户名已存在,注册失败");
            else {
                User user = new User(null, username, password, 1, 1);
                userDao.insertSelective(user);
                result = new SignUpResult("success", "注册成功,请登录!");
            }
        }
        return result;
    }
}
