package com.hello.beans;

import java.util.ArrayList;
import java.util.List;

public class Pager {
	private int currPage;
	private int pageSize;
	private int pageCount;
	private int dataCount;
	private ArrayList<Goods> allgoods;
	private ArrayList<Order> orders;
	private ArrayList<Car> cars;
	private ArrayList<Param> allparam;
	private ArrayList<Picture> allpicture;
	private ArrayList<Goodstype> alltype;
	private ArrayList<User> alluser;
	private List<Order> allorder;
	private List<PingJia> allpj;
 	
	
	
	
	
	
	public Pager(int currPage, int pageSize, int pageCount, int dataCount,
			ArrayList<Goods> allgoods, ArrayList<Param> allparam) {
		super();
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.dataCount = dataCount;
		this.allgoods = allgoods;
		this.allparam = allparam;
	}
	public Pager(List<PingJia> allpj,int currPage, int pageSize, int pageCount, int dataCount
			) {
		super();
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.dataCount = dataCount;
		this.allpj = allpj;
	}
	public List<PingJia> getAllpj() {
		return allpj;
	}
	public void setAllpjl(List<PingJia> allpj) {
		this.allpj = allpj;
	}
	public Pager(int currPage, int pageSize, int pageCount, int dataCount,
			List<Order> allorder) {
		super();
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.dataCount = dataCount;
		this.allorder = allorder;
	}
	public List<Order> getAllorder() {
		return allorder;
	}
	public void setAllorder(List<Order> allorder) {
		this.allorder = allorder;
	}
	public Pager(int currPage, int pageSize,ArrayList<User> alluser, int pageCount, int dataCount
			) {
		super();
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.dataCount = dataCount;
		this.alluser = alluser;
	}
	public ArrayList<User> getAlluser() {
		return alluser;
	}
	public void setAlluser(ArrayList<User> alluser) {
		this.alluser = alluser;
	}
	public Pager(int currPage, int pageSize, int pageCount,ArrayList<Goodstype> alltype,int dataCount
			) {
		super();
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.dataCount = dataCount;
		this.alltype = alltype;
	}
	public ArrayList<Goodstype> getAlltype() {
		return alltype;
	}
	public void setAlltype(ArrayList<Goodstype> alltype) {
		this.alltype = alltype;
	}
	public Pager(int currPage, ArrayList<Picture> allpicture,int pageSize, int pageCount, int dataCount
			) {
		super();
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.dataCount = dataCount;
		this.allpicture = allpicture;
	}
	public ArrayList<Picture> getAllpicture() {
		return allpicture;
	}
	public void setAllpicture(ArrayList<Picture> allpicture) {
		this.allpicture = allpicture;
	}
	public Pager(ArrayList<Param> allparam,int currPage, int pageSize, int pageCount, int dataCount
			) {
		super();
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.dataCount = dataCount;
		this.allparam = allparam;
	}
	public ArrayList<Param> getAllparam() {
		return allparam;
	}
	public void setAllparam(ArrayList<Param> allparam) {
		this.allparam = allparam;
	}
	public ArrayList<Car> getCars() {
		return cars;
	}
	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}
	
	
	
	public ArrayList<Order> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	public ArrayList<Goods> getAllgoods() {
		return allgoods;
	}
	public void setAllgoods(ArrayList<Goods> allgoods) {
		this.allgoods = allgoods;
	}
	public Pager(int currPage, int pageSize, int pageCount, int dataCount,
			ArrayList<Goods> allgoods) {
		super();
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.dataCount = dataCount;
		this.allgoods = allgoods;
	}
	
	public Pager(int currPage, int pageSize, int pageCount, int dataCount) {
		super();
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.dataCount = dataCount;
	}
	public Pager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getDataCount() {
		return dataCount;
	}
	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}
	@Override
	public String toString() {
		return "Pager [currPage=" + currPage + ", pageSize=" + pageSize
				+ ", pageCount=" + pageCount + ", dataCount=" + dataCount
				+ ", allgoods=" + allgoods + "]";
	}
	
	
}
