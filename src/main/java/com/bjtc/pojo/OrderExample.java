package com.bjtc.pojo;

import java.util.ArrayList;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdIsNull() {
            addCriterion("order_seller_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdIsNotNull() {
            addCriterion("order_seller_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdEqualTo(Integer value) {
            addCriterion("order_seller_id =", value, "orderSellerId");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdNotEqualTo(Integer value) {
            addCriterion("order_seller_id <>", value, "orderSellerId");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdGreaterThan(Integer value) {
            addCriterion("order_seller_id >", value, "orderSellerId");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_seller_id >=", value, "orderSellerId");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdLessThan(Integer value) {
            addCriterion("order_seller_id <", value, "orderSellerId");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_seller_id <=", value, "orderSellerId");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdIn(List<Integer> values) {
            addCriterion("order_seller_id in", values, "orderSellerId");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdNotIn(List<Integer> values) {
            addCriterion("order_seller_id not in", values, "orderSellerId");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdBetween(Integer value1, Integer value2) {
            addCriterion("order_seller_id between", value1, value2, "orderSellerId");
            return (Criteria) this;
        }

        public Criteria andOrderSellerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_seller_id not between", value1, value2, "orderSellerId");
            return (Criteria) this;
        }

        public Criteria andOrderSellerNameIsNull() {
            addCriterion("order_seller_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderSellerNameIsNotNull() {
            addCriterion("order_seller_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSellerNameEqualTo(String value) {
            addCriterion("order_seller_name =", value, "orderSellerName");
            return (Criteria) this;
        }

        public Criteria andOrderSellerNameNotEqualTo(String value) {
            addCriterion("order_seller_name <>", value, "orderSellerName");
            return (Criteria) this;
        }

        public Criteria andOrderSellerNameGreaterThan(String value) {
            addCriterion("order_seller_name >", value, "orderSellerName");
            return (Criteria) this;
        }

        public Criteria andOrderSellerNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_seller_name >=", value, "orderSellerName");
            return (Criteria) this;
        }

        public Criteria andOrderSellerNameLessThan(String value) {
            addCriterion("order_seller_name <", value, "orderSellerName");
            return (Criteria) this;
        }

        public Criteria andOrderSellerNameLessThanOrEqualTo(String value) {
            addCriterion("order_seller_name <=", value, "orderSellerName");
            return (Criteria) this;
        }

        public Criteria andOrderSellerNameLike(String value) {
            addCriterion("order_seller_name like", value, "orderSellerName");
            return (Criteria) this;
        }

        public Criteria andOrderSellerNameNotLike(String value) {
            addCriterion("order_seller_name not like", value, "orderSellerName");
            return (Criteria) this;
        }

        public Criteria andOrderSellerNameIn(List<String> values) {
            addCriterion("order_seller_name in", values, "orderSellerName");
            return (Criteria) this;
        }

        public Criteria andOrderSellerNameNotIn(List<String> values) {
            addCriterion("order_seller_name not in", values, "orderSellerName");
            return (Criteria) this;
        }

        public Criteria andOrderSellerNameBetween(String value1, String value2) {
            addCriterion("order_seller_name between", value1, value2, "orderSellerName");
            return (Criteria) this;
        }

        public Criteria andOrderSellerNameNotBetween(String value1, String value2) {
            addCriterion("order_seller_name not between", value1, value2, "orderSellerName");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdIsNull() {
            addCriterion("order_buyer_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdIsNotNull() {
            addCriterion("order_buyer_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdEqualTo(Integer value) {
            addCriterion("order_buyer_id =", value, "orderBuyerId");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdNotEqualTo(Integer value) {
            addCriterion("order_buyer_id <>", value, "orderBuyerId");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdGreaterThan(Integer value) {
            addCriterion("order_buyer_id >", value, "orderBuyerId");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_buyer_id >=", value, "orderBuyerId");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdLessThan(Integer value) {
            addCriterion("order_buyer_id <", value, "orderBuyerId");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_buyer_id <=", value, "orderBuyerId");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdIn(List<Integer> values) {
            addCriterion("order_buyer_id in", values, "orderBuyerId");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdNotIn(List<Integer> values) {
            addCriterion("order_buyer_id not in", values, "orderBuyerId");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdBetween(Integer value1, Integer value2) {
            addCriterion("order_buyer_id between", value1, value2, "orderBuyerId");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_buyer_id not between", value1, value2, "orderBuyerId");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerNameIsNull() {
            addCriterion("order_buyer_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerNameIsNotNull() {
            addCriterion("order_buyer_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerNameEqualTo(String value) {
            addCriterion("order_buyer_name =", value, "orderBuyerName");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerNameNotEqualTo(String value) {
            addCriterion("order_buyer_name <>", value, "orderBuyerName");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerNameGreaterThan(String value) {
            addCriterion("order_buyer_name >", value, "orderBuyerName");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_buyer_name >=", value, "orderBuyerName");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerNameLessThan(String value) {
            addCriterion("order_buyer_name <", value, "orderBuyerName");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerNameLessThanOrEqualTo(String value) {
            addCriterion("order_buyer_name <=", value, "orderBuyerName");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerNameLike(String value) {
            addCriterion("order_buyer_name like", value, "orderBuyerName");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerNameNotLike(String value) {
            addCriterion("order_buyer_name not like", value, "orderBuyerName");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerNameIn(List<String> values) {
            addCriterion("order_buyer_name in", values, "orderBuyerName");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerNameNotIn(List<String> values) {
            addCriterion("order_buyer_name not in", values, "orderBuyerName");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerNameBetween(String value1, String value2) {
            addCriterion("order_buyer_name between", value1, value2, "orderBuyerName");
            return (Criteria) this;
        }

        public Criteria andOrderBuyerNameNotBetween(String value1, String value2) {
            addCriterion("order_buyer_name not between", value1, value2, "orderBuyerName");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveIdIsNull() {
            addCriterion("order_receive_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveIdIsNotNull() {
            addCriterion("order_receive_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveIdEqualTo(Integer value) {
            addCriterion("order_receive_id =", value, "orderReceiveId");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveIdNotEqualTo(Integer value) {
            addCriterion("order_receive_id <>", value, "orderReceiveId");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveIdGreaterThan(Integer value) {
            addCriterion("order_receive_id >", value, "orderReceiveId");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_receive_id >=", value, "orderReceiveId");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveIdLessThan(Integer value) {
            addCriterion("order_receive_id <", value, "orderReceiveId");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_receive_id <=", value, "orderReceiveId");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveIdIn(List<Integer> values) {
            addCriterion("order_receive_id in", values, "orderReceiveId");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveIdNotIn(List<Integer> values) {
            addCriterion("order_receive_id not in", values, "orderReceiveId");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveIdBetween(Integer value1, Integer value2) {
            addCriterion("order_receive_id between", value1, value2, "orderReceiveId");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_receive_id not between", value1, value2, "orderReceiveId");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(String value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(String value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(String value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(String value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLike(String value) {
            addCriterion("order_status like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotLike(String value) {
            addCriterion("order_status not like", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<String> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<String> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(String value1, String value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(String value1, String value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderItemDescribeIsNull() {
            addCriterion("order_item_describe is null");
            return (Criteria) this;
        }

        public Criteria andOrderItemDescribeIsNotNull() {
            addCriterion("order_item_describe is not null");
            return (Criteria) this;
        }

        public Criteria andOrderItemDescribeEqualTo(String value) {
            addCriterion("order_item_describe =", value, "orderItemDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderItemDescribeNotEqualTo(String value) {
            addCriterion("order_item_describe <>", value, "orderItemDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderItemDescribeGreaterThan(String value) {
            addCriterion("order_item_describe >", value, "orderItemDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderItemDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("order_item_describe >=", value, "orderItemDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderItemDescribeLessThan(String value) {
            addCriterion("order_item_describe <", value, "orderItemDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderItemDescribeLessThanOrEqualTo(String value) {
            addCriterion("order_item_describe <=", value, "orderItemDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderItemDescribeLike(String value) {
            addCriterion("order_item_describe like", value, "orderItemDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderItemDescribeNotLike(String value) {
            addCriterion("order_item_describe not like", value, "orderItemDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderItemDescribeIn(List<String> values) {
            addCriterion("order_item_describe in", values, "orderItemDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderItemDescribeNotIn(List<String> values) {
            addCriterion("order_item_describe not in", values, "orderItemDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderItemDescribeBetween(String value1, String value2) {
            addCriterion("order_item_describe between", value1, value2, "orderItemDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderItemDescribeNotBetween(String value1, String value2) {
            addCriterion("order_item_describe not between", value1, value2, "orderItemDescribe");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveNameIsNull() {
            addCriterion("order_receive_name is null");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveNameIsNotNull() {
            addCriterion("order_receive_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveNameEqualTo(String value) {
            addCriterion("order_receive_name =", value, "orderReceiveName");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveNameNotEqualTo(String value) {
            addCriterion("order_receive_name <>", value, "orderReceiveName");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveNameGreaterThan(String value) {
            addCriterion("order_receive_name >", value, "orderReceiveName");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveNameGreaterThanOrEqualTo(String value) {
            addCriterion("order_receive_name >=", value, "orderReceiveName");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveNameLessThan(String value) {
            addCriterion("order_receive_name <", value, "orderReceiveName");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveNameLessThanOrEqualTo(String value) {
            addCriterion("order_receive_name <=", value, "orderReceiveName");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveNameLike(String value) {
            addCriterion("order_receive_name like", value, "orderReceiveName");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveNameNotLike(String value) {
            addCriterion("order_receive_name not like", value, "orderReceiveName");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveNameIn(List<String> values) {
            addCriterion("order_receive_name in", values, "orderReceiveName");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveNameNotIn(List<String> values) {
            addCriterion("order_receive_name not in", values, "orderReceiveName");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveNameBetween(String value1, String value2) {
            addCriterion("order_receive_name between", value1, value2, "orderReceiveName");
            return (Criteria) this;
        }

        public Criteria andOrderReceiveNameNotBetween(String value1, String value2) {
            addCriterion("order_receive_name not between", value1, value2, "orderReceiveName");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNull() {
            addCriterion("order_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNotNull() {
            addCriterion("order_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceEqualTo(Double value) {
            addCriterion("order_price =", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotEqualTo(Double value) {
            addCriterion("order_price <>", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThan(Double value) {
            addCriterion("order_price >", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("order_price >=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThan(Double value) {
            addCriterion("order_price <", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThanOrEqualTo(Double value) {
            addCriterion("order_price <=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIn(List<Double> values) {
            addCriterion("order_price in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotIn(List<Double> values) {
            addCriterion("order_price not in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceBetween(Double value1, Double value2) {
            addCriterion("order_price between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotBetween(Double value1, Double value2) {
            addCriterion("order_price not between", value1, value2, "orderPrice");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}