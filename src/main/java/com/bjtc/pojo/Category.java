package com.bjtc.pojo;

import java.util.Date;

public class Category {
    private Integer categoryId;

    private Integer categoryParentId;

    private String categoryName;

    private String categoryIsParent;

    private Date categoryCreatedDate;

    private Date categoryUpdateDate;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCategoryParentId() {
        return categoryParentId;
    }

    public void setCategoryParentId(Integer categoryParentId) {
        this.categoryParentId = categoryParentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getCategoryIsParent() {
        return categoryIsParent;
    }

    public void setCategoryIsParent(String categoryIsParent) {
        this.categoryIsParent = categoryIsParent == null ? null : categoryIsParent.trim();
    }

    public Date getCategoryCreatedDate() {
        return categoryCreatedDate;
    }

    public void setCategoryCreatedDate(Date categoryCreatedDate) {
        this.categoryCreatedDate = categoryCreatedDate;
    }

    public Date getCategoryUpdateDate() {
        return categoryUpdateDate;
    }

    public void setCategoryUpdateDate(Date categoryUpdateDate) {
        this.categoryUpdateDate = categoryUpdateDate;
    }
}