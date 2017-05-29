package com.hello.servlet;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello.dao.CarDao;
import com.hello.dao.PayDao;
import com.hello.dao.impl.CarImpl;
import com.hello.dao.impl.PayImpl;

public class PayServlet extends BaseServlet {
	private CarDao ci = new CarImpl();
	//确认订单以后向数据库里添加订单
	public String list(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PayDao pay = new PayImpl();
		String addressid = request.getParameter("addressid");
		String sumprice = request.getParameter("sumprice");
		String[] addr = addressid.split(",");
		for (String string : addr) {
		}
		String[] listcar = request.getParameterValues("listcar");
		String[] carids = request.getParameterValues("carids");
		//形成订单之后删除购物车
		if(carids != null){
			for (String string : carids) {
				ci.delete(Integer.parseInt(string));
			}
		}
		String[] goods_order = null;
		ArrayList<Integer> ordernums = new ArrayList<Integer>();
		for (String lis : listcar) {
			goods_order = lis.split(",");
			int ordernum = pay.addOrderByuserid(goods_order,addr);
			ordernums.add(ordernum);
		}
		request.setAttribute("sum",sumprice );
		request.setAttribute("ordernums",ordernums);
		return  redirect+"/page/pay.jsp";		
		
	}



}
