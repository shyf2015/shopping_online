package com.hello.dao;

import java.util.ArrayList;
import java.util.List;

import com.hello.beans.Goods;
import com.hello.beans.Pager;

public interface GoodsDao {
	public ArrayList<Goods> list();
	public Goods query(int goodsid);
	public ArrayList<Goods> getGoodsByType(String supertype);
	public ArrayList<Goods> getGoodsByType(String supertype,String brand);
	public List<Integer> getAllIdLikeGoodsName(String goodsName);
	public List<String> getAllBrandByLikeBrand(String brand);
	public List<String> getAllSuperTypeByLikeSuperType(String supertype);
	public void addGoods(Goods goods);
	public List<Goods> listGoodsIdAndGoodsName();
	public Goods listGoodsName();
	public Pager getPage(int currPage, int pageSize,String searchinfo);
	
	public Pager getPagerBySupertypeAndBrand(String supertype, String brand, int currPage, int pageSize);
	public int getDataCount(String supertype, String brand);
	

	public Pager getPager2(int currPage, int pageSize);
	public void updataGoods(Goods goods);
	public void deleteGoods(int goodsid);
	public int maxGoodsId();
}
