package com.bjtc.pojo;

import java.util.Date;

/**
 * 管理员POJO类
 */
public class Admin {


    public Admin(){

    }

    public Admin(Integer adminId, String adminName, String adminPassword, String adminPhone, String adminMail, Date adminCreateDate, Date adminUpdateDate, Integer adminRole) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminPhone = adminPhone;
        this.adminMail = adminMail;
        this.adminCreateDate = adminCreateDate;
        this.adminUpdateDate = adminUpdateDate;
        this.adminRole = adminRole;
    }

    private Integer adminId;

    private String adminName;

    private String adminPassword;

    private String adminPhone;

    private String adminMail;

    private Date adminCreateDate;

    private Date adminUpdateDate;

    private Integer adminRole;

    private String adminAddress;


    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public String getAdminMail() {
        return adminMail;
    }

    public void setAdminMail(String adminMail) {
        this.adminMail = adminMail;
    }

    public Date getAdminCreateDate() {
        return adminCreateDate;
    }

    public void setAdminCreateDate(Date adminCreateDate) {
        this.adminCreateDate = adminCreateDate;
    }

    public Date getAdminUpdateDate() {
        return adminUpdateDate;
    }

    public void setAdminUpdateDate(Date adminUpdateDate) {
        this.adminUpdateDate = adminUpdateDate;
    }

    public Integer getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(Integer adminRole) {
        this.adminRole = adminRole;
    }
    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }
}
