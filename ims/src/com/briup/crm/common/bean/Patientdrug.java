package com.briup.crm.common.bean;

public class Patientdrug {
    private Integer id;

    private Double cost;

    private Integer patientId;

    private Integer drugId;

    @Override
	public String toString() {
		return "Patientdrug [id=" + id + ", cost=" + cost + ", patientId=" + patientId + ", drugId=" + drugId + ", num="
				+ num + "]";
	}

	private Integer num;

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

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}