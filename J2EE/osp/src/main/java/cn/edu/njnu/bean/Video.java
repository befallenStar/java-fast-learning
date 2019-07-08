package cn.edu.njnu.bean;

import java.io.Serializable;

public class Video implements Serializable {

    private Integer videoId;

    private Course course;

    private String chapter;

    private String videoName;

    private static final long serialVersionUID = 1L;

    public Video() {
    }

    public Video(Integer videoId, Course course, String chapter, String videoName) {
        this.videoId = videoId;
        this.course = course;
        this.chapter = chapter;
        this.videoName = videoName;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

}