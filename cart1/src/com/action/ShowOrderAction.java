package com.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bean.Orders;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.OrderService;

public class ShowOrderAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private OrderService orderService;
	private String userNo;

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	
	public String showOrder(){
		userNo="110";//
		//Map<String, Object> session = ActionContext.getContext().getSession(); 
		//userNo=session.get("userNo").toString();
		orderService.setOrderList(userNo);
		List<Orders> orderList=orderService.getOrderList();
		int[] priceList = orderService.priceList();
		int i,j=0;
		
		for(i=1; i<orderList.size();i++){
			if(orderList.get(i).getOrderTime().equals(orderList.get(i-1).getOrderTime())){
				orderList.get(i).setOrderNo(null);
				orderList.get(i).setAddress(null);
				orderList.get(i).setOrderTime(null);
				priceList[j] += priceList[i];
				priceList[i] = 0;
			}
			else{
				j=i;
			}
		}
		
		String Time="";
		Date orderTime = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm");
		for(i=0;i<orderList.size();i++){
			if(priceList[i]==0){
				orderList.get(i).setUserNo(null);
			}
			else{
				orderList.get(i).setUserNo("￥"+priceList[i]);
				
				Time =  df.format(orderList.get(i).getOrderTime());// new Date()为获取当前系统时间
				try {
					orderTime = df.parse(Time);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				orderList.get(i).setOrderTime(orderTime);
			}
		}
		ActionContext ctx = ActionContext.getContext();                
		HttpServletRequest request = (HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		request.setAttribute("orderList", orderList);
		return "success";
		
	}

}
