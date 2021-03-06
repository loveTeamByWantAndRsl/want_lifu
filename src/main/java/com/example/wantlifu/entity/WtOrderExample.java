package com.example.wantlifu.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WtOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WtOrderExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
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

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andIspayIsNull() {
            addCriterion("ispay is null");
            return (Criteria) this;
        }

        public Criteria andIspayIsNotNull() {
            addCriterion("ispay is not null");
            return (Criteria) this;
        }

        public Criteria andIspayEqualTo(Integer value) {
            addCriterion("ispay =", value, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayNotEqualTo(Integer value) {
            addCriterion("ispay <>", value, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayGreaterThan(Integer value) {
            addCriterion("ispay >", value, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayGreaterThanOrEqualTo(Integer value) {
            addCriterion("ispay >=", value, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayLessThan(Integer value) {
            addCriterion("ispay <", value, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayLessThanOrEqualTo(Integer value) {
            addCriterion("ispay <=", value, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayIn(List<Integer> values) {
            addCriterion("ispay in", values, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayNotIn(List<Integer> values) {
            addCriterion("ispay not in", values, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayBetween(Integer value1, Integer value2) {
            addCriterion("ispay between", value1, value2, "ispay");
            return (Criteria) this;
        }

        public Criteria andIspayNotBetween(Integer value1, Integer value2) {
            addCriterion("ispay not between", value1, value2, "ispay");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
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

        public Criteria andDeliverTypeIsNull() {
            addCriterion("deliver_type is null");
            return (Criteria) this;
        }

        public Criteria andDeliverTypeIsNotNull() {
            addCriterion("deliver_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverTypeEqualTo(Integer value) {
            addCriterion("deliver_type =", value, "deliverType");
            return (Criteria) this;
        }

        public Criteria andDeliverTypeNotEqualTo(Integer value) {
            addCriterion("deliver_type <>", value, "deliverType");
            return (Criteria) this;
        }

        public Criteria andDeliverTypeGreaterThan(Integer value) {
            addCriterion("deliver_type >", value, "deliverType");
            return (Criteria) this;
        }

        public Criteria andDeliverTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("deliver_type >=", value, "deliverType");
            return (Criteria) this;
        }

        public Criteria andDeliverTypeLessThan(Integer value) {
            addCriterion("deliver_type <", value, "deliverType");
            return (Criteria) this;
        }

        public Criteria andDeliverTypeLessThanOrEqualTo(Integer value) {
            addCriterion("deliver_type <=", value, "deliverType");
            return (Criteria) this;
        }

        public Criteria andDeliverTypeIn(List<Integer> values) {
            addCriterion("deliver_type in", values, "deliverType");
            return (Criteria) this;
        }

        public Criteria andDeliverTypeNotIn(List<Integer> values) {
            addCriterion("deliver_type not in", values, "deliverType");
            return (Criteria) this;
        }

        public Criteria andDeliverTypeBetween(Integer value1, Integer value2) {
            addCriterion("deliver_type between", value1, value2, "deliverType");
            return (Criteria) this;
        }

        public Criteria andDeliverTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("deliver_type not between", value1, value2, "deliverType");
            return (Criteria) this;
        }

        public Criteria andIsRefundIsNull() {
            addCriterion("is_refund is null");
            return (Criteria) this;
        }

        public Criteria andIsRefundIsNotNull() {
            addCriterion("is_refund is not null");
            return (Criteria) this;
        }

        public Criteria andIsRefundEqualTo(Integer value) {
            addCriterion("is_refund =", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundNotEqualTo(Integer value) {
            addCriterion("is_refund <>", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundGreaterThan(Integer value) {
            addCriterion("is_refund >", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_refund >=", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundLessThan(Integer value) {
            addCriterion("is_refund <", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundLessThanOrEqualTo(Integer value) {
            addCriterion("is_refund <=", value, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundIn(List<Integer> values) {
            addCriterion("is_refund in", values, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundNotIn(List<Integer> values) {
            addCriterion("is_refund not in", values, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundBetween(Integer value1, Integer value2) {
            addCriterion("is_refund between", value1, value2, "isRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundNotBetween(Integer value1, Integer value2) {
            addCriterion("is_refund not between", value1, value2, "isRefund");
            return (Criteria) this;
        }

        public Criteria andDeliverMoneyIsNull() {
            addCriterion("deliver_money is null");
            return (Criteria) this;
        }

        public Criteria andDeliverMoneyIsNotNull() {
            addCriterion("deliver_money is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverMoneyEqualTo(BigDecimal value) {
            addCriterion("deliver_money =", value, "deliverMoney");
            return (Criteria) this;
        }

        public Criteria andDeliverMoneyNotEqualTo(BigDecimal value) {
            addCriterion("deliver_money <>", value, "deliverMoney");
            return (Criteria) this;
        }

        public Criteria andDeliverMoneyGreaterThan(BigDecimal value) {
            addCriterion("deliver_money >", value, "deliverMoney");
            return (Criteria) this;
        }

        public Criteria andDeliverMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deliver_money >=", value, "deliverMoney");
            return (Criteria) this;
        }

        public Criteria andDeliverMoneyLessThan(BigDecimal value) {
            addCriterion("deliver_money <", value, "deliverMoney");
            return (Criteria) this;
        }

        public Criteria andDeliverMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deliver_money <=", value, "deliverMoney");
            return (Criteria) this;
        }

        public Criteria andDeliverMoneyIn(List<BigDecimal> values) {
            addCriterion("deliver_money in", values, "deliverMoney");
            return (Criteria) this;
        }

        public Criteria andDeliverMoneyNotIn(List<BigDecimal> values) {
            addCriterion("deliver_money not in", values, "deliverMoney");
            return (Criteria) this;
        }

        public Criteria andDeliverMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deliver_money between", value1, value2, "deliverMoney");
            return (Criteria) this;
        }

        public Criteria andDeliverMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deliver_money not between", value1, value2, "deliverMoney");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseIsNull() {
            addCriterion("is_appraise is null");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseIsNotNull() {
            addCriterion("is_appraise is not null");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseEqualTo(Integer value) {
            addCriterion("is_appraise =", value, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseNotEqualTo(Integer value) {
            addCriterion("is_appraise <>", value, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseGreaterThan(Integer value) {
            addCriterion("is_appraise >", value, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_appraise >=", value, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseLessThan(Integer value) {
            addCriterion("is_appraise <", value, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseLessThanOrEqualTo(Integer value) {
            addCriterion("is_appraise <=", value, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseIn(List<Integer> values) {
            addCriterion("is_appraise in", values, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseNotIn(List<Integer> values) {
            addCriterion("is_appraise not in", values, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseBetween(Integer value1, Integer value2) {
            addCriterion("is_appraise between", value1, value2, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andIsAppraiseNotBetween(Integer value1, Integer value2) {
            addCriterion("is_appraise not between", value1, value2, "isAppraise");
            return (Criteria) this;
        }

        public Criteria andRejectOtherReasonIsNull() {
            addCriterion("reject_other_reason is null");
            return (Criteria) this;
        }

        public Criteria andRejectOtherReasonIsNotNull() {
            addCriterion("reject_other_reason is not null");
            return (Criteria) this;
        }

        public Criteria andRejectOtherReasonEqualTo(String value) {
            addCriterion("reject_other_reason =", value, "rejectOtherReason");
            return (Criteria) this;
        }

        public Criteria andRejectOtherReasonNotEqualTo(String value) {
            addCriterion("reject_other_reason <>", value, "rejectOtherReason");
            return (Criteria) this;
        }

        public Criteria andRejectOtherReasonGreaterThan(String value) {
            addCriterion("reject_other_reason >", value, "rejectOtherReason");
            return (Criteria) this;
        }

        public Criteria andRejectOtherReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reject_other_reason >=", value, "rejectOtherReason");
            return (Criteria) this;
        }

        public Criteria andRejectOtherReasonLessThan(String value) {
            addCriterion("reject_other_reason <", value, "rejectOtherReason");
            return (Criteria) this;
        }

        public Criteria andRejectOtherReasonLessThanOrEqualTo(String value) {
            addCriterion("reject_other_reason <=", value, "rejectOtherReason");
            return (Criteria) this;
        }

        public Criteria andRejectOtherReasonLike(String value) {
            addCriterion("reject_other_reason like", value, "rejectOtherReason");
            return (Criteria) this;
        }

        public Criteria andRejectOtherReasonNotLike(String value) {
            addCriterion("reject_other_reason not like", value, "rejectOtherReason");
            return (Criteria) this;
        }

        public Criteria andRejectOtherReasonIn(List<String> values) {
            addCriterion("reject_other_reason in", values, "rejectOtherReason");
            return (Criteria) this;
        }

        public Criteria andRejectOtherReasonNotIn(List<String> values) {
            addCriterion("reject_other_reason not in", values, "rejectOtherReason");
            return (Criteria) this;
        }

        public Criteria andRejectOtherReasonBetween(String value1, String value2) {
            addCriterion("reject_other_reason between", value1, value2, "rejectOtherReason");
            return (Criteria) this;
        }

        public Criteria andRejectOtherReasonNotBetween(String value1, String value2) {
            addCriterion("reject_other_reason not between", value1, value2, "rejectOtherReason");
            return (Criteria) this;
        }

        public Criteria andExpressIdIsNull() {
            addCriterion("express_id is null");
            return (Criteria) this;
        }

        public Criteria andExpressIdIsNotNull() {
            addCriterion("express_id is not null");
            return (Criteria) this;
        }

        public Criteria andExpressIdEqualTo(Integer value) {
            addCriterion("express_id =", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdNotEqualTo(Integer value) {
            addCriterion("express_id <>", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdGreaterThan(Integer value) {
            addCriterion("express_id >", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("express_id >=", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdLessThan(Integer value) {
            addCriterion("express_id <", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdLessThanOrEqualTo(Integer value) {
            addCriterion("express_id <=", value, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdIn(List<Integer> values) {
            addCriterion("express_id in", values, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdNotIn(List<Integer> values) {
            addCriterion("express_id not in", values, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdBetween(Integer value1, Integer value2) {
            addCriterion("express_id between", value1, value2, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressIdNotBetween(Integer value1, Integer value2) {
            addCriterion("express_id not between", value1, value2, "expressId");
            return (Criteria) this;
        }

        public Criteria andExpressNoIsNull() {
            addCriterion("express_no is null");
            return (Criteria) this;
        }

        public Criteria andExpressNoIsNotNull() {
            addCriterion("express_no is not null");
            return (Criteria) this;
        }

        public Criteria andExpressNoEqualTo(String value) {
            addCriterion("express_no =", value, "expressNo");
            return (Criteria) this;
        }

        public Criteria andExpressNoNotEqualTo(String value) {
            addCriterion("express_no <>", value, "expressNo");
            return (Criteria) this;
        }

        public Criteria andExpressNoGreaterThan(String value) {
            addCriterion("express_no >", value, "expressNo");
            return (Criteria) this;
        }

        public Criteria andExpressNoGreaterThanOrEqualTo(String value) {
            addCriterion("express_no >=", value, "expressNo");
            return (Criteria) this;
        }

        public Criteria andExpressNoLessThan(String value) {
            addCriterion("express_no <", value, "expressNo");
            return (Criteria) this;
        }

        public Criteria andExpressNoLessThanOrEqualTo(String value) {
            addCriterion("express_no <=", value, "expressNo");
            return (Criteria) this;
        }

        public Criteria andExpressNoLike(String value) {
            addCriterion("express_no like", value, "expressNo");
            return (Criteria) this;
        }

        public Criteria andExpressNoNotLike(String value) {
            addCriterion("express_no not like", value, "expressNo");
            return (Criteria) this;
        }

        public Criteria andExpressNoIn(List<String> values) {
            addCriterion("express_no in", values, "expressNo");
            return (Criteria) this;
        }

        public Criteria andExpressNoNotIn(List<String> values) {
            addCriterion("express_no not in", values, "expressNo");
            return (Criteria) this;
        }

        public Criteria andExpressNoBetween(String value1, String value2) {
            addCriterion("express_no between", value1, value2, "expressNo");
            return (Criteria) this;
        }

        public Criteria andExpressNoNotBetween(String value1, String value2) {
            addCriterion("express_no not between", value1, value2, "expressNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNull() {
            addCriterion("trade_no is null");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNotNull() {
            addCriterion("trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNoEqualTo(String value) {
            addCriterion("trade_no =", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotEqualTo(String value) {
            addCriterion("trade_no <>", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThan(String value) {
            addCriterion("trade_no >", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("trade_no >=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThan(String value) {
            addCriterion("trade_no <", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThanOrEqualTo(String value) {
            addCriterion("trade_no <=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLike(String value) {
            addCriterion("trade_no like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotLike(String value) {
            addCriterion("trade_no not like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIn(List<String> values) {
            addCriterion("trade_no in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotIn(List<String> values) {
            addCriterion("trade_no not in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoBetween(String value1, String value2) {
            addCriterion("trade_no between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotBetween(String value1, String value2) {
            addCriterion("trade_no not between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andShowInUserIsNull() {
            addCriterion("show_in_user is null");
            return (Criteria) this;
        }

        public Criteria andShowInUserIsNotNull() {
            addCriterion("show_in_user is not null");
            return (Criteria) this;
        }

        public Criteria andShowInUserEqualTo(Integer value) {
            addCriterion("show_in_user =", value, "showInUser");
            return (Criteria) this;
        }

        public Criteria andShowInUserNotEqualTo(Integer value) {
            addCriterion("show_in_user <>", value, "showInUser");
            return (Criteria) this;
        }

        public Criteria andShowInUserGreaterThan(Integer value) {
            addCriterion("show_in_user >", value, "showInUser");
            return (Criteria) this;
        }

        public Criteria andShowInUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_in_user >=", value, "showInUser");
            return (Criteria) this;
        }

        public Criteria andShowInUserLessThan(Integer value) {
            addCriterion("show_in_user <", value, "showInUser");
            return (Criteria) this;
        }

        public Criteria andShowInUserLessThanOrEqualTo(Integer value) {
            addCriterion("show_in_user <=", value, "showInUser");
            return (Criteria) this;
        }

        public Criteria andShowInUserIn(List<Integer> values) {
            addCriterion("show_in_user in", values, "showInUser");
            return (Criteria) this;
        }

        public Criteria andShowInUserNotIn(List<Integer> values) {
            addCriterion("show_in_user not in", values, "showInUser");
            return (Criteria) this;
        }

        public Criteria andShowInUserBetween(Integer value1, Integer value2) {
            addCriterion("show_in_user between", value1, value2, "showInUser");
            return (Criteria) this;
        }

        public Criteria andShowInUserNotBetween(Integer value1, Integer value2) {
            addCriterion("show_in_user not between", value1, value2, "showInUser");
            return (Criteria) this;
        }

        public Criteria andLifuTotalPriceIsNull() {
            addCriterion("lifu_total_price is null");
            return (Criteria) this;
        }

        public Criteria andLifuTotalPriceIsNotNull() {
            addCriterion("lifu_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andLifuTotalPriceEqualTo(BigDecimal value) {
            addCriterion("lifu_total_price =", value, "lifuTotalPrice");
            return (Criteria) this;
        }

        public Criteria andLifuTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("lifu_total_price <>", value, "lifuTotalPrice");
            return (Criteria) this;
        }

        public Criteria andLifuTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("lifu_total_price >", value, "lifuTotalPrice");
            return (Criteria) this;
        }

        public Criteria andLifuTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("lifu_total_price >=", value, "lifuTotalPrice");
            return (Criteria) this;
        }

        public Criteria andLifuTotalPriceLessThan(BigDecimal value) {
            addCriterion("lifu_total_price <", value, "lifuTotalPrice");
            return (Criteria) this;
        }

        public Criteria andLifuTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("lifu_total_price <=", value, "lifuTotalPrice");
            return (Criteria) this;
        }

        public Criteria andLifuTotalPriceIn(List<BigDecimal> values) {
            addCriterion("lifu_total_price in", values, "lifuTotalPrice");
            return (Criteria) this;
        }

        public Criteria andLifuTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("lifu_total_price not in", values, "lifuTotalPrice");
            return (Criteria) this;
        }

        public Criteria andLifuTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lifu_total_price between", value1, value2, "lifuTotalPrice");
            return (Criteria) this;
        }

        public Criteria andLifuTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("lifu_total_price not between", value1, value2, "lifuTotalPrice");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyIsNull() {
            addCriterion("real_total_money is null");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyIsNotNull() {
            addCriterion("real_total_money is not null");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyEqualTo(BigDecimal value) {
            addCriterion("real_total_money =", value, "realTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyNotEqualTo(BigDecimal value) {
            addCriterion("real_total_money <>", value, "realTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyGreaterThan(BigDecimal value) {
            addCriterion("real_total_money >", value, "realTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_total_money >=", value, "realTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyLessThan(BigDecimal value) {
            addCriterion("real_total_money <", value, "realTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_total_money <=", value, "realTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyIn(List<BigDecimal> values) {
            addCriterion("real_total_money in", values, "realTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyNotIn(List<BigDecimal> values) {
            addCriterion("real_total_money not in", values, "realTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_total_money between", value1, value2, "realTotalMoney");
            return (Criteria) this;
        }

        public Criteria andRealTotalMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_total_money not between", value1, value2, "realTotalMoney");
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