package com.hello.beans;

public class Goods {
	private int goodsId;
	private String goodsName;
	private double goodsPrice;
	private String goodsImgurl;
	private String goodsInfo;
	private int goodStype_id;
	private String goodsTypeName;
	
	public Goods(int goodsId, String goodsName, double goodsPrice,
			String goodsInfo, int goodStype_id, String goodsTypeName,
			int goodsNum) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsInfo = goodsInfo;
		this.goodStype_id = goodStype_id;
		this.goodsTypeName = goodsTypeName;
		this.goodsNum = goodsNum;
	}

	public Goods(int goodsId, String goodsName, double goodsPrice,
			String goodsInfo, String goodsTypeName, int goodsNum) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsInfo = goodsInfo;
		this.goodsTypeName = goodsTypeName;
		this.goodsNum = goodsNum;
	}

	public String getGoodsTypeName() {
		return goodsTypeName;
	}

	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}

	public Goods(int goodsId, String goodsName) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
	}

	public Goods(String goodsName, double goodsPrice, String goodsInfo,
			int goodStype_id, int goodsNum) {
		super();
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsInfo = goodsInfo;
		this.goodStype_id = goodStype_id;
		this.goodsNum = goodsNum;
	}
	private int goodsNum;
	
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Goods(int goodsId, String goodsName, double goodsPrice,
			String goodsInfo, int goodStype_id, int goodsNum) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsInfo = goodsInfo;
		this.goodStype_id = goodStype_id;
		this.goodsNum = goodsNum;
	}
	public Goods(String goodsImgurl,int goodsId, String goodsName, double goodsPrice,
			 String goodsInfo, int goodStype_id, int goodsNum) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsImgurl = goodsImgurl;
		this.goodsInfo = goodsInfo;
		this.goodStype_id = goodStype_id;
		this.goodsNum = goodsNum;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName
				+ ", goodsPrice=" + goodsPrice + ", goodsImgurl=" + goodsImgurl
				+ ", goodsInfo=" + goodsInfo + ", goodStype_id=" + goodStype_id
				+ ", goodsNum=" + goodsNum + ", param_id=" +  "]";
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsImgurl() {
		return goodsImgurl;
	}
	public void setGoodsImgurl(String goodsImgurl) {
		this.goodsImgurl = goodsImgurl;
	}
	public String getGoodsInfo() {
		return goodsInfo;
	}
	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	public int getGoodStype_id() {
		return goodStype_id;
	}
	public void setGoodStype_id(int goodStype_id) {
		this.goodStype_id = goodStype_id;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	
}
