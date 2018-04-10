package com.qudian.pay.ares.dao.entity.local;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FinancingCostExample extends PageInfoPOA{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FinancingCostExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andChannelTypeIsNull() {
            addCriterion("channel_type is null");
            return (Criteria) this;
        }

        public Criteria andChannelTypeIsNotNull() {
            addCriterion("channel_type is not null");
            return (Criteria) this;
        }

        public Criteria andChannelTypeEqualTo(Byte value) {
            addCriterion("channel_type =", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeNotEqualTo(Byte value) {
            addCriterion("channel_type <>", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeGreaterThan(Byte value) {
            addCriterion("channel_type >", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("channel_type >=", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeLessThan(Byte value) {
            addCriterion("channel_type <", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeLessThanOrEqualTo(Byte value) {
            addCriterion("channel_type <=", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeIn(List<Byte> values) {
            addCriterion("channel_type in", values, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeNotIn(List<Byte> values) {
            addCriterion("channel_type not in", values, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeBetween(Byte value1, Byte value2) {
            addCriterion("channel_type between", value1, value2, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("channel_type not between", value1, value2, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelNameIsNull() {
            addCriterion("channel_name is null");
            return (Criteria) this;
        }

        public Criteria andChannelNameIsNotNull() {
            addCriterion("channel_name is not null");
            return (Criteria) this;
        }

        public Criteria andChannelNameEqualTo(String value) {
            addCriterion("channel_name =", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotEqualTo(String value) {
            addCriterion("channel_name <>", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameGreaterThan(String value) {
            addCriterion("channel_name >", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameGreaterThanOrEqualTo(String value) {
            addCriterion("channel_name >=", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLessThan(String value) {
            addCriterion("channel_name <", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLessThanOrEqualTo(String value) {
            addCriterion("channel_name <=", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLike(String value) {
            addCriterion("channel_name like", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotLike(String value) {
            addCriterion("channel_name not like", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameIn(List<String> values) {
            addCriterion("channel_name in", values, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotIn(List<String> values) {
            addCriterion("channel_name not in", values, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameBetween(String value1, String value2) {
            addCriterion("channel_name between", value1, value2, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotBetween(String value1, String value2) {
            addCriterion("channel_name not between", value1, value2, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(Integer value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(Integer value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(Integer value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(Integer value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(Integer value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<Integer> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<Integer> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(Integer value1, Integer value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelClassifiedIsNull() {
            addCriterion("channel_classified is null");
            return (Criteria) this;
        }

        public Criteria andChannelClassifiedIsNotNull() {
            addCriterion("channel_classified is not null");
            return (Criteria) this;
        }

        public Criteria andChannelClassifiedEqualTo(Integer value) {
            addCriterion("channel_classified =", value, "channelClassified");
            return (Criteria) this;
        }

        public Criteria andChannelClassifiedNotEqualTo(Integer value) {
            addCriterion("channel_classified <>", value, "channelClassified");
            return (Criteria) this;
        }

        public Criteria andChannelClassifiedGreaterThan(Integer value) {
            addCriterion("channel_classified >", value, "channelClassified");
            return (Criteria) this;
        }

        public Criteria andChannelClassifiedGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel_classified >=", value, "channelClassified");
            return (Criteria) this;
        }

        public Criteria andChannelClassifiedLessThan(Integer value) {
            addCriterion("channel_classified <", value, "channelClassified");
            return (Criteria) this;
        }

        public Criteria andChannelClassifiedLessThanOrEqualTo(Integer value) {
            addCriterion("channel_classified <=", value, "channelClassified");
            return (Criteria) this;
        }

        public Criteria andChannelClassifiedIn(List<Integer> values) {
            addCriterion("channel_classified in", values, "channelClassified");
            return (Criteria) this;
        }

        public Criteria andChannelClassifiedNotIn(List<Integer> values) {
            addCriterion("channel_classified not in", values, "channelClassified");
            return (Criteria) this;
        }

        public Criteria andChannelClassifiedBetween(Integer value1, Integer value2) {
            addCriterion("channel_classified between", value1, value2, "channelClassified");
            return (Criteria) this;
        }

        public Criteria andChannelClassifiedNotBetween(Integer value1, Integer value2) {
            addCriterion("channel_classified not between", value1, value2, "channelClassified");
            return (Criteria) this;
        }

        public Criteria andRepayMethodIsNull() {
            addCriterion("repay_method is null");
            return (Criteria) this;
        }

        public Criteria andRepayMethodIsNotNull() {
            addCriterion("repay_method is not null");
            return (Criteria) this;
        }

        public Criteria andRepayMethodEqualTo(Byte value) {
            addCriterion("repay_method =", value, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andRepayMethodNotEqualTo(Byte value) {
            addCriterion("repay_method <>", value, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andRepayMethodGreaterThan(Byte value) {
            addCriterion("repay_method >", value, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andRepayMethodGreaterThanOrEqualTo(Byte value) {
            addCriterion("repay_method >=", value, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andRepayMethodLessThan(Byte value) {
            addCriterion("repay_method <", value, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andRepayMethodLessThanOrEqualTo(Byte value) {
            addCriterion("repay_method <=", value, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andRepayMethodIn(List<Byte> values) {
            addCriterion("repay_method in", values, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andRepayMethodNotIn(List<Byte> values) {
            addCriterion("repay_method not in", values, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andRepayMethodBetween(Byte value1, Byte value2) {
            addCriterion("repay_method between", value1, value2, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andRepayMethodNotBetween(Byte value1, Byte value2) {
            addCriterion("repay_method not between", value1, value2, "repayMethod");
            return (Criteria) this;
        }

        public Criteria andRepayRateIsNull() {
            addCriterion("repay_rate is null");
            return (Criteria) this;
        }

        public Criteria andRepayRateIsNotNull() {
            addCriterion("repay_rate is not null");
            return (Criteria) this;
        }

        public Criteria andRepayRateEqualTo(BigDecimal value) {
            addCriterion("repay_rate =", value, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateNotEqualTo(BigDecimal value) {
            addCriterion("repay_rate <>", value, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateGreaterThan(BigDecimal value) {
            addCriterion("repay_rate >", value, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repay_rate >=", value, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateLessThan(BigDecimal value) {
            addCriterion("repay_rate <", value, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repay_rate <=", value, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateIn(List<BigDecimal> values) {
            addCriterion("repay_rate in", values, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateNotIn(List<BigDecimal> values) {
            addCriterion("repay_rate not in", values, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repay_rate between", value1, value2, "repayRate");
            return (Criteria) this;
        }

        public Criteria andRepayRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repay_rate not between", value1, value2, "repayRate");
            return (Criteria) this;
        }

        public Criteria andLoanDayIsNull() {
            addCriterion("loan_day is null");
            return (Criteria) this;
        }

        public Criteria andLoanDayIsNotNull() {
            addCriterion("loan_day is not null");
            return (Criteria) this;
        }

        public Criteria andLoanDayEqualTo(Date value) {
            addCriterionForJDBCDate("loan_day =", value, "loanDay");
            return (Criteria) this;
        }

        public Criteria andLoanDayNotEqualTo(Date value) {
            addCriterionForJDBCDate("loan_day <>", value, "loanDay");
            return (Criteria) this;
        }

        public Criteria andLoanDayGreaterThan(Date value) {
            addCriterionForJDBCDate("loan_day >", value, "loanDay");
            return (Criteria) this;
        }

        public Criteria andLoanDayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("loan_day >=", value, "loanDay");
            return (Criteria) this;
        }

        public Criteria andLoanDayLessThan(Date value) {
            addCriterionForJDBCDate("loan_day <", value, "loanDay");
            return (Criteria) this;
        }

        public Criteria andLoanDayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("loan_day <=", value, "loanDay");
            return (Criteria) this;
        }

        public Criteria andLoanDayIn(List<Date> values) {
            addCriterionForJDBCDate("loan_day in", values, "loanDay");
            return (Criteria) this;
        }

        public Criteria andLoanDayNotIn(List<Date> values) {
            addCriterionForJDBCDate("loan_day not in", values, "loanDay");
            return (Criteria) this;
        }

        public Criteria andLoanDayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("loan_day between", value1, value2, "loanDay");
            return (Criteria) this;
        }

        public Criteria andLoanDayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("loan_day not between", value1, value2, "loanDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayIsNull() {
            addCriterion("repay_day is null");
            return (Criteria) this;
        }

        public Criteria andRepayDayIsNotNull() {
            addCriterion("repay_day is not null");
            return (Criteria) this;
        }

        public Criteria andRepayDayEqualTo(Date value) {
            addCriterionForJDBCDate("repay_day =", value, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayNotEqualTo(Date value) {
            addCriterionForJDBCDate("repay_day <>", value, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayGreaterThan(Date value) {
            addCriterionForJDBCDate("repay_day >", value, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("repay_day >=", value, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayLessThan(Date value) {
            addCriterionForJDBCDate("repay_day <", value, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("repay_day <=", value, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayIn(List<Date> values) {
            addCriterionForJDBCDate("repay_day in", values, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayNotIn(List<Date> values) {
            addCriterionForJDBCDate("repay_day not in", values, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("repay_day between", value1, value2, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("repay_day not between", value1, value2, "repayDay");
            return (Criteria) this;
        }

        public Criteria andInterestTypeIsNull() {
            addCriterion("interest_type is null");
            return (Criteria) this;
        }

        public Criteria andInterestTypeIsNotNull() {
            addCriterion("interest_type is not null");
            return (Criteria) this;
        }

        public Criteria andInterestTypeEqualTo(Byte value) {
            addCriterion("interest_type =", value, "interestType");
            return (Criteria) this;
        }

        public Criteria andInterestTypeNotEqualTo(Byte value) {
            addCriterion("interest_type <>", value, "interestType");
            return (Criteria) this;
        }

        public Criteria andInterestTypeGreaterThan(Byte value) {
            addCriterion("interest_type >", value, "interestType");
            return (Criteria) this;
        }

        public Criteria andInterestTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("interest_type >=", value, "interestType");
            return (Criteria) this;
        }

        public Criteria andInterestTypeLessThan(Byte value) {
            addCriterion("interest_type <", value, "interestType");
            return (Criteria) this;
        }

        public Criteria andInterestTypeLessThanOrEqualTo(Byte value) {
            addCriterion("interest_type <=", value, "interestType");
            return (Criteria) this;
        }

        public Criteria andInterestTypeIn(List<Byte> values) {
            addCriterion("interest_type in", values, "interestType");
            return (Criteria) this;
        }

        public Criteria andInterestTypeNotIn(List<Byte> values) {
            addCriterion("interest_type not in", values, "interestType");
            return (Criteria) this;
        }

        public Criteria andInterestTypeBetween(Byte value1, Byte value2) {
            addCriterion("interest_type between", value1, value2, "interestType");
            return (Criteria) this;
        }

        public Criteria andInterestTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("interest_type not between", value1, value2, "interestType");
            return (Criteria) this;
        }

        public Criteria andTermIsNull() {
            addCriterion("term is null");
            return (Criteria) this;
        }

        public Criteria andTermIsNotNull() {
            addCriterion("term is not null");
            return (Criteria) this;
        }

        public Criteria andTermEqualTo(Byte value) {
            addCriterion("term =", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotEqualTo(Byte value) {
            addCriterion("term <>", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThan(Byte value) {
            addCriterion("term >", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThanOrEqualTo(Byte value) {
            addCriterion("term >=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThan(Byte value) {
            addCriterion("term <", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThanOrEqualTo(Byte value) {
            addCriterion("term <=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermIn(List<Byte> values) {
            addCriterion("term in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotIn(List<Byte> values) {
            addCriterion("term not in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermBetween(Byte value1, Byte value2) {
            addCriterion("term between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotBetween(Byte value1, Byte value2) {
            addCriterion("term not between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andTermNumberIsNull() {
            addCriterion("term_number is null");
            return (Criteria) this;
        }

        public Criteria andTermNumberIsNotNull() {
            addCriterion("term_number is not null");
            return (Criteria) this;
        }

        public Criteria andTermNumberEqualTo(Byte value) {
            addCriterion("term_number =", value, "termNumber");
            return (Criteria) this;
        }

        public Criteria andTermNumberNotEqualTo(Byte value) {
            addCriterion("term_number <>", value, "termNumber");
            return (Criteria) this;
        }

        public Criteria andTermNumberGreaterThan(Byte value) {
            addCriterion("term_number >", value, "termNumber");
            return (Criteria) this;
        }

        public Criteria andTermNumberGreaterThanOrEqualTo(Byte value) {
            addCriterion("term_number >=", value, "termNumber");
            return (Criteria) this;
        }

        public Criteria andTermNumberLessThan(Byte value) {
            addCriterion("term_number <", value, "termNumber");
            return (Criteria) this;
        }

        public Criteria andTermNumberLessThanOrEqualTo(Byte value) {
            addCriterion("term_number <=", value, "termNumber");
            return (Criteria) this;
        }

        public Criteria andTermNumberIn(List<Byte> values) {
            addCriterion("term_number in", values, "termNumber");
            return (Criteria) this;
        }

        public Criteria andTermNumberNotIn(List<Byte> values) {
            addCriterion("term_number not in", values, "termNumber");
            return (Criteria) this;
        }

        public Criteria andTermNumberBetween(Byte value1, Byte value2) {
            addCriterion("term_number between", value1, value2, "termNumber");
            return (Criteria) this;
        }

        public Criteria andTermNumberNotBetween(Byte value1, Byte value2) {
            addCriterion("term_number not between", value1, value2, "termNumber");
            return (Criteria) this;
        }

        public Criteria andLoanCapitalIsNull() {
            addCriterion("loan_capital is null");
            return (Criteria) this;
        }

        public Criteria andLoanCapitalIsNotNull() {
            addCriterion("loan_capital is not null");
            return (Criteria) this;
        }

        public Criteria andLoanCapitalEqualTo(BigDecimal value) {
            addCriterion("loan_capital =", value, "loanCapital");
            return (Criteria) this;
        }

        public Criteria andLoanCapitalNotEqualTo(BigDecimal value) {
            addCriterion("loan_capital <>", value, "loanCapital");
            return (Criteria) this;
        }

        public Criteria andLoanCapitalGreaterThan(BigDecimal value) {
            addCriterion("loan_capital >", value, "loanCapital");
            return (Criteria) this;
        }

        public Criteria andLoanCapitalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_capital >=", value, "loanCapital");
            return (Criteria) this;
        }

        public Criteria andLoanCapitalLessThan(BigDecimal value) {
            addCriterion("loan_capital <", value, "loanCapital");
            return (Criteria) this;
        }

        public Criteria andLoanCapitalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("loan_capital <=", value, "loanCapital");
            return (Criteria) this;
        }

        public Criteria andLoanCapitalIn(List<BigDecimal> values) {
            addCriterion("loan_capital in", values, "loanCapital");
            return (Criteria) this;
        }

        public Criteria andLoanCapitalNotIn(List<BigDecimal> values) {
            addCriterion("loan_capital not in", values, "loanCapital");
            return (Criteria) this;
        }

        public Criteria andLoanCapitalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_capital between", value1, value2, "loanCapital");
            return (Criteria) this;
        }

        public Criteria andLoanCapitalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("loan_capital not between", value1, value2, "loanCapital");
            return (Criteria) this;
        }

        public Criteria andYinghuanLixiIsNull() {
            addCriterion("yinghuan_lixi is null");
            return (Criteria) this;
        }

        public Criteria andYinghuanLixiIsNotNull() {
            addCriterion("yinghuan_lixi is not null");
            return (Criteria) this;
        }

        public Criteria andYinghuanLixiEqualTo(BigDecimal value) {
            addCriterion("yinghuan_lixi =", value, "yinghuanLixi");
            return (Criteria) this;
        }

        public Criteria andYinghuanLixiNotEqualTo(BigDecimal value) {
            addCriterion("yinghuan_lixi <>", value, "yinghuanLixi");
            return (Criteria) this;
        }

        public Criteria andYinghuanLixiGreaterThan(BigDecimal value) {
            addCriterion("yinghuan_lixi >", value, "yinghuanLixi");
            return (Criteria) this;
        }

        public Criteria andYinghuanLixiGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("yinghuan_lixi >=", value, "yinghuanLixi");
            return (Criteria) this;
        }

        public Criteria andYinghuanLixiLessThan(BigDecimal value) {
            addCriterion("yinghuan_lixi <", value, "yinghuanLixi");
            return (Criteria) this;
        }

        public Criteria andYinghuanLixiLessThanOrEqualTo(BigDecimal value) {
            addCriterion("yinghuan_lixi <=", value, "yinghuanLixi");
            return (Criteria) this;
        }

        public Criteria andYinghuanLixiIn(List<BigDecimal> values) {
            addCriterion("yinghuan_lixi in", values, "yinghuanLixi");
            return (Criteria) this;
        }

        public Criteria andYinghuanLixiNotIn(List<BigDecimal> values) {
            addCriterion("yinghuan_lixi not in", values, "yinghuanLixi");
            return (Criteria) this;
        }

        public Criteria andYinghuanLixiBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("yinghuan_lixi between", value1, value2, "yinghuanLixi");
            return (Criteria) this;
        }

        public Criteria andYinghuanLixiNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("yinghuan_lixi not between", value1, value2, "yinghuanLixi");
            return (Criteria) this;
        }

        public Criteria andShengyuCapitalIsNull() {
            addCriterion("shengyu_capital is null");
            return (Criteria) this;
        }

        public Criteria andShengyuCapitalIsNotNull() {
            addCriterion("shengyu_capital is not null");
            return (Criteria) this;
        }

        public Criteria andShengyuCapitalEqualTo(BigDecimal value) {
            addCriterion("shengyu_capital =", value, "shengyuCapital");
            return (Criteria) this;
        }

        public Criteria andShengyuCapitalNotEqualTo(BigDecimal value) {
            addCriterion("shengyu_capital <>", value, "shengyuCapital");
            return (Criteria) this;
        }

        public Criteria andShengyuCapitalGreaterThan(BigDecimal value) {
            addCriterion("shengyu_capital >", value, "shengyuCapital");
            return (Criteria) this;
        }

        public Criteria andShengyuCapitalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("shengyu_capital >=", value, "shengyuCapital");
            return (Criteria) this;
        }

        public Criteria andShengyuCapitalLessThan(BigDecimal value) {
            addCriterion("shengyu_capital <", value, "shengyuCapital");
            return (Criteria) this;
        }

        public Criteria andShengyuCapitalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("shengyu_capital <=", value, "shengyuCapital");
            return (Criteria) this;
        }

        public Criteria andShengyuCapitalIn(List<BigDecimal> values) {
            addCriterion("shengyu_capital in", values, "shengyuCapital");
            return (Criteria) this;
        }

        public Criteria andShengyuCapitalNotIn(List<BigDecimal> values) {
            addCriterion("shengyu_capital not in", values, "shengyuCapital");
            return (Criteria) this;
        }

        public Criteria andShengyuCapitalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shengyu_capital between", value1, value2, "shengyuCapital");
            return (Criteria) this;
        }

        public Criteria andShengyuCapitalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shengyu_capital not between", value1, value2, "shengyuCapital");
            return (Criteria) this;
        }

        public Criteria andOtherCostIsNull() {
            addCriterion("other_cost is null");
            return (Criteria) this;
        }

        public Criteria andOtherCostIsNotNull() {
            addCriterion("other_cost is not null");
            return (Criteria) this;
        }

        public Criteria andOtherCostEqualTo(BigDecimal value) {
            addCriterion("other_cost =", value, "otherCost");
            return (Criteria) this;
        }

        public Criteria andOtherCostNotEqualTo(BigDecimal value) {
            addCriterion("other_cost <>", value, "otherCost");
            return (Criteria) this;
        }

        public Criteria andOtherCostGreaterThan(BigDecimal value) {
            addCriterion("other_cost >", value, "otherCost");
            return (Criteria) this;
        }

        public Criteria andOtherCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("other_cost >=", value, "otherCost");
            return (Criteria) this;
        }

        public Criteria andOtherCostLessThan(BigDecimal value) {
            addCriterion("other_cost <", value, "otherCost");
            return (Criteria) this;
        }

        public Criteria andOtherCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("other_cost <=", value, "otherCost");
            return (Criteria) this;
        }

        public Criteria andOtherCostIn(List<BigDecimal> values) {
            addCriterion("other_cost in", values, "otherCost");
            return (Criteria) this;
        }

        public Criteria andOtherCostNotIn(List<BigDecimal> values) {
            addCriterion("other_cost not in", values, "otherCost");
            return (Criteria) this;
        }

        public Criteria andOtherCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_cost between", value1, value2, "otherCost");
            return (Criteria) this;
        }

        public Criteria andOtherCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("other_cost not between", value1, value2, "otherCost");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andOptUserIsNull() {
            addCriterion("opt_user is null");
            return (Criteria) this;
        }

        public Criteria andOptUserIsNotNull() {
            addCriterion("opt_user is not null");
            return (Criteria) this;
        }

        public Criteria andOptUserEqualTo(String value) {
            addCriterion("opt_user =", value, "optUser");
            return (Criteria) this;
        }

        public Criteria andOptUserNotEqualTo(String value) {
            addCriterion("opt_user <>", value, "optUser");
            return (Criteria) this;
        }

        public Criteria andOptUserGreaterThan(String value) {
            addCriterion("opt_user >", value, "optUser");
            return (Criteria) this;
        }

        public Criteria andOptUserGreaterThanOrEqualTo(String value) {
            addCriterion("opt_user >=", value, "optUser");
            return (Criteria) this;
        }

        public Criteria andOptUserLessThan(String value) {
            addCriterion("opt_user <", value, "optUser");
            return (Criteria) this;
        }

        public Criteria andOptUserLessThanOrEqualTo(String value) {
            addCriterion("opt_user <=", value, "optUser");
            return (Criteria) this;
        }

        public Criteria andOptUserLike(String value) {
            addCriterion("opt_user like", value, "optUser");
            return (Criteria) this;
        }

        public Criteria andOptUserNotLike(String value) {
            addCriterion("opt_user not like", value, "optUser");
            return (Criteria) this;
        }

        public Criteria andOptUserIn(List<String> values) {
            addCriterion("opt_user in", values, "optUser");
            return (Criteria) this;
        }

        public Criteria andOptUserNotIn(List<String> values) {
            addCriterion("opt_user not in", values, "optUser");
            return (Criteria) this;
        }

        public Criteria andOptUserBetween(String value1, String value2) {
            addCriterion("opt_user between", value1, value2, "optUser");
            return (Criteria) this;
        }

        public Criteria andOptUserNotBetween(String value1, String value2) {
            addCriterion("opt_user not between", value1, value2, "optUser");
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

        public Criteria andExt1IsNull() {
            addCriterion("ext_1 is null");
            return (Criteria) this;
        }

        public Criteria andExt1IsNotNull() {
            addCriterion("ext_1 is not null");
            return (Criteria) this;
        }

        public Criteria andExt1EqualTo(String value) {
            addCriterion("ext_1 =", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotEqualTo(String value) {
            addCriterion("ext_1 <>", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThan(String value) {
            addCriterion("ext_1 >", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThanOrEqualTo(String value) {
            addCriterion("ext_1 >=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThan(String value) {
            addCriterion("ext_1 <", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThanOrEqualTo(String value) {
            addCriterion("ext_1 <=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Like(String value) {
            addCriterion("ext_1 like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotLike(String value) {
            addCriterion("ext_1 not like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1In(List<String> values) {
            addCriterion("ext_1 in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotIn(List<String> values) {
            addCriterion("ext_1 not in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Between(String value1, String value2) {
            addCriterion("ext_1 between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotBetween(String value1, String value2) {
            addCriterion("ext_1 not between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt2IsNull() {
            addCriterion("ext_2 is null");
            return (Criteria) this;
        }

        public Criteria andExt2IsNotNull() {
            addCriterion("ext_2 is not null");
            return (Criteria) this;
        }

        public Criteria andExt2EqualTo(String value) {
            addCriterion("ext_2 =", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotEqualTo(String value) {
            addCriterion("ext_2 <>", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThan(String value) {
            addCriterion("ext_2 >", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThanOrEqualTo(String value) {
            addCriterion("ext_2 >=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThan(String value) {
            addCriterion("ext_2 <", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThanOrEqualTo(String value) {
            addCriterion("ext_2 <=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Like(String value) {
            addCriterion("ext_2 like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotLike(String value) {
            addCriterion("ext_2 not like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2In(List<String> values) {
            addCriterion("ext_2 in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotIn(List<String> values) {
            addCriterion("ext_2 not in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Between(String value1, String value2) {
            addCriterion("ext_2 between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotBetween(String value1, String value2) {
            addCriterion("ext_2 not between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt3IsNull() {
            addCriterion("ext_3 is null");
            return (Criteria) this;
        }

        public Criteria andExt3IsNotNull() {
            addCriterion("ext_3 is not null");
            return (Criteria) this;
        }

        public Criteria andExt3EqualTo(String value) {
            addCriterion("ext_3 =", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotEqualTo(String value) {
            addCriterion("ext_3 <>", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3GreaterThan(String value) {
            addCriterion("ext_3 >", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3GreaterThanOrEqualTo(String value) {
            addCriterion("ext_3 >=", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3LessThan(String value) {
            addCriterion("ext_3 <", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3LessThanOrEqualTo(String value) {
            addCriterion("ext_3 <=", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3Like(String value) {
            addCriterion("ext_3 like", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotLike(String value) {
            addCriterion("ext_3 not like", value, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3In(List<String> values) {
            addCriterion("ext_3 in", values, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotIn(List<String> values) {
            addCriterion("ext_3 not in", values, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3Between(String value1, String value2) {
            addCriterion("ext_3 between", value1, value2, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt3NotBetween(String value1, String value2) {
            addCriterion("ext_3 not between", value1, value2, "ext3");
            return (Criteria) this;
        }

        public Criteria andExt4IsNull() {
            addCriterion("ext_4 is null");
            return (Criteria) this;
        }

        public Criteria andExt4IsNotNull() {
            addCriterion("ext_4 is not null");
            return (Criteria) this;
        }

        public Criteria andExt4EqualTo(String value) {
            addCriterion("ext_4 =", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotEqualTo(String value) {
            addCriterion("ext_4 <>", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4GreaterThan(String value) {
            addCriterion("ext_4 >", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4GreaterThanOrEqualTo(String value) {
            addCriterion("ext_4 >=", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4LessThan(String value) {
            addCriterion("ext_4 <", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4LessThanOrEqualTo(String value) {
            addCriterion("ext_4 <=", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4Like(String value) {
            addCriterion("ext_4 like", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotLike(String value) {
            addCriterion("ext_4 not like", value, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4In(List<String> values) {
            addCriterion("ext_4 in", values, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotIn(List<String> values) {
            addCriterion("ext_4 not in", values, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4Between(String value1, String value2) {
            addCriterion("ext_4 between", value1, value2, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt4NotBetween(String value1, String value2) {
            addCriterion("ext_4 not between", value1, value2, "ext4");
            return (Criteria) this;
        }

        public Criteria andExt5IsNull() {
            addCriterion("ext_5 is null");
            return (Criteria) this;
        }

        public Criteria andExt5IsNotNull() {
            addCriterion("ext_5 is not null");
            return (Criteria) this;
        }

        public Criteria andExt5EqualTo(String value) {
            addCriterion("ext_5 =", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotEqualTo(String value) {
            addCriterion("ext_5 <>", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5GreaterThan(String value) {
            addCriterion("ext_5 >", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5GreaterThanOrEqualTo(String value) {
            addCriterion("ext_5 >=", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5LessThan(String value) {
            addCriterion("ext_5 <", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5LessThanOrEqualTo(String value) {
            addCriterion("ext_5 <=", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5Like(String value) {
            addCriterion("ext_5 like", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotLike(String value) {
            addCriterion("ext_5 not like", value, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5In(List<String> values) {
            addCriterion("ext_5 in", values, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotIn(List<String> values) {
            addCriterion("ext_5 not in", values, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5Between(String value1, String value2) {
            addCriterion("ext_5 between", value1, value2, "ext5");
            return (Criteria) this;
        }

        public Criteria andExt5NotBetween(String value1, String value2) {
            addCriterion("ext_5 not between", value1, value2, "ext5");
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