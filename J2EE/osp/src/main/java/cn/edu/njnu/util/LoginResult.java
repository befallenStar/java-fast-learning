package cn.edu.njnu.util;


import java.util.List;

import cn.edu.njnu.bean.CourseRecord;

public class LoginResult {

    private Integer userId;
    private String username;
    private Integer power;
    private String type;
    private String msg;
    private String CourseState;
    private List<CourseRecord> courses;

    public List<CourseRecord> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseRecord> courses) {
        this.courses = courses;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCourseState() {
        return CourseState;
    }

    public void setCourseState(String courseState) {
        CourseState = courseState;
    }

    public LoginResult() { }
}
