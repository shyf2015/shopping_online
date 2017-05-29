package com.hello.dao;

import com.hello.beans.Pager;
import com.hello.beans.Param;

public interface ParamDao {
	Param query(int goodsid);
	public void addParam(Param param);
	public Param findParamByGoodsid(int goodsid);
	public int getDataCount();
	public Pager getPager(int currPage, int pageSize);
	public void updateParam(Param param);
}
