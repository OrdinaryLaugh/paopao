package com.bjtc.mapper;

import com.bjtc.pojo.Evaluation;

public interface EvaluationMapper {
    public int addEvaluation(Evaluation evaluation);

    public Evaluation getEvaluationByOrderId(String orderId);

    public Evaluation getEvaluationBySellerId(String sellerId);

    public int deleteEvaluation(Evaluation evaluation);
}
