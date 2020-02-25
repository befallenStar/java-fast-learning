package com.junenatte.bean;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;



public class User implements Serializable {
    private Integer id;
    @NotBlank(message="请输入用户名")
    private String userName;
    private String phone;
    private Date birthday;
    private String img;
    private String description;
    private Point point;

    @Override
    public String toString() {
        return "姓名：" + userName + "，电话：" + phone + "，生日：" + birthday + "，坐标：" + point.toString() + "，简介" + description;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
