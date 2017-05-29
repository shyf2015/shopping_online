package com.hello.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hello.beans.Car;
import com.hello.beans.Goods;
import com.hello.beans.Pager;
import com.hello.beans.Param;
import com.hello.dao.CarDao;
import com.hello.util.CreateConnection;

public class CarImpl implements CarDao {
	//拿到所有购物车
	public List<Car> listAllCar(int user_id){
		String sql="select *from t_car where user_id="+user_id;
		Connection connection=CreateConnection.getConnection();
		try {
			int i=0,x=0;
			Statement sta=connection.createStatement();
			ResultSet set=sta.executeQuery(sql);
			List<Car> cars=new ArrayList<Car>();
			while(set.next()){
				int carid=set.getInt("carid");
				int goods_id=set.getInt("goods_id");
				int goods_num=set.getInt("goods_num");
				//int userid=set.getInt("user_id");
				String imgurl=set.getString("imgurl");
				
				List<Goods> gos=listAllGoods(user_id);
				List<Param> pars=getParamByGoods(user_id);
				Car car=new Car(goods_num, carid, goods_id, user_id,gos.get(i++),pars.get(x++),imgurl);
				cars.add(car);
			}
			return cars;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(connection);
		}
		return null;
	}
	
	//拿到所有的商品
	public List<Goods> listAllGoods(int user_id){
		String sql="select g.*from t_goods g,t_car c where g.goodsid=c.goods_id and c.user_id="+user_id;
		Connection connection=CreateConnection.getConnection();
		try {
			Statement sta=connection.createStatement();
			ResultSet set=sta.executeQuery(sql);
			List<Goods> goods=new ArrayList<Goods>();
			while(set.next()){
				int goodsId=set.getInt("goodsid");
				String goodsName=set.getString("goodsname");
				double goodsPrice=set.getDouble("goodsprice");
				//String goodsImgurl=set.getString("goodsimaurl");
				String goodsInfo=set.getString("goodsinfo");
				int goodStype_id=set.getInt("goodstype_id");
				int goodsNum=set.getInt("goodsnum");
				Goods good=new Goods(goodsId, goodsName, goodsPrice,goodsInfo, goodStype_id, goodsNum);
				goods.add(good);
			}
			return goods;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(connection);
		}
		return null;
	}
	
	//通过商品拿到商品对应的参数
	public List<Param> getParamByGoods(int user_id){
		String sql="select t_param.* from t_param ,(select g.*from t_goods g,t_car c where g.goodsid=c.goods_id and c.user_id="+user_id+") temp where temp.goodsid=t_param.goods_id";
		Connection connection=CreateConnection.getConnection();
		Param param=null;
		try {
			Statement sta = connection.createStatement();
			ResultSet set=sta.executeQuery(sql);
			List<Param> params=new ArrayList<Param>();
			while(set.next()){
				int paramid=set.getInt("paramid");
				String cpu=set.getString("cpu");
				//String color=set.getString("color");
				String ram=set.getString("ram");
				String rom=set.getString("rom");
				String size=set.getString("size");
				String battery=set.getString("battery");
				String os=set.getString("os");
				param=new Param(paramid, cpu, ram, rom, size, battery, os);
				params.add(param);
			}
			return params;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(connection);
		}
		return null;
	}
	//删除购物车
	public void delete(int carid) {
		String sql="delete from t_car where carid="+carid;
		Connection connection=CreateConnection.getConnection();
		try {
			Statement sta = connection.createStatement();
			sta.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(connection);
		}
	}

	public void add(Car car) {
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "insert into t_car (goods_id,goods_num,user_id,imgurl) values(?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, car.getGoods_id());
			statement.setInt(2, car.getGoods_num());
			statement.setInt(3, car.getUser_id());
			statement.setString(4, car.getImgurl());
			statement.execute();
			CreateConnection.close(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void updata(int carid,int goodsnum) {
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "update t_car set goods_num="+goodsnum+" where carid="+carid;
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			CreateConnection.close(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int getKucun(int carid){
		Connection connection = CreateConnection.getConnection();
		try {
			String sql = "select goodsnum from t_goods g,t_car c where c.carid="+carid+" and c.goods_id=g.goodsid";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet set=statement.executeQuery();
			int kucun=0;
			while(set.next()){
				kucun=set.getInt("goodsnum");
			}
			return kucun;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(connection);
		}
		return 0;
	}
	
	public int getDataCount(int userid) {
		int count=0;
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "select count(*) c from t_car where user_id="+userid;
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			if(set.next()){
				count = set.getInt("c");
			}
			CreateConnection.close(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}
	
	public Pager getPager(int currPage,int pageSize,int userid){
		ArrayList<Car> cars = new ArrayList<Car>();
		Pager pager = null;
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "select * from t_car c,t_goods g,t_param p where user_id=? and c.goods_id=p.goods_id and p.goods_id=g.goodsid order by c.carid desc limit ?,?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, userid);
			statement.setInt(2, (currPage-1)*pageSize);
			statement.setInt(3, pageSize);
			ResultSet set = statement.executeQuery();
			while(set.next()){
				int carid = set.getInt("carid");
				int goodsid = set.getInt("goods_id");
				int goodsnum = set.getInt("goods_num");
				String imgurl = set.getString("imgurl");
				int paramid = set.getInt("paramid");
				String cpu = set.getString("cpu");
				String ram = set.getString("ram");
				String rom = set.getString("rom");
				String size = set.getString("size");
				String battery = set.getString("battery");
				String os = set.getString("os");
				String goodsname = set.getString("goodsname");
				double goodsprice = set.getDouble("goodsprice");
				String goodsinfo = set.getString("goodsinfo");
				int goodstype_id = set.getInt("goodstype_id");
				int goodsnums = set.getInt("goodsnum");
				
				Goods goods = new Goods(imgurl, goodsid, goodsname, goodsprice, goodsinfo, goodstype_id, goodsnums);
				Param param = new Param(paramid, cpu, ram, rom, size, battery, os, goodsid);
				Car car = new Car(goodsnum, carid, goodsid, userid, goods, param, imgurl);
				cars.add(car);
				
				//Car car = new Car;
				
			}
			int dataCount = getDataCount(userid);
			int pageCount = dataCount%pageSize==0?dataCount/pageSize:dataCount/pageSize+1;
			pager = new Pager(currPage, pageSize, pageCount, dataCount);
			pager.setCars(cars);
			CreateConnection.close(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return pager;
	} 
}
