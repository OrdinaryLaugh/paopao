package com.bjtc.pojo;

import java.util.Date;

public class Seller {
    private Integer sellerId;
    private String sellerPhone;
    private String sellerName;
    private String sellerShopName;
    private Integer sellerStatus;
    private String sellerPassword;
    private Date sellerCreateDate;
    private String sellerAddress;

    public Seller(){

    }

    public Seller(Integer sellerId, String sellerPhone, String sellerName, String sellerShopName, Integer sellerStatus, String sellerPassword, Date sellerCreateDate, String sellerAddress) {
        this.sellerId = sellerId;
        this.sellerPhone = sellerPhone;
        this.sellerName = sellerName;
        this.sellerShopName = sellerShopName;
        this.sellerStatus = sellerStatus;
        this.sellerPassword = sellerPassword;
        this.sellerCreateDate = sellerCreateDate;
        this.sellerAddress = sellerAddress;
    }

    public Integer getSellerStatus() {
        return sellerStatus;
    }

    public void setSellerStatus(Integer sellerStatus) {
        this.sellerStatus = sellerStatus;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerPassword() {
        return sellerPassword;
    }

    public void setSellerPassword(String sellerPassword) {
        this.sellerPassword = sellerPassword;
    }

    public Date getSellerCreateDate() {
        return sellerCreateDate;
    }

    public void setSellerCreateDate(Date sellerCreateDate) {
        this.sellerCreateDate = sellerCreateDate;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(String  sellerAddress) {
        this.sellerAddress = sellerAddress;
    }
    public String getSellerShopName() {
        return sellerShopName;
    }

    public void setSellerShopName(String sellerShopName) {
        this.sellerShopName = sellerShopName;
    }

}
