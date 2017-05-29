package com.hello.beans;

import java.util.Date;
/*t_order: ordernum(订单号),orderstate(订单状态),ordertime(下单时间)
goods_name(商品名称),goods_price(商品价格),goods_num(购买数量)
address(详细地址),conname(收货人姓名),conphone(收货人电话)
sumpprice(订单总价)*/
public class Order {
	private int user_id;
	private int ordernum;
	private int orderstate;
	private Date ordertime;
	private String goods_name;
	private double goods_price;
	private int goods_number;
	private String address;
	private String conname;
	private String conphone;
	private double sumprice;
	private String orderimgurl;
	private String username;
	
	public Order(int ordernum, int orderstate, Date ordertime,
			String goods_name, double goods_price, int goods_number,
			String address, String conname, String conphone, double sumprice,
			String orderimgurl, String username) {
		super();
		this.ordernum = ordernum;
		this.orderstate = orderstate;
		this.ordertime = ordertime;
		this.goods_name = goods_name;
		this.goods_price = goods_price;
		this.goods_number = goods_number;
		this.address = address;
		this.conname = conname;
		this.conphone = conphone;
		this.sumprice = sumprice;
		this.orderimgurl = orderimgurl;
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Order(String orderimgurl) {
		super();
		this.orderimgurl = orderimgurl;
	}
	public String getOrderimgurl() {
		return orderimgurl;
	}
	public void setOrderimgurl(String orderimgurl) {
		this.orderimgurl = orderimgurl;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}
	public int getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(int orderstate) {
		this.orderstate = orderstate;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}
	public int getGoods_number() {
		return goods_number;
	}
	public void setGoods_number(int goods_number) {
		this.goods_number = goods_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getConname() {
		return conname;
	}
	public void setConname(String conname) {
		this.conname = conname;
	}
	public String getConphone() {
		return conphone;
	}
	public void setConphone(String conphone) {
		this.conphone = conphone;
	}
	public double getSumprice() {
		return sumprice;
	}
	public void setSumprice(double sumprice) {
		this.sumprice = sumprice;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Order(int user_id, int ordernum, int orderstate, Date ordertime,
			String goods_name, double goods_price, int goods_number,
			String address, String conname, String conphone, double sumprice,
			String orderimgurl) {
		super();
		this.user_id = user_id;
		this.ordernum = ordernum;
		this.orderstate = orderstate;
		this.ordertime = ordertime;
		this.goods_name = goods_name;
		this.goods_price = goods_price;
		this.goods_number = goods_number;
		this.address = address;
		this.conname = conname;
		this.conphone = conphone;
		this.sumprice = sumprice;
		this.orderimgurl = orderimgurl;
	}
	@Override
	public String toString() {
		return "Order [user_id=" + user_id + ", ordernum=" + ordernum
				+ ", orderstate=" + orderstate + ", ordertime=" + ordertime
				+ ", goods_name=" + goods_name + ", goods_price=" + goods_price
				+ ", goods_number=" + goods_number + ", address=" + address
				+ ", conname=" + conname + ", conphone=" + conphone
				+ ", sumprice=" + sumprice + ", orderimgurl=" + orderimgurl
				+ "]";
	}
	

	
	
	
}
