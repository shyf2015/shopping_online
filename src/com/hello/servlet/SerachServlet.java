package com.hello.servlet;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello.beans.Goods;
import com.hello.beans.Goodstype;
import com.hello.beans.Pager;
import com.hello.dao.GoodsDao;
import com.hello.dao.GoodsTypeDao;
import com.hello.dao.impl.GoodsImpl;
import com.hello.dao.impl.GoodsTypeImpl;

public class SerachServlet extends BaseServlet {
	private GoodsDao gi = new GoodsImpl();
	public String list(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			String supertype=request.getParameter("st");
			String currPage = request.getParameter("currPage");
			Pager pager=null;
			if(currPage==null){
				currPage = "1";
			}
			if(supertype!=null){
				//如果supertype不为空，则证明用户在界面上点的是类型下面的品牌
				String brand = request.getParameter("searchinfo");
				List<Goods> lists=gi.getGoodsByType(supertype, brand);
				pager=gi.getPagerBySupertypeAndBrand(supertype, brand, Integer.parseInt(currPage), 8);
				request.setAttribute("brand","brand");
				request.setAttribute("st",supertype);
			}else{
				//否则点的是类型或者搜索
				String searchinfo = request.getParameter("searchinfo");
				pager = gi.getPage(Integer.parseInt(currPage), 8, searchinfo);
				request.setAttribute("searchinfo", searchinfo);
			}
			request.setAttribute("searchpager", pager);
			
			List<Goodstype> supertypesAndBrands =new ArrayList<Goodstype>();
			GoodsTypeDao dao=new GoodsTypeImpl();
			List<String> types=dao.getAllType();
			for(String t: types){
				List<String> brands=dao.getAllBrand(t);
				Goodstype goodstype=new Goodstype(t, brands);
				supertypesAndBrands.add(goodstype);
			}
			request.setAttribute("supertypesAndBrands", supertypesAndBrands);
			
			
			
			return redirect+"/page/main.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/*public Pager getPager(int currPage,int pageSize,String searchinfo){
		
	}*/
}
