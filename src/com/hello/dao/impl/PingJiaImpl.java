package com.hello.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hello.beans.Pager;
import com.hello.beans.PingJia;
import com.hello.dao.PingJiaDao;
import com.hello.util.CreateConnection;

public class PingJiaImpl implements PingJiaDao{

	public int getDataCount() {
		int count=0;
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "select count(*) c from t_pingjia";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			if(set.next()){
				count = set.getInt("c");
			}
			CreateConnection.close(connection);
		} catch (Exception e) {
			
		}
		return count;
	}

	public Pager getPager(int currPage, int pageSize) {
		List<PingJia> allpj=new ArrayList<PingJia>();
		Pager pager=null;
		Connection conn=CreateConnection.getConnection();
		String sql="select username,goods_name,evaluate,dengji from t_user,t_pingjia where user_id=userid order by pingjiaid desc limit ?,?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, (currPage-1)*pageSize);
			ps.setInt(2, pageSize);
			ResultSet set=ps.executeQuery();
			while(set.next()){
				String user_name=set.getString("username");
				String goods_name=set.getString("goods_name");
				String evaluate=set.getString("evaluate");
				int dengji=set.getInt("dengji");
				PingJia pingJia=new PingJia(evaluate, dengji, goods_name, user_name);
				allpj.add(pingJia);
			}
			int dataCount = getDataCount();
			int pageCount = dataCount%pageSize==0?dataCount/pageSize:dataCount/pageSize+1;
			pager=new Pager(allpj, currPage, pageSize, pageCount, dataCount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pager;
	}
	
}
