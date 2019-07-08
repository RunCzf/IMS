package com.briup.crm.common.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Patient {
    private Integer id;

    private String name;

    private Integer age;

    private String gender;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birth;

    private String merriage;

    private String address;

    private String drugallergy;

    private String cardno;

    private Double balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getMerriage() {
        return merriage;
    }

    public void setMerriage(String merriage) {
        this.merriage = merriage == null ? null : merriage.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getDrugallergy() {
        return drugallergy;
    }

    public void setDrugallergy(String drugallergy) {
        this.drugallergy = drugallergy == null ? null : drugallergy.trim();
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}