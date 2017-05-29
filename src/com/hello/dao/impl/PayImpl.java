package com.hello.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import com.hello.dao.OrderDao;
import com.hello.dao.PayDao;
import com.hello.util.CreateConnection;

public class PayImpl implements PayDao{
	private OrderDao oi = new OrderImpl();
	//将订单添加到数据库
	public int addOrderByuserid(String[] goods_order,String[] addr) {
		//System.out.println(Arrays.toString(goods_order)+"这是listcar");
		//System.out.println(Arrays.toString(addr)+"这是address");
		String sql = "insert into t_order (goods_name,goods_price,goods_num,address,conname,conphone,sumprice,user_id,orderimgurl) value (?,?,?,?,?,?,?,?,?)";
		Connection connection = CreateConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);			
				
				ps.setString(1, goods_order[8]);
			
				ps.setString(2, goods_order[1]);
				
				ps.setString(3, goods_order[0]);
				
				ps.setString(4, addr[5]);
			
				ps.setString(5, addr[6]);
		
				ps.setString(6,addr[7]);
			
				ps.setString(7, goods_order[4]);
		
				ps.setString(8, goods_order[3]);
			
				ps.setString(9, goods_order[6]);
				
				ps.execute();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			CreateConnection.close(connection);
			
		}
		return oi.getMax();
	}

	public void updateorderstate(int user_id) {
		// TODO Auto-generated method stub
		
	}

}
