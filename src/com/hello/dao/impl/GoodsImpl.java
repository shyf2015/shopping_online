package com.hello.dao.impl;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hello.beans.Goods;
import com.hello.beans.Pager;
import com.hello.beans.Param;
import com.hello.beans.Picture;
import com.hello.dao.GoodsDao;
import com.hello.util.CreateConnection;

public class GoodsImpl implements GoodsDao{
	public static void main(String[] args) {
		GoodsDao dao=new GoodsImpl();
		Pager pager=dao.getPager2(1, 8);
		//System.out.println(pager);
	}
	
	
	private PictureImpl pi = new PictureImpl();
	public ArrayList<Goods> list() {
		ArrayList<Goods> allgoods = new ArrayList<Goods>();
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "select * from t_goods";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()){
				int goodsId = set.getInt("goodsid");
				String goodsName = set.getString("goodsname");
				double goodsPrice = set.getDouble("goodsprice");
				String goodsInfo = set.getString("goodsinfo");
				int goodStype_id = set.getInt("goodstype_id");
				int goodsNum = set.getInt("goodsnum");
				Picture picture = pi.query(goodsId);
				String goodsImgurl = "";
				if(picture.getImgurls().size()>0){
					goodsImgurl = picture.getImgurls().get(0);
				}
				Goods goods = new Goods(goodsImgurl,goodsId, goodsName, goodsPrice,goodsInfo, goodStype_id, goodsNum);
				allgoods.add(goods);
			}
			CreateConnection.close(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allgoods;
	}

	public Goods query(int goodsid) {
		ArrayList<Goods> allgoods = list();
		for (Goods goods : allgoods) {
			if(goods.getGoodsId()==goodsid){
				return goods;
			}
		}
		return null;
	}
	
