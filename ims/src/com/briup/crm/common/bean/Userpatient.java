package com.briup.crm.common.bean;

import java.util.Date;

public class Userpatient {
    private Integer id;

    private Double price;

    private String status;

    private String symptom;

    private String advice;

    private Integer userId;

    private Integer patientId;

    private Date date;

    private String complained;

    private String pastmedicalhistory;

    private String historyofpresentillness;

    private String physicalexamresult;
    
    private Patient patient;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom == null ? null : symptom.trim();
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice == null ? null : advice.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComplained() {
        return complained;
    }

    public void setComplained(String complained) {
        this.complained = complained == null ? null : complained.trim();
    }

    public String getPastmedicalhistory() {
        return pastmedicalhistory;
    }

    public void setPastmedicalhistory(String pastmedicalhistory) {
        this.pastmedicalhistory = pastmedicalhistory == null ? null : pastmedicalhistory.trim();
    }

    public String getHistoryofpresentillness() {
        return historyofpresentillness;
    }

    public void setHistoryofpresentillness(String historyofpresentillness) {
        this.historyofpresentillness = historyofpresentillness == null ? null : historyofpresentillness.trim();
    }

    public String getPhysicalexamresult() {
        return physicalexamresult;
    }

    public void setPhysicalexamresult(String physicalexamresult) {
        this.physicalexamresult = physicalexamresult == null ? null : physicalexamresult.trim();
    }

    public Patient getPatient() {
    	return patient;
    }
    
    public void setPatient(Patient patient) {
    	this.patient = patient;
    }

	@Override
	public String toString() {
		return "Userpatient [id=" + id + ", price=" + price + ", status=" + status + ", symptom=" + symptom
				+ ", advice=" + advice + ", userId=" + userId + ", patientId=" + patientId + ", date=" + date
				+ ", complained=" + complained + ", pastmedicalhistory=" + pastmedicalhistory
				+ ", historyofpresentillness=" + historyofpresentillness + ", physicalexamresult=" + physicalexamresult
				+ ", patient=" + patient + "]";
	}

}