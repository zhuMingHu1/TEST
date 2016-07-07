package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.Address;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.CartService;

public class PayCartAction extends ActionSupport {
	private CartService cartService;
	private static final long serialVersionUID = 0;
	private String userNo = new String();
	
	public CartService getCartService() {
		return cartService;
	}
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	
	public void payCart(){
		String userAddr;
		ActionContext ctx = ActionContext.getContext();                
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		if(request.getAttribute("userAddr")!=null){
			userAddr=request.getAttribute("userAddr").toString();
		}
		else{
			Address addr = cartService.getDefaultAddress(userNo);
			userAddr = addr.getUserAddr();
		}
		cartService.payCart(userAddr);
	}

}
