package com.hello.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hello.beans.Goodstype;
import com.hello.beans.Pager;
import com.hello.dao.GoodsTypeDao;
import com.hello.util.CreateConnection;

public class GoodsTypeImpl implements GoodsTypeDao{

	public List<Goodstype> typeListById() {
		List<Goodstype> lists= new ArrayList<Goodstype>();
		Connection conn=CreateConnection.getConnection();
		String sql="select goodstypeid,goodstypename from t_goodstype";
		try {
			Statement sta=conn.createStatement();
			ResultSet set=sta.executeQuery(sql);
			while(set.next()){
				int goodsTypeId=set.getInt("goodstypeid");
				String goodsTypeName=set.getString("goodstypename");
				Goodstype goodstype=new Goodstype(goodsTypeId, goodsTypeName);
				
				lists.add(goodstype);
			}
			return lists;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<String> getAllType() {
		String sql="select t.supertype from t_goodstype t group by  t.supertype";
		Connection connection=CreateConnection.getConnection();
		try {
			Statement sta=connection.createStatement();
			ResultSet set=sta.executeQuery(sql);
			List<String> lists=new ArrayList<String>();
			while(set.next()){
				String supertype=set.getString("supertype");
				lists.add(supertype);
			}
			return lists;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(connection);
		}
		return null;
	}

	public List<String> getAllBrand(String supertype) {
		String sql="select t.brand from t_goodstype t where t.supertype='"+supertype+"'";
		Connection connection=CreateConnection.getConnection();
		try {
			Statement sta=connection.createStatement();
			ResultSet set=sta.executeQuery(sql);
			List<String> lists=new ArrayList<String>();
			while(set.next()){
				String brand=set.getString("brand");
				lists.add(brand);
			}
			return lists;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(connection);
		}
		return null;
	}
	public void addType(Goodstype goodstype) {
		Connection conn=CreateConnection.getConnection();
		String sql="insert into t_goodstype (goodstypename,supertype,brand) value (?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, goodstype.getGoodstypename());
			ps.setString(2, goodstype.getSupertype());
			ps.setString(3, goodstype.getBrand());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}
		
	}
	public int getDataCount() {
		int count=0;
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "select count(*) c from t_goodstype";
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
		ArrayList<Goodstype> alltype=new ArrayList<Goodstype>();
		Pager pager=null;
		Connection conn=CreateConnection.getConnection();
		String sql="select goodstypeid,goodstypename,supertype,brand from t_goodstype order by goodstypeid desc limit ?,?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, (currPage-1)*pageSize);
			ps.setInt(2, pageSize);
			ResultSet set=ps.executeQuery();
			while(set.next()){
				int goodstypeid=set.getInt("goodstypeid");
				String goodstypename=set.getString("goodstypename");
				String supertype=set.getString("supertype");
				String brand=set.getString("brand");
				Goodstype goodstype=new Goodstype(goodstypeid, goodstypename, supertype, brand);
				alltype.add(goodstype);
			}
			int dataCount = getDataCount();
			int pageCount = dataCount%pageSize==0?dataCount/pageSize:dataCount/pageSize+1;
			pager=new Pager(currPage, pageSize, pageCount, alltype, dataCount);
			CreateConnection.close(conn);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return pager;
	}
	public void updateType(Goodstype goodstype) {
		Connection conn=CreateConnection.getConnection();
		String sql="update t_goodstype set goodstypename=?,supertype=?,brand=? where goodstypeid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, goodstype.getGoodstypename());
			ps.setString(2, goodstype.getSupertype());
			ps.setString(3, goodstype.getBrand());
			ps.setInt(4, goodstype.getGoodstypeid());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}
	}
	public void deleteType(int goodstypeid) {
		Connection conn=CreateConnection.getConnection();
		String sql="delete from t_goodstype where goodstypeid="+goodstypeid;
		try {
			Statement sta=conn.createStatement();
			sta.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}
		
	}
	
}
