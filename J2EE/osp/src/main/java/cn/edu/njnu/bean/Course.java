package cn.edu.njnu.bean;

import java.io.Serializable;

public class Course implements Serializable {
    private Integer courseId;

    private String courseName;

    private Category category;

    private String introduction;

    private String note;

    private Integer stuNum;

    private Integer state;

    private static final long serialVersionUID = 1L;

    public Course() {
    }

    public Course(Integer courseId, String courseName, Category category, String introduction, String note, Integer stuNum, Integer state) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.category = category;
        this.introduction = introduction;
        this.note = note;
        this.stuNum = stuNum;
        this.state = state;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStuNum() {
        return stuNum;
    }

    public void setStuNum(Integer stuNum) {
        this.stuNum = stuNum;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}