package com.junenatte.imooc.bean;

import java.io.Serializable;

public class ProjectImgs implements Serializable {
    private Integer id;

    private String imgUrl;

    private String imgText;

    private Integer imgOrder;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getImgText() {
        return imgText;
    }

    public void setImgText(String imgText) {
        this.imgText = imgText == null ? null : imgText.trim();
    }

    public Integer getImgOrder() {
        return imgOrder;
    }

    public void setImgOrder(Integer imgOrder) {
        this.imgOrder = imgOrder;
    }
}