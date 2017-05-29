package com.hello.beans;

public class Address {
	// addressid,user_id(用户ID),province(省),
//	city(市),country(区),address(详细地址),country(区)
//	conname(收货人姓名),conphone(收货人电话)
	private int addressid;
	private int user_id;
	private String province;
	private String city;
	private String country;
	private String address;
	private String conname;
	private String conphone;
	
	
	public Address(int addressid, int user_id, String province, String city,
			String country, String address, String conname, String conphone) {
		super();
		this.addressid = addressid;
		this.user_id = user_id;
		this.province = province;
		this.city = city;
		this.country = country;
		this.address = address;
		this.conname = conname;
		this.conphone = conphone;
	}
	
	

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	@Override
	public String toString() {
		return addressid + "," + user_id
				+ "," + province + "," + city + ","
				+ country + "," + address + "," + conname
				+ "," + conphone;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
		
}
