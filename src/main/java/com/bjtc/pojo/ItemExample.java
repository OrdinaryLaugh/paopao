package com.bjtc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemExample() {
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

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Integer value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Integer value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Integer value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Integer value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Integer> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Integer> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Integer value1, Integer value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("item_name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("item_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("item_name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("item_name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("item_name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("item_name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("item_name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("item_name like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("item_name not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("item_name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("item_name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("item_name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("item_name not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemPriceIsNull() {
            addCriterion("item_price is null");
            return (Criteria) this;
        }

        public Criteria andItemPriceIsNotNull() {
            addCriterion("item_price is not null");
            return (Criteria) this;
        }

        public Criteria andItemPriceEqualTo(Double value) {
            addCriterion("item_price =", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotEqualTo(Double value) {
            addCriterion("item_price <>", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceGreaterThan(Double value) {
            addCriterion("item_price >", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("item_price >=", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceLessThan(Double value) {
            addCriterion("item_price <", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceLessThanOrEqualTo(Double value) {
            addCriterion("item_price <=", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceIn(List<Double> values) {
            addCriterion("item_price in", values, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotIn(List<Double> values) {
            addCriterion("item_price not in", values, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceBetween(Double value1, Double value2) {
            addCriterion("item_price between", value1, value2, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotBetween(Double value1, Double value2) {
            addCriterion("item_price not between", value1, value2, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemImagePathIsNull() {
            addCriterion("item_image_path is null");
            return (Criteria) this;
        }

        public Criteria andItemImagePathIsNotNull() {
            addCriterion("item_image_path is not null");
            return (Criteria) this;
        }

        public Criteria andItemImagePathEqualTo(String value) {
            addCriterion("item_image_path =", value, "itemImagePath");
            return (Criteria) this;
        }

        public Criteria andItemImagePathNotEqualTo(String value) {
            addCriterion("item_image_path <>", value, "itemImagePath");
            return (Criteria) this;
        }

        public Criteria andItemImagePathGreaterThan(String value) {
            addCriterion("item_image_path >", value, "itemImagePath");
            return (Criteria) this;
        }

        public Criteria andItemImagePathGreaterThanOrEqualTo(String value) {
            addCriterion("item_image_path >=", value, "itemImagePath");
            return (Criteria) this;
        }

        public Criteria andItemImagePathLessThan(String value) {
            addCriterion("item_image_path <", value, "itemImagePath");
            return (Criteria) this;
        }

        public Criteria andItemImagePathLessThanOrEqualTo(String value) {
            addCriterion("item_image_path <=", value, "itemImagePath");
            return (Criteria) this;
        }

        public Criteria andItemImagePathLike(String value) {
            addCriterion("item_image_path like", value, "itemImagePath");
            return (Criteria) this;
        }

        public Criteria andItemImagePathNotLike(String value) {
            addCriterion("item_image_path not like", value, "itemImagePath");
            return (Criteria) this;
        }

        public Criteria andItemImagePathIn(List<String> values) {
            addCriterion("item_image_path in", values, "itemImagePath");
            return (Criteria) this;
        }

        public Criteria andItemImagePathNotIn(List<String> values) {
            addCriterion("item_image_path not in", values, "itemImagePath");
            return (Criteria) this;
        }

        public Criteria andItemImagePathBetween(String value1, String value2) {
            addCriterion("item_image_path between", value1, value2, "itemImagePath");
            return (Criteria) this;
        }

        public Criteria andItemImagePathNotBetween(String value1, String value2) {
            addCriterion("item_image_path not between", value1, value2, "itemImagePath");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdIsNull() {
            addCriterion("item_category_id is null");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdIsNotNull() {
            addCriterion("item_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdEqualTo(Integer value) {
            addCriterion("item_category_id =", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdNotEqualTo(Integer value) {
            addCriterion("item_category_id <>", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdGreaterThan(Integer value) {
            addCriterion("item_category_id >", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_category_id >=", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdLessThan(Integer value) {
            addCriterion("item_category_id <", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("item_category_id <=", value, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdIn(List<Integer> values) {
            addCriterion("item_category_id in", values, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdNotIn(List<Integer> values) {
            addCriterion("item_category_id not in", values, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("item_category_id between", value1, value2, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("item_category_id not between", value1, value2, "itemCategoryId");
            return (Criteria) this;
        }

        public Criteria andItemStatusIsNull() {
            addCriterion("item_status is null");
            return (Criteria) this;
        }

        public Criteria andItemStatusIsNotNull() {
            addCriterion("item_status is not null");
            return (Criteria) this;
        }

        public Criteria andItemStatusEqualTo(String value) {
            addCriterion("item_status =", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusNotEqualTo(String value) {
            addCriterion("item_status <>", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusGreaterThan(String value) {
            addCriterion("item_status >", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusGreaterThanOrEqualTo(String value) {
            addCriterion("item_status >=", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusLessThan(String value) {
            addCriterion("item_status <", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusLessThanOrEqualTo(String value) {
            addCriterion("item_status <=", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusLike(String value) {
            addCriterion("item_status like", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusNotLike(String value) {
            addCriterion("item_status not like", value, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusIn(List<String> values) {
            addCriterion("item_status in", values, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusNotIn(List<String> values) {
            addCriterion("item_status not in", values, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusBetween(String value1, String value2) {
            addCriterion("item_status between", value1, value2, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemStatusNotBetween(String value1, String value2) {
            addCriterion("item_status not between", value1, value2, "itemStatus");
            return (Criteria) this;
        }

        public Criteria andItemCreateDateIsNull() {
            addCriterion("item_create_date is null");
            return (Criteria) this;
        }

        public Criteria andItemCreateDateIsNotNull() {
            addCriterion("item_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andItemCreateDateEqualTo(Date value) {
            addCriterion("item_create_date =", value, "itemCreateDate");
            return (Criteria) this;
        }

        public Criteria andItemCreateDateNotEqualTo(Date value) {
            addCriterion("item_create_date <>", value, "itemCreateDate");
            return (Criteria) this;
        }

        public Criteria andItemCreateDateGreaterThan(Date value) {
            addCriterion("item_create_date >", value, "itemCreateDate");
            return (Criteria) this;
        }

        public Criteria andItemCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("item_create_date >=", value, "itemCreateDate");
            return (Criteria) this;
        }

        public Criteria andItemCreateDateLessThan(Date value) {
            addCriterion("item_create_date <", value, "itemCreateDate");
            return (Criteria) this;
        }

        public Criteria andItemCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("item_create_date <=", value, "itemCreateDate");
            return (Criteria) this;
        }

        public Criteria andItemCreateDateIn(List<Date> values) {
            addCriterion("item_create_date in", values, "itemCreateDate");
            return (Criteria) this;
        }

        public Criteria andItemCreateDateNotIn(List<Date> values) {
            addCriterion("item_create_date not in", values, "itemCreateDate");
            return (Criteria) this;
        }

        public Criteria andItemCreateDateBetween(Date value1, Date value2) {
            addCriterion("item_create_date between", value1, value2, "itemCreateDate");
            return (Criteria) this;
        }

        public Criteria andItemCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("item_create_date not between", value1, value2, "itemCreateDate");
            return (Criteria) this;
        }

        public Criteria andItemUpdateDateIsNull() {
            addCriterion("item_update_date is null");
            return (Criteria) this;
        }

        public Criteria andItemUpdateDateIsNotNull() {
            addCriterion("item_update_date is not null");
            return (Criteria) this;
        }

        public Criteria andItemUpdateDateEqualTo(Date value) {
            addCriterion("item_update_date =", value, "itemUpdateDate");
            return (Criteria) this;
        }

        public Criteria andItemUpdateDateNotEqualTo(Date value) {
            addCriterion("item_update_date <>", value, "itemUpdateDate");
            return (Criteria) this;
        }

        public Criteria andItemUpdateDateGreaterThan(Date value) {
            addCriterion("item_update_date >", value, "itemUpdateDate");
            return (Criteria) this;
        }

        public Criteria andItemUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("item_update_date >=", value, "itemUpdateDate");
            return (Criteria) this;
        }

        public Criteria andItemUpdateDateLessThan(Date value) {
            addCriterion("item_update_date <", value, "itemUpdateDate");
            return (Criteria) this;
        }

        public Criteria andItemUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("item_update_date <=", value, "itemUpdateDate");
            return (Criteria) this;
        }

        public Criteria andItemUpdateDateIn(List<Date> values) {
            addCriterion("item_update_date in", values, "itemUpdateDate");
            return (Criteria) this;
        }

        public Criteria andItemUpdateDateNotIn(List<Date> values) {
            addCriterion("item_update_date not in", values, "itemUpdateDate");
            return (Criteria) this;
        }

        public Criteria andItemUpdateDateBetween(Date value1, Date value2) {
            addCriterion("item_update_date between", value1, value2, "itemUpdateDate");
            return (Criteria) this;
        }

        public Criteria andItemUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("item_update_date not between", value1, value2, "itemUpdateDate");
            return (Criteria) this;
        }

        public Criteria andItemDescribeIsNull() {
            addCriterion("item_describe is null");
            return (Criteria) this;
        }

        public Criteria andItemDescribeIsNotNull() {
            addCriterion("item_describe is not null");
            return (Criteria) this;
        }

        public Criteria andItemDescribeEqualTo(String value) {
            addCriterion("item_describe =", value, "itemDescribe");
            return (Criteria) this;
        }

        public Criteria andItemDescribeNotEqualTo(String value) {
            addCriterion("item_describe <>", value, "itemDescribe");
            return (Criteria) this;
        }

        public Criteria andItemDescribeGreaterThan(String value) {
            addCriterion("item_describe >", value, "itemDescribe");
            return (Criteria) this;
        }

        public Criteria andItemDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("item_describe >=", value, "itemDescribe");
            return (Criteria) this;
        }

        public Criteria andItemDescribeLessThan(String value) {
            addCriterion("item_describe <", value, "itemDescribe");
            return (Criteria) this;
        }

        public Criteria andItemDescribeLessThanOrEqualTo(String value) {
            addCriterion("item_describe <=", value, "itemDescribe");
            return (Criteria) this;
        }

        public Criteria andItemDescribeLike(String value) {
            addCriterion("item_describe like", value, "itemDescribe");
            return (Criteria) this;
        }

        public Criteria andItemDescribeNotLike(String value) {
            addCriterion("item_describe not like", value, "itemDescribe");
            return (Criteria) this;
        }

        public Criteria andItemDescribeIn(List<String> values) {
            addCriterion("item_describe in", values, "itemDescribe");
            return (Criteria) this;
        }

        public Criteria andItemDescribeNotIn(List<String> values) {
            addCriterion("item_describe not in", values, "itemDescribe");
            return (Criteria) this;
        }

        public Criteria andItemDescribeBetween(String value1, String value2) {
            addCriterion("item_describe between", value1, value2, "itemDescribe");
            return (Criteria) this;
        }

        public Criteria andItemDescribeNotBetween(String value1, String value2) {
            addCriterion("item_describe not between", value1, value2, "itemDescribe");
            return (Criteria) this;
        }

        public Criteria andItemUserIdIsNull() {
            addCriterion("item_user_id is null");
            return (Criteria) this;
        }

        public Criteria andItemUserIdIsNotNull() {
            addCriterion("item_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemUserIdEqualTo(Integer value) {
            addCriterion("item_user_id =", value, "itemUserId");
            return (Criteria) this;
        }

        public Criteria andItemUserIdNotEqualTo(Integer value) {
            addCriterion("item_user_id <>", value, "itemUserId");
            return (Criteria) this;
        }

        public Criteria andItemUserIdGreaterThan(Integer value) {
            addCriterion("item_user_id >", value, "itemUserId");
            return (Criteria) this;
        }

        public Criteria andItemUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_user_id >=", value, "itemUserId");
            return (Criteria) this;
        }

        public Criteria andItemUserIdLessThan(Integer value) {
            addCriterion("item_user_id <", value, "itemUserId");
            return (Criteria) this;
        }

        public Criteria andItemUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("item_user_id <=", value, "itemUserId");
            return (Criteria) this;
        }

        public Criteria andItemUserIdIn(List<Integer> values) {
            addCriterion("item_user_id in", values, "itemUserId");
            return (Criteria) this;
        }

        public Criteria andItemUserIdNotIn(List<Integer> values) {
            addCriterion("item_user_id not in", values, "itemUserId");
            return (Criteria) this;
        }

        public Criteria andItemUserIdBetween(Integer value1, Integer value2) {
            addCriterion("item_user_id between", value1, value2, "itemUserId");
            return (Criteria) this;
        }

        public Criteria andItemUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("item_user_id not between", value1, value2, "itemUserId");
            return (Criteria) this;
        }

        public Criteria andItemUserPhoneIsNull() {
            addCriterion("item_user_phone is null");
            return (Criteria) this;
        }

        public Criteria andItemUserPhoneIsNotNull() {
            addCriterion("item_user_phone is not null");
            return (Criteria) this;
        }

        public Criteria andItemUserPhoneEqualTo(String value) {
            addCriterion("item_user_phone =", value, "itemUserPhone");
            return (Criteria) this;
        }

        public Criteria andItemUserPhoneNotEqualTo(String value) {
            addCriterion("item_user_phone <>", value, "itemUserPhone");
            return (Criteria) this;
        }

        public Criteria andItemUserPhoneGreaterThan(String value) {
            addCriterion("item_user_phone >", value, "itemUserPhone");
            return (Criteria) this;
        }

        public Criteria andItemUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("item_user_phone >=", value, "itemUserPhone");
            return (Criteria) this;
        }

        public Criteria andItemUserPhoneLessThan(String value) {
            addCriterion("item_user_phone <", value, "itemUserPhone");
            return (Criteria) this;
        }

        public Criteria andItemUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("item_user_phone <=", value, "itemUserPhone");
            return (Criteria) this;
        }

        public Criteria andItemUserPhoneLike(String value) {
            addCriterion("item_user_phone like", value, "itemUserPhone");
            return (Criteria) this;
        }

        public Criteria andItemUserPhoneNotLike(String value) {
            addCriterion("item_user_phone not like", value, "itemUserPhone");
            return (Criteria) this;
        }

        public Criteria andItemUserPhoneIn(List<String> values) {
            addCriterion("item_user_phone in", values, "itemUserPhone");
            return (Criteria) this;
        }

        public Criteria andItemUserPhoneNotIn(List<String> values) {
            addCriterion("item_user_phone not in", values, "itemUserPhone");
            return (Criteria) this;
        }

        public Criteria andItemUserPhoneBetween(String value1, String value2) {
            addCriterion("item_user_phone between", value1, value2, "itemUserPhone");
            return (Criteria) this;
        }

        public Criteria andItemUserPhoneNotBetween(String value1, String value2) {
            addCriterion("item_user_phone not between", value1, value2, "itemUserPhone");
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