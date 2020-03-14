package com.junenatte.model.bean;

public class User {
    private Integer id;
    private String name;
    private String sex;

    public User(Integer id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public User() {
    }

    public User(String name) {
        this.id=1;
        this.name=name;
        this.sex="男";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
