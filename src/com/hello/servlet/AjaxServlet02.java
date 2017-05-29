package com.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class AjaxServlet02 extends HttpServlet {

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
		/*System.out.println(username);
		System.out.println(pwd);
		System.out.println(conf_pwd);*/

		String name_reg = "^[\\u4e00-\\u9fa5_a-zA-Z0-9-]{1,16}$";
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;

		// 判断用户名
		if (username.matches(name_reg)) {
			j.put("msg", "合法");
			out.write(j.toString());
			flag1 = true;
		} else {
			j.put("msg", "限16位,字母数字下划线");
			out.write(j.toString());
		}
//		// 判断密码
//			if (pwd.matches(name_reg)) {
//				j.put("pwd_msg", "合法");
//				out.write(j.toString());
//				flag2 = true;
//			} else {
//				j.put("pwd_msg", "限16位,字母数字下划线");
//				out.write(j.toString());
//			}
//		// 判断 确认密码是否与密码相同
//		if (conf_pwd.equals(pwd)) {
//			j.put("conf_msg", "一致");
//			out.write(j.toString());
//			flag3 = true;
//		} else {
//			j.put("conf_msg", "与之前的密码不一致");
//			out.write(j.toString());
//		}
//		//判断是否可以注册
//		System.out.println(flag1);
//		System.out.println(flag2);
//		System.out.println(flag3);
//		if(flag1==true && flag2==true && flag3==true){
//			j.put("sub_msg", "注册");
//			out.write(j.toString());
//		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
