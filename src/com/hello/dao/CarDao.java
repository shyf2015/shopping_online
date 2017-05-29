package com.hello.dao;

import java.util.List;

import com.hello.beans.Car;
import com.hello.beans.Goods;
import com.hello.beans.Pager;
import com.hello.beans.Param;

public interface CarDao {
	public List<Car> listAllCar(int user_id);
	public List<Goods> listAllGoods(int user_id);
	public List<Param> getParamByGoods(int user_id);
	public void delete(int carid);
	void add(Car car);
	Pager getPager(int currPage,int pageSize,int userid);
	int getDataCount(int userid);
	public int getKucun(int carid);
}
