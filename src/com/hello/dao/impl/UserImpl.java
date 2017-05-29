package com.hello.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hello.beans.Admin;
import com.hello.beans.Pager;
import com.hello.beans.User;
import com.hello.dao.UserDao;
import com.hello.util.CreateConnection;
import com.hello.util.MD5;

public class UserImpl implements UserDao{
	public static void main(String[] args) {
		UserImpl userImpl = new UserImpl();
	}
	
	Connection connection = CreateConnection.getConnection();
	//添加用户
	public void add(User user) {
		String sql = "insert into t_user(username,password,realname) values (?,?,?)";
		//使用MD5进行加密
		String password = MD5.getMD5(user.getPassword());
		try {
			Connection connection = CreateConnection.getConnection();
			PreparedStatement sta = connection.prepareStatement(sql);
			sta.setString(1, user.getUsername());
			sta.setString(2, password);
			sta.setString(3, user.getRealname());
			sta.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//判断此管理员是否存在
	public boolean selectadmin(Admin admin) {
		String sql = "select * from t_admin where adminname=? and adminpassword=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, admin.getAdminname());
			ps.setString(2, admin.getAdminpassword());
			ResultSet res = ps.executeQuery();
			while(res.next()){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public User query(String username) {
		User user = null;
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "select * from t_user where username='"+username+"'";
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()){
				int userid = set.getInt("userid");
				String password = set.getString("password");
				String realname = set.getString("realname");
				user = new User(userid,username, password, realname);
				
			}
			CreateConnection.close(connection);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public int getDataCount() {
		int count=0;
		try {
			Connection connection = CreateConnection.getConnection();
			String sql = "select count(*) c from t_user";
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
		ArrayList<User> alluser=new ArrayList<User>();
		Pager pager=null;
		Connection conn=CreateConnection.getConnection();
		String sql="select * from t_user order by userid desc limit ?,?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, (currPage-1)*pageSize);
			ps.setInt(2, pageSize);
			ResultSet set=ps.executeQuery();
			while(set.next()){
				int userid=set.getInt("userid");
				String username=set.getString("username");
				String password=set.getString("password");
				String realname=set.getString("realname");
				User user=new User(userid, username, password, realname);
				alluser.add(user);
			}
			int dataCount = getDataCount();
			int pageCount = dataCount%pageSize==0?dataCount/pageSize:dataCount/pageSize+1;
			pager=new Pager(currPage, pageSize, alluser, pageCount, dataCount);
			CreateConnection.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pager;
	}

	public void deleteUser(int userid) {
		Connection conn=CreateConnection.getConnection();
		String sql="delete from t_user where userid="+userid;
		try {
			Statement sta=conn.createStatement();
			sta.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}
	}
	public void addEvaluate(int userid,String evaluate,int dengji,String goods_name,String username){
		String sql="insert into t_pingjia (user_id,evaluate,dengji,goods_name,user_name) values (?,?,?,?,?) ";
		Connection conn=CreateConnection.getConnection();
		try {
			PreparedStatement sta=conn.prepareStatement(sql);
			sta.setInt(1, userid);
			sta.setString(2, evaluate);
			sta.setInt(3, dengji);
			sta.setString(4,goods_name);
			sta.setString(5,username);
			sta.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			CreateConnection.close(conn);
		}
	}

}
