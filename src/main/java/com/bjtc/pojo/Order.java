package com.bjtc.pojo;

public class Order {
    private String orderId;

    private Integer orderSellerId;

    private String orderSellerName;

    private Integer orderBuyerId;

    private String orderBuyerName;

    private Integer orderReceiveId;

    private String orderStatus;

    private String orderItemDescribe;

    private String orderReceiveName;

    private Double orderPrice;

    private String orderSellerPhone;

    private String orderBuyerPhone;

    private String orderReceivePhone;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String  orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderSellerId() {
        return orderSellerId;
    }

    public void setOrderSellerId(Integer orderSellerId) {
        this.orderSellerId = orderSellerId;
    }

    public String getOrderSellerName() {
        return orderSellerName;
    }

    public void setOrderSellerName(String orderSellerName) {
        this.orderSellerName = orderSellerName == null ? null : orderSellerName.trim();
    }

    public Integer getOrderBuyerId() {
        return orderBuyerId;
    }

    public void setOrderBuyerId(Integer orderBuyerId) {
        this.orderBuyerId = orderBuyerId;
    }

    public String getOrderBuyerName() {
        return orderBuyerName;
    }

    public void setOrderBuyerName(String orderBuyerName) {
        this.orderBuyerName = orderBuyerName == null ? null : orderBuyerName.trim();
    }

    public Integer getOrderReceiveId() {
        return orderReceiveId;
    }

    public void setOrderReceiveId(Integer orderReceiveId) {
        this.orderReceiveId = orderReceiveId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public String getOrderItemDescribe() {
        return orderItemDescribe;
    }

    public void setOrderItemDescribe(String orderItemDescribe) {
        this.orderItemDescribe = orderItemDescribe == null ? null : orderItemDescribe.trim();
    }

    public String getOrderReceiveName() {
        return orderReceiveName;
    }

    public void setOrderReceiveName(String orderReceiveName) {
        this.orderReceiveName = orderReceiveName == null ? null : orderReceiveName.trim();
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderSellerPhone() {
        return orderSellerPhone;
    }

    public void setOrderSellerPhone(String orderSellerPhone) {
        this.orderSellerPhone = orderSellerPhone;
    }

    public String getOrderBuyerPhone() {
        return orderBuyerPhone;
    }

    public void setOrderBuyerPhone(String orderBuyerPhone) {
        this.orderBuyerPhone = orderBuyerPhone;
    }

    public String getOrderReceivePhone() {
        return orderReceivePhone;
    }

    public void setOrderReceivePhone(String orderReceivePhone) {
        this.orderReceivePhone = orderReceivePhone;
    }
}