package com.ml.prize.commons.entity;

import java.util.ArrayList;
import java.util.List;

public class GameRuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GameRuleExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andGameRuleIdIsNull() {
            addCriterion("game_rule_id is null");
            return (Criteria) this;
        }

        public Criteria andGameRuleIdIsNotNull() {
            addCriterion("game_rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andGameRuleIdEqualTo(Integer value) {
            addCriterion("game_rule_id =", value, "gameRuleId");
            return (Criteria) this;
        }

        public Criteria andGameRuleIdNotEqualTo(Integer value) {
            addCriterion("game_rule_id <>", value, "gameRuleId");
            return (Criteria) this;
        }

        public Criteria andGameRuleIdGreaterThan(Integer value) {
            addCriterion("game_rule_id >", value, "gameRuleId");
            return (Criteria) this;
        }

        public Criteria andGameRuleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("game_rule_id >=", value, "gameRuleId");
            return (Criteria) this;
        }

        public Criteria andGameRuleIdLessThan(Integer value) {
            addCriterion("game_rule_id <", value, "gameRuleId");
            return (Criteria) this;
        }

        public Criteria andGameRuleIdLessThanOrEqualTo(Integer value) {
            addCriterion("game_rule_id <=", value, "gameRuleId");
            return (Criteria) this;
        }

        public Criteria andGameRuleIdIn(List<Integer> values) {
            addCriterion("game_rule_id in", values, "gameRuleId");
            return (Criteria) this;
        }

        public Criteria andGameRuleIdNotIn(List<Integer> values) {
            addCriterion("game_rule_id not in", values, "gameRuleId");
            return (Criteria) this;
        }

        public Criteria andGameRuleIdBetween(Integer value1, Integer value2) {
            addCriterion("game_rule_id between", value1, value2, "gameRuleId");
            return (Criteria) this;
        }

        public Criteria andGameRuleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("game_rule_id not between", value1, value2, "gameRuleId");
            return (Criteria) this;
        }

        public Criteria andGameIdIsNull() {
            addCriterion("game_id is null");
            return (Criteria) this;
        }

        public Criteria andGameIdIsNotNull() {
            addCriterion("game_id is not null");
            return (Criteria) this;
        }

        public Criteria andGameIdEqualTo(Integer value) {
            addCriterion("game_id =", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotEqualTo(Integer value) {
            addCriterion("game_id <>", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThan(Integer value) {
            addCriterion("game_id >", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("game_id >=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThan(Integer value) {
            addCriterion("game_id <", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdLessThanOrEqualTo(Integer value) {
            addCriterion("game_id <=", value, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdIn(List<Integer> values) {
            addCriterion("game_id in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotIn(List<Integer> values) {
            addCriterion("game_id not in", values, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdBetween(Integer value1, Integer value2) {
            addCriterion("game_id between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andGameIdNotBetween(Integer value1, Integer value2) {
            addCriterion("game_id not between", value1, value2, "gameId");
            return (Criteria) this;
        }

        public Criteria andUserLevelIsNull() {
            addCriterion("user_level is null");
            return (Criteria) this;
        }

        public Criteria andUserLevelIsNotNull() {
            addCriterion("user_level is not null");
            return (Criteria) this;
        }

        public Criteria andUserLevelEqualTo(Integer value) {
            addCriterion("user_level =", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelNotEqualTo(Integer value) {
            addCriterion("user_level <>", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelGreaterThan(Integer value) {
            addCriterion("user_level >", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_level >=", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelLessThan(Integer value) {
            addCriterion("user_level <", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelLessThanOrEqualTo(Integer value) {
            addCriterion("user_level <=", value, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelIn(List<Integer> values) {
            addCriterion("user_level in", values, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelNotIn(List<Integer> values) {
            addCriterion("user_level not in", values, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelBetween(Integer value1, Integer value2) {
            addCriterion("user_level between", value1, value2, "userLevel");
            return (Criteria) this;
        }

        public Criteria andUserLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("user_level not between", value1, value2, "userLevel");
            return (Criteria) this;
        }

        public Criteria andEnterTimesIsNull() {
            addCriterion("enter_times is null");
            return (Criteria) this;
        }

        public Criteria andEnterTimesIsNotNull() {
            addCriterion("enter_times is not null");
            return (Criteria) this;
        }

        public Criteria andEnterTimesEqualTo(Short value) {
            addCriterion("enter_times =", value, "enterTimes");
            return (Criteria) this;
        }

        public Criteria andEnterTimesNotEqualTo(Short value) {
            addCriterion("enter_times <>", value, "enterTimes");
            return (Criteria) this;
        }

        public Criteria andEnterTimesGreaterThan(Short value) {
            addCriterion("enter_times >", value, "enterTimes");
            return (Criteria) this;
        }

        public Criteria andEnterTimesGreaterThanOrEqualTo(Short value) {
            addCriterion("enter_times >=", value, "enterTimes");
            return (Criteria) this;
        }

        public Criteria andEnterTimesLessThan(Short value) {
            addCriterion("enter_times <", value, "enterTimes");
            return (Criteria) this;
        }

        public Criteria andEnterTimesLessThanOrEqualTo(Short value) {
            addCriterion("enter_times <=", value, "enterTimes");
            return (Criteria) this;
        }

        public Criteria andEnterTimesIn(List<Short> values) {
            addCriterion("enter_times in", values, "enterTimes");
            return (Criteria) this;
        }

        public Criteria andEnterTimesNotIn(List<Short> values) {
            addCriterion("enter_times not in", values, "enterTimes");
            return (Criteria) this;
        }

        public Criteria andEnterTimesBetween(Short value1, Short value2) {
            addCriterion("enter_times between", value1, value2, "enterTimes");
            return (Criteria) this;
        }

        public Criteria andEnterTimesNotBetween(Short value1, Short value2) {
            addCriterion("enter_times not between", value1, value2, "enterTimes");
            return (Criteria) this;
        }

        public Criteria andGoalTimesIsNull() {
            addCriterion("goal_times is null");
            return (Criteria) this;
        }

        public Criteria andGoalTimesIsNotNull() {
            addCriterion("goal_times is not null");
            return (Criteria) this;
        }

        public Criteria andGoalTimesEqualTo(Short value) {
            addCriterion("goal_times =", value, "goalTimes");
            return (Criteria) this;
        }

        public Criteria andGoalTimesNotEqualTo(Short value) {
            addCriterion("goal_times <>", value, "goalTimes");
            return (Criteria) this;
        }

        public Criteria andGoalTimesGreaterThan(Short value) {
            addCriterion("goal_times >", value, "goalTimes");
            return (Criteria) this;
        }

        public Criteria andGoalTimesGreaterThanOrEqualTo(Short value) {
            addCriterion("goal_times >=", value, "goalTimes");
            return (Criteria) this;
        }

        public Criteria andGoalTimesLessThan(Short value) {
            addCriterion("goal_times <", value, "goalTimes");
            return (Criteria) this;
        }

        public Criteria andGoalTimesLessThanOrEqualTo(Short value) {
            addCriterion("goal_times <=", value, "goalTimes");
            return (Criteria) this;
        }

        public Criteria andGoalTimesIn(List<Short> values) {
            addCriterion("goal_times in", values, "goalTimes");
            return (Criteria) this;
        }

        public Criteria andGoalTimesNotIn(List<Short> values) {
            addCriterion("goal_times not in", values, "goalTimes");
            return (Criteria) this;
        }

        public Criteria andGoalTimesBetween(Short value1, Short value2) {
            addCriterion("goal_times between", value1, value2, "goalTimes");
            return (Criteria) this;
        }

        public Criteria andGoalTimesNotBetween(Short value1, Short value2) {
            addCriterion("goal_times not between", value1, value2, "goalTimes");
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