package com.example.wantlifu.entity;

import java.util.ArrayList;
import java.util.List;

public class UserAddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserAddressExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andDetailIsNull() {
            addCriterion("detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("detail =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("detail <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("detail >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("detail >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("detail <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("detail <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("detail like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("detail not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("detail in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("detail not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("detail between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("detail not between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andReciverNameIsNull() {
            addCriterion("reciver_name is null");
            return (Criteria) this;
        }

        public Criteria andReciverNameIsNotNull() {
            addCriterion("reciver_name is not null");
            return (Criteria) this;
        }

        public Criteria andReciverNameEqualTo(String value) {
            addCriterion("reciver_name =", value, "reciverName");
            return (Criteria) this;
        }

        public Criteria andReciverNameNotEqualTo(String value) {
            addCriterion("reciver_name <>", value, "reciverName");
            return (Criteria) this;
        }

        public Criteria andReciverNameGreaterThan(String value) {
            addCriterion("reciver_name >", value, "reciverName");
            return (Criteria) this;
        }

        public Criteria andReciverNameGreaterThanOrEqualTo(String value) {
            addCriterion("reciver_name >=", value, "reciverName");
            return (Criteria) this;
        }

        public Criteria andReciverNameLessThan(String value) {
            addCriterion("reciver_name <", value, "reciverName");
            return (Criteria) this;
        }

        public Criteria andReciverNameLessThanOrEqualTo(String value) {
            addCriterion("reciver_name <=", value, "reciverName");
            return (Criteria) this;
        }

        public Criteria andReciverNameLike(String value) {
            addCriterion("reciver_name like", value, "reciverName");
            return (Criteria) this;
        }

        public Criteria andReciverNameNotLike(String value) {
            addCriterion("reciver_name not like", value, "reciverName");
            return (Criteria) this;
        }

        public Criteria andReciverNameIn(List<String> values) {
            addCriterion("reciver_name in", values, "reciverName");
            return (Criteria) this;
        }

        public Criteria andReciverNameNotIn(List<String> values) {
            addCriterion("reciver_name not in", values, "reciverName");
            return (Criteria) this;
        }

        public Criteria andReciverNameBetween(String value1, String value2) {
            addCriterion("reciver_name between", value1, value2, "reciverName");
            return (Criteria) this;
        }

        public Criteria andReciverNameNotBetween(String value1, String value2) {
            addCriterion("reciver_name not between", value1, value2, "reciverName");
            return (Criteria) this;
        }

        public Criteria andReciverPhoneIsNull() {
            addCriterion("reciver_phone is null");
            return (Criteria) this;
        }

        public Criteria andReciverPhoneIsNotNull() {
            addCriterion("reciver_phone is not null");
            return (Criteria) this;
        }

        public Criteria andReciverPhoneEqualTo(String value) {
            addCriterion("reciver_phone =", value, "reciverPhone");
            return (Criteria) this;
        }

        public Criteria andReciverPhoneNotEqualTo(String value) {
            addCriterion("reciver_phone <>", value, "reciverPhone");
            return (Criteria) this;
        }

        public Criteria andReciverPhoneGreaterThan(String value) {
            addCriterion("reciver_phone >", value, "reciverPhone");
            return (Criteria) this;
        }

        public Criteria andReciverPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("reciver_phone >=", value, "reciverPhone");
            return (Criteria) this;
        }

        public Criteria andReciverPhoneLessThan(String value) {
            addCriterion("reciver_phone <", value, "reciverPhone");
            return (Criteria) this;
        }

        public Criteria andReciverPhoneLessThanOrEqualTo(String value) {
            addCriterion("reciver_phone <=", value, "reciverPhone");
            return (Criteria) this;
        }

        public Criteria andReciverPhoneLike(String value) {
            addCriterion("reciver_phone like", value, "reciverPhone");
            return (Criteria) this;
        }

        public Criteria andReciverPhoneNotLike(String value) {
            addCriterion("reciver_phone not like", value, "reciverPhone");
            return (Criteria) this;
        }

        public Criteria andReciverPhoneIn(List<String> values) {
            addCriterion("reciver_phone in", values, "reciverPhone");
            return (Criteria) this;
        }

        public Criteria andReciverPhoneNotIn(List<String> values) {
            addCriterion("reciver_phone not in", values, "reciverPhone");
            return (Criteria) this;
        }

        public Criteria andReciverPhoneBetween(String value1, String value2) {
            addCriterion("reciver_phone between", value1, value2, "reciverPhone");
            return (Criteria) this;
        }

        public Criteria andReciverPhoneNotBetween(String value1, String value2) {
            addCriterion("reciver_phone not between", value1, value2, "reciverPhone");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDefaultedIsNull() {
            addCriterion("defaulted is null");
            return (Criteria) this;
        }

        public Criteria andDefaultedIsNotNull() {
            addCriterion("defaulted is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultedEqualTo(Integer value) {
            addCriterion("defaulted =", value, "defaulted");
            return (Criteria) this;
        }

        public Criteria andDefaultedNotEqualTo(Integer value) {
            addCriterion("defaulted <>", value, "defaulted");
            return (Criteria) this;
        }

        public Criteria andDefaultedGreaterThan(Integer value) {
            addCriterion("defaulted >", value, "defaulted");
            return (Criteria) this;
        }

        public Criteria andDefaultedGreaterThanOrEqualTo(Integer value) {
            addCriterion("defaulted >=", value, "defaulted");
            return (Criteria) this;
        }

        public Criteria andDefaultedLessThan(Integer value) {
            addCriterion("defaulted <", value, "defaulted");
            return (Criteria) this;
        }

        public Criteria andDefaultedLessThanOrEqualTo(Integer value) {
            addCriterion("defaulted <=", value, "defaulted");
            return (Criteria) this;
        }

        public Criteria andDefaultedIn(List<Integer> values) {
            addCriterion("defaulted in", values, "defaulted");
            return (Criteria) this;
        }

        public Criteria andDefaultedNotIn(List<Integer> values) {
            addCriterion("defaulted not in", values, "defaulted");
            return (Criteria) this;
        }

        public Criteria andDefaultedBetween(Integer value1, Integer value2) {
            addCriterion("defaulted between", value1, value2, "defaulted");
            return (Criteria) this;
        }

        public Criteria andDefaultedNotBetween(Integer value1, Integer value2) {
            addCriterion("defaulted not between", value1, value2, "defaulted");
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