package com.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello.util.CreateConnection;

public class UpdateAddressServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sql = "update t_address set province=?,city=?,country=?,conname=?,conphone=?,address=? where addressid=?;";
		try {
			Connection connection = CreateConnection.getConnection();
			PreparedStatement sta = connection.prepareStatement(sql);
			sta.setString(1, request.getParameter("province"));
			sta.setString(2, request.getParameter("city"));
			sta.setString(3, request.getParameter("country"));
			sta.setString(4, request.getParameter("conname"));
			sta.setString(5, request.getParameter("conphone"));
			sta.setString(6, request.getParameter("address"));
//			sta.setInt(7, address.getUser_id());
			sta.setInt(7, Integer.parseInt(request.getParameter("addressid")));
			sta.execute();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("page/return.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		doGet(req, resp);
	}
	
	


}
