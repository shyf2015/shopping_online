package com.hello.servlet;


import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello.beans.Pager;
import com.hello.dao.PingJiaDao;
import com.hello.dao.impl.PingJiaImpl;

public class PingJiaServlet extends BaseServlet {
	public String listPingJia(HttpServletRequest request, HttpServletResponse response){
		String result="";
		try {
			request.setCharacterEncoding("utf-8");
			int currPage=Integer.parseInt(request.getParameter("currPage"));
			PingJiaDao dao=new PingJiaImpl();
			Pager pager=dao.getPager(currPage, 5);
			request.setAttribute("pager", pager);
			result = redirect+"/massager/pingjia_list.jsp";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
