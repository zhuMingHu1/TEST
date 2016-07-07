package com.bean;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orders", catalog = "takeout")
public class Orders implements java.io.Serializable {

	// Fields

	private Integer orderNo;
	private Integer amount;
	private Date orderTime;
	private Date sendTime;
	private boolean isPay;
	private String address;
	private String foodName;
	private String userNo;

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** full constructor */
	public Orders(Integer amount, Date orderTime, Date sendTime, boolean isPay,
			String address, String foodName, String userNo) {
		this.amount = amount;
		this.orderTime = orderTime;
		this.sendTime = sendTime;
		this.isPay = isPay;
		this.address = address;
		this.foodName = foodName;
		this.userNo = userNo;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "orderNo", unique = true, nullable = false)
	public Integer getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	@Column(name = "amount")
	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Column(name = "orderTime", length = 19)
	public Date getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	@Column(name = "sendTime", length = 19)
	public Date getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	@Column(name = "isPay")
	public boolean getIsPay() {
		return this.isPay;
	}

	public void setIsPay(boolean isPay) {
		this.isPay = isPay;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "foodName", length = 10)
	public String getFoodName() {
		return this.foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	@Column(name = "userNo", length = 11)
	public String getUserNo() {
		return this.userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

}