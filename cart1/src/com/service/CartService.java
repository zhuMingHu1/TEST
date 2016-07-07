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
public class CartService  {
	private OrdersDAO ordersDAO;
	private FoodDAO foodDAO;
	private AddressDAO addrDAO;
	private List<Orders> cartList = new ArrayList<Orders>();
	
	public OrdersDAO getOrdersDAO() {
		return ordersDAO;
	}

	public void setOrdersDAO(OrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}
	
	public FoodDAO getFoodDAO() {
		return foodDAO;
	}

	public void setFoodDAO(FoodDAO foodDAO) {
		this.foodDAO = foodDAO;
	}
	
	public AddressDAO getAddrDAO() {
		return addrDAO;
	}

	public void setAddrDAO(AddressDAO addrDAO) {
		this.addrDAO = addrDAO;
	}
	
	
	public List<Orders> getCartList() {
		return cartList;
	}
	
	public void setCartList(String userNo) {
		List<Orders> list1 = new ArrayList<Orders>();
		List<Orders> list2 = new ArrayList<Orders>();
		List<Orders> list3 = new ArrayList<Orders>();
		list1 = this.ordersDAO.findByIsPay(false);
		list2 = this.ordersDAO.findByUserNo(userNo);//需要修改
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
		this.cartList = list3;
	}
	
	public Address getDefaultAddress(String userNo){
		List<Address> addrs = this.addrDAO.findByUserNo(userNo);
		Address defAddr = new Address();
		for(int i=0; i<addrs.size(); i++){
			if(addrs.get(i).getAddrNo()==0){
				defAddr = addrs.get(i);
			}
		}
		//this.address = defAddr;
		return defAddr;
	}
	
	public List<Address> addrList(String userNo){
		List<Address> addrs = this.addrDAO.findByUserNo(userNo);
		return addrs;
	}
	
	public String[] picList(){
		String[] picList = new String[cartList.size()];
		String foodName;
		for(int i=0; i<cartList.size(); i++){
			foodName = cartList.get(i).getFoodName();
			picList[i] = this.foodDAO.findByFoodName(foodName).get(0).getFoodPicture();
		}
		return picList;
	}

	public int[] priceList(){
		int[] priceList = new int[cartList.size()];
		int price = 0;
		int amount = 0;
		String foodName;
		for(int i=0; i<cartList.size(); i++){
			foodName = cartList.get(i).getFoodName();
			amount= cartList.get(i).getAmount();
			price = amount * this.foodDAO.findByFoodName(foodName).get(0).getFoodPrice();
			priceList[i] = price;
		}
		return priceList;
	}
	
	public int totalPrice(){
		int totalPrice = 0;
		int price = 0;
		int amount = 0;
		String foodName;
		for(int i=0; i<cartList.size(); i++){
			foodName = cartList.get(i).getFoodName();
			amount= cartList.get(i).getAmount();
			price = amount * this.foodDAO.findByFoodName(foodName).get(0).getFoodPrice();
			totalPrice = totalPrice + price;
		}
		return totalPrice;
	}
	
	public String planSendTime(){
		SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd HH:mm");//设置日期格式
		String Time =  df.format(new Date());// new Date()为获取当前系统时间
		Date orderTime = new Date();
		try {
			orderTime = df.parse(Time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cOT = java.util.Calendar.getInstance(); 
		cOT.setTime(orderTime);
		cOT.add(Calendar.MINUTE, +30);
		Date sendTime = cOT.getTime();
		String planSendTime = df.format(sendTime);
		return planSendTime;
	}
	

	public void addOrder(String foodName, int amount, String address, String userNo){
		Orders order = new Orders(amount,null,null, false, address, foodName, userNo);
		this.ordersDAO.save(order);
	}
	
	public void deleteOrder(int orderNo){
		Orders order = this.ordersDAO.findById(orderNo);
		this.ordersDAO.delete(order);
	}
	
	/*public void addAmount(int orderNo){
		Orders order = this.ordersDAO.findById(orderNo);
		this.ordersDAO.delete(order);
		order.setAmount(order.getAmount()+1);
		this.ordersDAO.save(order);
	}
	
	public void minusAmount(int orderNo){
		Orders order = this.ordersDAO.findById(orderNo);
		this.ordersDAO.delete(order);
		order.setAmount(order.getAmount()-1);
		this.ordersDAO.save(order);
	}*/
	
	public void payCart(String userAddr){
		List<Orders> list1 = this.cartList;
		Date orderTime=new Date(), sendTime=new Date();
		Calendar cOT = java.util.Calendar.getInstance();
		String Time;
		SimpleDateFormat df;
		for(int i=0; i<list1.size(); i++){
			ordersDAO.delete(list1.get(i));
			list1.get(i).setIsPay(true);
			df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			Time =  df.format(new Date());// new Date()为获取当前系统时间
			try {
				orderTime = df.parse(Time);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cOT.setTime(orderTime);
			cOT.add(Calendar.MINUTE, +30);
			sendTime = cOT.getTime();
			list1.get(i).setOrderTime(orderTime);
			list1.get(i).setSendTime(sendTime);
			list1.get(i).setAddress(userAddr);
			ordersDAO.save(list1.get(i));
		}
		cartList.clear();

	}

}
