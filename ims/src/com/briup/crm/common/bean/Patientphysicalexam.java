package com.briup.crm.common.bean;

public class Patientphysicalexam {
    private Integer id;

    private Double cost;

    private Integer patientId;

    private Integer physicalId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getPhysicalId() {
        return physicalId;
    }

    public void setPhysicalId(Integer physicalId) {
        this.physicalId = physicalId;
    }
}