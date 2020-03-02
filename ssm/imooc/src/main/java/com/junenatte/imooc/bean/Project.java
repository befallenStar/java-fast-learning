package com.junenatte.imooc.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 沈嘉豪
 */
@ApiModel(value = "项目")
public class Project implements Serializable {
    @ApiModelProperty(value="项目编号")
    private Integer id;

    @ApiModelProperty(value="项目标题")
    private String projectTitle;

    @ApiModelProperty(value="项目副标题")
    private String projectSubtitle;

    @ApiModelProperty(value="项目关键字")
    private String projectKeywords;

    @ApiModelProperty(value="项目简介")
    private String projectDesc;

    @ApiModelProperty(value="项目封面")
    private String projectCover;

    @ApiModelProperty(value="项目价格")
    private Float projectPrice;

    @ApiModelProperty(value="项目创建者id")
    private Integer createUser;

    @ApiModelProperty(value="项目创建时间")
    private Date createTime;

    @ApiModelProperty(value="项目最后更新时间")
    private Date lastUpdate;

    @ApiModelProperty(value="项目浏览次数")
    private Integer browseCount;

    @ApiModelProperty(value="项目下载次数")
    private Integer downloadCount;

    @ApiModelProperty(value="项目是否置顶")
    private Integer istop;

    public List<ProjectImgs> getProjectImgsList() {
        return projectImgsList;
    }

    public void setProjectImgsList(List<ProjectImgs> projectImgsList) {
        this.projectImgsList = projectImgsList;
    }

    public List<ProjectMaterial> getProjectMaterialList() {
        return projectMaterialList;
    }

    public void setProjectMaterialList(List<ProjectMaterial> projectMaterialList) {
        this.projectMaterialList = projectMaterialList;
    }

    private List<ProjectImgs> projectImgsList;
    private List<ProjectMaterial> projectMaterialList;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle == null ? null : projectTitle.trim();
    }

    public String getProjectSubtitle() {
        return projectSubtitle;
    }

    public void setProjectSubtitle(String projectSubtitle) {
        this.projectSubtitle = projectSubtitle == null ? null : projectSubtitle.trim();
    }

    public String getProjectKeywords() {
        return projectKeywords;
    }

    public void setProjectKeywords(String projectKeywords) {
        this.projectKeywords = projectKeywords == null ? null : projectKeywords.trim();
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc == null ? null : projectDesc.trim();
    }

    public String getProjectCover() {
        return projectCover;
    }

    public void setProjectCover(String projectCover) {
        this.projectCover = projectCover == null ? null : projectCover.trim();
    }

    public Float getProjectPrice() {
        return projectPrice;
    }

    public void setProjectPrice(Float projectPrice) {
        this.projectPrice = projectPrice;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getBrowseCount() {
        return browseCount;
    }

    public void setBrowseCount(Integer browseCount) {
        this.browseCount = browseCount;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Integer getIstop() {
        return istop;
    }

    public void setIstop(Integer istop) {
        this.istop = istop;
    }
}