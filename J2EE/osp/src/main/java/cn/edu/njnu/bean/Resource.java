package cn.edu.njnu.bean;

import java.io.Serializable;

public class Resource implements Serializable {
    private Integer resourceId;

    private Course course;

    private String fileName;

    private String realName;

    private String path;

    private Integer state;

    private static final long serialVersionUID = 1L;

    public Resource(Integer resourceId, Course course, String fileName, String realName, String path, Integer state) {
        this.resourceId = resourceId;
        this.course = course;
        this.fileName = fileName;
        this.realName = realName;
        this.path = path;
        this.state = state;
    }

    public Resource() {
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}