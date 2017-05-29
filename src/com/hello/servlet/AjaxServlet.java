package com.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello.util.CreateConnection;

import net.sf.json.JSONObject;

public class AjaxServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONObject j = new JSONObject();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 接收发过来的user数据
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String conf_pwd = request.getParameter("conf_pwd");
//		System.out.println(username);
//		System.out.println(pwd);
//		System.out.println(conf_pwd);
		// 判断 用户名的正则表达式,用以验证用户名是否合法
		String name_reg = "^[\\u4e00-\\u9fa5_a-zA-Z0-9-]{1,16}$";
		boolean flag = true;
		if (username != "" && username != null) {
			Connection conn = CreateConnection.getConnection();
			try {
				String sql = "select username from t_user";
				Statement sta = conn.createStatement();
				ResultSet set = sta.executeQuery(sql);
				while (set.next()) {
					if(username.equals(set.getString("username"))){
						flag=false;
						j.put("msg", "该用户名已被注册");
						out.write(j.toString());
						break;
					}
				}
					if(flag){
						if (username.matches(name_reg)) {
							// 向页面传送数据
							j.put("msg", "合法");
							out.write(j.toString());
						} else {
							j.put("msg", "限16位,字母数字下划线");
							out.write(j.toString());
						}
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		// 判断密码
		String pwd_reg = "^[\\u4e00-\\u9fa5_a-zA-Z0-9-]{1,16}$";
		if (pwd != "" && pwd != null && conf_pwd == null) {
			if (pwd.matches(pwd_reg)) {
				j.put("pwd_msg", "合法");
				out.write(j.toString());
			} else {
				j.put("pwd_msg", "限16位,字母数字下划线");
				out.write(j.toString());
			}
		}
		//判断 确认密码是否与密码相同
		if (conf_pwd != "" && conf_pwd != null) {
			if (conf_pwd.equals(pwd)) {
				j.put("conf_msg", "与之前输入的密码一致");
				out.write(j.toString());
			} else {
				j.put("conf_msg", "与之前输入的密码不一致");
				out.write(j.toString());
			}
		}
//		System.out.println(pwd);
//		System.out.println(conf_pwd);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
