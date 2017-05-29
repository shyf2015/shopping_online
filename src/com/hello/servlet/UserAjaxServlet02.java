package com.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import com.hello.beans.User;
import com.hello.dao.UserDao;
import com.hello.dao.impl.UserImpl;
import com.hello.util.CreateConnection;
import com.hello.util.MD5;

public class UserAjaxServlet02 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			JSONObject j = new JSONObject();
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			//拿到从前台通过ajax传过来的数据
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String pwd = MD5.getMD5(password);
			
			String sql = "select username from t_user";
			String sql2 = "select password from t_user where username = '"+username+"'";
			
				try {
					Connection conn = CreateConnection.getConnection(); 	
					Statement sta = conn.createStatement();
					ResultSet set = sta.executeQuery(sql);
					
					boolean flag = true;
					boolean flag2 = true;
					while (set.next()) {
						//System.out.println("=="+set.getString("username"));
						//判断从前台来的username是否和从数据库中查到的数据匹配?
						if (username.equals(set.getString("username"))) {
							ResultSet set2 = sta.executeQuery(sql2);
							flag=true;
							while (set2.next()) {
								if(pwd.equals(set2.getString("password"))){
									HttpSession session = request.getSession();
									UserDao dao = new UserImpl();
									User user = dao.query(username);
									session.setAttribute("session_user", user);
									flag2=true;
									break;
								}else{
									flag2=false;
								}
							}
							//如果匹配到,跳出循环
							break;
						} else {
							flag=false;
						}
					}
					
					if (flag == false) {
						j.put("msg", "用户名或密码错误");
						out.write(j.toString());
					}
					if(flag2 == false){
						j.put("msg3", "用户名或密码错误");
						out.write(j.toString());
					}
					if(flag == true && flag2 == true){
						j.put("msg2", "登录");
						out.write(j.toString());
//						request.getRequestDispatcher("GoodsServlet?method=list").forward(request, response);
						
					}
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
