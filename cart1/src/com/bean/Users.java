package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "users", catalog = "takeout")
public class Users implements java.io.Serializable {

	// Fields

	private Integer userNo;
	private String password;
	private boolean sex;
	private String phoneNumber;
	private boolean isLogin;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String password) {
		this.password = password;
	}

	/** full constructor */
	public Users(String password, boolean sex, String phoneNumber,
			boolean isLogin) {
		this.password = password;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.isLogin = isLogin;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "userNo", unique = true, nullable = false)
	public Integer getUserNo() {
		return this.userNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	@Column(name = "password", nullable = false, length = 16)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "sex")
	public boolean getSex() {
		return this.sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	@Column(name = "phoneNumber", length = 11)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "isLogin")
	public boolean getIsLogin() {
		return this.isLogin;
	}

	public void setIsLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

}