package com.bjtc.service;

import com.bjtc.mapper.EvaluationMapper;
import com.bjtc.mapper.OrderMapper;
import com.bjtc.pojo.Evaluation;
import com.bjtc.pojo.Order;
import com.bjtc.util.CheckInputUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EvaluationServiceImpl implements EvaluationService {
    @Autowired
    EvaluationMapper evaluationMapper;
    @Autowired
    OrderMapper orderMapper;

    /**
     * 对订单进行评价，需要订单状态为 已接收（D），状态变为评价完成（H）
     * @param evaluation
     * @return
     */
    @Override
    @Transactional
    public int addEvaluation(Evaluation evaluation, Order order) {

        evaluation.setReceiverId(order.getOrderReceiveId());
        evaluation.setSellerId(order.getOrderSellerId());
        evaluation.setUserId(order.getOrderBuyerId());
        int addEvaluation = evaluationMapper.addEvaluation(evaluation);
        if(addEvaluation!=1||!order.getOrderStatus().substring(1).equals("D")){
            return 0;
        }
        order.setOrderStatus(order.getOrderStatus().substring(0,1)+"H");
        int i = orderMapper.updateByPrimaryKey(order);
        return i;
    }

    @Override
    public Evaluation getEvaluationByOrderId(String orderId) {
        boolean checkOrderId = CheckInputUtils.checkOrderId(orderId);
        if(!checkOrderId){
            return null;
        }
        return evaluationMapper.getEvaluationByOrderId(orderId);
    }

    @Override
    public Evaluation getEvaluationBySellerId(String sellerId) {
        return evaluationMapper.getEvaluationBySellerId(sellerId);
    }


    @Transactional
    @Override
    public int deleteEvaluation(Evaluation evaluation) {
        return evaluationMapper.deleteEvaluation(evaluation);
    }
}
