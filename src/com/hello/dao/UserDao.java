package com.hello.dao;

import com.hello.beans.Admin;
import com.hello.beans.Pager;
import com.hello.beans.User;

public interface UserDao {
	void add(User user);
	public boolean selectadmin(Admin admin);
	public User query(String username);
	public int getDataCount();
	public Pager getPager(int currPage, int pageSize);
	public void deleteUser(int userid);
	public void addEvaluate(int userid,String evaluate,int dengji,String goods_name,String username);
}
