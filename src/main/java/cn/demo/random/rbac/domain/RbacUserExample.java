package cn.demo.random.rbac.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RbacUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RbacUserExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCommontsIsNull() {
            addCriterion("commonts is null");
            return (Criteria) this;
        }

        public Criteria andCommontsIsNotNull() {
            addCriterion("commonts is not null");
            return (Criteria) this;
        }

        public Criteria andCommontsEqualTo(String value) {
            addCriterion("commonts =", value, "commonts");
            return (Criteria) this;
        }

        public Criteria andCommontsNotEqualTo(String value) {
            addCriterion("commonts <>", value, "commonts");
            return (Criteria) this;
        }

        public Criteria andCommontsGreaterThan(String value) {
            addCriterion("commonts >", value, "commonts");
            return (Criteria) this;
        }

        public Criteria andCommontsGreaterThanOrEqualTo(String value) {
            addCriterion("commonts >=", value, "commonts");
            return (Criteria) this;
        }

        public Criteria andCommontsLessThan(String value) {
            addCriterion("commonts <", value, "commonts");
            return (Criteria) this;
        }

        public Criteria andCommontsLessThanOrEqualTo(String value) {
            addCriterion("commonts <=", value, "commonts");
            return (Criteria) this;
        }

        public Criteria andCommontsLike(String value) {
            addCriterion("commonts like", value, "commonts");
            return (Criteria) this;
        }

        public Criteria andCommontsNotLike(String value) {
            addCriterion("commonts not like", value, "commonts");
            return (Criteria) this;
        }

        public Criteria andCommontsIn(List<String> values) {
            addCriterion("commonts in", values, "commonts");
            return (Criteria) this;
        }

        public Criteria andCommontsNotIn(List<String> values) {
            addCriterion("commonts not in", values, "commonts");
            return (Criteria) this;
        }

        public Criteria andCommontsBetween(String value1, String value2) {
            addCriterion("commonts between", value1, value2, "commonts");
            return (Criteria) this;
        }

        public Criteria andCommontsNotBetween(String value1, String value2) {
            addCriterion("commonts not between", value1, value2, "commonts");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(Long value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(Long value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(Long value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(Long value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(Long value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(Long value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<Long> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<Long> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(Long value1, Long value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(Long value1, Long value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andIsvalidIsNull() {
            addCriterion("isvalid is null");
            return (Criteria) this;
        }

        public Criteria andIsvalidIsNotNull() {
            addCriterion("isvalid is not null");
            return (Criteria) this;
        }

        public Criteria andIsvalidEqualTo(String value) {
            addCriterion("isvalid =", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidNotEqualTo(String value) {
            addCriterion("isvalid <>", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidGreaterThan(String value) {
            addCriterion("isvalid >", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidGreaterThanOrEqualTo(String value) {
            addCriterion("isvalid >=", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidLessThan(String value) {
            addCriterion("isvalid <", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidLessThanOrEqualTo(String value) {
            addCriterion("isvalid <=", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidLike(String value) {
            addCriterion("isvalid like", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidNotLike(String value) {
            addCriterion("isvalid not like", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidIn(List<String> values) {
            addCriterion("isvalid in", values, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidNotIn(List<String> values) {
            addCriterion("isvalid not in", values, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidBetween(String value1, String value2) {
            addCriterion("isvalid between", value1, value2, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidNotBetween(String value1, String value2) {
            addCriterion("isvalid not between", value1, value2, "isvalid");
            return (Criteria) this;
        }

        public Criteria andActivatedIsNull() {
            addCriterion("activated is null");
            return (Criteria) this;
        }

        public Criteria andActivatedIsNotNull() {
            addCriterion("activated is not null");
            return (Criteria) this;
        }

        public Criteria andActivatedEqualTo(Boolean value) {
            addCriterion("activated =", value, "activated");
            return (Criteria) this;
        }

        public Criteria andActivatedNotEqualTo(Boolean value) {
            addCriterion("activated <>", value, "activated");
            return (Criteria) this;
        }

        public Criteria andActivatedGreaterThan(Boolean value) {
            addCriterion("activated >", value, "activated");
            return (Criteria) this;
        }

        public Criteria andActivatedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("activated >=", value, "activated");
            return (Criteria) this;
        }

        public Criteria andActivatedLessThan(Boolean value) {
            addCriterion("activated <", value, "activated");
            return (Criteria) this;
        }

        public Criteria andActivatedLessThanOrEqualTo(Boolean value) {
            addCriterion("activated <=", value, "activated");
            return (Criteria) this;
        }

        public Criteria andActivatedIn(List<Boolean> values) {
            addCriterion("activated in", values, "activated");
            return (Criteria) this;
        }

        public Criteria andActivatedNotIn(List<Boolean> values) {
            addCriterion("activated not in", values, "activated");
            return (Criteria) this;
        }

        public Criteria andActivatedBetween(Boolean value1, Boolean value2) {
            addCriterion("activated between", value1, value2, "activated");
            return (Criteria) this;
        }

        public Criteria andActivatedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("activated not between", value1, value2, "activated");
            return (Criteria) this;
        }

        public Criteria andActivationKeyIsNull() {
            addCriterion("activation_key is null");
            return (Criteria) this;
        }

        public Criteria andActivationKeyIsNotNull() {
            addCriterion("activation_key is not null");
            return (Criteria) this;
        }

        public Criteria andActivationKeyEqualTo(String value) {
            addCriterion("activation_key =", value, "activationKey");
            return (Criteria) this;
        }

        public Criteria andActivationKeyNotEqualTo(String value) {
            addCriterion("activation_key <>", value, "activationKey");
            return (Criteria) this;
        }

        public Criteria andActivationKeyGreaterThan(String value) {
            addCriterion("activation_key >", value, "activationKey");
            return (Criteria) this;
        }

        public Criteria andActivationKeyGreaterThanOrEqualTo(String value) {
            addCriterion("activation_key >=", value, "activationKey");
            return (Criteria) this;
        }

        public Criteria andActivationKeyLessThan(String value) {
            addCriterion("activation_key <", value, "activationKey");
            return (Criteria) this;
        }

        public Criteria andActivationKeyLessThanOrEqualTo(String value) {
            addCriterion("activation_key <=", value, "activationKey");
            return (Criteria) this;
        }

        public Criteria andActivationKeyLike(String value) {
            addCriterion("activation_key like", value, "activationKey");
            return (Criteria) this;
        }

        public Criteria andActivationKeyNotLike(String value) {
            addCriterion("activation_key not like", value, "activationKey");
            return (Criteria) this;
        }

        public Criteria andActivationKeyIn(List<String> values) {
            addCriterion("activation_key in", values, "activationKey");
            return (Criteria) this;
        }

        public Criteria andActivationKeyNotIn(List<String> values) {
            addCriterion("activation_key not in", values, "activationKey");
            return (Criteria) this;
        }

        public Criteria andActivationKeyBetween(String value1, String value2) {
            addCriterion("activation_key between", value1, value2, "activationKey");
            return (Criteria) this;
        }

        public Criteria andActivationKeyNotBetween(String value1, String value2) {
            addCriterion("activation_key not between", value1, value2, "activationKey");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andLangKeyIsNull() {
            addCriterion("lang_key is null");
            return (Criteria) this;
        }

        public Criteria andLangKeyIsNotNull() {
            addCriterion("lang_key is not null");
            return (Criteria) this;
        }

        public Criteria andLangKeyEqualTo(String value) {
            addCriterion("lang_key =", value, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyNotEqualTo(String value) {
            addCriterion("lang_key <>", value, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyGreaterThan(String value) {
            addCriterion("lang_key >", value, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyGreaterThanOrEqualTo(String value) {
            addCriterion("lang_key >=", value, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyLessThan(String value) {
            addCriterion("lang_key <", value, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyLessThanOrEqualTo(String value) {
            addCriterion("lang_key <=", value, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyLike(String value) {
            addCriterion("lang_key like", value, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyNotLike(String value) {
            addCriterion("lang_key not like", value, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyIn(List<String> values) {
            addCriterion("lang_key in", values, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyNotIn(List<String> values) {
            addCriterion("lang_key not in", values, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyBetween(String value1, String value2) {
            addCriterion("lang_key between", value1, value2, "langKey");
            return (Criteria) this;
        }

        public Criteria andLangKeyNotBetween(String value1, String value2) {
            addCriterion("lang_key not between", value1, value2, "langKey");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andResetDateIsNull() {
            addCriterion("reset_date is null");
            return (Criteria) this;
        }

        public Criteria andResetDateIsNotNull() {
            addCriterion("reset_date is not null");
            return (Criteria) this;
        }

        public Criteria andResetDateEqualTo(Date value) {
            addCriterion("reset_date =", value, "resetDate");
            return (Criteria) this;
        }

        public Criteria andResetDateNotEqualTo(Date value) {
            addCriterion("reset_date <>", value, "resetDate");
            return (Criteria) this;
        }

        public Criteria andResetDateGreaterThan(Date value) {
            addCriterion("reset_date >", value, "resetDate");
            return (Criteria) this;
        }

        public Criteria andResetDateGreaterThanOrEqualTo(Date value) {
            addCriterion("reset_date >=", value, "resetDate");
            return (Criteria) this;
        }

        public Criteria andResetDateLessThan(Date value) {
            addCriterion("reset_date <", value, "resetDate");
            return (Criteria) this;
        }

        public Criteria andResetDateLessThanOrEqualTo(Date value) {
            addCriterion("reset_date <=", value, "resetDate");
            return (Criteria) this;
        }

        public Criteria andResetDateIn(List<Date> values) {
            addCriterion("reset_date in", values, "resetDate");
            return (Criteria) this;
        }

        public Criteria andResetDateNotIn(List<Date> values) {
            addCriterion("reset_date not in", values, "resetDate");
            return (Criteria) this;
        }

        public Criteria andResetDateBetween(Date value1, Date value2) {
            addCriterion("reset_date between", value1, value2, "resetDate");
            return (Criteria) this;
        }

        public Criteria andResetDateNotBetween(Date value1, Date value2) {
            addCriterion("reset_date not between", value1, value2, "resetDate");
            return (Criteria) this;
        }

        public Criteria andResetKeyIsNull() {
            addCriterion("reset_key is null");
            return (Criteria) this;
        }

        public Criteria andResetKeyIsNotNull() {
            addCriterion("reset_key is not null");
            return (Criteria) this;
        }

        public Criteria andResetKeyEqualTo(String value) {
            addCriterion("reset_key =", value, "resetKey");
            return (Criteria) this;
        }

        public Criteria andResetKeyNotEqualTo(String value) {
            addCriterion("reset_key <>", value, "resetKey");
            return (Criteria) this;
        }

        public Criteria andResetKeyGreaterThan(String value) {
            addCriterion("reset_key >", value, "resetKey");
            return (Criteria) this;
        }

        public Criteria andResetKeyGreaterThanOrEqualTo(String value) {
            addCriterion("reset_key >=", value, "resetKey");
            return (Criteria) this;
        }

        public Criteria andResetKeyLessThan(String value) {
            addCriterion("reset_key <", value, "resetKey");
            return (Criteria) this;
        }

        public Criteria andResetKeyLessThanOrEqualTo(String value) {
            addCriterion("reset_key <=", value, "resetKey");
            return (Criteria) this;
        }

        public Criteria andResetKeyLike(String value) {
            addCriterion("reset_key like", value, "resetKey");
            return (Criteria) this;
        }

        public Criteria andResetKeyNotLike(String value) {
            addCriterion("reset_key not like", value, "resetKey");
            return (Criteria) this;
        }

        public Criteria andResetKeyIn(List<String> values) {
            addCriterion("reset_key in", values, "resetKey");
            return (Criteria) this;
        }

        public Criteria andResetKeyNotIn(List<String> values) {
            addCriterion("reset_key not in", values, "resetKey");
            return (Criteria) this;
        }

        public Criteria andResetKeyBetween(String value1, String value2) {
            addCriterion("reset_key between", value1, value2, "resetKey");
            return (Criteria) this;
        }

        public Criteria andResetKeyNotBetween(String value1, String value2) {
            addCriterion("reset_key not between", value1, value2, "resetKey");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
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

        public Criteria andUserPwdIsNull() {
            addCriterion("user_pwd is null");
            return (Criteria) this;
        }

        public Criteria andUserPwdIsNotNull() {
            addCriterion("user_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andUserPwdEqualTo(String value) {
            addCriterion("user_pwd =", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotEqualTo(String value) {
            addCriterion("user_pwd <>", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThan(String value) {
            addCriterion("user_pwd >", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdGreaterThanOrEqualTo(String value) {
            addCriterion("user_pwd >=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThan(String value) {
            addCriterion("user_pwd <", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLessThanOrEqualTo(String value) {
            addCriterion("user_pwd <=", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdLike(String value) {
            addCriterion("user_pwd like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotLike(String value) {
            addCriterion("user_pwd not like", value, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdIn(List<String> values) {
            addCriterion("user_pwd in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotIn(List<String> values) {
            addCriterion("user_pwd not in", values, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdBetween(String value1, String value2) {
            addCriterion("user_pwd between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andUserPwdNotBetween(String value1, String value2) {
            addCriterion("user_pwd not between", value1, value2, "userPwd");
            return (Criteria) this;
        }

        public Criteria andValidateDateIsNull() {
            addCriterion("validate_date is null");
            return (Criteria) this;
        }

        public Criteria andValidateDateIsNotNull() {
            addCriterion("validate_date is not null");
            return (Criteria) this;
        }

        public Criteria andValidateDateEqualTo(Date value) {
            addCriterionForJDBCDate("validate_date =", value, "validateDate");
            return (Criteria) this;
        }

        public Criteria andValidateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("validate_date <>", value, "validateDate");
            return (Criteria) this;
        }

        public Criteria andValidateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("validate_date >", value, "validateDate");
            return (Criteria) this;
        }

        public Criteria andValidateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("validate_date >=", value, "validateDate");
            return (Criteria) this;
        }

        public Criteria andValidateDateLessThan(Date value) {
            addCriterionForJDBCDate("validate_date <", value, "validateDate");
            return (Criteria) this;
        }

        public Criteria andValidateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("validate_date <=", value, "validateDate");
            return (Criteria) this;
        }

        public Criteria andValidateDateIn(List<Date> values) {
            addCriterionForJDBCDate("validate_date in", values, "validateDate");
            return (Criteria) this;
        }

        public Criteria andValidateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("validate_date not in", values, "validateDate");
            return (Criteria) this;
        }

        public Criteria andValidateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("validate_date between", value1, value2, "validateDate");
            return (Criteria) this;
        }

        public Criteria andValidateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("validate_date not between", value1, value2, "validateDate");
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