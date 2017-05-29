package com.hello.beans;

import java.util.ArrayList;

public class Picture {
	private int goods_id;
	private ArrayList<String> colors = new ArrayList<String>();
	private ArrayList<String> imgurls = new ArrayList<String>();
	private String color;
	private String imgurl;
	private String goodsname;
	private int pictureid;
	
	public Picture(String color, String imgurl) {
		super();
		this.color = color;
		this.imgurl = imgurl;
	}
	public Picture(String color, String imgurl, int pictureid) {
		super();
		this.color = color;
		this.imgurl = imgurl;
		this.pictureid = pictureid;
	}
	public Picture(int goods_id, String goodsname, int pictureid) {
		super();
		this.goods_id = goods_id;
		this.goodsname = goodsname;
		this.pictureid = pictureid;
	}
	public Picture(int goods_id, String color, String imgurl, String goodsname,
			int pictureid) {
		super();
		this.goods_id = goods_id;
		this.color = color;
		this.imgurl = imgurl;
		this.goodsname = goodsname;
		this.pictureid = pictureid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public int getPictureid() {
		return pictureid;
	}
	public void setPictureid(int pictureid) {
		this.pictureid = pictureid;
	}
	public Picture(int goods_id, String color, String imgurl) {
		super();
		this.goods_id = goods_id;
		this.color = color;
		this.imgurl = imgurl;
	}
	public Picture(int goods_id, ArrayList<String> colors,
			ArrayList<String> imgurls) {
		super();
		this.goods_id = goods_id;
		this.colors = colors;
		this.imgurls = imgurls;
	}
	public Picture() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Picture [goods_id=" + goods_id + ", colors=" + colors
				+ ", imgurls=" + imgurls + "]";
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public ArrayList<String> getColors() {
		return colors;
	}
	public void setColors(ArrayList<String> colors) {
		this.colors = colors;
	}
	public ArrayList<String> getImgurls() {
		return imgurls;
	}
	public void setImgurls(ArrayList<String> imgurls) {
		this.imgurls = imgurls;
	}
	
	
}
