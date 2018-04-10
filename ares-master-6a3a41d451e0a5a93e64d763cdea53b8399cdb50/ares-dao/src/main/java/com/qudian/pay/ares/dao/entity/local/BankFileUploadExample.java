package com.qudian.pay.ares.dao.entity.local;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BankFileUploadExample extends PageInfoPOA {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BankFileUploadExample() {
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

        public Criteria andInsNameIsNull() {
            addCriterion("ins_name is null");
            return (Criteria) this;
        }

        public Criteria andInsNameIsNotNull() {
            addCriterion("ins_name is not null");
            return (Criteria) this;
        }

        public Criteria andInsNameEqualTo(String value) {
            addCriterion("ins_name =", value, "insName");
            return (Criteria) this;
        }

        public Criteria andInsNameNotEqualTo(String value) {
            addCriterion("ins_name <>", value, "insName");
            return (Criteria) this;
        }

        public Criteria andInsNameGreaterThan(String value) {
            addCriterion("ins_name >", value, "insName");
            return (Criteria) this;
        }

        public Criteria andInsNameGreaterThanOrEqualTo(String value) {
            addCriterion("ins_name >=", value, "insName");
            return (Criteria) this;
        }

        public Criteria andInsNameLessThan(String value) {
            addCriterion("ins_name <", value, "insName");
            return (Criteria) this;
        }

        public Criteria andInsNameLessThanOrEqualTo(String value) {
            addCriterion("ins_name <=", value, "insName");
            return (Criteria) this;
        }

        public Criteria andInsNameLike(String value) {
            addCriterion("ins_name like", value, "insName");
            return (Criteria) this;
        }

        public Criteria andInsNameNotLike(String value) {
            addCriterion("ins_name not like", value, "insName");
            return (Criteria) this;
        }

        public Criteria andInsNameIn(List<String> values) {
            addCriterion("ins_name in", values, "insName");
            return (Criteria) this;
        }

        public Criteria andInsNameNotIn(List<String> values) {
            addCriterion("ins_name not in", values, "insName");
            return (Criteria) this;
        }

        public Criteria andInsNameBetween(String value1, String value2) {
            addCriterion("ins_name between", value1, value2, "insName");
            return (Criteria) this;
        }

        public Criteria andInsNameNotBetween(String value1, String value2) {
            addCriterion("ins_name not between", value1, value2, "insName");
            return (Criteria) this;
        }

        public Criteria andLoandetailIsNull() {
            addCriterion("loandetail is null");
            return (Criteria) this;
        }

        public Criteria andLoandetailIsNotNull() {
            addCriterion("loandetail is not null");
            return (Criteria) this;
        }

        public Criteria andLoandetailEqualTo(String value) {
            addCriterion("loandetail =", value, "loandetail");
            return (Criteria) this;
        }

        public Criteria andLoandetailNotEqualTo(String value) {
            addCriterion("loandetail <>", value, "loandetail");
            return (Criteria) this;
        }

        public Criteria andLoandetailGreaterThan(String value) {
            addCriterion("loandetail >", value, "loandetail");
            return (Criteria) this;
        }

        public Criteria andLoandetailGreaterThanOrEqualTo(String value) {
            addCriterion("loandetail >=", value, "loandetail");
            return (Criteria) this;
        }

        public Criteria andLoandetailLessThan(String value) {
            addCriterion("loandetail <", value, "loandetail");
            return (Criteria) this;
        }

        public Criteria andLoandetailLessThanOrEqualTo(String value) {
            addCriterion("loandetail <=", value, "loandetail");
            return (Criteria) this;
        }

        public Criteria andLoandetailLike(String value) {
            addCriterion("loandetail like", value, "loandetail");
            return (Criteria) this;
        }

        public Criteria andLoandetailNotLike(String value) {
            addCriterion("loandetail not like", value, "loandetail");
            return (Criteria) this;
        }

        public Criteria andLoandetailIn(List<String> values) {
            addCriterion("loandetail in", values, "loandetail");
            return (Criteria) this;
        }

        public Criteria andLoandetailNotIn(List<String> values) {
            addCriterion("loandetail not in", values, "loandetail");
            return (Criteria) this;
        }

        public Criteria andLoandetailBetween(String value1, String value2) {
            addCriterion("loandetail between", value1, value2, "loandetail");
            return (Criteria) this;
        }

        public Criteria andLoandetailNotBetween(String value1, String value2) {
            addCriterion("loandetail not between", value1, value2, "loandetail");
            return (Criteria) this;
        }

        public Criteria andPayplanIsNull() {
            addCriterion("payplan is null");
            return (Criteria) this;
        }

        public Criteria andPayplanIsNotNull() {
            addCriterion("payplan is not null");
            return (Criteria) this;
        }

        public Criteria andPayplanEqualTo(String value) {
            addCriterion("payplan =", value, "payplan");
            return (Criteria) this;
        }

        public Criteria andPayplanNotEqualTo(String value) {
            addCriterion("payplan <>", value, "payplan");
            return (Criteria) this;
        }

        public Criteria andPayplanGreaterThan(String value) {
            addCriterion("payplan >", value, "payplan");
            return (Criteria) this;
        }

        public Criteria andPayplanGreaterThanOrEqualTo(String value) {
            addCriterion("payplan >=", value, "payplan");
            return (Criteria) this;
        }

        public Criteria andPayplanLessThan(String value) {
            addCriterion("payplan <", value, "payplan");
            return (Criteria) this;
        }

        public Criteria andPayplanLessThanOrEqualTo(String value) {
            addCriterion("payplan <=", value, "payplan");
            return (Criteria) this;
        }

        public Criteria andPayplanLike(String value) {
            addCriterion("payplan like", value, "payplan");
            return (Criteria) this;
        }

        public Criteria andPayplanNotLike(String value) {
            addCriterion("payplan not like", value, "payplan");
            return (Criteria) this;
        }

        public Criteria andPayplanIn(List<String> values) {
            addCriterion("payplan in", values, "payplan");
            return (Criteria) this;
        }

        public Criteria andPayplanNotIn(List<String> values) {
            addCriterion("payplan not in", values, "payplan");
            return (Criteria) this;
        }

        public Criteria andPayplanBetween(String value1, String value2) {
            addCriterion("payplan between", value1, value2, "payplan");
            return (Criteria) this;
        }

        public Criteria andPayplanNotBetween(String value1, String value2) {
            addCriterion("payplan not between", value1, value2, "payplan");
            return (Criteria) this;
        }

        public Criteria andPaylogIsNull() {
            addCriterion("paylog is null");
            return (Criteria) this;
        }

        public Criteria andPaylogIsNotNull() {
            addCriterion("paylog is not null");
            return (Criteria) this;
        }

        public Criteria andPaylogEqualTo(String value) {
            addCriterion("paylog =", value, "paylog");
            return (Criteria) this;
        }

        public Criteria andPaylogNotEqualTo(String value) {
            addCriterion("paylog <>", value, "paylog");
            return (Criteria) this;
        }

        public Criteria andPaylogGreaterThan(String value) {
            addCriterion("paylog >", value, "paylog");
            return (Criteria) this;
        }

        public Criteria andPaylogGreaterThanOrEqualTo(String value) {
            addCriterion("paylog >=", value, "paylog");
            return (Criteria) this;
        }

        public Criteria andPaylogLessThan(String value) {
            addCriterion("paylog <", value, "paylog");
            return (Criteria) this;
        }

        public Criteria andPaylogLessThanOrEqualTo(String value) {
            addCriterion("paylog <=", value, "paylog");
            return (Criteria) this;
        }

        public Criteria andPaylogLike(String value) {
            addCriterion("paylog like", value, "paylog");
            return (Criteria) this;
        }

        public Criteria andPaylogNotLike(String value) {
            addCriterion("paylog not like", value, "paylog");
            return (Criteria) this;
        }

        public Criteria andPaylogIn(List<String> values) {
            addCriterion("paylog in", values, "paylog");
            return (Criteria) this;
        }

        public Criteria andPaylogNotIn(List<String> values) {
            addCriterion("paylog not in", values, "paylog");
            return (Criteria) this;
        }

        public Criteria andPaylogBetween(String value1, String value2) {
            addCriterion("paylog between", value1, value2, "paylog");
            return (Criteria) this;
        }

        public Criteria andPaylogNotBetween(String value1, String value2) {
            addCriterion("paylog not between", value1, value2, "paylog");
            return (Criteria) this;
        }

        public Criteria andIndemnityIsNull() {
            addCriterion("indemnity is null");
            return (Criteria) this;
        }

        public Criteria andIndemnityIsNotNull() {
            addCriterion("indemnity is not null");
            return (Criteria) this;
        }

        public Criteria andIndemnityEqualTo(String value) {
            addCriterion("indemnity =", value, "indemnity");
            return (Criteria) this;
        }

        public Criteria andIndemnityNotEqualTo(String value) {
            addCriterion("indemnity <>", value, "indemnity");
            return (Criteria) this;
        }

        public Criteria andIndemnityGreaterThan(String value) {
            addCriterion("indemnity >", value, "indemnity");
            return (Criteria) this;
        }

        public Criteria andIndemnityGreaterThanOrEqualTo(String value) {
            addCriterion("indemnity >=", value, "indemnity");
            return (Criteria) this;
        }

        public Criteria andIndemnityLessThan(String value) {
            addCriterion("indemnity <", value, "indemnity");
            return (Criteria) this;
        }

        public Criteria andIndemnityLessThanOrEqualTo(String value) {
            addCriterion("indemnity <=", value, "indemnity");
            return (Criteria) this;
        }

        public Criteria andIndemnityLike(String value) {
            addCriterion("indemnity like", value, "indemnity");
            return (Criteria) this;
        }

        public Criteria andIndemnityNotLike(String value) {
            addCriterion("indemnity not like", value, "indemnity");
            return (Criteria) this;
        }

        public Criteria andIndemnityIn(List<String> values) {
            addCriterion("indemnity in", values, "indemnity");
            return (Criteria) this;
        }

        public Criteria andIndemnityNotIn(List<String> values) {
            addCriterion("indemnity not in", values, "indemnity");
            return (Criteria) this;
        }

        public Criteria andIndemnityBetween(String value1, String value2) {
            addCriterion("indemnity between", value1, value2, "indemnity");
            return (Criteria) this;
        }

        public Criteria andIndemnityNotBetween(String value1, String value2) {
            addCriterion("indemnity not between", value1, value2, "indemnity");
            return (Criteria) this;
        }

        public Criteria andOverdueIsNull() {
            addCriterion("overdue is null");
            return (Criteria) this;
        }

        public Criteria andOverdueIsNotNull() {
            addCriterion("overdue is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueEqualTo(String value) {
            addCriterion("overdue =", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueNotEqualTo(String value) {
            addCriterion("overdue <>", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueGreaterThan(String value) {
            addCriterion("overdue >", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueGreaterThanOrEqualTo(String value) {
            addCriterion("overdue >=", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueLessThan(String value) {
            addCriterion("overdue <", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueLessThanOrEqualTo(String value) {
            addCriterion("overdue <=", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueLike(String value) {
            addCriterion("overdue like", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueNotLike(String value) {
            addCriterion("overdue not like", value, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueIn(List<String> values) {
            addCriterion("overdue in", values, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueNotIn(List<String> values) {
            addCriterion("overdue not in", values, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueBetween(String value1, String value2) {
            addCriterion("overdue between", value1, value2, "overdue");
            return (Criteria) this;
        }

        public Criteria andOverdueNotBetween(String value1, String value2) {
            addCriterion("overdue not between", value1, value2, "overdue");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNull() {
            addCriterion("upload_time is null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNotNull() {
            addCriterion("upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeEqualTo(Date value) {
            addCriterionForJDBCDate("upload_time =", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("upload_time <>", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("upload_time >", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("upload_time >=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThan(Date value) {
            addCriterionForJDBCDate("upload_time <", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("upload_time <=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIn(List<Date> values) {
            addCriterionForJDBCDate("upload_time in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("upload_time not in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("upload_time between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("upload_time not between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andOptNameIsNull() {
            addCriterion("opt_name is null");
            return (Criteria) this;
        }

        public Criteria andOptNameIsNotNull() {
            addCriterion("opt_name is not null");
            return (Criteria) this;
        }

        public Criteria andOptNameEqualTo(String value) {
            addCriterion("opt_name =", value, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameNotEqualTo(String value) {
            addCriterion("opt_name <>", value, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameGreaterThan(String value) {
            addCriterion("opt_name >", value, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameGreaterThanOrEqualTo(String value) {
            addCriterion("opt_name >=", value, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameLessThan(String value) {
            addCriterion("opt_name <", value, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameLessThanOrEqualTo(String value) {
            addCriterion("opt_name <=", value, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameLike(String value) {
            addCriterion("opt_name like", value, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameNotLike(String value) {
            addCriterion("opt_name not like", value, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameIn(List<String> values) {
            addCriterion("opt_name in", values, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameNotIn(List<String> values) {
            addCriterion("opt_name not in", values, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameBetween(String value1, String value2) {
            addCriterion("opt_name between", value1, value2, "optName");
            return (Criteria) this;
        }

        public Criteria andOptNameNotBetween(String value1, String value2) {
            addCriterion("opt_name not between", value1, value2, "optName");
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