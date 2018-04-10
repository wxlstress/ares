package com.qudian.pay.ares.dao.entity.laifenqi;

import com.qudian.pay.ares.dao.entity.local.PageInfoPO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersExample extends PageInfoPO<Orders>{ protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNull() {
            addCriterion("province_id is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNotNull() {
            addCriterion("province_id is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdEqualTo(Integer value) {
            addCriterion("province_id =", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotEqualTo(Integer value) {
            addCriterion("province_id <>", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThan(Integer value) {
            addCriterion("province_id >", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("province_id >=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThan(Integer value) {
            addCriterion("province_id <", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThanOrEqualTo(Integer value) {
            addCriterion("province_id <=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIn(List<Integer> values) {
            addCriterion("province_id in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotIn(List<Integer> values) {
            addCriterion("province_id not in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdBetween(Integer value1, Integer value2) {
            addCriterion("province_id between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("province_id not between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(Integer value) {
            addCriterion("city_id =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(Integer value) {
            addCriterion("city_id <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(Integer value) {
            addCriterion("city_id >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_id >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(Integer value) {
            addCriterion("city_id <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("city_id <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<Integer> values) {
            addCriterion("city_id in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<Integer> values) {
            addCriterion("city_id not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(Integer value1, Integer value2) {
            addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("city_id not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Integer value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Integer value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Integer value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Integer value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Integer> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Integer> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
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

        public Criteria andNewAddressIsNull() {
            addCriterion("new_address is null");
            return (Criteria) this;
        }

        public Criteria andNewAddressIsNotNull() {
            addCriterion("new_address is not null");
            return (Criteria) this;
        }

        public Criteria andNewAddressEqualTo(String value) {
            addCriterion("new_address =", value, "newAddress");
            return (Criteria) this;
        }

        public Criteria andNewAddressNotEqualTo(String value) {
            addCriterion("new_address <>", value, "newAddress");
            return (Criteria) this;
        }

        public Criteria andNewAddressGreaterThan(String value) {
            addCriterion("new_address >", value, "newAddress");
            return (Criteria) this;
        }

        public Criteria andNewAddressGreaterThanOrEqualTo(String value) {
            addCriterion("new_address >=", value, "newAddress");
            return (Criteria) this;
        }

        public Criteria andNewAddressLessThan(String value) {
            addCriterion("new_address <", value, "newAddress");
            return (Criteria) this;
        }

        public Criteria andNewAddressLessThanOrEqualTo(String value) {
            addCriterion("new_address <=", value, "newAddress");
            return (Criteria) this;
        }

        public Criteria andNewAddressLike(String value) {
            addCriterion("new_address like", value, "newAddress");
            return (Criteria) this;
        }

        public Criteria andNewAddressNotLike(String value) {
            addCriterion("new_address not like", value, "newAddress");
            return (Criteria) this;
        }

        public Criteria andNewAddressIn(List<String> values) {
            addCriterion("new_address in", values, "newAddress");
            return (Criteria) this;
        }

        public Criteria andNewAddressNotIn(List<String> values) {
            addCriterion("new_address not in", values, "newAddress");
            return (Criteria) this;
        }

        public Criteria andNewAddressBetween(String value1, String value2) {
            addCriterion("new_address between", value1, value2, "newAddress");
            return (Criteria) this;
        }

        public Criteria andNewAddressNotBetween(String value1, String value2) {
            addCriterion("new_address not between", value1, value2, "newAddress");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
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

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(BigDecimal value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(BigDecimal value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(BigDecimal value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(BigDecimal value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<BigDecimal> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<BigDecimal> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andActivityRateIsNull() {
            addCriterion("activity_rate is null");
            return (Criteria) this;
        }

        public Criteria andActivityRateIsNotNull() {
            addCriterion("activity_rate is not null");
            return (Criteria) this;
        }

        public Criteria andActivityRateEqualTo(BigDecimal value) {
            addCriterion("activity_rate =", value, "activityRate");
            return (Criteria) this;
        }

        public Criteria andActivityRateNotEqualTo(BigDecimal value) {
            addCriterion("activity_rate <>", value, "activityRate");
            return (Criteria) this;
        }

        public Criteria andActivityRateGreaterThan(BigDecimal value) {
            addCriterion("activity_rate >", value, "activityRate");
            return (Criteria) this;
        }

        public Criteria andActivityRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("activity_rate >=", value, "activityRate");
            return (Criteria) this;
        }

        public Criteria andActivityRateLessThan(BigDecimal value) {
            addCriterion("activity_rate <", value, "activityRate");
            return (Criteria) this;
        }

        public Criteria andActivityRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("activity_rate <=", value, "activityRate");
            return (Criteria) this;
        }

        public Criteria andActivityRateIn(List<BigDecimal> values) {
            addCriterion("activity_rate in", values, "activityRate");
            return (Criteria) this;
        }

        public Criteria andActivityRateNotIn(List<BigDecimal> values) {
            addCriterion("activity_rate not in", values, "activityRate");
            return (Criteria) this;
        }

        public Criteria andActivityRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("activity_rate between", value1, value2, "activityRate");
            return (Criteria) this;
        }

        public Criteria andActivityRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("activity_rate not between", value1, value2, "activityRate");
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

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(BigDecimal value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(BigDecimal value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<BigDecimal> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTipAmountIsNull() {
            addCriterion("tip_amount is null");
            return (Criteria) this;
        }

        public Criteria andTipAmountIsNotNull() {
            addCriterion("tip_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTipAmountEqualTo(BigDecimal value) {
            addCriterion("tip_amount =", value, "tipAmount");
            return (Criteria) this;
        }

        public Criteria andTipAmountNotEqualTo(BigDecimal value) {
            addCriterion("tip_amount <>", value, "tipAmount");
            return (Criteria) this;
        }

        public Criteria andTipAmountGreaterThan(BigDecimal value) {
            addCriterion("tip_amount >", value, "tipAmount");
            return (Criteria) this;
        }

        public Criteria andTipAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tip_amount >=", value, "tipAmount");
            return (Criteria) this;
        }

        public Criteria andTipAmountLessThan(BigDecimal value) {
            addCriterion("tip_amount <", value, "tipAmount");
            return (Criteria) this;
        }

        public Criteria andTipAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tip_amount <=", value, "tipAmount");
            return (Criteria) this;
        }

        public Criteria andTipAmountIn(List<BigDecimal> values) {
            addCriterion("tip_amount in", values, "tipAmount");
            return (Criteria) this;
        }

        public Criteria andTipAmountNotIn(List<BigDecimal> values) {
            addCriterion("tip_amount not in", values, "tipAmount");
            return (Criteria) this;
        }

        public Criteria andTipAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tip_amount between", value1, value2, "tipAmount");
            return (Criteria) this;
        }

        public Criteria andTipAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tip_amount not between", value1, value2, "tipAmount");
            return (Criteria) this;
        }

        public Criteria andDownPaymentIsNull() {
            addCriterion("down_payment is null");
            return (Criteria) this;
        }

        public Criteria andDownPaymentIsNotNull() {
            addCriterion("down_payment is not null");
            return (Criteria) this;
        }

        public Criteria andDownPaymentEqualTo(BigDecimal value) {
            addCriterion("down_payment =", value, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentNotEqualTo(BigDecimal value) {
            addCriterion("down_payment <>", value, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentGreaterThan(BigDecimal value) {
            addCriterion("down_payment >", value, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("down_payment >=", value, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentLessThan(BigDecimal value) {
            addCriterion("down_payment <", value, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("down_payment <=", value, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentIn(List<BigDecimal> values) {
            addCriterion("down_payment in", values, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentNotIn(List<BigDecimal> values) {
            addCriterion("down_payment not in", values, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("down_payment between", value1, value2, "downPayment");
            return (Criteria) this;
        }

        public Criteria andDownPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("down_payment not between", value1, value2, "downPayment");
            return (Criteria) this;
        }

        public Criteria andFenqiIsNull() {
            addCriterion("fenqi is null");
            return (Criteria) this;
        }

        public Criteria andFenqiIsNotNull() {
            addCriterion("fenqi is not null");
            return (Criteria) this;
        }

        public Criteria andFenqiEqualTo(Integer value) {
            addCriterion("fenqi =", value, "fenqi");
            return (Criteria) this;
        }

        public Criteria andFenqiNotEqualTo(Integer value) {
            addCriterion("fenqi <>", value, "fenqi");
            return (Criteria) this;
        }

        public Criteria andFenqiGreaterThan(Integer value) {
            addCriterion("fenqi >", value, "fenqi");
            return (Criteria) this;
        }

        public Criteria andFenqiGreaterThanOrEqualTo(Integer value) {
            addCriterion("fenqi >=", value, "fenqi");
            return (Criteria) this;
        }

        public Criteria andFenqiLessThan(Integer value) {
            addCriterion("fenqi <", value, "fenqi");
            return (Criteria) this;
        }

        public Criteria andFenqiLessThanOrEqualTo(Integer value) {
            addCriterion("fenqi <=", value, "fenqi");
            return (Criteria) this;
        }

        public Criteria andFenqiIn(List<Integer> values) {
            addCriterion("fenqi in", values, "fenqi");
            return (Criteria) this;
        }

        public Criteria andFenqiNotIn(List<Integer> values) {
            addCriterion("fenqi not in", values, "fenqi");
            return (Criteria) this;
        }

        public Criteria andFenqiBetween(Integer value1, Integer value2) {
            addCriterion("fenqi between", value1, value2, "fenqi");
            return (Criteria) this;
        }

        public Criteria andFenqiNotBetween(Integer value1, Integer value2) {
            addCriterion("fenqi not between", value1, value2, "fenqi");
            return (Criteria) this;
        }

        public Criteria andPerAmountIsNull() {
            addCriterion("per_amount is null");
            return (Criteria) this;
        }

        public Criteria andPerAmountIsNotNull() {
            addCriterion("per_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPerAmountEqualTo(BigDecimal value) {
            addCriterion("per_amount =", value, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountNotEqualTo(BigDecimal value) {
            addCriterion("per_amount <>", value, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountGreaterThan(BigDecimal value) {
            addCriterion("per_amount >", value, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("per_amount >=", value, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountLessThan(BigDecimal value) {
            addCriterion("per_amount <", value, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("per_amount <=", value, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountIn(List<BigDecimal> values) {
            addCriterion("per_amount in", values, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountNotIn(List<BigDecimal> values) {
            addCriterion("per_amount not in", values, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("per_amount between", value1, value2, "perAmount");
            return (Criteria) this;
        }

        public Criteria andPerAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("per_amount not between", value1, value2, "perAmount");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("channel is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("channel is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(String value) {
            addCriterion("channel =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(String value) {
            addCriterion("channel <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(String value) {
            addCriterion("channel >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(String value) {
            addCriterion("channel >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(String value) {
            addCriterion("channel <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(String value) {
            addCriterion("channel <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLike(String value) {
            addCriterion("channel like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotLike(String value) {
            addCriterion("channel not like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<String> values) {
            addCriterion("channel in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<String> values) {
            addCriterion("channel not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(String value1, String value2) {
            addCriterion("channel between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(String value1, String value2) {
            addCriterion("channel not between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andRateConfigIdIsNull() {
            addCriterion("rate_config_id is null");
            return (Criteria) this;
        }

        public Criteria andRateConfigIdIsNotNull() {
            addCriterion("rate_config_id is not null");
            return (Criteria) this;
        }

        public Criteria andRateConfigIdEqualTo(Byte value) {
            addCriterion("rate_config_id =", value, "rateConfigId");
            return (Criteria) this;
        }

        public Criteria andRateConfigIdNotEqualTo(Byte value) {
            addCriterion("rate_config_id <>", value, "rateConfigId");
            return (Criteria) this;
        }

        public Criteria andRateConfigIdGreaterThan(Byte value) {
            addCriterion("rate_config_id >", value, "rateConfigId");
            return (Criteria) this;
        }

        public Criteria andRateConfigIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("rate_config_id >=", value, "rateConfigId");
            return (Criteria) this;
        }

        public Criteria andRateConfigIdLessThan(Byte value) {
            addCriterion("rate_config_id <", value, "rateConfigId");
            return (Criteria) this;
        }

        public Criteria andRateConfigIdLessThanOrEqualTo(Byte value) {
            addCriterion("rate_config_id <=", value, "rateConfigId");
            return (Criteria) this;
        }

        public Criteria andRateConfigIdIn(List<Byte> values) {
            addCriterion("rate_config_id in", values, "rateConfigId");
            return (Criteria) this;
        }

        public Criteria andRateConfigIdNotIn(List<Byte> values) {
            addCriterion("rate_config_id not in", values, "rateConfigId");
            return (Criteria) this;
        }

        public Criteria andRateConfigIdBetween(Byte value1, Byte value2) {
            addCriterion("rate_config_id between", value1, value2, "rateConfigId");
            return (Criteria) this;
        }

        public Criteria andRateConfigIdNotBetween(Byte value1, Byte value2) {
            addCriterion("rate_config_id not between", value1, value2, "rateConfigId");
            return (Criteria) this;
        }

        public Criteria andOrignAmountIsNull() {
            addCriterion("orign_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrignAmountIsNotNull() {
            addCriterion("orign_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrignAmountEqualTo(BigDecimal value) {
            addCriterion("orign_amount =", value, "orignAmount");
            return (Criteria) this;
        }

        public Criteria andOrignAmountNotEqualTo(BigDecimal value) {
            addCriterion("orign_amount <>", value, "orignAmount");
            return (Criteria) this;
        }

        public Criteria andOrignAmountGreaterThan(BigDecimal value) {
            addCriterion("orign_amount >", value, "orignAmount");
            return (Criteria) this;
        }

        public Criteria andOrignAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("orign_amount >=", value, "orignAmount");
            return (Criteria) this;
        }

        public Criteria andOrignAmountLessThan(BigDecimal value) {
            addCriterion("orign_amount <", value, "orignAmount");
            return (Criteria) this;
        }

        public Criteria andOrignAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("orign_amount <=", value, "orignAmount");
            return (Criteria) this;
        }

        public Criteria andOrignAmountIn(List<BigDecimal> values) {
            addCriterion("orign_amount in", values, "orignAmount");
            return (Criteria) this;
        }

        public Criteria andOrignAmountNotIn(List<BigDecimal> values) {
            addCriterion("orign_amount not in", values, "orignAmount");
            return (Criteria) this;
        }

        public Criteria andOrignAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("orign_amount between", value1, value2, "orignAmount");
            return (Criteria) this;
        }

        public Criteria andOrignAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("orign_amount not between", value1, value2, "orignAmount");
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

        public Criteria andCancelAtIsNull() {
            addCriterion("cancel_at is null");
            return (Criteria) this;
        }

        public Criteria andCancelAtIsNotNull() {
            addCriterion("cancel_at is not null");
            return (Criteria) this;
        }

        public Criteria andCancelAtEqualTo(Date value) {
            addCriterion("cancel_at =", value, "cancelAt");
            return (Criteria) this;
        }

        public Criteria andCancelAtNotEqualTo(Date value) {
            addCriterion("cancel_at <>", value, "cancelAt");
            return (Criteria) this;
        }

        public Criteria andCancelAtGreaterThan(Date value) {
            addCriterion("cancel_at >", value, "cancelAt");
            return (Criteria) this;
        }

        public Criteria andCancelAtGreaterThanOrEqualTo(Date value) {
            addCriterion("cancel_at >=", value, "cancelAt");
            return (Criteria) this;
        }

        public Criteria andCancelAtLessThan(Date value) {
            addCriterion("cancel_at <", value, "cancelAt");
            return (Criteria) this;
        }

        public Criteria andCancelAtLessThanOrEqualTo(Date value) {
            addCriterion("cancel_at <=", value, "cancelAt");
            return (Criteria) this;
        }

        public Criteria andCancelAtIn(List<Date> values) {
            addCriterion("cancel_at in", values, "cancelAt");
            return (Criteria) this;
        }

        public Criteria andCancelAtNotIn(List<Date> values) {
            addCriterion("cancel_at not in", values, "cancelAt");
            return (Criteria) this;
        }

        public Criteria andCancelAtBetween(Date value1, Date value2) {
            addCriterion("cancel_at between", value1, value2, "cancelAt");
            return (Criteria) this;
        }

        public Criteria andCancelAtNotBetween(Date value1, Date value2) {
            addCriterion("cancel_at not between", value1, value2, "cancelAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtIsNull() {
            addCriterion("deleted_at is null");
            return (Criteria) this;
        }

        public Criteria andDeletedAtIsNotNull() {
            addCriterion("deleted_at is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedAtEqualTo(Date value) {
            addCriterion("deleted_at =", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtNotEqualTo(Date value) {
            addCriterion("deleted_at <>", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtGreaterThan(Date value) {
            addCriterion("deleted_at >", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("deleted_at >=", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtLessThan(Date value) {
            addCriterion("deleted_at <", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtLessThanOrEqualTo(Date value) {
            addCriterion("deleted_at <=", value, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtIn(List<Date> values) {
            addCriterion("deleted_at in", values, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtNotIn(List<Date> values) {
            addCriterion("deleted_at not in", values, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtBetween(Date value1, Date value2) {
            addCriterion("deleted_at between", value1, value2, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andDeletedAtNotBetween(Date value1, Date value2) {
            addCriterion("deleted_at not between", value1, value2, "deletedAt");
            return (Criteria) this;
        }

        public Criteria andFenqiCycleIsNull() {
            addCriterion("fenqi_cycle is null");
            return (Criteria) this;
        }

        public Criteria andFenqiCycleIsNotNull() {
            addCriterion("fenqi_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andFenqiCycleEqualTo(Byte value) {
            addCriterion("fenqi_cycle =", value, "fenqiCycle");
            return (Criteria) this;
        }

        public Criteria andFenqiCycleNotEqualTo(Byte value) {
            addCriterion("fenqi_cycle <>", value, "fenqiCycle");
            return (Criteria) this;
        }

        public Criteria andFenqiCycleGreaterThan(Byte value) {
            addCriterion("fenqi_cycle >", value, "fenqiCycle");
            return (Criteria) this;
        }

        public Criteria andFenqiCycleGreaterThanOrEqualTo(Byte value) {
            addCriterion("fenqi_cycle >=", value, "fenqiCycle");
            return (Criteria) this;
        }

        public Criteria andFenqiCycleLessThan(Byte value) {
            addCriterion("fenqi_cycle <", value, "fenqiCycle");
            return (Criteria) this;
        }

        public Criteria andFenqiCycleLessThanOrEqualTo(Byte value) {
            addCriterion("fenqi_cycle <=", value, "fenqiCycle");
            return (Criteria) this;
        }

        public Criteria andFenqiCycleIn(List<Byte> values) {
            addCriterion("fenqi_cycle in", values, "fenqiCycle");
            return (Criteria) this;
        }

        public Criteria andFenqiCycleNotIn(List<Byte> values) {
            addCriterion("fenqi_cycle not in", values, "fenqiCycle");
            return (Criteria) this;
        }

        public Criteria andFenqiCycleBetween(Byte value1, Byte value2) {
            addCriterion("fenqi_cycle between", value1, value2, "fenqiCycle");
            return (Criteria) this;
        }

        public Criteria andFenqiCycleNotBetween(Byte value1, Byte value2) {
            addCriterion("fenqi_cycle not between", value1, value2, "fenqiCycle");
            return (Criteria) this;
        }

        public Criteria andPayAreaIsNull() {
            addCriterion("pay_area is null");
            return (Criteria) this;
        }

        public Criteria andPayAreaIsNotNull() {
            addCriterion("pay_area is not null");
            return (Criteria) this;
        }

        public Criteria andPayAreaEqualTo(Integer value) {
            addCriterion("pay_area =", value, "payArea");
            return (Criteria) this;
        }

        public Criteria andPayAreaNotEqualTo(Integer value) {
            addCriterion("pay_area <>", value, "payArea");
            return (Criteria) this;
        }

        public Criteria andPayAreaGreaterThan(Integer value) {
            addCriterion("pay_area >", value, "payArea");
            return (Criteria) this;
        }

        public Criteria andPayAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_area >=", value, "payArea");
            return (Criteria) this;
        }

        public Criteria andPayAreaLessThan(Integer value) {
            addCriterion("pay_area <", value, "payArea");
            return (Criteria) this;
        }

        public Criteria andPayAreaLessThanOrEqualTo(Integer value) {
            addCriterion("pay_area <=", value, "payArea");
            return (Criteria) this;
        }

        public Criteria andPayAreaIn(List<Integer> values) {
            addCriterion("pay_area in", values, "payArea");
            return (Criteria) this;
        }

        public Criteria andPayAreaNotIn(List<Integer> values) {
            addCriterion("pay_area not in", values, "payArea");
            return (Criteria) this;
        }

        public Criteria andPayAreaBetween(Integer value1, Integer value2) {
            addCriterion("pay_area between", value1, value2, "payArea");
            return (Criteria) this;
        }

        public Criteria andPayAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_area not between", value1, value2, "payArea");
            return (Criteria) this;
        }

        public Criteria andLoanAreaIsNull() {
            addCriterion("loan_area is null");
            return (Criteria) this;
        }

        public Criteria andLoanAreaIsNotNull() {
            addCriterion("loan_area is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAreaEqualTo(Integer value) {
            addCriterion("loan_area =", value, "loanArea");
            return (Criteria) this;
        }

        public Criteria andLoanAreaNotEqualTo(Integer value) {
            addCriterion("loan_area <>", value, "loanArea");
            return (Criteria) this;
        }

        public Criteria andLoanAreaGreaterThan(Integer value) {
            addCriterion("loan_area >", value, "loanArea");
            return (Criteria) this;
        }

        public Criteria andLoanAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("loan_area >=", value, "loanArea");
            return (Criteria) this;
        }

        public Criteria andLoanAreaLessThan(Integer value) {
            addCriterion("loan_area <", value, "loanArea");
            return (Criteria) this;
        }

        public Criteria andLoanAreaLessThanOrEqualTo(Integer value) {
            addCriterion("loan_area <=", value, "loanArea");
            return (Criteria) this;
        }

        public Criteria andLoanAreaIn(List<Integer> values) {
            addCriterion("loan_area in", values, "loanArea");
            return (Criteria) this;
        }

        public Criteria andLoanAreaNotIn(List<Integer> values) {
            addCriterion("loan_area not in", values, "loanArea");
            return (Criteria) this;
        }

        public Criteria andLoanAreaBetween(Integer value1, Integer value2) {
            addCriterion("loan_area between", value1, value2, "loanArea");
            return (Criteria) this;
        }

        public Criteria andLoanAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("loan_area not between", value1, value2, "loanArea");
            return (Criteria) this;
        }

        public Criteria andShareBenefitIsNull() {
            addCriterion("share_benefit is null");
            return (Criteria) this;
        }

        public Criteria andShareBenefitIsNotNull() {
            addCriterion("share_benefit is not null");
            return (Criteria) this;
        }

        public Criteria andShareBenefitEqualTo(Integer value) {
            addCriterion("share_benefit =", value, "shareBenefit");
            return (Criteria) this;
        }

        public Criteria andShareBenefitNotEqualTo(Integer value) {
            addCriterion("share_benefit <>", value, "shareBenefit");
            return (Criteria) this;
        }

        public Criteria andShareBenefitGreaterThan(Integer value) {
            addCriterion("share_benefit >", value, "shareBenefit");
            return (Criteria) this;
        }

        public Criteria andShareBenefitGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_benefit >=", value, "shareBenefit");
            return (Criteria) this;
        }

        public Criteria andShareBenefitLessThan(Integer value) {
            addCriterion("share_benefit <", value, "shareBenefit");
            return (Criteria) this;
        }

        public Criteria andShareBenefitLessThanOrEqualTo(Integer value) {
            addCriterion("share_benefit <=", value, "shareBenefit");
            return (Criteria) this;
        }

        public Criteria andShareBenefitIn(List<Integer> values) {
            addCriterion("share_benefit in", values, "shareBenefit");
            return (Criteria) this;
        }

        public Criteria andShareBenefitNotIn(List<Integer> values) {
            addCriterion("share_benefit not in", values, "shareBenefit");
            return (Criteria) this;
        }

        public Criteria andShareBenefitBetween(Integer value1, Integer value2) {
            addCriterion("share_benefit between", value1, value2, "shareBenefit");
            return (Criteria) this;
        }

        public Criteria andShareBenefitNotBetween(Integer value1, Integer value2) {
            addCriterion("share_benefit not between", value1, value2, "shareBenefit");
            return (Criteria) this;
        }

        public Criteria andCompanyRateIsNull() {
            addCriterion("company_rate is null");
            return (Criteria) this;
        }

        public Criteria andCompanyRateIsNotNull() {
            addCriterion("company_rate is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyRateEqualTo(BigDecimal value) {
            addCriterion("company_rate =", value, "companyRate");
            return (Criteria) this;
        }

        public Criteria andCompanyRateNotEqualTo(BigDecimal value) {
            addCriterion("company_rate <>", value, "companyRate");
            return (Criteria) this;
        }

        public Criteria andCompanyRateGreaterThan(BigDecimal value) {
            addCriterion("company_rate >", value, "companyRate");
            return (Criteria) this;
        }

        public Criteria andCompanyRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("company_rate >=", value, "companyRate");
            return (Criteria) this;
        }

        public Criteria andCompanyRateLessThan(BigDecimal value) {
            addCriterion("company_rate <", value, "companyRate");
            return (Criteria) this;
        }

        public Criteria andCompanyRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("company_rate <=", value, "companyRate");
            return (Criteria) this;
        }

        public Criteria andCompanyRateIn(List<BigDecimal> values) {
            addCriterion("company_rate in", values, "companyRate");
            return (Criteria) this;
        }

        public Criteria andCompanyRateNotIn(List<BigDecimal> values) {
            addCriterion("company_rate not in", values, "companyRate");
            return (Criteria) this;
        }

        public Criteria andCompanyRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("company_rate between", value1, value2, "companyRate");
            return (Criteria) this;
        }

        public Criteria andCompanyRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("company_rate not between", value1, value2, "companyRate");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNull() {
            addCriterion("trade_type is null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNotNull() {
            addCriterion("trade_type is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeEqualTo(Byte value) {
            addCriterion("trade_type =", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotEqualTo(Byte value) {
            addCriterion("trade_type <>", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThan(Byte value) {
            addCriterion("trade_type >", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("trade_type >=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThan(Byte value) {
            addCriterion("trade_type <", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThanOrEqualTo(Byte value) {
            addCriterion("trade_type <=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIn(List<Byte> values) {
            addCriterion("trade_type in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotIn(List<Byte> values) {
            addCriterion("trade_type not in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeBetween(Byte value1, Byte value2) {
            addCriterion("trade_type between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("trade_type not between", value1, value2, "tradeType");
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