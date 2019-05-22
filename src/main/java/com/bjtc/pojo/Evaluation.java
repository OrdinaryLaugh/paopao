package com.bjtc.pojo;

public class Evaluation {
    public Integer getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Integer evaluationId) {
        this.evaluationId = evaluationId;
    }

    public String getEvaluationMessage() {
        return evaluationMessage;
    }

    public void setEvaluationMessage(String evaluationMessage) {
        this.evaluationMessage = evaluationMessage;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getEvaluationImg() {
        return evaluationImg;
    }

    public void setEvaluationImg(String evaluationImg) {
        this.evaluationImg = evaluationImg;
    }

    private Integer evaluationId;
    private String evaluationMessage;
    private String orderId;
    private String evaluationImg;

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    private Integer sellerId;
    private Integer userId;
    private Integer receiverId;
}
