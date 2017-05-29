package com.hello.servlet;


import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello.beans.User;
import com.hello.dao.OrderDao;
import com.hello.dao.UserDao;
import com.hello.dao.impl.OrderImpl;
import com.hello.dao.impl.UserImpl;

public class EvaluateServlet extends BaseServlet {
	public String addEvaluate(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("session_user");
		String ordernum=request.getParameter("ordernum");
		String userid=request.getParameter("userid");
		String evaluate=request.getParameter("evaluate");
		String dengji=request.getParameter("star");
		String goods_name=request.getParameter("goodsname");
		String username = user.getUsername();
	//	System.out.println(username);
		UserDao dao=new UserImpl();
		OrderDao orderstate = new OrderImpl();
		orderstate.updata(Integer.parseInt(ordernum), 4);
		dao.addEvaluate(Integer.parseInt(userid), evaluate,Integer.parseInt(dengji),goods_name,username);
		return "OrderServlet?method=listall";
	}
}
