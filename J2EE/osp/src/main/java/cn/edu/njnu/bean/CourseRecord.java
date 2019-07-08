package cn.edu.njnu.bean;

import java.io.Serializable;

public class CourseRecord implements Serializable {
    private User user;

    private Course course;

    private static final long serialVersionUID = 1L;

    public CourseRecord() {
    }

    public CourseRecord(User user, Course course) {
        this.user = user;
        this.course = course;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

}