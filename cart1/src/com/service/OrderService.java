package com.service;

import java.util.ArrayList;
import java.util.List;

import com.bean.FoodDAO;
import com.bean.Orders;
import com.bean.OrdersDAO;

public class OrderService {
	private OrdersDAO ordersDAO;
	private FoodDAO foodDAO;
	private List<Orders> orderList = new ArrayList<Orders>();
	
	public FoodDAO getFoodDAO() {
		return foodDAO;
	}

	public void setFoodDAO(FoodDAO foodDAO) {
		this.foodDAO = foodDAO;
	}

	public OrdersDAO getOrdersDAO() {
		return ordersDAO;
	}

	public void setOrdersDAO(OrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}
	
	public List<Orders> getOrderList() {
		return orderList;
	}
	
	public void setOrderList(String userNo) {
		List<Orders> list1 = new ArrayList<Orders>();
		List<Orders> list2 = new ArrayList<Orders>();
		List<Orders> list3 = new ArrayList<Orders>();
		list1 = this.ordersDAO.findByIsPay(true);
		list2 = this.ordersDAO.findByUserNo(userNo);//ÐèÒªÐÞ¸Ä
		int order1=0,order2=0;
		for(int i=0; i<list1.size(); i++){
			for(int j=0; j<list2.size(); j++){
				order1=list1.get(i).getOrderNo();
				order2=list2.get(j).getOrderNo();
				if(order1==order2){
					list3.add(list1.get(i));
				}
			}
		}
		this.orderList = list3;
	}
	
	public int[] priceList(){
		int[] priceList = new int[orderList.size()];
		int price = 0;
		int amount = 0;
		String foodName;
		for(int i=0; i<orderList.size(); i++){
			foodName = orderList.get(i).getFoodName();
			amount= orderList.get(i).getAmount();
			price = amount * this.foodDAO.findByFoodName(foodName).get(0).getFoodPrice();
			priceList[i] = price;
		}
		return priceList;
	}

}
