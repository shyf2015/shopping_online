package com.hello.beans;

public class User {
	private int userid;
	private String username;		
	private String password;
	private String realname;
	public  String  getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int userid, String username, String password, String realname) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.realname = realname;
	}
	public User(String username, String password, String realname) {
		super();
		this.username = username;
		this.password = password;
		this.realname = realname;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", realname=" + realname + "]";
	}
	
	
}
