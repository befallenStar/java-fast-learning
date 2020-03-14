package com.junenatte.imooc.bean;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 沈嘉豪
 */
@ApiModel(value = "下载记录")
public class DownloadHistory implements Serializable {
    @ApiModelProperty(value = "下载记录编号")
    private Integer id;

    @ApiModelProperty(value = "下载记录用户编号")
    private Integer userId;

    @ApiModelProperty(value = "下载记录项目编号")
    private Integer projectId;

    private Integer materialId;

    @ApiModelProperty(value = "下载时间")
    private Date downloadTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Date getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(Date downloadTime) {
        this.downloadTime = downloadTime;
    }
}