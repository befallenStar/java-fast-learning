package com.junenatte.dao;

public class Category {
    private Integer id;

    private String category;

    private String remark;

    public Category(Integer id, String category, String remark) {
        this.id = id;
        this.category = category;
        this.remark = remark;
    }

    public Category() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}