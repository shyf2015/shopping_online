package com.hello.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.hello.beans.Address;
import com.hello.dao.AddressDao;
import com.hello.util.CreateConnection;
import com.jspsmart.upload.Request;

public class AddressImpl implements AddressDao{
	public void add(Address address) {
		String sql = "insert into t_address (user_id,province,city,country,address,conname,conphone) values (?,?,?,?,?,?,?)";
		try {
			Connection connection = CreateConnection.getConnection();
			PreparedStatement sta = connection.prepareStatement(sql);
			sta.setInt(1, address.getUser_id());
			sta.setString(2, address.getProvince());
			sta.setString(3, address.getCity());
			sta.setString(4, address.getCountry());
			sta.setString(5, address.getAddress());
			sta.setString(6, address.getConname());
			sta.setString(7, address.getConphone());
			sta.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Address> query_address(int user_id) {
		ArrayList<Address> list = new ArrayList<Address>();
		Connection connection = CreateConnection.getConnection();
		String sql = "select * from t_address where user_id='"+user_id+"'";
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while (set.next()) {
				int addressid = set.getInt("addressid");
				String province = set.getString("province");
				String city = set.getString("city");
				String country = set.getString("country");
				String address = set.getString("address");
				String conname = set.getString("conname");
				String conphone = set.getString("conphone");
				Address address2 = new Address(addressid, user_id,province,city,
						country, address,conname,conphone);
				list.add(address2);
			}
			connection.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public void delete_address(int addressid) {
		Connection connection = CreateConnection.getConnection();
		String sql = "delete from t_address where addressid = '"+addressid+"'";
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void update_address(Address address,int addressid) {
		String sql = "update t_address set province=?,city=?,country=?,conname=?,conphone=?,address=?,user_id=? where addressid=?;";
		try {
			Connection connection = CreateConnection.getConnection();
			PreparedStatement sta = connection.prepareStatement(sql);
			sta.setString(1, address.getProvince());
			sta.setString(2, address.getCity());
			sta.setString(3, address.getCountry());
			sta.setString(4, address.getConname());
			sta.setString(5, address.getConphone());
			sta.setString(6, address.getAddress());
			sta.setInt(7, address.getUser_id());
			sta.setInt(8, address.getAddressid());
			sta.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
