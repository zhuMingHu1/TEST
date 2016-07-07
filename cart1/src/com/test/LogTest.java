package com.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.service.CartService;

public class LogTest {
	private CartService cs;
	public CartService getCs() {
		return cs;
	}

	public void setCs(CartService cs) {
		this.cs = cs;
	}
	@Test
	public void test() {
		int p = cs.totalPrice();
		System.out.println(p);
	}

	

}
