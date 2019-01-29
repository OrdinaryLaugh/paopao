package com.bjtc.pojo;

import java.util.Date;

public class Item {
    private Integer itemId;

    private String itemName;

    private Double itemPrice;

    private String itemImagePath;

    private Integer itemCategoryId;

    private String itemStatus;

    private Date itemCreateDate;

    private Date itemUpdateDate;

    private String itemDescribe;

    private Integer itemUserId;

    private String itemUserPhone;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemImagePath() {
        return itemImagePath;
    }

    public void setItemImagePath(String itemImagePath) {
        this.itemImagePath = itemImagePath == null ? null : itemImagePath.trim();
    }

    public Integer getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(Integer itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus == null ? null : itemStatus.trim();
    }

    public Date getItemCreateDate() {
        return itemCreateDate;
    }

    public void setItemCreateDate(Date itemCreateDate) {
        this.itemCreateDate = itemCreateDate;
    }

    public Date getItemUpdateDate() {
        return itemUpdateDate;
    }

    public void setItemUpdateDate(Date itemUpdateDate) {
        this.itemUpdateDate = itemUpdateDate;
    }

    public String getItemDescribe() {
        return itemDescribe;
    }

    public void setItemDescribe(String itemDescribe) {
        this.itemDescribe = itemDescribe == null ? null : itemDescribe.trim();
    }

    public Integer getItemUserId() {
        return itemUserId;
    }

    public void setItemUserId(Integer itemUserId) {
        this.itemUserId = itemUserId;
    }

    public String getItemUserPhone() {
        return itemUserPhone;
    }

    public void setItemUserPhone(String itemUserPhone) {
        this.itemUserPhone = itemUserPhone == null ? null : itemUserPhone.trim();
    }
}