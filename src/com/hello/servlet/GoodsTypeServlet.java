package com.hello.servlet;


import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello.beans.Goodstype;
import com.hello.beans.Pager;
import com.hello.dao.GoodsTypeDao;
import com.hello.dao.impl.GoodsTypeImpl;
import com.hello.util.FormtoObject;

public class GoodsTypeServlet extends BaseServlet {
	public String Typelist(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			request.setCharacterEncoding("utf-8");
			GoodsTypeDao dao =new GoodsTypeImpl();
			List<Goodstype> goodsType=dao.typeListById();
			
			request.setAttribute("goodsType", goodsType);
			result= redirect+"/massager/goods_add01.jsp";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	public String addType(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			request.setCharacterEncoding("utf-8");
			GoodsTypeDao dao =new GoodsTypeImpl();
			String goodstypename=request.getParameter("goodstypename");
			//System.out.println(goodstypename);
			String supertype=request.getParameter("supertype");
			String brand=request.getParameter("brand");
			Goodstype goodstype=new Goodstype(goodstypename, supertype, brand);
			dao.addType(goodstype);
			result= redirect+"/massager/goods_add03.jsp";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
		}
	public String listGoodsType(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			request.setCharacterEncoding("utf-8");
			GoodsTypeDao dao= new GoodsTypeImpl();
			int currPage=Integer.parseInt(request.getParameter("currpage"));
			Pager pager=dao.getPager(currPage, 10);
			request.setAttribute("pager", pager);
			result= redirect+"/massager/goods_list04.jsp";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	public String updateType01(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			request.setCharacterEncoding("utf-8");
			String goodstypeid=request.getParameter("goodstypeid");
			request.setAttribute("goodstypeid", goodstypeid);
			result= redirect+"/massager/goods_update04.jsp";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	public String updateType(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			request.setCharacterEncoding("utf-8");
			int goodstypeid=Integer.parseInt(request.getParameter("goodstypeid"));
			//System.out.println(goodstypeid);
			String goodstypename=request.getParameter("goodstypename");
			String supertype=request.getParameter("supertype");
			String brand=request.getParameter("brand");
			Goodstype goodstype= new Goodstype(goodstypeid, goodstypename, supertype, brand);
			GoodsTypeDao dao=new GoodsTypeImpl();
			dao.updateType(goodstype);
			result= redirect+"GoodsTypeServlet?method=listGoodsType&currpage=1";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	public String deleteType(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			request.setCharacterEncoding("utf-8");
			int goodstypeid=Integer.parseInt(request.getParameter("goodstypeid"));
			GoodsTypeDao dao=new GoodsTypeImpl();
			dao.deleteType(goodstypeid);
			result= redirect+"GoodsTypeServlet?method=listGoodsType&currpage=1";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
		
	}
}