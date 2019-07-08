package cn.edu.njnu.bean;

import java.io.Serializable;

public class User implements Serializable {
    private Integer userId;

    private String username;

    private String password;

    private Integer role;

    private Integer state;

    private static final long serialVersionUID = 1L;

    public User(Integer userId, String username, String password, Integer role, Integer state) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.state = state;
    }

    public User() {
        super();
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
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}