package com.example.wantlifu.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LifuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LifuExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPicIsNull() {
            addCriterion("pic is null");
            return (Criteria) this;
        }

        public Criteria andPicIsNotNull() {
            addCriterion("pic is not null");
            return (Criteria) this;
        }

        public Criteria andPicEqualTo(String value) {
            addCriterion("pic =", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotEqualTo(String value) {
            addCriterion("pic <>", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThan(String value) {
            addCriterion("pic >", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThanOrEqualTo(String value) {
            addCriterion("pic >=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThan(String value) {
            addCriterion("pic <", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThanOrEqualTo(String value) {
            addCriterion("pic <=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLike(String value) {
            addCriterion("pic like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotLike(String value) {
            addCriterion("pic not like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicIn(List<String> values) {
            addCriterion("pic in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotIn(List<String> values) {
            addCriterion("pic not in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicBetween(String value1, String value2) {
            addCriterion("pic between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotBetween(String value1, String value2) {
            addCriterion("pic not between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andBuyCountIsNull() {
            addCriterion("buy_count is null");
            return (Criteria) this;
        }

        public Criteria andBuyCountIsNotNull() {
            addCriterion("buy_count is not null");
            return (Criteria) this;
        }

        public Criteria andBuyCountEqualTo(Integer value) {
            addCriterion("buy_count =", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountNotEqualTo(Integer value) {
            addCriterion("buy_count <>", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountGreaterThan(Integer value) {
            addCriterion("buy_count >", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_count >=", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountLessThan(Integer value) {
            addCriterion("buy_count <", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountLessThanOrEqualTo(Integer value) {
            addCriterion("buy_count <=", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountIn(List<Integer> values) {
            addCriterion("buy_count in", values, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountNotIn(List<Integer> values) {
            addCriterion("buy_count not in", values, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountBetween(Integer value1, Integer value2) {
            addCriterion("buy_count between", value1, value2, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_count not between", value1, value2, "buyCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNull() {
            addCriterion("comment_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNotNull() {
            addCriterion("comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCountEqualTo(Integer value) {
            addCriterion("comment_count =", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotEqualTo(Integer value) {
            addCriterion("comment_count <>", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThan(Integer value) {
            addCriterion("comment_count >", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_count >=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThan(Integer value) {
            addCriterion("comment_count <", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThanOrEqualTo(Integer value) {
            addCriterion("comment_count <=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIn(List<Integer> values) {
            addCriterion("comment_count in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotIn(List<Integer> values) {
            addCriterion("comment_count not in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountBetween(Integer value1, Integer value2) {
            addCriterion("comment_count between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_count not between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andLoveCountIsNull() {
            addCriterion("love_count is null");
            return (Criteria) this;
        }

        public Criteria andLoveCountIsNotNull() {
            addCriterion("love_count is not null");
            return (Criteria) this;
        }

        public Criteria andLoveCountEqualTo(Integer value) {
            addCriterion("love_count =", value, "loveCount");
            return (Criteria) this;
        }

        public Criteria andLoveCountNotEqualTo(Integer value) {
            addCriterion("love_count <>", value, "loveCount");
            return (Criteria) this;
        }

        public Criteria andLoveCountGreaterThan(Integer value) {
            addCriterion("love_count >", value, "loveCount");
            return (Criteria) this;
        }

        public Criteria andLoveCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("love_count >=", value, "loveCount");
            return (Criteria) this;
        }

        public Criteria andLoveCountLessThan(Integer value) {
            addCriterion("love_count <", value, "loveCount");
            return (Criteria) this;
        }

        public Criteria andLoveCountLessThanOrEqualTo(Integer value) {
            addCriterion("love_count <=", value, "loveCount");
            return (Criteria) this;
        }

        public Criteria andLoveCountIn(List<Integer> values) {
            addCriterion("love_count in", values, "loveCount");
            return (Criteria) this;
        }

        public Criteria andLoveCountNotIn(List<Integer> values) {
            addCriterion("love_count not in", values, "loveCount");
            return (Criteria) this;
        }

        public Criteria andLoveCountBetween(Integer value1, Integer value2) {
            addCriterion("love_count between", value1, value2, "loveCount");
            return (Criteria) this;
        }

        public Criteria andLoveCountNotBetween(Integer value1, Integer value2) {
            addCriterion("love_count not between", value1, value2, "loveCount");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNull() {
            addCriterion("is_hot is null");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNotNull() {
            addCriterion("is_hot is not null");
            return (Criteria) this;
        }

        public Criteria andIsHotEqualTo(Integer value) {
            addCriterion("is_hot =", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotEqualTo(Integer value) {
            addCriterion("is_hot <>", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThan(Integer value) {
            addCriterion("is_hot >", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_hot >=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThan(Integer value) {
            addCriterion("is_hot <", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThanOrEqualTo(Integer value) {
            addCriterion("is_hot <=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotIn(List<Integer> values) {
            addCriterion("is_hot in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotIn(List<Integer> values) {
            addCriterion("is_hot not in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotBetween(Integer value1, Integer value2) {
            addCriterion("is_hot between", value1, value2, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotBetween(Integer value1, Integer value2) {
            addCriterion("is_hot not between", value1, value2, "isHot");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Integer value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Integer value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Integer value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Integer value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Integer value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Integer> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Integer> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Integer value1, Integer value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Integer value1, Integer value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andWarningCountIsNull() {
            addCriterion("warning_count is null");
            return (Criteria) this;
        }

        public Criteria andWarningCountIsNotNull() {
            addCriterion("warning_count is not null");
            return (Criteria) this;
        }

        public Criteria andWarningCountEqualTo(Integer value) {
            addCriterion("warning_count =", value, "warningCount");
            return (Criteria) this;
        }

        public Criteria andWarningCountNotEqualTo(Integer value) {
            addCriterion("warning_count <>", value, "warningCount");
            return (Criteria) this;
        }

        public Criteria andWarningCountGreaterThan(Integer value) {
            addCriterion("warning_count >", value, "warningCount");
            return (Criteria) this;
        }

        public Criteria andWarningCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("warning_count >=", value, "warningCount");
            return (Criteria) this;
        }

        public Criteria andWarningCountLessThan(Integer value) {
            addCriterion("warning_count <", value, "warningCount");
            return (Criteria) this;
        }

        public Criteria andWarningCountLessThanOrEqualTo(Integer value) {
            addCriterion("warning_count <=", value, "warningCount");
            return (Criteria) this;
        }

        public Criteria andWarningCountIn(List<Integer> values) {
            addCriterion("warning_count in", values, "warningCount");
            return (Criteria) this;
        }

        public Criteria andWarningCountNotIn(List<Integer> values) {
            addCriterion("warning_count not in", values, "warningCount");
            return (Criteria) this;
        }

        public Criteria andWarningCountBetween(Integer value1, Integer value2) {
            addCriterion("warning_count between", value1, value2, "warningCount");
            return (Criteria) this;
        }

        public Criteria andWarningCountNotBetween(Integer value1, Integer value2) {
            addCriterion("warning_count not between", value1, value2, "warningCount");
            return (Criteria) this;
        }

        public Criteria andIsNewIsNull() {
            addCriterion("is_new is null");
            return (Criteria) this;
        }

        public Criteria andIsNewIsNotNull() {
            addCriterion("is_new is not null");
            return (Criteria) this;
        }

        public Criteria andIsNewEqualTo(Integer value) {
            addCriterion("is_new =", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewNotEqualTo(Integer value) {
            addCriterion("is_new <>", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewGreaterThan(Integer value) {
            addCriterion("is_new >", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_new >=", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewLessThan(Integer value) {
            addCriterion("is_new <", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewLessThanOrEqualTo(Integer value) {
            addCriterion("is_new <=", value, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewIn(List<Integer> values) {
            addCriterion("is_new in", values, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewNotIn(List<Integer> values) {
            addCriterion("is_new not in", values, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewBetween(Integer value1, Integer value2) {
            addCriterion("is_new between", value1, value2, "isNew");
            return (Criteria) this;
        }

        public Criteria andIsNewNotBetween(Integer value1, Integer value2) {
            addCriterion("is_new not between", value1, value2, "isNew");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andTrademarkIdIsNull() {
            addCriterion("trademark_id is null");
            return (Criteria) this;
        }

        public Criteria andTrademarkIdIsNotNull() {
            addCriterion("trademark_id is not null");
            return (Criteria) this;
        }

        public Criteria andTrademarkIdEqualTo(Integer value) {
            addCriterion("trademark_id =", value, "trademarkId");
            return (Criteria) this;
        }

        public Criteria andTrademarkIdNotEqualTo(Integer value) {
            addCriterion("trademark_id <>", value, "trademarkId");
            return (Criteria) this;
        }

        public Criteria andTrademarkIdGreaterThan(Integer value) {
            addCriterion("trademark_id >", value, "trademarkId");
            return (Criteria) this;
        }

        public Criteria andTrademarkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trademark_id >=", value, "trademarkId");
            return (Criteria) this;
        }

        public Criteria andTrademarkIdLessThan(Integer value) {
            addCriterion("trademark_id <", value, "trademarkId");
            return (Criteria) this;
        }

        public Criteria andTrademarkIdLessThanOrEqualTo(Integer value) {
            addCriterion("trademark_id <=", value, "trademarkId");
            return (Criteria) this;
        }

        public Criteria andTrademarkIdIn(List<Integer> values) {
            addCriterion("trademark_id in", values, "trademarkId");
            return (Criteria) this;
        }

        public Criteria andTrademarkIdNotIn(List<Integer> values) {
            addCriterion("trademark_id not in", values, "trademarkId");
            return (Criteria) this;
        }

        public Criteria andTrademarkIdBetween(Integer value1, Integer value2) {
            addCriterion("trademark_id between", value1, value2, "trademarkId");
            return (Criteria) this;
        }

        public Criteria andTrademarkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trademark_id not between", value1, value2, "trademarkId");
            return (Criteria) this;
        }

        public Criteria andTruePriceIsNull() {
            addCriterion("true_price is null");
            return (Criteria) this;
        }

        public Criteria andTruePriceIsNotNull() {
            addCriterion("true_price is not null");
            return (Criteria) this;
        }

        public Criteria andTruePriceEqualTo(Float value) {
            addCriterion("true_price =", value, "truePrice");
            return (Criteria) this;
        }

        public Criteria andTruePriceNotEqualTo(Float value) {
            addCriterion("true_price <>", value, "truePrice");
            return (Criteria) this;
        }

        public Criteria andTruePriceGreaterThan(Float value) {
            addCriterion("true_price >", value, "truePrice");
            return (Criteria) this;
        }

        public Criteria andTruePriceGreaterThanOrEqualTo(Float value) {
            addCriterion("true_price >=", value, "truePrice");
            return (Criteria) this;
        }

        public Criteria andTruePriceLessThan(Float value) {
            addCriterion("true_price <", value, "truePrice");
            return (Criteria) this;
        }

        public Criteria andTruePriceLessThanOrEqualTo(Float value) {
            addCriterion("true_price <=", value, "truePrice");
            return (Criteria) this;
        }

        public Criteria andTruePriceIn(List<Float> values) {
            addCriterion("true_price in", values, "truePrice");
            return (Criteria) this;
        }

        public Criteria andTruePriceNotIn(List<Float> values) {
            addCriterion("true_price not in", values, "truePrice");
            return (Criteria) this;
        }

        public Criteria andTruePriceBetween(Float value1, Float value2) {
            addCriterion("true_price between", value1, value2, "truePrice");
            return (Criteria) this;
        }

        public Criteria andTruePriceNotBetween(Float value1, Float value2) {
            addCriterion("true_price not between", value1, value2, "truePrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceIsNull() {
            addCriterion("origin_price is null");
            return (Criteria) this;
        }

        public Criteria andOriginPriceIsNotNull() {
            addCriterion("origin_price is not null");
            return (Criteria) this;
        }

        public Criteria andOriginPriceEqualTo(Float value) {
            addCriterion("origin_price =", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceNotEqualTo(Float value) {
            addCriterion("origin_price <>", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceGreaterThan(Float value) {
            addCriterion("origin_price >", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("origin_price >=", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceLessThan(Float value) {
            addCriterion("origin_price <", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceLessThanOrEqualTo(Float value) {
            addCriterion("origin_price <=", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceIn(List<Float> values) {
            addCriterion("origin_price in", values, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceNotIn(List<Float> values) {
            addCriterion("origin_price not in", values, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceBetween(Float value1, Float value2) {
            addCriterion("origin_price between", value1, value2, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceNotBetween(Float value1, Float value2) {
            addCriterion("origin_price not between", value1, value2, "originPrice");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNull() {
            addCriterion("remark1 is null");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNotNull() {
            addCriterion("remark1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark1EqualTo(String value) {
            addCriterion("remark1 =", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotEqualTo(String value) {
            addCriterion("remark1 <>", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThan(String value) {
            addCriterion("remark1 >", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            addCriterion("remark1 >=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThan(String value) {
            addCriterion("remark1 <", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            addCriterion("remark1 <=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Like(String value) {
            addCriterion("remark1 like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotLike(String value) {
            addCriterion("remark1 not like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1In(List<String> values) {
            addCriterion("remark1 in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotIn(List<String> values) {
            addCriterion("remark1 not in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Between(String value1, String value2) {
            addCriterion("remark1 between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            addCriterion("remark1 not between", value1, value2, "remark1");
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

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andCanZuPinIsNull() {
            addCriterion("can_zu_pin is null");
            return (Criteria) this;
        }

        public Criteria andCanZuPinIsNotNull() {
            addCriterion("can_zu_pin is not null");
            return (Criteria) this;
        }

        public Criteria andCanZuPinEqualTo(Integer value) {
            addCriterion("can_zu_pin =", value, "canZuPin");
            return (Criteria) this;
        }

        public Criteria andCanZuPinNotEqualTo(Integer value) {
            addCriterion("can_zu_pin <>", value, "canZuPin");
            return (Criteria) this;
        }

        public Criteria andCanZuPinGreaterThan(Integer value) {
            addCriterion("can_zu_pin >", value, "canZuPin");
            return (Criteria) this;
        }

        public Criteria andCanZuPinGreaterThanOrEqualTo(Integer value) {
            addCriterion("can_zu_pin >=", value, "canZuPin");
            return (Criteria) this;
        }

        public Criteria andCanZuPinLessThan(Integer value) {
            addCriterion("can_zu_pin <", value, "canZuPin");
            return (Criteria) this;
        }

        public Criteria andCanZuPinLessThanOrEqualTo(Integer value) {
            addCriterion("can_zu_pin <=", value, "canZuPin");
            return (Criteria) this;
        }

        public Criteria andCanZuPinIn(List<Integer> values) {
            addCriterion("can_zu_pin in", values, "canZuPin");
            return (Criteria) this;
        }

        public Criteria andCanZuPinNotIn(List<Integer> values) {
            addCriterion("can_zu_pin not in", values, "canZuPin");
            return (Criteria) this;
        }

        public Criteria andCanZuPinBetween(Integer value1, Integer value2) {
            addCriterion("can_zu_pin between", value1, value2, "canZuPin");
            return (Criteria) this;
        }

        public Criteria andCanZuPinNotBetween(Integer value1, Integer value2) {
            addCriterion("can_zu_pin not between", value1, value2, "canZuPin");
            return (Criteria) this;
        }

        public Criteria andShowInIndexIsNull() {
            addCriterion("show_in_index is null");
            return (Criteria) this;
        }

        public Criteria andShowInIndexIsNotNull() {
            addCriterion("show_in_index is not null");
            return (Criteria) this;
        }

        public Criteria andShowInIndexEqualTo(Integer value) {
            addCriterion("show_in_index =", value, "showInIndex");
            return (Criteria) this;
        }

        public Criteria andShowInIndexNotEqualTo(Integer value) {
            addCriterion("show_in_index <>", value, "showInIndex");
            return (Criteria) this;
        }

        public Criteria andShowInIndexGreaterThan(Integer value) {
            addCriterion("show_in_index >", value, "showInIndex");
            return (Criteria) this;
        }

        public Criteria andShowInIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_in_index >=", value, "showInIndex");
            return (Criteria) this;
        }

        public Criteria andShowInIndexLessThan(Integer value) {
            addCriterion("show_in_index <", value, "showInIndex");
            return (Criteria) this;
        }

        public Criteria andShowInIndexLessThanOrEqualTo(Integer value) {
            addCriterion("show_in_index <=", value, "showInIndex");
            return (Criteria) this;
        }

        public Criteria andShowInIndexIn(List<Integer> values) {
            addCriterion("show_in_index in", values, "showInIndex");
            return (Criteria) this;
        }

        public Criteria andShowInIndexNotIn(List<Integer> values) {
            addCriterion("show_in_index not in", values, "showInIndex");
            return (Criteria) this;
        }

        public Criteria andShowInIndexBetween(Integer value1, Integer value2) {
            addCriterion("show_in_index between", value1, value2, "showInIndex");
            return (Criteria) this;
        }

        public Criteria andShowInIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("show_in_index not between", value1, value2, "showInIndex");
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