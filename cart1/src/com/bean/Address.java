package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Address entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "address", catalog = "takeout")
public class Address implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userAddr;
	private Integer addrNo;
	private String userNo;

	// Constructors

	/** default constructor */
	public Address() {
	}

	/** full constructor */
	public Address(String userAddr, Integer addrNo, String userNo) {
		this.userAddr = userAddr;
		this.addrNo = addrNo;
		this.userNo = userNo;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "userAddr", length = 100)
	public String getUserAddr() {
		return this.userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	@Column(name = "addrNo")
	public Integer getAddrNo() {
		return this.addrNo;
	}

	public void setAddrNo(Integer addrNo) {
		this.addrNo = addrNo;
	}

	@Column(name = "userNo", length = 11)
	public String getUserNo() {
		return this.userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

}