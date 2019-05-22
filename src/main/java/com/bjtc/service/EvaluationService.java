package com.bjtc.service;

import com.bjtc.pojo.Evaluation;
import com.bjtc.pojo.Order;

public interface EvaluationService {
    public int addEvaluation(Evaluation evaluation, Order order);

    public Evaluation getEvaluationByOrderId(String orderId);

    public Evaluation getEvaluationBySellerId(String sellerId);

    public int deleteEvaluation(Evaluation evaluation);
}
