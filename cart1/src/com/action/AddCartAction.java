package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.Address;
import com.bean.Orders;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.CartService;

public class AddCartAction extends ActionSupport {
	private CartService cartService;
	private static final long serialVersionUID = 0;
	private int amount;
	private String foodName;
	public CartService getCartService() {
		return cartService;
	}
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	public String addOrder(){
		Map<String, Object> session = ActionContext.getContext().getSession(); 
		String userNo=session.get("userNo").toString();
		cartService.addOrder(foodName, amount, "", userNo);
		
		//重新获取request
		ActionContext ctx = ActionContext.getContext();                
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);

		cartService.setCartList(userNo);
		List<Orders> cartList = cartService.getCartList();
		String userAddr;
		if(request.getAttribute("userAddr")!=null){
			userAddr=request.getAttribute("userAddr").toString();
		}
		else{
			Address addr = cartService.getDefaultAddress(userNo);
			userAddr = addr.getUserAddr();
			}
		List<Address> userAddrList = cartService.addrList(userNo);
		
		int totalPrice = cartService.totalPrice();
		String planSendTime = cartService.planSendTime();
		int[] priceList = cartService.priceList();
		String[] picList = cartService.picList();
		
		
		request.setAttribute("cartList", cartList);
		request.setAttribute("userAddr", userAddr);
		request.setAttribute("userAddrList", userAddrList);
		request.setAttribute("totalPrice", totalPrice);
		request.setAttribute("planSendTime", planSendTime);
		request.setAttribute("priceList", priceList);
		request.setAttribute("picList", picList);
		
		/*Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("cartList", cartList);
		session.put("userAddr", userAddr);*/
		return "success";
	}

}
