package cn.edu.njnu.bean;

import java.io.Serializable;

public class Category implements Serializable {
    private Integer categoryId;

    private String category;

    private static final long serialVersionUID = 1L;

    public Category(Integer categoryId, String category) {
        this.categoryId = categoryId;
        this.category = category;
    }

    public Category() {
        super();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }
}