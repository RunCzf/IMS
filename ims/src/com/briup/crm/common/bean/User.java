package com.briup.crm.common.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
    private Integer id;

    private String name;

    private String gender;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birth;

    private String phone;

    private String address;

    private String card;

    private String education;

    private String position;

    private String professional;

    private Integer departmentId;

    private String username;

    private String password;

    private Integer roleId;

    private Department department;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card == null ? null : card.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional == null ? null : professional.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", birth=" + birth + ", phone=" + phone
				+ ", address=" + address + ", card=" + card + ", education=" + education + ", position=" + position
				+ ", professional=" + professional + ", departmentId=" + departmentId + ", username=" + username
				+ ", password=" + password + ", roleId=" + roleId + "]";
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
    
}