	public int getDataCount() {
		int count=0;
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "select count(*) c from t_goods";
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

	public Pager getPager(int currPage, int pageSize) {
		ArrayList<Goods> allgoods = new ArrayList<Goods>();
		Pager pager = null;
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "select * from t_goods limit ?,?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, (currPage-1)*pageSize);
			statement.setInt(2, pageSize);
			ResultSet set = statement.executeQuery();
			while(set.next()){
				int goodsId = set.getInt("goodsid");
				String goodsName = set.getString("goodsname");
				double goodsPrice = set.getDouble("goodsprice");
				String goodsInfo = set.getString("goodsinfo");
				int goodStype_id = set.getInt("goodstype_id");
				int goodsNum = set.getInt("goodsnum");
				Picture picture = pi.query(goodsId);
				String goodsImgurl = "str";
				if(picture.getImgurls().size()>0){
					goodsImgurl = picture.getImgurls().get(0);
				}
				Goods goods = new Goods(goodsImgurl,goodsId, goodsName, goodsPrice,goodsInfo, goodStype_id, goodsNum);
				allgoods.add(goods);
			}
			int dataCount = getDataCount();
			int pageCount = dataCount%pageSize==0?dataCount/pageSize:dataCount/pageSize+1;
			pager = new Pager(currPage, pageSize, pageCount, dataCount, allgoods);
			
			CreateConnection.close(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return pager;
	}

	public ArrayList<Goods> getGoodsByType(String supertype) {
		ArrayList<Goods> allgoods = new ArrayList<Goods>();
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "select * from t_goods g,t_goodstype t where g.goodstype_id=t.goodstypeid and supertype='"+supertype+"'";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()){
				int goodsId = set.getInt("goodsid");
				String goodsName = set.getString("goodsname");
				double goodsPrice = set.getDouble("goodsprice");
				String goodsInfo = set.getString("goodsinfo");
				int goodStype_id = set.getInt("goodstype_id");
				int goodsNum = set.getInt("goodsnum");
				Picture picture = pi.query(goodsId);
				String goodsImgurl = "str";
				if(picture.getImgurls().size()>0){
					goodsImgurl = picture.getImgurls().get(0);
				}
				Goods goods = new Goods(goodsImgurl,goodsId, goodsName, goodsPrice,goodsInfo, goodStype_id, goodsNum);
				allgoods.add(goods);
			}
			CreateConnection.close(connection);
			return allgoods;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Goods> getGoodsByType(String supertype, String brand) {
		ArrayList<Goods> allgoods = new ArrayList<Goods>();
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "select * from t_goods g,t_goodstype t where g.goodstype_id=t.goodstypeid and supertype='"+supertype+"' and brand='"+brand+"'";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()){
				int goodsId = set.getInt("goodsid");
				String goodsName = set.getString("goodsname");
				double goodsPrice = set.getDouble("goodsprice");
				String goodsInfo = set.getString("goodsinfo");
				int goodStype_id = set.getInt("goodstype_id");
				int goodsNum = set.getInt("goodsnum");
				Picture picture = pi.query(goodsId);
				String goodsImgurl="q";
				if(picture.getImgurls().size()>0){
					goodsImgurl = picture.getImgurls().get(0);
				}
				
				Goods goods = new Goods(goodsImgurl,goodsId, goodsName, goodsPrice,goodsInfo, goodStype_id, goodsNum);
				allgoods.add(goods);
			}
			CreateConnection.close(connection);
			return allgoods;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//拿到所有像商品名字的商品ID
	public List<Integer> getAllIdLikeGoodsName(String goodsName) {
		String sql="select t.goodsid from t_goods t where t.goodsname like '%"+goodsName+"%'";
		Connection connection = CreateConnection.getConnection();
		try {
			Statement sta=connection.createStatement();
			ResultSet set=sta.executeQuery(sql);
			List<Integer> lists=new ArrayList<Integer>();
			while(set.next()){
				int  goodsid=set.getInt("goodsid");
				lists.add(goodsid);
			}
			return lists;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(connection);
		}
		return null;
	}
	//拿到所有像品牌的品牌
	public List<String> getAllBrandByLikeBrand(String brand) {
		String sql="select distinct t.brand from t_goodstype t where t.brand like '%"+brand+"%'";
		Connection connection = CreateConnection.getConnection();
		try {
			Statement sta=connection.createStatement();
			ResultSet set=sta.executeQuery(sql);
			List<String> lists=new ArrayList<String>();
			while(set.next()){
				String br=set.getString("brand");
				lists.add(br);
			}
			return lists;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(connection);
		}
		return null;
	}
	//拿到所有像类型的类型
	public List<String> getAllSuperTypeByLikeSuperType(String supertype) {
		String sql="select distinct t.supertype from t_goodstype t where t.supertype like '%"+supertype+"%'";
		Connection connection = CreateConnection.getConnection();
		try {
			Statement sta=connection.createStatement();
			ResultSet set=sta.executeQuery(sql);
			List<String> lists=new ArrayList<String>();
			while(set.next()){
				String br=set.getString("supertype");
				lists.add(br);
			}
			return lists;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(connection);
		}
		return null;
	}
	
	

	public void addGoods(Goods goods) {
		String sql="insert into t_goods (goodsname,goodsprice,goodsinfo,goodstype_id,goodsnum) value (?,?,?,?,?)";
		Connection conn =CreateConnection.getConnection();
		//System.out.println(goods);
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, goods.getGoodsName());
			ps.setDouble(2, goods.getGoodsPrice());
			ps.setString(3, goods.getGoodsInfo());
			ps.setInt(4, goods.getGoodStype_id());
			ps.setInt(5, goods.getGoodsNum());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}
		
	}

	public List<Goods> listGoodsIdAndGoodsName() {
		Connection conn=CreateConnection.getConnection();
		String sql="select goodsid,goodsname from t_goods";
		try {
			Statement sta=conn.createStatement();
			ResultSet set=sta.executeQuery(sql);
			List<Goods> lists=new ArrayList<Goods>();
			while(set.next()){
				int goodsid=set.getInt("goodsid");
				String goodsname=set.getString("goodsname");
				Goods goods=new Goods(goodsid, goodsname);
				lists.add(goods);
			}
			return lists;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}
		
		return null;
	}

