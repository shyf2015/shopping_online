package com.hello.beans;

public class PingJia {
	private int pingjiaid;
	private int user_id;
	private String evaluate;
	private int dengji;
	private String goods_name;
	private String user_name;
	
	public PingJia(String evaluate, int dengji, String goods_name,
			String user_name) {
		super();
		this.evaluate = evaluate;
		this.dengji = dengji;
		this.goods_name = goods_name;
		this.user_name = user_name;
	}
	public int getPingjiaid() {
		return pingjiaid;
	}
	public void setPingjiaid(int pingjiaid) {
		this.pingjiaid = pingjiaid;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	public int getDengji() {
		return dengji;
	}
	public void setDengji(int dengji) {
		this.dengji = dengji;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public PingJia(int pingjiaid, int user_id, String evaluate, int dengji,
			String goods_name, String user_name) {
		super();
		this.pingjiaid = pingjiaid;
		this.user_id = user_id;
		this.evaluate = evaluate;
		this.dengji = dengji;
		this.goods_name = goods_name;
		this.user_name = user_name;
	}
	public PingJia() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PingJia [pingjiaid=" + pingjiaid + ", user_id=" + user_id
				+ ", evaluate=" + evaluate + ", dengji=" + dengji
				+ ", goods_name=" + goods_name + ", user_name=" + user_name
				+ "]";
	}
	
}
