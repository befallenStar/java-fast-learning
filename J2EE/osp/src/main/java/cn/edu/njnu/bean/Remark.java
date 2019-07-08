package cn.edu.njnu.bean;

import java.io.Serializable;
import java.util.Date;

public class Remark implements Serializable {
    private User user;

    private Course course;

    private String content;

    private Date time;

    private static final long serialVersionUID = 1L;

    public Remark() {
    }

    public Remark(User user, Course course, String content, Date time) {
        this.user = user;
        this.course = course;
        this.content = content;
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}