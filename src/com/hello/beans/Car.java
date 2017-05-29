package com.hello.beans;

import java.util.List;

/*（购物车） t_car:  carid(购物车ID),user_id(用户ID),goods_id(商品ID),
goods_num(购买数量)*/
public class Car {
	
	private int goods_num; 
	private int carid;
	private int goods_id;
	private int user_id;
	
	private String imgurl;
	private Goods goods;
	private Param params;
	
	
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Param getParams() {
		return params;
	}
	public void setParams(Param params) {
		this.params = params;
	}
	public Car(int goods_num, int carid, int goods_id, int user_id,
			Goods goods, Param params) {
		super();
		this.goods_num = goods_num;
		this.carid = carid;
		this.goods_id = goods_id;
		this.user_id = user_id;
		this.goods = goods;
		this.params = params;
	}
	public Car(int goods_num, int carid, int goods_id, int user_id,
			Goods goods, Param params,String imgurl) {
		super();
		this.goods_num = goods_num;
		this.carid = carid;
		this.goods_id = goods_id;
		this.user_id = user_id;
		this.goods = goods;
		this.params = params;
		this.imgurl=imgurl;
	}
	
	
	
	
	public Car(int goods_num, int carid, int goods_id, int user_id,
			String imgurl) {
		super();
		this.goods_num = goods_num;
		this.carid = carid;
		this.goods_id = goods_id;
		this.user_id = user_id;
		this.imgurl = imgurl;
	}
	public int getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public Car(int goods_num, int carid, int goods_id, int user_id) {
		super();
		this.goods_num = goods_num;
		this.carid = carid;
		this.goods_id = goods_id;
		this.user_id = user_id;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Car [goods_num=" + goods_num + ", carid=" + carid
				+ ", goods_id=" + goods_id + ", user_id=" + user_id
				+ ", goods=" + goods + ", params=" + params + "]";
	}
	
	
}
