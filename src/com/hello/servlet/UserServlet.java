package com.hello.servlet;


import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello.beans.Pager;
import com.hello.beans.User;
import com.hello.dao.GoodsDao;
import com.hello.dao.UserDao;
import com.hello.dao.impl.GoodsImpl;
import com.hello.dao.impl.UserImpl;
import com.hello.util.FormtoObject;

public class UserServlet extends BaseServlet {
	FormtoObject fo = new FormtoObject();
	UserImpl user_impl = new UserImpl();
	public String add(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			User user = (User) fo.form2Object(request, User.class);
			user_impl.add(user);
			return  redirect+"/page/login.jsp";
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String listUser(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			//System.out.println("123312312");
			request.setCharacterEncoding("utf-8");
			UserDao dao=new UserImpl();
			int currPage = Integer.parseInt(request.getParameter("currPage"));
			Pager pager= dao.getPager(currPage, 5);
			request.setAttribute("pager", pager);
			result = redirect+"/massager/user_list.jsp";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	public String deleteUser(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			request.setCharacterEncoding("utf-8");
			int userid=Integer.parseInt(request.getParameter("userid"));
			UserDao dao=new UserImpl();
			dao.deleteUser(userid);
			result = redirect+"UserServlet?method=listUser&currPage=1";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
}	
