package com.bjtc.pojo;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String userPhone;

    private String userMail;

    private Date userCreateDate;

    private Date userUpdateDate;

    private String userIdentity;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail == null ? null : userMail.trim();
    }

    public Date getUserCreateDate() {
        return userCreateDate;
    }

    public void setUserCreateDate(Date userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    public Date getUserUpdateDate() {
        return userUpdateDate;
    }

    public void setUserUpdateDate(Date userUpdateDate) {
        this.userUpdateDate = userUpdateDate;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity == null ? null : userIdentity.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userMail='" + userMail + '\'' +
                ", userCreateDate=" + userCreateDate +
                ", userUpdateDate=" + userUpdateDate +
                ", userIdentity='" + userIdentity + '\'' +
                '}';
    }
}