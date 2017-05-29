package com.hello.beans;

import java.util.List;

public class Goodstype {
	private int goodstypeid;
	private String goodstypename;
	private String supertype;
	private String brand;
	
	private String supertypes;
	private List<String> brands;
	
	public Goodstype(String supertypes, List<String> brands) {
		this.supertypes = supertypes;
		this.brands = brands;
	}
	public String getSupertypes() {
		return supertypes;
	}
	public void setSupertypes(String supertypes) {
		this.supertypes = supertypes;
	}
	public List<String> getBrands() {
		return brands;
	}
	
	
	
	
	
	public void setBrands(List<String> brands) {
		this.brands = brands;
	}
	public Goodstype(int goodstypeid, String goodstypename) {
		super();
		this.goodstypeid = goodstypeid;
		this.goodstypename = goodstypename;
	}
	public int getGoodstypeid() {
		return goodstypeid;
	}
	public void setGoodstypeid(int goodstypeid) {
		this.goodstypeid = goodstypeid;
	}
	public String getGoodstypename() {
		return goodstypename;
	}
	public void setGoodstypename(String goodstypename) {
		this.goodstypename = goodstypename;
	}
	public String getSupertype() {
		return supertype;
	}
	public void setSupertype(String supertype) {
		this.supertype = supertype;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Goodstype [goodstypeid=" + goodstypeid + ", goodstypename="
				+ goodstypename + ", supertype=" + supertype + ", brand="
				+ brand + "]";
	}
	public Goodstype(int goodstypeid, String goodstypename, String supertype,
			String brand) {
		super();
		this.goodstypeid = goodstypeid;
		this.goodstypename = goodstypename;
		this.supertype = supertype;
		this.brand = brand;
	}
	
	public Goodstype(String goodstypename, String supertype, String brand) {
		super();
		this.goodstypename = goodstypename;
		this.supertype = supertype;
		this.brand = brand;
	}
	public Goodstype() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
