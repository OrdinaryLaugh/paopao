package com.bjtc.pojo;

public class OrderItem {
    private Integer orderItemId;

    private Integer orderItemCount;

    private Double orderItemPrice;

    private Integer orderId;

    private Integer itemId;

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getOrderItemCount() {
        return orderItemCount;
    }

    public void setOrderItemCount(Integer orderItemCount) {
        this.orderItemCount = orderItemCount;
    }

    public Double getOrderItemPrice() {
        return orderItemPrice;
    }

    public void setOrderItemPrice(Double orderItemPrice) {
        this.orderItemPrice = orderItemPrice;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}