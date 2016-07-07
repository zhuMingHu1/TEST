package com.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.bean.Address;
import com.bean.AddressDAO;
import com.bean.FoodDAO;
import com.bean.OrdersDAO;
import com.bean.Orders;
public interface CartService  {
	
	
	public OrdersDAO getOrdersDAO();

	public void setOrdersDAO(OrdersDAO ordersDAO);
	
	public FoodDAO getFoodDAO();

	public void setFoodDAO(FoodDAO foodDAO);
	
	public AddressDAO getAddrDAO();
	
	public void setAddrDAO(AddressDAO addrDAO);
	
	
	public List<Orders> getCartList();
	
	public void setCartList(String userNo);
	
	public Address getDefaultAddress(String userNo);
	
	public List<Address> addrList(String userNo);
	
	public String[] picList();

	public int[] priceList();
	
	public int totalPrice();
	
	public String planSendTime();
	

	public void addOrder(String foodName, int amount, String address, String userNo);
	
	public void deleteOrder(int orderNo);
	
	public void payCart(String userAddr);

}
