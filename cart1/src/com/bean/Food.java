package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Food entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "food", catalog = "takeout")
public class Food implements java.io.Serializable {

	// Fields

	private String foodNo;
	private String foodName;
	private String foodType;
	private byte foodPrice;
	private String foodPicture;

	// Constructors

	/** default constructor */
	public Food() {
	}

	/** full constructor */
	public Food(String foodName, String foodType, byte foodPrice,
			String foodPicture) {
		this.foodName = foodName;
		this.foodType = foodType;
		this.foodPrice = foodPrice;
		this.foodPicture = foodPicture;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "foodNo", unique = true, nullable = false, length = 8)
	public String getFoodNo() {
		return this.foodNo;
	}

	public void setFoodNo(String foodNo) {
		this.foodNo = foodNo;
	}

	@Column(name = "foodName", length = 10)
	public String getFoodName() {
		return this.foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	@Column(name = "foodType", length = 6)
	public String getFoodType() {
		return this.foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	@Column(name = "foodPrice", precision = 2, scale = 0)
	public byte getFoodPrice() {
		return this.foodPrice;
	}

	public void setFoodPrice(byte foodPrice) {
		this.foodPrice = foodPrice;
	}

	@Column(name = "foodPicture", length = 15)
	public String getFoodPicture() {
		return this.foodPicture;
	}

	public void setFoodPicture(String foodPicture) {
		this.foodPicture = foodPicture;
	}

}