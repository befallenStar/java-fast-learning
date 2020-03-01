package com.junenatte.imooc.bean;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 沈嘉豪
 */
@ApiModel(value = "轮播")
public class Banner implements Serializable {
    @ApiModelProperty(value = "轮播图片编号")
    private Integer id;

    @ApiModelProperty(value = "轮播图片路径")
    private String imgpath;

    @ApiModelProperty(value = "轮播图片文字信息")
    private String imgtext;

    @ApiModelProperty(value = "轮播图片顺序")
    private Integer orderNum;

    @ApiModelProperty(value = "轮播图片上传者")
    private String createUser;

    @ApiModelProperty(value = "轮播图片上传时间")
    private Date createTime;

    @ApiModelProperty(value = "轮播图片更新时间")
    private Date lastTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath == null ? null : imgpath.trim();
    }

    public String getImgtext() {
        return imgtext;
    }

    public void setImgtext(String imgtext) {
        this.imgtext = imgtext == null ? null : imgtext.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}