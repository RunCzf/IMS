package com.briup.crm.common.bean;

public class Drug {
    private Integer id;

    private Integer categoryId;

    private String barcode;

    private String name;

    private String description;

    private String dosageform;

    private String specifications;

    private String unit;

    private Double primeCost;

    private Double price;

    private Integer inventory;

    private Integer minimum;
    
    private Category category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getDosageform() {
        return dosageform;
    }

    public void setDosageform(String dosageform) {
        this.dosageform = dosageform == null ? null : dosageform.trim();
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Double getPrimeCost() {
        return primeCost;
    }

    public void setPrimeCost(Double primeCost) {
        this.primeCost = primeCost;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}