package com.hello.beans;

public class CarOrder {
	private	 int goodshopnum;
	private	 double goodprice;
	private  int goodcarid;
	private  int userid;
	private	double sum;
	private int goodsid;
	private	String img;
	private	String color;
	private	String goodsname;
	private	String goodsinfo;
	private	String	cpu;
	private	String	ram;
	private	String	rom;
	private	String	size;
	private	String	battery;
	
	
	
	public CarOrder(int goodshopnum, double goodprice, double sum, int goodsid,
			String img, String color, String goodsname, String goodsinfo,
			String cpu, String ram, String rom, String size, String battery,int userid) {
		super();
		this.goodshopnum = goodshopnum;
		this.goodprice = goodprice;
		this.sum = sum;
		this.goodsid = goodsid;
		this.img = img;
		this.color = color;
		this.goodsname = goodsname;
		this.goodsinfo = goodsinfo;
		this.cpu = cpu;
		this.ram = ram;
		this.rom = rom;
		this.size = size;
		this.battery = battery;
		this.userid = userid;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getRom() {
		return rom;
	}
	public void setRom(String rom) {
		this.rom = rom;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getBattery() {
		return battery;
	}
	public void setBattery(String battery) {
		this.battery = battery;
	}
	public int getGoodshopnum() {
		return goodshopnum;
	}
	public void setGoodshopnum(int goodshopnum) {
		this.goodshopnum = goodshopnum;
	}
	public double getGoodprice() {
		return goodprice;
	}
	public void setGoodprice(double goodprice) {
		this.goodprice = goodprice;
	}
	public int getGoodcarid() {
		return goodcarid;
	}
	public void setGoodcarid(int goodcarid) {
		this.goodcarid = goodcarid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getGoodsinfo() {
		return goodsinfo;
	}
	public void setGoodsinfo(String goodsinfo) {
		this.goodsinfo = goodsinfo;
	}
	
	public CarOrder(int goodshopnum, double goodprice, int goodcarid,
			int userid, double sum, int goodsid, String img, String color,
			String goodsname, String goodsinfo, String cpu, String ram,
			String rom, String size, String battery) {
		super();
		this.goodshopnum = goodshopnum;
		this.goodprice = goodprice;
		this.goodcarid = goodcarid;
		this.userid = userid;
		this.sum = sum;
		this.goodsid = goodsid;
		this.img = img;
		this.color = color;
		this.goodsname = goodsname;
		this.goodsinfo = goodsinfo;
		this.cpu = cpu;
		this.ram = ram;
		this.rom = rom;
		this.size = size;
		this.battery = battery;
	}
	public CarOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return  goodshopnum + ","
				+ goodprice + "," + goodcarid + "," + userid
				+ "," + sum + "," + goodsid + "," + img
				+ "," + color + "," + goodsname
				+ "," + goodsinfo;
	}
	
}
