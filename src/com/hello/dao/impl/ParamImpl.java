package com.hello.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hello.beans.Pager;
import com.hello.beans.Param;
import com.hello.beans.Picture;
import com.hello.dao.ParamDao;
import com.hello.util.CreateConnection;

public class ParamImpl implements ParamDao{
	public static void main(String[] args) {
		ParamDao dao=new ParamImpl();
		Param param=dao.findParamByGoodsid(1);
		//System.out.println(param);
	}

	public Param query(int goodsid) {
		Param param = null;
		//System.out.println(param);
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "select * from t_param where goods_id="+goodsid;
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()){
				int paramid = set.getInt("paramid");
				String cpu = set.getString("cpu");
				String ram = set.getString("ram");
				String rom = set.getString("rom");
				String size = set.getString("size");
				String battery = set.getString("battery");
				String os = set.getString("os");
				param = new Param(paramid,cpu, ram, rom, size, battery, os);
			}
			CreateConnection.close(connection);
			return param;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addParam(Param param) {
		Connection conn=CreateConnection.getConnection();
		String sql="insert into t_param (cpu,ram,rom,size,battery,os,goods_id) value (?,?,?,?,?,?,(select max(goodsid) from t_goods))";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, param.getCpu());
			ps.setString(2, param.getRam());
			ps.setString(3, param.getRom());
			ps.setString(4, param.getSize());
			ps.setString(5, param.getBattery());
			ps.setString(6, param.getOs());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}
	}

	public Param findParamByGoodsid(int goodsid) {
		Connection conn=CreateConnection.getConnection();
		String sql="select paramid,goodsname,goods_id from t_param,t_goods where goods_id=goodsid and goods_id+"+goodsid;
		Param param=null;
		try {
			Statement sta=conn.createStatement();
			ResultSet set=sta.executeQuery(sql);
			while(set.next()){
				int paramid=set.getInt("paramid");
				String goodsname=set.getString("goodsname");
				int goods_id=set.getInt("goods_id");
				param=new Param(paramid, goods_id, goodsname);
			}
			return param;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public int getDataCount() {
		int count=0;
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "select count(*) c from t_param";
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
		ArrayList<Param> allparam=new ArrayList<Param>();
		Pager pager=null;
		Connection conn=CreateConnection.getConnection();
		String sql="select paramid,cpu,ram,rom,size,battery,os,goods_id,goodsname from t_param,t_goods where goodsid=goods_id order by paramid desc limit ?,?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, (currPage-1)*pageSize);
			ps.setInt(2, pageSize);
			ResultSet set=ps.executeQuery();
			while(set.next()){
				int paramid=set.getInt("paramid");
				String cpu=set.getString("cpu");
				String ram=set.getString("ram");
				String rom=set.getString("rom");
				String size=set.getString("size");
				String battery=set.getString("battery");
				String os=set.getString("os");
				String goodsname=set.getString("goodsname");
				int goods_id=set.getInt("goods_id");
				Param param=new Param(paramid, cpu, ram, rom, size, battery, os, goods_id, goodsname);
				allparam.add(param);
			}
			int dataCount = getDataCount();
			int pageCount = dataCount%pageSize==0?dataCount/pageSize:dataCount/pageSize+1;
			pager=new Pager(allparam, currPage, pageSize, pageCount, dataCount);
			CreateConnection.close(conn);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return pager;
	}

	public void updateParam(Param param) {
		Connection conn=CreateConnection.getConnection();
		String sql="update t_param set cpu=?,ram=?,rom=?,size=?,battery=?,os=?,goods_id=? where paramid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, param.getCpu());
			ps.setString(2, param.getRam());
			ps.setString(3, param.getRom());
			ps.setString(4, param.getSize());
			ps.setString(5, param.getBattery());
			ps.setString(6, param.getOs());
			ps.setInt(7, param.getGoods_id());
			ps.setInt(8, param.getParamid());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}
	}
	

}
