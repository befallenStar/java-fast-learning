package com.junenatte.imooc.bean;

import java.io.Serializable;
import java.util.Date;

public class ProjectMaterial implements Serializable {
    private Integer id;

    private String materialTitle;

    private String materialPath;

    private String materialSuffix;

    private String materialIcon;

    private Date createTime;

    private Integer projectId;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public ProjectMaterialType getProjectMaterialType() {
        return projectMaterialType;
    }

    public void setProjectMaterialType(ProjectMaterialType projectMaterialType) {
        this.projectMaterialType = projectMaterialType;
    }

    private Integer typeId;

    private ProjectMaterialType projectMaterialType;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaterialTitle() {
        return materialTitle;
    }

    public void setMaterialTitle(String materialTitle) {
        this.materialTitle = materialTitle == null ? null : materialTitle.trim();
    }

    public String getMaterialPath() {
        return materialPath;
    }

    public void setMaterialPath(String materialPath) {
        this.materialPath = materialPath == null ? null : materialPath.trim();
    }

    public String getMaterialSuffix() {
        return materialSuffix;
    }

    public void setMaterialSuffix(String materialSuffix) {
        this.materialSuffix = materialSuffix == null ? null : materialSuffix.trim();
    }

    public String getMaterialIcon() {
        return materialIcon;
    }

    public void setMaterialIcon(String materialIcon) {
        this.materialIcon = materialIcon == null ? null : materialIcon.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}