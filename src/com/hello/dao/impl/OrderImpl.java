package com.hello.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.hello.beans.Address;
import com.hello.beans.Car;
import com.hello.beans.Goods;
import com.hello.beans.Order;
import com.hello.beans.Pager;
import com.hello.beans.Param;
import com.hello.beans.Picture;
import com.hello.dao.OrderDao;
import com.hello.util.CreateConnection;
import com.sun.org.apache.xpath.internal.operations.Or;

public class OrderImpl implements OrderDao {

	public static void main(String[] args) {
		OrderImpl order = new OrderImpl();
		int id = 1;
	//	List<Order> list = order.listAllOrderbyId(id);
		//System.out.println(list);
	//	System.out.println(order.getOrderstateByordernum(248));
	}

	//查看某ID所有地址
	public List<Address> listAddressById(int id) {
		String sql = "select * from t_address where user_id=?";
		Connection connection=CreateConnection.getConnection();
		List<Address> list = new ArrayList<Address>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet res = ps.executeQuery();
			while(res.next()){
				String addressid = res.getString("addressid");
				String user_id = res.getString("user_id");
				String province = res.getString("province");
				String city = res.getString("city");
				String country = res.getString("country");		    	
				String address = res.getString("address");
				String conname = res.getString("conname");
				String conphone = res.getString("conphone");
				Address user_address = new Address(Integer.parseInt(addressid),Integer.parseInt(user_id),province,city,country,address,conname,conphone);
				list.add(user_address);	
			}		
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/*//查询当前立即购买的商品的订单详情信息
	public List<Order> listOrderbyId(int id) {
		String sql = "select * from t_order where user_id=?";
		Connection connection = CreateConnection.getConnection();
		List<Order> list = new ArrayList<Order>();
		try {
			PreparedStatement ps =connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet res = ps.executeQuery();
			while(res.next()){
				int user_id = res.getInt("user_id");
				int ordernum = res.getInt("ordernum");
				int orderstate = res.getInt("orderstate");
				Date ordertime = res.getDate("ordertime");
				String goods_name = res.getString("goods_name");
				double goods_price = res.getDouble("goods_price");
				int goods_number = res.getInt("goods_num");
				String address = res.getString("address");
				String conname = res.getString("conname");
				String conphone = res.getString("conphone");
				double sumprice = res.getDouble("sumprice");
				String orderimgurl = res.getString("orderimgurl");
				Order order = new Order(user_id, ordernum, orderstate, ordertime, goods_name, goods_price, goods_number, address, conname, conphone, sumprice,orderimgurl);
				list.add(order);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return null;
	}
	 */



	//获取立即购买时的图片和颜色
	public String getcolorByimgurl(String imgurl) {
		String sql = "select color from t_picture where imgurl=?";
		Connection connection = CreateConnection.getConnection();
		try {
			PreparedStatement ps =	connection.prepareStatement(sql);
			ps.setString(1, imgurl);
			ResultSet res = ps.executeQuery();
			while(res.next()){
				String color = res.getString("color");			
				return color;			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	//列出订单表里所有清单
	public List<Order> listAllOrderbyId(int id) {
		String sql = "select * from t_order where user_id=?";
		Connection connection = CreateConnection.getConnection();
		List<Order>  orderLists = new ArrayList<Order>();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet res = ps.executeQuery();
			while(res.next()){
				int user_id = res.getInt("user_id");
				int ordernum = res.getInt("ordernum");
				int orderstate = res.getInt("orderstate");
				Date ordertime = res.getDate("ordertime");
				String goods_name = res.getString("goods_name");
				double goods_price = res.getDouble("goods_price");
				int goods_number = res.getInt("goods_num");
				String address = res.getString("address");
				String conname = res.getString("conname");
				String conphone = res.getString("conphone");
				double sumprice = res.getDouble("sumprice");
				String orderimgurl = res.getString("orderimgurl");
				Order order = new Order(user_id,ordernum,orderstate,ordertime,goods_name,goods_price,goods_number,address,conname,conphone,sumprice,orderimgurl);
				orderLists.add(order);
			}
			return orderLists;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	//查询购物车里该商品的购买数量
	public Car carquery(int car_id) {
		String sql = "select * from t_car where carid=? ";
		Connection connection = CreateConnection.getConnection();
		Car car =null;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,car_id);
			ResultSet res = ps.executeQuery();
			while(res.next()){
				int goods_num = res.getInt("goods_num"); 
				int carid = res.getInt("carid");
				int goods_id = res.getInt("goods_id");
				int user_id = res.getInt("user_id");			
				String imgurl = res.getString("imgurl");
				car = new Car(goods_num,carid,goods_id,user_id,imgurl);
			}
			return car;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
	}
	//通过carid查询到goodsid然后查询goods表查出对应的商品信息
	public Goods querygoodsBycarid(int car_id) {
		String sql = "select * from t_goods where goodsid = (select goods_id from t_car where carid=? )";
		Connection connection = CreateConnection.getConnection();
		Goods goods = null;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, car_id);
			ResultSet res = ps.executeQuery();
			while(res.next()){
				int goodsid=res.getInt("goodsid");
				String goodsName = res.getString("goodsname");
				double goodsPrice = res.getDouble("goodsprice");
				String goodsInfo = res.getString("goodsinfo");
				int goodStype_id = res.getInt("goodstype_id");	
				int goodsId = res.getInt("goodsid");
				goods = new Goods(goodsid,goodsName, goodsPrice, goodsInfo, goodStype_id,goodsId);
			}
			return goods;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return null;




	}
	//通过商品id查询详情信息表
	public Param queryBygoodsid(int goodsid) {
		String sql= "select * from t_param where goods_id=?";
		Connection connection = CreateConnection.getConnection();
		Param param = null;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,goodsid);
			ResultSet res = ps.executeQuery();
			while(res.next()){
				int	paramid = res.getInt("paramid");
				String	cpu = res.getString("cpu");
				String	ram = res.getString("ram");
				String	rom = res.getString("rom");
				String	size = res.getString("size");
				String	battery = res.getString("battery");
				String	os = res.getString("os");
				int	goods_id = res.getInt("goods_id");
				param = new Param(paramid, cpu, ram, rom, size, battery, os, goods_id);	
			}
			return param;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return null;




	}

	public int getMax() {
		int max = 0;
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "select max(ordernum) m from t_order";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()){
				max = set.getInt("m");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return max;
	}

	public void add(Order order) {
		// TODO Auto-generated method stub

	}

	public void updata(int ordernum, int state) {
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "update t_order set orderstate="+state+" where ordernum="+ordernum;
			Statement statement = connection.createStatement();
			statement.execute(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public int getDataCount() {
		int count=0;
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "select count(*) c from t_order";
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



	//我的订单分页

	public int getDataCount(int userid) {
		int count=0;
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "select count(*) o from t_order where user_id="+userid;
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			if(set.next()){
				count = set.getInt("o");
			}
			CreateConnection.close(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}

	public Pager getPager(int currPage,int pageSize,int userid){
		ArrayList<Order>  orderLists = new ArrayList<Order>();
		Pager pager = null;
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "select * from t_order o where user_id=?  order by ordernum desc limit ?,?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, userid);
			statement.setInt(2, (currPage-1)*pageSize);
			statement.setInt(3, pageSize);
			ResultSet set = statement.executeQuery();
			while(set.next()){
				int user_id = set.getInt("user_id");
				int ordernum = set.getInt("ordernum");
				int orderstate = set.getInt("orderstate");
				Date ordertime = set.getDate("ordertime");
				String goods_name = set.getString("goods_name");
				double goods_price = set.getDouble("goods_price");
				int goods_number = set.getInt("goods_num");
				String address = set.getString("address");
				String conname = set.getString("conname");
				String conphone = set.getString("conphone");
				double sumprice = set.getDouble("sumprice");
				String orderimgurl = set.getString("orderimgurl");
				Order order = new Order(user_id,ordernum,orderstate,ordertime,goods_name,goods_price,goods_number,address,conname,conphone,sumprice,orderimgurl);
				orderLists.add(order);
			}

			int dataCount = getDataCount(userid);
			int pageCount = dataCount%pageSize==0?dataCount/pageSize:dataCount/pageSize+1;
			pager = new Pager(currPage, pageSize, pageCount, dataCount);
			pager.setOrders(orderLists);
			CreateConnection.close(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return pager;
	} 


	public Pager getPager(int currPage, int pageSize) {
		List<Order> allorder=new ArrayList<Order>();
		Pager pager=null;
		Connection conn=CreateConnection.getConnection();
		String sql="select ordernum,orderstate,ordertime,goods_num,goods_price,goods_name,address,conname,conphone,sumprice,username,orderimgurl from t_order,t_user where user_id=userid order by ordernum desc limit ?,?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, (currPage-1)*pageSize);
			ps.setInt(2, pageSize);
			ResultSet set=ps.executeQuery();
			while(set.next()){
				int ordernum=set.getInt("ordernum");
				int orderstate=set.getInt("orderstate");
				int goods_num=set.getInt("goods_num");
				Date  ordertime =set.getDate("ordertime");
				double goods_price=set.getDouble("goods_price");
				String goods_name=set.getString("goods_name");
				String address=set.getString("address");
				String conname=set.getString("conname");
				String conphone=set.getString("conphone");
				double sumprice=set.getDouble("sumprice");
				String username=set.getString("username");
				String orderimgurl=set.getString("orderimgurl");
				Order order=new Order(ordernum, orderstate, ordertime, goods_name, goods_price, goods_num, address, conname, conphone, sumprice, orderimgurl, username);
				allorder.add(order);
			}
			int dataCount = getDataCount();
			int pageCount = dataCount%pageSize==0?dataCount/pageSize:dataCount/pageSize+1;
			pager=new Pager(currPage, pageSize, pageCount, dataCount, allorder);

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}
		return pager;
	}

	public void updateOrderstate(int ordernum) {
		Connection conn=CreateConnection.getConnection();
		String sql="update t_order set orderstate=? where ordernum="+ordernum;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, 3);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}


	}

	public void deleteOrder(int ordernum) {
		Connection conn=CreateConnection.getConnection();
		String sql="delete from t_order where ordernum="+ordernum;
		try {
			Statement sta=conn.createStatement();
			sta.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}
	}

	//下面这两个方法打算用来更改t_goods 表中的库存数量
	public int getGoodsNumByGoodsId(int goodsid){
		String sql="select goodsnum from t_goods t where t.goodsid="+goodsid;
		Connection conn=CreateConnection.getConnection();
		try {
			Statement sta=conn.createStatement();
			ResultSet set=sta.executeQuery(sql);
			int goodnum=0;
			while(set.next()){
				goodnum=set.getInt("goodsnum");
			}
			return  goodnum;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}
		return 0;
	}
	public void updateGoodsnum(int goodsid, int num){
		int goodnum=getGoodsNumByGoodsId(goodsid);
		goodnum=goodnum-num;
		String sql="update t_goods set t_goods.goodsnum="+goodnum+" where t_goods.goodsid="+goodsid+"";
		Connection conn=CreateConnection.getConnection();
		try {
			Statement sta=conn.createStatement();
			sta.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}
	}

	public List<Order> listByState(int userid,int state) {
		List<Order> orders = listAllOrderbyId(userid);
		List<Order> orders2 = new ArrayList<Order>();
		for (Order order : orders) {
			if(order.getOrderstate()==state){
				orders.add(order);
			}
		}
		return orders2;
	}

	public Pager getPagerByState(int currPage,int pageSize,int userid,int state){
		ArrayList<Order>  orderLists = new ArrayList<Order>();
		Pager pager = null;
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "select * from t_order o where user_id=? and orderstate=? order by ordernum desc limit ?,?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, userid);
			statement.setInt(2, state);
			statement.setInt(3, (currPage-1)*pageSize);
			statement.setInt(4, pageSize);
			ResultSet set = statement.executeQuery();
			while(set.next()){
				int user_id = set.getInt("user_id");
				int ordernum = set.getInt("ordernum");
				Date ordertime = set.getDate("ordertime");
				String goods_name = set.getString("goods_name");
				double goods_price = set.getDouble("goods_price");
				int goods_number = set.getInt("goods_num");
				String address = set.getString("address");
				String conname = set.getString("conname");
				String conphone = set.getString("conphone");
				double sumprice = set.getDouble("sumprice");
				String orderimgurl = set.getString("orderimgurl");
				Order order = new Order(user_id,ordernum,state,ordertime,goods_name,goods_price,goods_number,address,conname,conphone,sumprice,orderimgurl);
				orderLists.add(order);
			}

			int dataCount = getDataCount(userid,state);
			int pageCount = dataCount%pageSize==0?dataCount/pageSize:dataCount/pageSize+1;
			pager = new Pager(currPage, pageSize, pageCount, dataCount);
			pager.setOrders(orderLists);
			CreateConnection.close(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pager;
	}

	private int getDataCount(int userid, int state) {
		int count=0;
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "select count(*) o from t_order where user_id="+userid+" and orderstate="+state;
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			if(set.next()){
				count = set.getInt("o");
			}
			CreateConnection.close(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}



	//通过ordernum获取订单状态，用于实时刷新订单界面
	public String getOrderstateByordernum(int ordernum) {
		String sql ="select orderstate s from t_order where ordernum=?";
		Connection connection = CreateConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, ordernum);
			ResultSet res =ps.executeQuery();
			while(res.next()){
				String state = res.getString("s");
				return state;
				}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
}





}
