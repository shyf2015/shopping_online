package com.hello.dao;

import java.util.Arrays;

import com.hello.beans.CarOrder;

public interface PayDao {
	public int addOrderByuserid(String[] goods_order,String[] addr);
	public void updateorderstate(int user_id);
}
