package com.hello.dao;

import java.util.List;

import com.hello.beans.Goodstype;
import com.hello.beans.Pager;

public interface GoodsTypeDao {
	public List<Goodstype> typeListById();
	public List<String> getAllType();
	public List<String> getAllBrand(String supertype);
	public void addType(Goodstype goodstype) ;
	public int getDataCount();
	public Pager getPager(int currPage, int pageSize);
	public void updateType(Goodstype goodstype);
	public void deleteType(int goodstypeid);
}
