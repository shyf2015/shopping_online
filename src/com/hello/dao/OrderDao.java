package com.hello.dao;

import java.util.ArrayList;
import java.util.List;

import com.hello.beans.Address;
import com.hello.beans.Car;
import com.hello.beans.Goods;
import com.hello.beans.Order;
import com.hello.beans.Pager;
import com.hello.beans.Param;

public interface OrderDao {
	public List<Address> listAddressById(int id);	
//	public List<Order> listOrderbyId(int id);
	public List<Order> listAllOrderbyId(int id);
	public String getcolorByimgurl(String imgurl);
	//public Car 
	public Car carquery(int car_id);
	public Goods querygoodsBycarid(int car_id);
	public Param queryBygoodsid(int goodsid);
	public void updata(int ordernum,int state);
	public int getMax();
	public List<Order> listByState(int userid,int state);
	public Pager getPagerByState(int currPage,int pageSize,int userid,int state);
	//public void add(Order order);

	

	public Pager getPager(int currPage,int pageSize,int userid);
	public int getDataCount();
	public Pager getPager(int currPage, int pageSize);
	public void updateOrderstate(int ordernum);
	public void deleteOrder(int ordernum);
	
	
	
	public void updateGoodsnum(int goodsid, int num);
	public int getGoodsNumByGoodsId(int goodsid);
	
	
	public String getOrderstateByordernum(int ordernum);

}
