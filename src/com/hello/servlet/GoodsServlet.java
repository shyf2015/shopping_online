	package com.hello.servlet;




import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hello.beans.Goods;
import com.hello.beans.Goodstype;
import com.hello.beans.Pager;
import com.hello.beans.Param;
import com.hello.beans.Picture;
import com.hello.dao.GoodsDao;
import com.hello.dao.GoodsTypeDao;
import com.hello.dao.ParamDao;
import com.hello.dao.impl.GoodsImpl;
import com.hello.dao.impl.GoodsTypeImpl;
import com.hello.dao.impl.ParamImpl;
import com.hello.dao.impl.PictureImpl;


public class GoodsServlet extends BaseServlet {
	private GoodsImpl gi = new GoodsImpl();
	private PictureImpl pi = new PictureImpl();
	private ParamImpl pai = new ParamImpl();
	public String list(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			Pager pager = null;
			String currPage = request.getParameter("currPage");
			//如果前台没有传当前页数，默认当前页数为1
			if(currPage==null){
				pager = gi.getPager(1, 8);
			}else{
				pager = gi.getPager(Integer.parseInt(currPage), 8);
			}
			request.setCharacterEncoding("utf-8");
			


			List<Goodstype> supertypesAndBrands =new ArrayList<Goodstype>();
			GoodsTypeDao dao=new GoodsTypeImpl();
			List<String> types=dao.getAllType();
			for(String t: types){
				List<String> brands=dao.getAllBrand(t);
				Goodstype goodstype=new Goodstype(t, brands);
				supertypesAndBrands.add(goodstype);
			}
			request.setAttribute("supertypesAndBrands", supertypesAndBrands);



			request.setAttribute("pager", pager);
			result = redirect+"/page/main.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String query(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			request.setCharacterEncoding("utf-8");
			String goodsid = request.getParameter("goodsid");
			Goods goods = gi.query(Integer.parseInt(goodsid));
			Param param = pai.query(goods.getGoodsId());
			//System.out.println(Integer.parseInt(goodsid));
			Picture picture = pi.query(goods.getGoodsId());
			request.setAttribute("goods",goods);
			request.setAttribute("picture", picture);
			request.setAttribute("_param", param);
			result = redirect+"/page/detailinfo.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String listbytype(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			request.setCharacterEncoding("utf-8");
			String supertype = request.getParameter("supertype");
			String brand = request.getParameter("brand");
			ArrayList<Goods> allgoods = null;
			if(brand==null){
				allgoods = gi.getGoodsByType(supertype);
			}else{
				allgoods = gi.getGoodsByType(supertype,brand);
			}


			List<Goodstype> supertypesAndBrands =new ArrayList<Goodstype>();
			GoodsTypeDao dao=new GoodsTypeImpl();
			List<String> types=dao.getAllType();
			for(String t: types){
				List<String> brands=dao.getAllBrand(t);
				Goodstype goodstype=new Goodstype(t, brands);
				supertypesAndBrands.add(goodstype);
			}
			request.setAttribute("supertypesAndBrands", supertypesAndBrands);


			request.setAttribute("allgoods", allgoods);
			result = redirect+"/page/main.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//搜索功能的实现
	public String search(HttpServletRequest request,HttpServletResponse response){
		String searchinfo=request.getParameter("searchinfo");
		String currPage=request.getParameter("currPage");
		GoodsDao dao=new GoodsImpl();
		GoodsTypeDao dao1=new GoodsTypeImpl();
		Pager pager=null;
		/*if(currPage==null){
			pager =dao.getPage(1,8, searchinfo);
		}else{
			pager=dao.getPage(Integer.parseInt(currPage), 8, searchinfo);
		}*/
		if(currPage==null){
			pager=dao.getPage(1,50, searchinfo);
		}
		request.setAttribute("pager1", pager);

		List<Goodstype> supertypesAndBrands =new ArrayList<Goodstype>();
		List<String> types=dao1.getAllType();
		for(String t: types){
			List<String> brands=dao1.getAllBrand(t);
			Goodstype goodstype=new Goodstype(t, brands);
			supertypesAndBrands.add(goodstype);
		}
		request.setAttribute("supertypesAndBrands", supertypesAndBrands);



		//request.setAttribute("allgoods", allgoods);
		return redirect+"/page/main.jsp";
	}

	public String add(HttpServletRequest request,HttpServletResponse response){
		String result="";
		try {
			request.setCharacterEncoding("utf-8");
			String goodsName=request.getParameter("goodsname");
			double goodsPrice=Double.parseDouble(request.getParameter("goodsprice"));
			String goodsInfo=request.getParameter("goodsinfo");
			int goodsNum=Integer.parseInt(request.getParameter("goodsnum"));
			int goodStype_id=Integer.parseInt(request.getParameter("goodstypename"));
			Goods goods=new Goods(goodsName, goodsPrice,goodsInfo, goodStype_id, goodsNum);
			//request.setAttribute("goods", goods);
			GoodsDao dao=new GoodsImpl();
			dao.addGoods(goods);
			String cpu=request.getParameter("cpu");
			String ram=request.getParameter("ram");
			String rom=request.getParameter("rom");
			String size=request.getParameter("size");
			String battery=request.getParameter("battery");
			String os=request.getParameter("os");
			Param param=new Param(cpu, ram, rom, size, battery, os);
			ParamDao dao1=new ParamImpl();
			dao1.addParam(param);
			int goodsid=gi.maxGoodsId();
			Goods goods2=gi.query(goodsid);
			request.setAttribute("goods2", goods2);
			HttpSession session = request.getSession();
			session.setAttribute("goods2", goods2);
			//System.out.println( goodStype_id);
			result =redirect+"/massager/goods_add02.jsp";
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		return result;
	}
	/*public String listGoodsIdAndGoodsName(HttpServletRequest request,HttpServletResponse response){
		String result="";
		try {
			request.setCharacterEncoding("utf-8");
			GoodsDao dao=new GoodsImpl();
			List<Goods> lists=dao.listGoodsIdAndGoodsName();
			request.setAttribute("lists", lists);
			result = redirect+"/massager/goods_add02.jsp";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
		
	}*/
	/*public String listGoodsName(HttpServletRequest request,HttpServletResponse response){
		String result="";
		try {
			request.setCharacterEncoding("utf-8");
			
			
			GoodsDao dao=new GoodsImpl();
			Goods goods=dao.listGoodsName();
			System.out.println(goods);
			request.setAttribute("goods", goods);
			result = redirect+"/massager/goods_add01_1.jsp";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
		
	}*/
	public String listGoods(HttpServletRequest request,HttpServletResponse response){
		String result="";
		try {
			request.setCharacterEncoding("utf-8");
			GoodsDao dao=new GoodsImpl();
			int currPage = Integer.parseInt(request.getParameter("currPage"));
			//System.out.println(currPage);
			Pager pager=dao.getPager2(currPage, 8);
			//System.out.println(pager);
			request.setAttribute("pager", pager);
			result = redirect+"/massager/goods_list01.jsp";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	public String deleteGoods(HttpServletRequest request,HttpServletResponse response){
		String result="";
		try {
			request.setCharacterEncoding("utf-8");
			int goodsid=Integer.parseInt(request.getParameter("goodsid"));
			GoodsDao dao=new GoodsImpl();
			dao.deleteGoods(goodsid);
			result=redirect+"GoodsServlet?method=listGoods&currPage=1";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	public String updataGoods(HttpServletRequest request,HttpServletResponse response){
		String result="";
		try {
			request.setCharacterEncoding("utf-8");
			GoodsTypeDao dao= new GoodsTypeImpl();
			List<Goodstype> lists=dao.typeListById();
			request.setAttribute("lists", lists);
			String goodsid=request.getParameter("goodsid");
			String paramid=request.getParameter("paramid");
			request.setAttribute("goodsid",goodsid);
			request.setAttribute("paramid", paramid);
			result = redirect+"/massager/goods_updata01.jsp";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	public String updataGoods01(HttpServletRequest request,HttpServletResponse response){
		String result="";
		try {
			request.setCharacterEncoding("utf-8");
			int goodsid=Integer.parseInt(request.getParameter("goodsid"));
			//System.out.println(goodsid);
			String goodsname=request.getParameter("goodsname");
			double goodsprice=Double.parseDouble(request.getParameter("goodsprice"));
			String goodsinfo=request.getParameter("goodsinfo");
			int goodsnum=Integer.parseInt(request.getParameter("goodsnum"));
			int goodstypeid=Integer.parseInt(request.getParameter("goodstypename"));
			Goods goods=new Goods(goodsid, goodsname, goodsprice, goodsinfo, goodstypeid, goodsnum);
			GoodsDao dao=new GoodsImpl();
			dao.updataGoods(goods);
			int paramid=Integer.parseInt(request.getParameter("paramid"));
			String cpu=request.getParameter("cpu");
			String ram=request.getParameter("ram");
			String rom=request.getParameter("rom");
			String size=request.getParameter("size");
			String battery=request.getParameter("battery");
			String os=request.getParameter("os");
			Param param=new Param(paramid, cpu, ram, rom, size, battery, os, goodsid, goodsname);
			ParamDao dao1=new ParamImpl();
			dao1.updateParam(param);
			//System.out.println(params);
			result = redirect+"GoodsServlet?method=listGoods&currPage=1";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	public String exit(HttpServletRequest request,HttpServletResponse response){
		String result = "";
		try {
			HttpSession session = request.getSession();
			session.removeAttribute("session_user");
			session.invalidate();
			result = redirect+"GoodsServlet?method=list";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
