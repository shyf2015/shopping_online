package com.hello.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hello.beans.Pager;
import com.hello.beans.Picture;
import com.hello.dao.PictureDao;
import com.hello.util.CreateConnection;


public class PictureImpl implements PictureDao{
	
	public Picture query(int goodsid) {
		ArrayList<String> colors = new ArrayList<String>();
		ArrayList<String> imgurls = new ArrayList<String>();
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "select * from t_picture where goods_id="+goodsid;
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()){
				String color = set.getString("color");
				String imgurl = set.getString("imgurl");
				colors.add(color);
				imgurls.add(imgurl);
			}
			Picture picture = new Picture(goodsid, colors, imgurls);
			CreateConnection.close(connection);
			return picture;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void addPicture(Picture picture) {
		Connection conn=CreateConnection.getConnection();
		String sql="insert into t_picture (goods_id,color,imgurl) value ((select max(goodsid) from t_goods),?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
		
			ps.setString(1, picture.getColor());
			ps.setString(2, picture.getImgurl());
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
			String sql = "select count(*) c from t_picture";
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
		ArrayList<Picture> allpicture=new ArrayList<Picture>();
		Pager pager=null;
		Connection conn=CreateConnection.getConnection();
		String sql="select color,imgurl,pictureid,goods_id,goodsname from t_picture,t_goods where goods_id=goodsid order by pictureid desc limit ?,?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, (currPage-1)*pageSize);
			ps.setInt(2, pageSize);
			ResultSet set=ps.executeQuery();
			while(set.next()){
				int goods_id=set.getInt("goods_id");
				//System.out.println(pictureid);
				//System.out.println(goods_id);
				String color=set.getString("color");
				//System.out.println(color);
				String imgurl=set.getString("imgurl");
				//System.out.println(imgurl);
				String goodsname=set.getString("goodsname");
				int pictureid=set.getInt("pictureid");
				Picture pictures=new Picture(goods_id, color, imgurl, goodsname, pictureid);
				//System.out.println(pictures);
				allpicture.add(pictures);
			}
			//System.out.println(allpicture);
			int dataCount = getDataCount();
			int pageCount = dataCount%pageSize==0?dataCount/pageSize:dataCount/pageSize+1;
			pager=new Pager(currPage, allpicture, pageSize, pageCount, dataCount);
			CreateConnection.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pager;
	}

	public void updatePicture(Picture picture) {
		Connection conn=CreateConnection.getConnection();
		String sql="update t_picture set color=?,imgurl=? where pictureid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, picture.getColor());
			ps.setString(2, picture.getImgurl());
			ps.setInt(3, picture.getPictureid());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}
	}

	public Picture findPictureById(int pictureid) {
		Connection conn=CreateConnection.getConnection();
		String sql="select goodsname,goods_id,pictureid from t_picture,t_goods where goods_id=goodsid and pictureid="+pictureid;
		
		try {
			Statement sta=conn.createStatement();
			ResultSet set=sta.executeQuery(sql);
			while(set.next()){
				String goodsname=set.getString("goodsname");
				int goods_id=set.getInt("goods_id");
				int pictureids=set.getInt("pictureid");
				Picture picture=new Picture(goods_id, goodsname, pictureids);
				
				return picture;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}
		return null;
	}

	public void deletePicture(int pictureid) {
		Connection conn=CreateConnection.getConnection();
		String sql="delete from t_picture where pictureid="+pictureid;
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
