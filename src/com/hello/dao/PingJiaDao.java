package com.hello.dao;

import com.hello.beans.Pager;

public interface PingJiaDao {
	public int getDataCount();
	public Pager getPager(int currPage, int pageSize);
}
