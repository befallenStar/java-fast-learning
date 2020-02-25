package com.junenatte.bean;

import java.io.Serializable;

public class Point implements Serializable {
    private String pointx;
    private String pointy;

    @Override
    public String toString() {
        return "pointx='" + pointx + ", pointy='" + pointy;
    }

    public String getPointx() {
        return pointx;
    }

    public void setPointx(String pointx) {
        this.pointx = pointx;
    }

    public String getPointy() {
        return pointy;
    }

    public void setPointy(String pointy) {
        this.pointy = pointy;
    }
}
