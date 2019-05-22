package com.bjtc.pojo;

public class Address {
    private Integer addressId;

    private String address;

    //1为商家地址，2为用户收货地址
    private Integer addressStatus;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getAddressStatus() {
        return addressStatus;
    }

    public void setAddressStatus(Integer addressStatus) {
        this.addressStatus = addressStatus;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", address='" + address + '\'' +
                ", addressStatus=" + addressStatus +
                '}';
    }
}