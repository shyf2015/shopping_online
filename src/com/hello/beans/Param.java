package com.hello.beans;

public class Param {
	private int paramid;
	private String cpu;
	private String ram;
	private String rom;
	private String size;
	private String battery;
	private String os;
	private int goods_id;
	private String goodsname;
	
	
	

	public Param(String cpu, String ram, String rom, String size,
			String battery, String os) {
		super();
		this.cpu = cpu;
		this.ram = ram;
		this.rom = rom;
		this.size = size;
		this.battery = battery;
		this.os = os;
	}
	public Param(String cpu, String ram, String rom, String size,
			String battery, String os, int goods_id) {
		super();
		this.cpu = cpu;
		this.ram = ram;
		this.rom = rom;
		this.size = size;
		this.battery = battery;
		this.os = os;
		this.goods_id = goods_id;
	}
	public Param(int paramid, String cpu, String ram, String rom, String size,
			String battery, String os, int goods_id, String goodsname) {
		super();
		this.paramid = paramid;
		this.cpu = cpu;
		this.ram = ram;
		this.rom = rom;
		this.size = size;
		this.battery = battery;
		this.os = os;
		this.goods_id = goods_id;
		this.goodsname = goodsname;
	}
	public Param(int paramid, int goods_id, String goodsname) {
		super();
		this.paramid = paramid;
		this.goods_id = goods_id;
		this.goodsname = goodsname;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public Param(int paramid, String cpu, String ram, String rom, String size,
			String battery, String os, int goods_id) {
		super();
		this.paramid = paramid;
		this.cpu = cpu;
		this.ram = ram;
		this.rom = rom;
		this.size = size;
		this.battery = battery;
		this.os = os;
		this.goods_id = goods_id;
	}
	public Param(int paramid, String cpu, String ram, String rom,
			String size, String battery, String os) {
		super();
		this.paramid = paramid;
		this.cpu = cpu;
		this.ram = ram;
		this.rom = rom;
		this.size = size;
		this.battery = battery;
		this.os = os;
	}
	public Param() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Param [paramid=" + paramid + ", cpu=" + cpu + ", ram=" + ram
				+ ", rom=" + rom + ", size=" + size + ", battery=" + battery
				+ ", os=" + os + ", goods_id=" + goods_id + "]";
	}
	public int getParamid() {
		return paramid;
	}
	public void setParamid(int paramid) {
		this.paramid = paramid;
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
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	 
	
}
