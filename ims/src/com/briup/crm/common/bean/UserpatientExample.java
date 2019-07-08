package com.briup.crm.common.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserpatientExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserpatientExample() {
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

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andSymptomIsNull() {
            addCriterion("symptom is null");
            return (Criteria) this;
        }

        public Criteria andSymptomIsNotNull() {
            addCriterion("symptom is not null");
            return (Criteria) this;
        }

        public Criteria andSymptomEqualTo(String value) {
            addCriterion("symptom =", value, "symptom");
            return (Criteria) this;
        }

        public Criteria andSymptomNotEqualTo(String value) {
            addCriterion("symptom <>", value, "symptom");
            return (Criteria) this;
        }

        public Criteria andSymptomGreaterThan(String value) {
            addCriterion("symptom >", value, "symptom");
            return (Criteria) this;
        }

        public Criteria andSymptomGreaterThanOrEqualTo(String value) {
            addCriterion("symptom >=", value, "symptom");
            return (Criteria) this;
        }

        public Criteria andSymptomLessThan(String value) {
            addCriterion("symptom <", value, "symptom");
            return (Criteria) this;
        }

        public Criteria andSymptomLessThanOrEqualTo(String value) {
            addCriterion("symptom <=", value, "symptom");
            return (Criteria) this;
        }

        public Criteria andSymptomLike(String value) {
            addCriterion("symptom like", value, "symptom");
            return (Criteria) this;
        }

        public Criteria andSymptomNotLike(String value) {
            addCriterion("symptom not like", value, "symptom");
            return (Criteria) this;
        }

        public Criteria andSymptomIn(List<String> values) {
            addCriterion("symptom in", values, "symptom");
            return (Criteria) this;
        }

        public Criteria andSymptomNotIn(List<String> values) {
            addCriterion("symptom not in", values, "symptom");
            return (Criteria) this;
        }

        public Criteria andSymptomBetween(String value1, String value2) {
            addCriterion("symptom between", value1, value2, "symptom");
            return (Criteria) this;
        }

        public Criteria andSymptomNotBetween(String value1, String value2) {
            addCriterion("symptom not between", value1, value2, "symptom");
            return (Criteria) this;
        }

        public Criteria andAdviceIsNull() {
            addCriterion("advice is null");
            return (Criteria) this;
        }

        public Criteria andAdviceIsNotNull() {
            addCriterion("advice is not null");
            return (Criteria) this;
        }

        public Criteria andAdviceEqualTo(String value) {
            addCriterion("advice =", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotEqualTo(String value) {
            addCriterion("advice <>", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceGreaterThan(String value) {
            addCriterion("advice >", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceGreaterThanOrEqualTo(String value) {
            addCriterion("advice >=", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceLessThan(String value) {
            addCriterion("advice <", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceLessThanOrEqualTo(String value) {
            addCriterion("advice <=", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceLike(String value) {
            addCriterion("advice like", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotLike(String value) {
            addCriterion("advice not like", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceIn(List<String> values) {
            addCriterion("advice in", values, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotIn(List<String> values) {
            addCriterion("advice not in", values, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceBetween(String value1, String value2) {
            addCriterion("advice between", value1, value2, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotBetween(String value1, String value2) {
            addCriterion("advice not between", value1, value2, "advice");
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

        public Criteria andPatientIdIsNull() {
            addCriterion("patient_id is null");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNotNull() {
            addCriterion("patient_id is not null");
            return (Criteria) this;
        }

        public Criteria andPatientIdEqualTo(Integer value) {
            addCriterion("patient_id =", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotEqualTo(Integer value) {
            addCriterion("patient_id <>", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThan(Integer value) {
            addCriterion("patient_id >", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("patient_id >=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThan(Integer value) {
            addCriterion("patient_id <", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThanOrEqualTo(Integer value) {
            addCriterion("patient_id <=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdIn(List<Integer> values) {
            addCriterion("patient_id in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotIn(List<Integer> values) {
            addCriterion("patient_id not in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdBetween(Integer value1, Integer value2) {
            addCriterion("patient_id between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotBetween(Integer value1, Integer value2) {
            addCriterion("patient_id not between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterion("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andComplainedIsNull() {
            addCriterion("complained is null");
            return (Criteria) this;
        }

        public Criteria andComplainedIsNotNull() {
            addCriterion("complained is not null");
            return (Criteria) this;
        }

        public Criteria andComplainedEqualTo(String value) {
            addCriterion("complained =", value, "complained");
            return (Criteria) this;
        }

        public Criteria andComplainedNotEqualTo(String value) {
            addCriterion("complained <>", value, "complained");
            return (Criteria) this;
        }

        public Criteria andComplainedGreaterThan(String value) {
            addCriterion("complained >", value, "complained");
            return (Criteria) this;
        }

        public Criteria andComplainedGreaterThanOrEqualTo(String value) {
            addCriterion("complained >=", value, "complained");
            return (Criteria) this;
        }

        public Criteria andComplainedLessThan(String value) {
            addCriterion("complained <", value, "complained");
            return (Criteria) this;
        }

        public Criteria andComplainedLessThanOrEqualTo(String value) {
            addCriterion("complained <=", value, "complained");
            return (Criteria) this;
        }

        public Criteria andComplainedLike(String value) {
            addCriterion("complained like", value, "complained");
            return (Criteria) this;
        }

        public Criteria andComplainedNotLike(String value) {
            addCriterion("complained not like", value, "complained");
            return (Criteria) this;
        }

        public Criteria andComplainedIn(List<String> values) {
            addCriterion("complained in", values, "complained");
            return (Criteria) this;
        }

        public Criteria andComplainedNotIn(List<String> values) {
            addCriterion("complained not in", values, "complained");
            return (Criteria) this;
        }

        public Criteria andComplainedBetween(String value1, String value2) {
            addCriterion("complained between", value1, value2, "complained");
            return (Criteria) this;
        }

        public Criteria andComplainedNotBetween(String value1, String value2) {
            addCriterion("complained not between", value1, value2, "complained");
            return (Criteria) this;
        }

        public Criteria andPastmedicalhistoryIsNull() {
            addCriterion("pastMedicalHistory is null");
            return (Criteria) this;
        }

        public Criteria andPastmedicalhistoryIsNotNull() {
            addCriterion("pastMedicalHistory is not null");
            return (Criteria) this;
        }

        public Criteria andPastmedicalhistoryEqualTo(String value) {
            addCriterion("pastMedicalHistory =", value, "pastmedicalhistory");
            return (Criteria) this;
        }

        public Criteria andPastmedicalhistoryNotEqualTo(String value) {
            addCriterion("pastMedicalHistory <>", value, "pastmedicalhistory");
            return (Criteria) this;
        }

        public Criteria andPastmedicalhistoryGreaterThan(String value) {
            addCriterion("pastMedicalHistory >", value, "pastmedicalhistory");
            return (Criteria) this;
        }

        public Criteria andPastmedicalhistoryGreaterThanOrEqualTo(String value) {
            addCriterion("pastMedicalHistory >=", value, "pastmedicalhistory");
            return (Criteria) this;
        }

        public Criteria andPastmedicalhistoryLessThan(String value) {
            addCriterion("pastMedicalHistory <", value, "pastmedicalhistory");
            return (Criteria) this;
        }

        public Criteria andPastmedicalhistoryLessThanOrEqualTo(String value) {
            addCriterion("pastMedicalHistory <=", value, "pastmedicalhistory");
            return (Criteria) this;
        }

        public Criteria andPastmedicalhistoryLike(String value) {
            addCriterion("pastMedicalHistory like", value, "pastmedicalhistory");
            return (Criteria) this;
        }

        public Criteria andPastmedicalhistoryNotLike(String value) {
            addCriterion("pastMedicalHistory not like", value, "pastmedicalhistory");
            return (Criteria) this;
        }

        public Criteria andPastmedicalhistoryIn(List<String> values) {
            addCriterion("pastMedicalHistory in", values, "pastmedicalhistory");
            return (Criteria) this;
        }

        public Criteria andPastmedicalhistoryNotIn(List<String> values) {
            addCriterion("pastMedicalHistory not in", values, "pastmedicalhistory");
            return (Criteria) this;
        }

        public Criteria andPastmedicalhistoryBetween(String value1, String value2) {
            addCriterion("pastMedicalHistory between", value1, value2, "pastmedicalhistory");
            return (Criteria) this;
        }

        public Criteria andPastmedicalhistoryNotBetween(String value1, String value2) {
            addCriterion("pastMedicalHistory not between", value1, value2, "pastmedicalhistory");
            return (Criteria) this;
        }

        public Criteria andHistoryofpresentillnessIsNull() {
            addCriterion("historyOfPresentIllness is null");
            return (Criteria) this;
        }

        public Criteria andHistoryofpresentillnessIsNotNull() {
            addCriterion("historyOfPresentIllness is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryofpresentillnessEqualTo(String value) {
            addCriterion("historyOfPresentIllness =", value, "historyofpresentillness");
            return (Criteria) this;
        }

        public Criteria andHistoryofpresentillnessNotEqualTo(String value) {
            addCriterion("historyOfPresentIllness <>", value, "historyofpresentillness");
            return (Criteria) this;
        }

        public Criteria andHistoryofpresentillnessGreaterThan(String value) {
            addCriterion("historyOfPresentIllness >", value, "historyofpresentillness");
            return (Criteria) this;
        }

        public Criteria andHistoryofpresentillnessGreaterThanOrEqualTo(String value) {
            addCriterion("historyOfPresentIllness >=", value, "historyofpresentillness");
            return (Criteria) this;
        }

        public Criteria andHistoryofpresentillnessLessThan(String value) {
            addCriterion("historyOfPresentIllness <", value, "historyofpresentillness");
            return (Criteria) this;
        }

        public Criteria andHistoryofpresentillnessLessThanOrEqualTo(String value) {
            addCriterion("historyOfPresentIllness <=", value, "historyofpresentillness");
            return (Criteria) this;
        }

        public Criteria andHistoryofpresentillnessLike(String value) {
            addCriterion("historyOfPresentIllness like", value, "historyofpresentillness");
            return (Criteria) this;
        }

        public Criteria andHistoryofpresentillnessNotLike(String value) {
            addCriterion("historyOfPresentIllness not like", value, "historyofpresentillness");
            return (Criteria) this;
        }

        public Criteria andHistoryofpresentillnessIn(List<String> values) {
            addCriterion("historyOfPresentIllness in", values, "historyofpresentillness");
            return (Criteria) this;
        }

        public Criteria andHistoryofpresentillnessNotIn(List<String> values) {
            addCriterion("historyOfPresentIllness not in", values, "historyofpresentillness");
            return (Criteria) this;
        }

        public Criteria andHistoryofpresentillnessBetween(String value1, String value2) {
            addCriterion("historyOfPresentIllness between", value1, value2, "historyofpresentillness");
            return (Criteria) this;
        }

        public Criteria andHistoryofpresentillnessNotBetween(String value1, String value2) {
            addCriterion("historyOfPresentIllness not between", value1, value2, "historyofpresentillness");
            return (Criteria) this;
        }

        public Criteria andPhysicalexamresultIsNull() {
            addCriterion("physicalExamResult is null");
            return (Criteria) this;
        }

        public Criteria andPhysicalexamresultIsNotNull() {
            addCriterion("physicalExamResult is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicalexamresultEqualTo(String value) {
            addCriterion("physicalExamResult =", value, "physicalexamresult");
            return (Criteria) this;
        }

        public Criteria andPhysicalexamresultNotEqualTo(String value) {
            addCriterion("physicalExamResult <>", value, "physicalexamresult");
            return (Criteria) this;
        }

        public Criteria andPhysicalexamresultGreaterThan(String value) {
            addCriterion("physicalExamResult >", value, "physicalexamresult");
            return (Criteria) this;
        }

        public Criteria andPhysicalexamresultGreaterThanOrEqualTo(String value) {
            addCriterion("physicalExamResult >=", value, "physicalexamresult");
            return (Criteria) this;
        }

        public Criteria andPhysicalexamresultLessThan(String value) {
            addCriterion("physicalExamResult <", value, "physicalexamresult");
            return (Criteria) this;
        }

        public Criteria andPhysicalexamresultLessThanOrEqualTo(String value) {
            addCriterion("physicalExamResult <=", value, "physicalexamresult");
            return (Criteria) this;
        }

        public Criteria andPhysicalexamresultLike(String value) {
            addCriterion("physicalExamResult like", value, "physicalexamresult");
            return (Criteria) this;
        }

        public Criteria andPhysicalexamresultNotLike(String value) {
            addCriterion("physicalExamResult not like", value, "physicalexamresult");
            return (Criteria) this;
        }

        public Criteria andPhysicalexamresultIn(List<String> values) {
            addCriterion("physicalExamResult in", values, "physicalexamresult");
            return (Criteria) this;
        }

        public Criteria andPhysicalexamresultNotIn(List<String> values) {
            addCriterion("physicalExamResult not in", values, "physicalexamresult");
            return (Criteria) this;
        }

        public Criteria andPhysicalexamresultBetween(String value1, String value2) {
            addCriterion("physicalExamResult between", value1, value2, "physicalexamresult");
            return (Criteria) this;
        }

        public Criteria andPhysicalexamresultNotBetween(String value1, String value2) {
            addCriterion("physicalExamResult not between", value1, value2, "physicalexamresult");
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