package com.junenatte.imooc.bean;

import java.io.Serializable;

public class TagsPage implements Serializable {
    private Integer id;

    private String tagtext;

    private String tagurl;

    private Integer tagnum;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagtext() {
        return tagtext;
    }

    public void setTagtext(String tagtext) {
        this.tagtext = tagtext == null ? null : tagtext.trim();
    }

    public String getTagurl() {
        return tagurl;
    }

    public void setTagurl(String tagurl) {
        this.tagurl = tagurl == null ? null : tagurl.trim();
    }

    public Integer getTagnum() {
        return tagnum;
    }

    public void setTagnum(Integer tagnum) {
        this.tagnum = tagnum;
    }
}