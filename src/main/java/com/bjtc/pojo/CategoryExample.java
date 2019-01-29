package com.bjtc.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CategoryExample() {
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

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdIsNull() {
            addCriterion("category_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdIsNotNull() {
            addCriterion("category_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdEqualTo(Integer value) {
            addCriterion("category_parent_id =", value, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdNotEqualTo(Integer value) {
            addCriterion("category_parent_id <>", value, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdGreaterThan(Integer value) {
            addCriterion("category_parent_id >", value, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_parent_id >=", value, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdLessThan(Integer value) {
            addCriterion("category_parent_id <", value, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_parent_id <=", value, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdIn(List<Integer> values) {
            addCriterion("category_parent_id in", values, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdNotIn(List<Integer> values) {
            addCriterion("category_parent_id not in", values, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdBetween(Integer value1, Integer value2) {
            addCriterion("category_parent_id between", value1, value2, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_parent_id not between", value1, value2, "categoryParentId");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNull() {
            addCriterion("category_name is null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNotNull() {
            addCriterion("category_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameEqualTo(String value) {
            addCriterion("category_name =", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotEqualTo(String value) {
            addCriterion("category_name <>", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThan(String value) {
            addCriterion("category_name >", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("category_name >=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThan(String value) {
            addCriterion("category_name <", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("category_name <=", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameLike(String value) {
            addCriterion("category_name like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotLike(String value) {
            addCriterion("category_name not like", value, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIn(List<String> values) {
            addCriterion("category_name in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotIn(List<String> values) {
            addCriterion("category_name not in", values, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameBetween(String value1, String value2) {
            addCriterion("category_name between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotBetween(String value1, String value2) {
            addCriterion("category_name not between", value1, value2, "categoryName");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentIsNull() {
            addCriterion("category_is_parent is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentIsNotNull() {
            addCriterion("category_is_parent is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentEqualTo(String value) {
            addCriterion("category_is_parent =", value, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentNotEqualTo(String value) {
            addCriterion("category_is_parent <>", value, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentGreaterThan(String value) {
            addCriterion("category_is_parent >", value, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentGreaterThanOrEqualTo(String value) {
            addCriterion("category_is_parent >=", value, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentLessThan(String value) {
            addCriterion("category_is_parent <", value, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentLessThanOrEqualTo(String value) {
            addCriterion("category_is_parent <=", value, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentLike(String value) {
            addCriterion("category_is_parent like", value, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentNotLike(String value) {
            addCriterion("category_is_parent not like", value, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentIn(List<String> values) {
            addCriterion("category_is_parent in", values, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentNotIn(List<String> values) {
            addCriterion("category_is_parent not in", values, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentBetween(String value1, String value2) {
            addCriterion("category_is_parent between", value1, value2, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryIsParentNotBetween(String value1, String value2) {
            addCriterion("category_is_parent not between", value1, value2, "categoryIsParent");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedDateIsNull() {
            addCriterion("category_created_date is null");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedDateIsNotNull() {
            addCriterion("category_created_date is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedDateEqualTo(Date value) {
            addCriterion("category_created_date =", value, "categoryCreatedDate");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedDateNotEqualTo(Date value) {
            addCriterion("category_created_date <>", value, "categoryCreatedDate");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedDateGreaterThan(Date value) {
            addCriterion("category_created_date >", value, "categoryCreatedDate");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("category_created_date >=", value, "categoryCreatedDate");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedDateLessThan(Date value) {
            addCriterion("category_created_date <", value, "categoryCreatedDate");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedDateLessThanOrEqualTo(Date value) {
            addCriterion("category_created_date <=", value, "categoryCreatedDate");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedDateIn(List<Date> values) {
            addCriterion("category_created_date in", values, "categoryCreatedDate");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedDateNotIn(List<Date> values) {
            addCriterion("category_created_date not in", values, "categoryCreatedDate");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedDateBetween(Date value1, Date value2) {
            addCriterion("category_created_date between", value1, value2, "categoryCreatedDate");
            return (Criteria) this;
        }

        public Criteria andCategoryCreatedDateNotBetween(Date value1, Date value2) {
            addCriterion("category_created_date not between", value1, value2, "categoryCreatedDate");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateDateIsNull() {
            addCriterion("category_update_date is null");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateDateIsNotNull() {
            addCriterion("category_update_date is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateDateEqualTo(Date value) {
            addCriterion("category_update_date =", value, "categoryUpdateDate");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateDateNotEqualTo(Date value) {
            addCriterion("category_update_date <>", value, "categoryUpdateDate");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateDateGreaterThan(Date value) {
            addCriterion("category_update_date >", value, "categoryUpdateDate");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("category_update_date >=", value, "categoryUpdateDate");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateDateLessThan(Date value) {
            addCriterion("category_update_date <", value, "categoryUpdateDate");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("category_update_date <=", value, "categoryUpdateDate");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateDateIn(List<Date> values) {
            addCriterion("category_update_date in", values, "categoryUpdateDate");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateDateNotIn(List<Date> values) {
            addCriterion("category_update_date not in", values, "categoryUpdateDate");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateDateBetween(Date value1, Date value2) {
            addCriterion("category_update_date between", value1, value2, "categoryUpdateDate");
            return (Criteria) this;
        }

        public Criteria andCategoryUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("category_update_date not between", value1, value2, "categoryUpdateDate");
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