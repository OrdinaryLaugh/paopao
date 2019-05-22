package com.bjtc.pojo;

import java.util.Date;

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

    public String getOrderSize() {
        return orderSize;
    }

    public void setOrderSize(String orderSize) {
        this.orderSize = orderSize;
    }

    private String orderSize;

    private Double orderPrice;

    private String orderSellerPhone;

    private String orderBuyerPhone;

    private String orderReceivePhone;

    private Date orderCreateDate;

    private Date orderUpdateDate;
    //最晚收货时间
    private Date orderBuyerDate;
    //需要代跑的地点（如：具体的某个快递点、超市）
    private String orderShopAddress;
    //收货地址
    private String orderBuyerAddress;
    //订单备注
    private String orderRemarks;
    //送取模式（送货上门或者送到楼下之类的）
    private String orderDeliveryPattern;

    public String getOrderRemarks() {
        return orderRemarks;
    }

    public void setOrderRemarks(String orderRemarks) {
        this.orderRemarks = orderRemarks;
    }

    public String getOrderDeliveryPattern() {
        return orderDeliveryPattern;
    }

    public void setOrderDeliveryPattern(String orderDeliveryPattern) {
        this.orderDeliveryPattern = orderDeliveryPattern;
    }



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
    public Date getOrderCreateDate() {
        return orderCreateDate;
    }

    public void setOrderCreateDate(Date orderCreateDate) {
        this.orderCreateDate = orderCreateDate;
    }

    public Date getOrderUpdateDate() {
        return orderUpdateDate;
    }

    public void setOrderUpdateDate(Date orderUpdateDate) {
        this.orderUpdateDate = orderUpdateDate;
    }

    public Date getOrderBuyerDate() {
        return orderBuyerDate;
    }

    public void setOrderBuyerDate(Date orderBuyerDate) {
        this.orderBuyerDate = orderBuyerDate;
    }

    public String getOrderShopAddress() {
        return orderShopAddress;
    }

    public void setOrderShopAddress(String orderShopAddress) {
        this.orderShopAddress = orderShopAddress;
    }

    public String getOrderBuyerAddress() {
        return orderBuyerAddress;
    }

    public void setOrderBuyerAddress(String orderBuyerAddress) {
        this.orderBuyerAddress = orderBuyerAddress;
    }
}