	public Goods listGoodsName() {
		Connection conn=CreateConnection.getConnection();
		String sql="select * from t_goods where goodsid=(select max(goodsid) from t_goods)";
		Goods goods = null;
		try {
			Statement sta=conn.createStatement();
			ResultSet set=sta.executeQuery(sql);
			while(set.next()){
				int goodsId=set.getInt("goodsid");
				String goodsName=set.getString("goodsname");
				goods=new Goods(goodsId, goodsName);
			}
			return goods;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}
		return null;
	}

	public Pager getPager2(int currPage, int pageSize) {
		ArrayList<Goods> allgoods = new ArrayList<Goods>();
		ArrayList<Param> allparam=new ArrayList<Param>();
		Pager pager = null;
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "select a.*,goodstypename,goodstypeid from(select * from t_goods right outer join t_param on goodsid=goods_id) a right outer join t_goodstype on a.goodstype_id= goodstypeid order by goodsid desc limit ?,?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, (currPage-1)*pageSize);
			statement.setInt(2, pageSize);
			ResultSet set = statement.executeQuery();
			while(set.next()){
				int goodsId = set.getInt("goodsid");
				String goodsName = set.getString("goodsname");
				double goodsPrice = set.getDouble("goodsprice");
				String goodsInfo = set.getString("goodsinfo");
				int goodsType_id=set.getInt("goodstype_id");
				String goodsTypeName=set.getString("goodstypename");
				int goodsNum = set.getInt("goodsnum");
				int paramid=set.getInt("paramid");
				String cpu=set.getString("cpu");
				String ram=set.getString("ram");
				String rom=set.getString("rom");
				String size=set.getString("size");
				String battery=set.getString("battery");
				String os=set.getString("os");
				Goods goods = new Goods(goodsId, goodsName, goodsPrice, goodsInfo, goodsType_id, goodsTypeName, goodsNum);
				Param param=new Param(paramid, cpu, ram, rom, size, battery, os, goodsId);
				allgoods.add(goods);
				allparam.add(param);
			}
			int dataCount = getDataCount();
			int pageCount = dataCount%pageSize==0?dataCount/pageSize:dataCount/pageSize+1;
			pager = new Pager(currPage, pageSize, pageCount, dataCount, allgoods, allparam);
			
			CreateConnection.close(connection);
		} catch (Exception e) {
			
		}
		return pager;
	}

	public void updataGoods(Goods goods) {
		Connection conn=CreateConnection.getConnection();
		String sql="update t_goods set goodsname=?,goodsprice=?,goodsinfo=?,goodstype_id=?,goodsnum=? where goodsid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, goods.getGoodsName());
			ps.setDouble(2, goods.getGoodsPrice());
			ps.setString(3, goods.getGoodsInfo());
			ps.setInt(4, goods.getGoodStype_id());
			ps.setInt(5, goods.getGoodsNum());
			ps.setInt(6, goods.getGoodsId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}
	}

	public void deleteGoods(int goodsid) {
		Connection conn=CreateConnection.getConnection();
		String sql="delete from t_goods where goodsid="+goodsid;
		
		try {
			Statement sta=conn.createStatement();
			sta.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}
	}
	public Pager getPage(int currPage, int pageSize, String searchinfo) {
		String sql="select g.* from t_goodstype t,t_goods g where g.goodstype_id=t.goodstypeid and (g.goodsname like ? or t.goodstypename like ? or t.supertype like ? or t.brand like ?)limit ?,?";
		Connection conn=CreateConnection.getConnection();
		try {
			PreparedStatement sta=conn.prepareStatement(sql);
			sta.setString(1, "%"+searchinfo+"%");
			sta.setString(2, "%"+searchinfo+"%");
			sta.setString(3, "%"+searchinfo+"%");
			sta.setString(4, "%"+searchinfo+"%");
			sta.setInt(5,(currPage-1)*pageSize);
			sta.setInt(6,pageSize);
			ResultSet set=sta.executeQuery();
			ArrayList<Goods> allgoods = new ArrayList<Goods>();
			while(set.next()){
				int goodsId = set.getInt("goodsid");
				String goodsName = set.getString("goodsname");
				double goodsPrice = set.getDouble("goodsprice");
				String goodsInfo = set.getString("goodsinfo");
				int goodStype_id = set.getInt("goodstype_id");
				int goodsNum = set.getInt("goodsnum");
				Picture picture = pi.query(goodsId);
				String goodsImgurl="q";
				if(picture.getImgurls().size()>0){
					goodsImgurl = picture.getImgurls().get(0);
				}
				Goods goods = new Goods(goodsImgurl,goodsId, goodsName, goodsPrice,goodsInfo, goodStype_id, goodsNum);
				allgoods.add(goods);
			}
			int dataCount = getDataCount(searchinfo);
			int pageCount = dataCount%pageSize==0?dataCount/pageSize:dataCount/pageSize+1;
			Pager pager = new Pager(currPage, pageSize, pageCount, dataCount, allgoods);
			return pager;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}
		return null;
	}

	private int getDataCount(String searchinfo) {
		int count = 0;
		try {
			Connection connection = CreateConnection.getConnection();
			String sql="select count(*) c from t_goodstype t,t_goods g where g.goodstype_id=t.goodstypeid and (g.goodsname like ? or t.goodstypename like ? or t.supertype like ? or t.brand like ?)";
			PreparedStatement sta = connection.prepareStatement(sql);
			sta.setString(1, "%"+searchinfo+"%");
			sta.setString(2, "%"+searchinfo+"%");
			sta.setString(3, "%"+searchinfo+"%");
			sta.setString(4, "%"+searchinfo+"%");
			ResultSet set = sta.executeQuery();
			while(set.next()){
				 count = set.getInt("c");
			}
			CreateConnection.close(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public Pager getPagerBySupertypeAndBrand(String supertype, String brand, int currPage, int pageSize){
		String sql = "select g.* from t_goods g,t_goodstype t where g.goodstype_id=t.goodstypeid and supertype=? and brand=? limit ?,?";
		Connection conn = CreateConnection.getConnection();
		PreparedStatement sta;
		try {
			sta = conn.prepareStatement(sql);
			sta.setString(1, supertype);
			sta.setString(2, brand);
			sta.setInt(3, (currPage-1)*pageSize);
			sta.setInt(4, pageSize);
			ResultSet set=sta.executeQuery();
			ArrayList<Goods> allgoods = new ArrayList<Goods>();
			while(set.next()){
				int goodsId = set.getInt("goodsid");
				String goodsName = set.getString("goodsname");
				double goodsPrice = set.getDouble("goodsprice");
				String goodsInfo = set.getString("goodsinfo");
				int goodStype_id = set.getInt("goodstype_id");
				int goodsNum = set.getInt("goodsnum");
				
				Picture picture = pi.query(goodsId);
				String goodsImgurl="q";
				if(picture.getImgurls().size()>0){
					goodsImgurl = picture.getImgurls().get(0);
				}
				Goods goods = new Goods(goodsImgurl,goodsId, goodsName, goodsPrice,goodsInfo, goodStype_id, goodsNum);
				allgoods.add(goods);
			}
			int dataCount = getDataCount(supertype,brand);
			int pageCount = dataCount%pageSize==0?dataCount/pageSize:dataCount/pageSize+1;
			Pager pager = new Pager(currPage, pageSize, pageCount, dataCount, allgoods);
			return pager;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}
		return null;
	}
	public int getDataCount(String supertype, String brand){
		String sql = "select count(*) c from t_goods g,t_goodstype t where g.goodstype_id=t.goodstypeid and supertype=? and brand=? ";
		Connection conn = CreateConnection.getConnection();
		try {
			PreparedStatement sta= conn.prepareStatement(sql);
			sta.setString(1, supertype);
			sta.setString(2, brand);
			ResultSet set=sta.executeQuery();
			int num=0;
			while(set.next()){
				num=set.getInt("c");
			}
			return num;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}
		return 0;
	}

	public int maxGoodsId() {
		Connection conn=CreateConnection.getConnection();
		String sql= "select max(goodsid) from t_goods";
		int maxGoodsId = 0;
		try {
			Statement sta=conn.createStatement();
			ResultSet set=sta.executeQuery(sql);
			while(set.next()){
				maxGoodsId=set.getInt("max(goodsid)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxGoodsId;
	}


	
}
