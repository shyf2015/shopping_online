package com.hello.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hello.beans.Goods;
import com.hello.beans.Pager;
import com.hello.beans.Picture;
import com.hello.dao.GoodsDao;
import com.hello.dao.PictureDao;
import com.hello.dao.impl.GoodsImpl;
import com.hello.dao.impl.PictureImpl;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class PictureServlet extends BaseServlet{
	private ServletConfig config;
	private Request req2;
	private GoodsDao gi = new GoodsImpl();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		super.init(config);
	}
	public String addPicture(HttpServletRequest request,HttpServletResponse response){
		String result="";
		
		try {
			request.setCharacterEncoding("utf-8");
			SmartUpload su = new SmartUpload();
			su.initialize(config, request, response);
			su.setAllowedFilesList("jpg,png,gif,jpeg");
			su.upload();
			Request req = su.getRequest();
			Request req2 = req;
//			su.save("/uploadimg");
			File file = su.getFiles().getFile(0);
			String imgurl = "/uploadimg"+new Date().getTime()+su.getFiles().getFile(0).getFileName();
			file.saveAs(imgurl);
			PictureDao dao=new PictureImpl();
			String goodsName=req.getParameter("goodsname");
			request.setAttribute("goodsName",goodsName);
			String color=req.getParameter("color");
			Picture picture=new Picture(color, imgurl.substring(1));
			dao.addPicture(picture);
			int maxGoodsId=gi.maxGoodsId();
			Goods goods2=gi.query(maxGoodsId);
			request.setAttribute("goods2", goods2);
			
			result = redirect+"/massager/againadd.jsp";
		} catch (Exception e) {
			
		}
		return result;
		
	}
	public void error(){
		
	}
	
	public String addagain(HttpServletRequest request,HttpServletResponse response){
		String result="";
		
		try {
			request.setCharacterEncoding("utf-8");
			String goodsid = request.getParameter("goodsid");
			Goods goods2 = gi.query(Integer.parseInt(goodsid));
			//System.out.println(goods2);
			request.setAttribute("goods2", goods2);
			//result = redirect+"/massager/addgoodssuc.jsp";
			result = redirect+"/massager/goods_add02.jsp";
		} catch (Exception e) {
			
		}
		return result;
	}
	public String listPicture(HttpServletRequest request,HttpServletResponse response){
		String result="";
		try {
			request.setCharacterEncoding("utf-8");
			PictureDao dao=new PictureImpl();
			int currPage=Integer.parseInt(request.getParameter("currpage"));
			Pager pager=dao.getPager(currPage, 5);
			System.out.println(pager);
			request.setAttribute("pager", pager);
			result = redirect+"/massager/goods_list03.jsp";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	public String updatePicture01(HttpServletRequest request,HttpServletResponse response){
		String result="";
		int pictureid=Integer.parseInt(request.getParameter("pictureid"));
		PictureDao dao=new PictureImpl();
		Picture picture=dao.findPictureById(pictureid);
		request.setAttribute("picture", picture);
		result = redirect+"/massager/goods_update03.jsp";
		return result;
	}
	public String updatePicture(HttpServletRequest request,HttpServletResponse response){
		String result="";
		try {
			request.setCharacterEncoding("utf-8");
			SmartUpload su = new SmartUpload();
			su.initialize(config, request, response);
			su.setAllowedFilesList("jpg,png,gif,jpeg");
			su.upload();
			Request req = su.getRequest();
			Request req2 = req;
			//			su.save("/uploadimg");
			File file = su.getFiles().getFile(0);
			String imgurl = "/uploadimg"+new Date().getTime()+su.getFiles().getFile(0).getFileName();
			file.saveAs(imgurl);
			PictureDao dao=new PictureImpl();
			int pictureid=Integer.parseInt(req.getParameter("pictureid"));
			String color=req.getParameter("color");
			Picture picture=new Picture(color, imgurl.substring(1), pictureid);
			dao.updatePicture(picture);
			result = redirect+"PictureServlet?method=listPicture&currpage=1";
			/*int goods_id=Integer.parseInt(req.getParameter("goodsname"));
			String color=req.getParameter("color");

			Picture picture=new Picture(goods_id, color, imgurl.substring(1));
			dao.addPicture(picture);
			Goods goods = gi.query(goods_id);
			request.setAttribute("goods", goods);*/
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	public String deletePicture(HttpServletRequest request,HttpServletResponse response){
		String result="";
		try {
			request.setCharacterEncoding("utf-8");
			int pictureid=Integer.parseInt(request.getParameter("pictureid"));
			//System.out.println(pictureid);
			PictureDao dao= new PictureImpl();
			dao.deletePicture(pictureid);
			result = redirect+"PictureServlet?method=listPicture&currpage=1";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
