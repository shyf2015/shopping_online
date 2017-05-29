package com.hello.servlet;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello.beans.Car;
import com.hello.beans.Pager;
import com.hello.beans.User;
import com.hello.dao.CarDao;
import com.hello.dao.impl.CarImpl;
import com.hello.util.FormtoObject;

public class CarServlet extends BaseServlet {
	private FormtoObject f2o = new FormtoObject();
	private CarImpl ci = new CarImpl();
	public String  list(HttpServletRequest request,HttpServletResponse response){
		CarDao dao=new CarImpl();
		//需要在这里获取用户id
		String currPage = request.getParameter("currPage");
		String[] carids =request.getParameterValues("cartCheckBox");
		ArrayList<String> carArr = new ArrayList<String>();
		if(carids != null){
			request.setAttribute("carids",carids);
			for (String s : carids) {
				carArr.add(s);
			}
			request.setAttribute("cararr", carArr);
		}
		if(currPage==null){
			currPage = "1";
		}
		User user = (User) request.getSession().getAttribute("session_user");
		Integer uid = user.getUserid();
//		if(user.getUserid().)
		Pager pager = ci.getPager(Integer.parseInt(currPage), 4, uid);
		request.setAttribute("pager",pager);
		return redirect+"/page/car.jsp";	
		
	}
	public String delete(HttpServletRequest request,HttpServletResponse response){
		if(request.getParameter("carids")==null){
			String carid=request.getParameter("carid");
			CarDao dao=new CarImpl();
			dao.delete(Integer.parseInt(carid));
		}else{
			String carids=request.getParameter("carids");
			CarDao dao=new CarImpl();
			String[] carid=carids.split(",");
			for(int i=0;i<carid.length;i++){
				dao.delete(Integer.parseInt(carid[i]));
			}
		}
		
		return "CarServlet?method=list";
	}
	public String add(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("utf-8");
			Car car = (Car)f2o.form2Object(request, Car.class);
			ci.add(car);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return redirect;
	}
	public String updata(HttpServletRequest request,HttpServletResponse response){
		try {
			PrintWriter out = response.getWriter();
			request.setCharacterEncoding("utf-8");
			String carid = request.getParameter("carid");
			String goodsnum = request.getParameter("goodsnum");
			ci.updata(Integer.parseInt(carid), Integer.parseInt(goodsnum));
			int num = Integer.parseInt(goodsnum)+1;
			out.print(num);
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return redirect;
	}
}
