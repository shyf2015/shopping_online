package com.hello.servlet;


import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello.beans.Goods;
import com.hello.beans.Pager;
import com.hello.beans.Param;
import com.hello.dao.GoodsDao;
import com.hello.dao.ParamDao;
import com.hello.dao.impl.GoodsImpl;
import com.hello.dao.impl.ParamImpl;

public class ParamServlet extends BaseServlet {
	private GoodsDao gi = new GoodsImpl();

	public String listParam(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			request.setCharacterEncoding("utf-8");
			ParamDao dao= new ParamImpl();
			int currPage=Integer.parseInt(request.getParameter("currpage"));
			Pager pager=dao.getPager(currPage, 8);
			request.setAttribute("pager", pager);
			result = redirect+"/massager/goods_list02.jsp";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	public String updateParam(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			request.setCharacterEncoding("utf-8");
			int paramid=Integer.parseInt(request.getParameter("paramid"));
			
			//System.out.println(paramid);
			int goods_id=Integer.parseInt(request.getParameter("goodsid"));
			String cpu=request.getParameter("cpu");
			String ram=request.getParameter("ram");
			String rom=request.getParameter("rom");
			String size=request.getParameter("size");
			String battery=request.getParameter("battery");
			String os=request.getParameter("os");
			Param param=new Param(paramid, cpu, ram, rom, size, battery, os, goods_id);
			
			ParamDao dao=new ParamImpl();
			dao.updateParam(param);
			result = redirect+"GoodsServlet?method=listGoods&currpage=1";
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		return result;
	}
}
