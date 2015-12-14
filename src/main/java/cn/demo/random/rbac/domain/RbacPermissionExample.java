package cn.demo.random.rbac.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RbacPermissionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RbacPermissionExample() {
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

        public Criteria andPsIdIsNull() {
            addCriterion("ps_id is null");
            return (Criteria) this;
        }

        public Criteria andPsIdIsNotNull() {
            addCriterion("ps_id is not null");
            return (Criteria) this;
        }

        public Criteria andPsIdEqualTo(Long value) {
            addCriterion("ps_id =", value, "psId");
            return (Criteria) this;
        }

        public Criteria andPsIdNotEqualTo(Long value) {
            addCriterion("ps_id <>", value, "psId");
            return (Criteria) this;
        }

        public Criteria andPsIdGreaterThan(Long value) {
            addCriterion("ps_id >", value, "psId");
            return (Criteria) this;
        }

        public Criteria andPsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ps_id >=", value, "psId");
            return (Criteria) this;
        }

        public Criteria andPsIdLessThan(Long value) {
            addCriterion("ps_id <", value, "psId");
            return (Criteria) this;
        }

        public Criteria andPsIdLessThanOrEqualTo(Long value) {
            addCriterion("ps_id <=", value, "psId");
            return (Criteria) this;
        }

        public Criteria andPsIdIn(List<Long> values) {
            addCriterion("ps_id in", values, "psId");
            return (Criteria) this;
        }

        public Criteria andPsIdNotIn(List<Long> values) {
            addCriterion("ps_id not in", values, "psId");
            return (Criteria) this;
        }

        public Criteria andPsIdBetween(Long value1, Long value2) {
            addCriterion("ps_id between", value1, value2, "psId");
            return (Criteria) this;
        }

        public Criteria andPsIdNotBetween(Long value1, Long value2) {
            addCriterion("ps_id not between", value1, value2, "psId");
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

        public Criteria andPsDescriptionIsNull() {
            addCriterion("ps_description is null");
            return (Criteria) this;
        }

        public Criteria andPsDescriptionIsNotNull() {
            addCriterion("ps_description is not null");
            return (Criteria) this;
        }

        public Criteria andPsDescriptionEqualTo(String value) {
            addCriterion("ps_description =", value, "psDescription");
            return (Criteria) this;
        }

        public Criteria andPsDescriptionNotEqualTo(String value) {
            addCriterion("ps_description <>", value, "psDescription");
            return (Criteria) this;
        }

        public Criteria andPsDescriptionGreaterThan(String value) {
            addCriterion("ps_description >", value, "psDescription");
            return (Criteria) this;
        }

        public Criteria andPsDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("ps_description >=", value, "psDescription");
            return (Criteria) this;
        }

        public Criteria andPsDescriptionLessThan(String value) {
            addCriterion("ps_description <", value, "psDescription");
            return (Criteria) this;
        }

        public Criteria andPsDescriptionLessThanOrEqualTo(String value) {
            addCriterion("ps_description <=", value, "psDescription");
            return (Criteria) this;
        }

        public Criteria andPsDescriptionLike(String value) {
            addCriterion("ps_description like", value, "psDescription");
            return (Criteria) this;
        }

        public Criteria andPsDescriptionNotLike(String value) {
            addCriterion("ps_description not like", value, "psDescription");
            return (Criteria) this;
        }

        public Criteria andPsDescriptionIn(List<String> values) {
            addCriterion("ps_description in", values, "psDescription");
            return (Criteria) this;
        }

        public Criteria andPsDescriptionNotIn(List<String> values) {
            addCriterion("ps_description not in", values, "psDescription");
            return (Criteria) this;
        }

        public Criteria andPsDescriptionBetween(String value1, String value2) {
            addCriterion("ps_description between", value1, value2, "psDescription");
            return (Criteria) this;
        }

        public Criteria andPsDescriptionNotBetween(String value1, String value2) {
            addCriterion("ps_description not between", value1, value2, "psDescription");
            return (Criteria) this;
        }

        public Criteria andPsGroupIsNull() {
            addCriterion("ps_group is null");
            return (Criteria) this;
        }

        public Criteria andPsGroupIsNotNull() {
            addCriterion("ps_group is not null");
            return (Criteria) this;
        }

        public Criteria andPsGroupEqualTo(String value) {
            addCriterion("ps_group =", value, "psGroup");
            return (Criteria) this;
        }

        public Criteria andPsGroupNotEqualTo(String value) {
            addCriterion("ps_group <>", value, "psGroup");
            return (Criteria) this;
        }

        public Criteria andPsGroupGreaterThan(String value) {
            addCriterion("ps_group >", value, "psGroup");
            return (Criteria) this;
        }

        public Criteria andPsGroupGreaterThanOrEqualTo(String value) {
            addCriterion("ps_group >=", value, "psGroup");
            return (Criteria) this;
        }

        public Criteria andPsGroupLessThan(String value) {
            addCriterion("ps_group <", value, "psGroup");
            return (Criteria) this;
        }

        public Criteria andPsGroupLessThanOrEqualTo(String value) {
            addCriterion("ps_group <=", value, "psGroup");
            return (Criteria) this;
        }

        public Criteria andPsGroupLike(String value) {
            addCriterion("ps_group like", value, "psGroup");
            return (Criteria) this;
        }

        public Criteria andPsGroupNotLike(String value) {
            addCriterion("ps_group not like", value, "psGroup");
            return (Criteria) this;
        }

        public Criteria andPsGroupIn(List<String> values) {
            addCriterion("ps_group in", values, "psGroup");
            return (Criteria) this;
        }

        public Criteria andPsGroupNotIn(List<String> values) {
            addCriterion("ps_group not in", values, "psGroup");
            return (Criteria) this;
        }

        public Criteria andPsGroupBetween(String value1, String value2) {
            addCriterion("ps_group between", value1, value2, "psGroup");
            return (Criteria) this;
        }

        public Criteria andPsGroupNotBetween(String value1, String value2) {
            addCriterion("ps_group not between", value1, value2, "psGroup");
            return (Criteria) this;
        }

        public Criteria andPsNameIsNull() {
            addCriterion("ps_name is null");
            return (Criteria) this;
        }

        public Criteria andPsNameIsNotNull() {
            addCriterion("ps_name is not null");
            return (Criteria) this;
        }

        public Criteria andPsNameEqualTo(String value) {
            addCriterion("ps_name =", value, "psName");
            return (Criteria) this;
        }

        public Criteria andPsNameNotEqualTo(String value) {
            addCriterion("ps_name <>", value, "psName");
            return (Criteria) this;
        }

        public Criteria andPsNameGreaterThan(String value) {
            addCriterion("ps_name >", value, "psName");
            return (Criteria) this;
        }

        public Criteria andPsNameGreaterThanOrEqualTo(String value) {
            addCriterion("ps_name >=", value, "psName");
            return (Criteria) this;
        }

        public Criteria andPsNameLessThan(String value) {
            addCriterion("ps_name <", value, "psName");
            return (Criteria) this;
        }

        public Criteria andPsNameLessThanOrEqualTo(String value) {
            addCriterion("ps_name <=", value, "psName");
            return (Criteria) this;
        }

        public Criteria andPsNameLike(String value) {
            addCriterion("ps_name like", value, "psName");
            return (Criteria) this;
        }

        public Criteria andPsNameNotLike(String value) {
            addCriterion("ps_name not like", value, "psName");
            return (Criteria) this;
        }

        public Criteria andPsNameIn(List<String> values) {
            addCriterion("ps_name in", values, "psName");
            return (Criteria) this;
        }

        public Criteria andPsNameNotIn(List<String> values) {
            addCriterion("ps_name not in", values, "psName");
            return (Criteria) this;
        }

        public Criteria andPsNameBetween(String value1, String value2) {
            addCriterion("ps_name between", value1, value2, "psName");
            return (Criteria) this;
        }

        public Criteria andPsNameNotBetween(String value1, String value2) {
            addCriterion("ps_name not between", value1, value2, "psName");
            return (Criteria) this;
        }

        public Criteria andPsTypeIsNull() {
            addCriterion("ps_type is null");
            return (Criteria) this;
        }

        public Criteria andPsTypeIsNotNull() {
            addCriterion("ps_type is not null");
            return (Criteria) this;
        }

        public Criteria andPsTypeEqualTo(String value) {
            addCriterion("ps_type =", value, "psType");
            return (Criteria) this;
        }

        public Criteria andPsTypeNotEqualTo(String value) {
            addCriterion("ps_type <>", value, "psType");
            return (Criteria) this;
        }

        public Criteria andPsTypeGreaterThan(String value) {
            addCriterion("ps_type >", value, "psType");
            return (Criteria) this;
        }

        public Criteria andPsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ps_type >=", value, "psType");
            return (Criteria) this;
        }

        public Criteria andPsTypeLessThan(String value) {
            addCriterion("ps_type <", value, "psType");
            return (Criteria) this;
        }

        public Criteria andPsTypeLessThanOrEqualTo(String value) {
            addCriterion("ps_type <=", value, "psType");
            return (Criteria) this;
        }

        public Criteria andPsTypeLike(String value) {
            addCriterion("ps_type like", value, "psType");
            return (Criteria) this;
        }

        public Criteria andPsTypeNotLike(String value) {
            addCriterion("ps_type not like", value, "psType");
            return (Criteria) this;
        }

        public Criteria andPsTypeIn(List<String> values) {
            addCriterion("ps_type in", values, "psType");
            return (Criteria) this;
        }

        public Criteria andPsTypeNotIn(List<String> values) {
            addCriterion("ps_type not in", values, "psType");
            return (Criteria) this;
        }

        public Criteria andPsTypeBetween(String value1, String value2) {
            addCriterion("ps_type between", value1, value2, "psType");
            return (Criteria) this;
        }

        public Criteria andPsTypeNotBetween(String value1, String value2) {
            addCriterion("ps_type not between", value1, value2, "psType");
            return (Criteria) this;
        }

        public Criteria andPsUrlIsNull() {
            addCriterion("ps_url is null");
            return (Criteria) this;
        }

        public Criteria andPsUrlIsNotNull() {
            addCriterion("ps_url is not null");
            return (Criteria) this;
        }

        public Criteria andPsUrlEqualTo(String value) {
            addCriterion("ps_url =", value, "psUrl");
            return (Criteria) this;
        }

        public Criteria andPsUrlNotEqualTo(String value) {
            addCriterion("ps_url <>", value, "psUrl");
            return (Criteria) this;
        }

        public Criteria andPsUrlGreaterThan(String value) {
            addCriterion("ps_url >", value, "psUrl");
            return (Criteria) this;
        }

        public Criteria andPsUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ps_url >=", value, "psUrl");
            return (Criteria) this;
        }

        public Criteria andPsUrlLessThan(String value) {
            addCriterion("ps_url <", value, "psUrl");
            return (Criteria) this;
        }

        public Criteria andPsUrlLessThanOrEqualTo(String value) {
            addCriterion("ps_url <=", value, "psUrl");
            return (Criteria) this;
        }

        public Criteria andPsUrlLike(String value) {
            addCriterion("ps_url like", value, "psUrl");
            return (Criteria) this;
        }

        public Criteria andPsUrlNotLike(String value) {
            addCriterion("ps_url not like", value, "psUrl");
            return (Criteria) this;
        }

        public Criteria andPsUrlIn(List<String> values) {
            addCriterion("ps_url in", values, "psUrl");
            return (Criteria) this;
        }

        public Criteria andPsUrlNotIn(List<String> values) {
            addCriterion("ps_url not in", values, "psUrl");
            return (Criteria) this;
        }

        public Criteria andPsUrlBetween(String value1, String value2) {
            addCriterion("ps_url between", value1, value2, "psUrl");
            return (Criteria) this;
        }

        public Criteria andPsUrlNotBetween(String value1, String value2) {
            addCriterion("ps_url not between", value1, value2, "psUrl");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Long value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Long value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Long value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Long value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Long value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Long> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Long> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Long value1, Long value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Long value1, Long value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
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