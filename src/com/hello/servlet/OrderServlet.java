package com.hello.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello.beans.Address;
import com.hello.beans.Car;
import com.hello.beans.CarOrder;
import com.hello.beans.Goods;
import com.hello.beans.Pager;
import com.hello.beans.Param;
import com.hello.beans.User;
import com.hello.dao.OrderDao;
import com.hello.dao.impl.GoodsImpl;
import com.hello.dao.impl.OrderImpl;
import com.hello.dao.impl.ParamImpl;

public class OrderServlet extends BaseServlet {
	private GoodsImpl gi = new GoodsImpl();
	private OrderDao pi = new OrderImpl();
	private ParamImpl pai = new ParamImpl();

	public String listall(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String result = "";
		User user = (User) request.getSession().getAttribute("session_user");
		Integer ids = user.getUserid();
		if(ids!=null){
			request.setAttribute("userid", ids);
			String state = request.getParameter("state");
			if(state == null){
				state="0";
			}
			try {
				OrderDao orderlist = new OrderImpl();	
				String currPage = request.getParameter("currPage");
				if(currPage==null){
					currPage = "1";
				}
				if(Integer.parseInt(state)==0){
					Pager myorders = orderlist.getPager(Integer.parseInt(currPage), 6, ids);
					request.setAttribute("myorders", myorders);
					request.setAttribute("state", state);
				}else{
					Pager myorders = orderlist.getPagerByState(Integer.parseInt(currPage), 6, ids,Integer.parseInt(state));
					
					request.setAttribute("myorders", myorders);
					request.setAttribute("state", state);
				}
				result = redirect + "/page/myorders.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}	

	public String listcar(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		
		OrderDao order = new OrderImpl();
		
		
		User user = (User) request.getSession().getAttribute("session_user");
		int ids = user.getUserid();
		List<Address> address = order.listAddressById(ids);		
		request.setAttribute("address", address);		
		double sum = 0;		
		CarOrder carOrder = null;
		List<CarOrder> listcar = new ArrayList<CarOrder>();
		String[] arr =request.getParameterValues("cartCheckBox");
		//去除重复购物车id
		
		String goodsid = request.getParameter("goodsid");
		
		String goodsnum = request.getParameter("goodsnum");
		
		String pictureimg = request.getParameter("imgurl");
		
		
		if(goodsid!=null){
		
			Goods goods = gi.query(Integer.parseInt(goodsid));
			
			Param param = pai.query(goods.getGoodsId());	
			
			String color = pi.getcolorByimgurl(pictureimg);	
		
			
			double sumprice = Integer.parseInt(goodsnum)*goods.getGoodsPrice();
			carOrder = new CarOrder(Integer.parseInt(goodsnum), goods.getGoodsPrice(), sumprice, Integer.parseInt(goodsid), pictureimg, color, goods.getGoodsName(), goods.getGoodsInfo(), param.getCpu(), param.getRam(), param.getRom(), param.getSize(), param.getBattery(),ids);
			pi.updateGoodsnum(Integer.parseInt(goodsid),Integer.parseInt(goodsnum));
			listcar.add(carOrder);
			request.setAttribute("sum", sumprice);
			request.setAttribute("listcar", listcar);
			
		}
		ArrayList<String> carids = new ArrayList<String>();
		if (arr!=null) {
			 List<String> list = new ArrayList<String>();  
			    for(int i = 0; i < arr.length; i++) {  
			        if(!list.contains(arr[i])) {  
			            list.add(arr[i]);  
			        }  
			    }  
			String[] arr2 = (String[])list.toArray(new String[list.size()]);
			
			for (String id : arr2) {
				carids.add(id);
				Car	car_num = pi.carquery(Integer.parseInt(id));   //拿到购物车信息
				Goods	goods_order = pi.querygoodsBycarid(Integer.parseInt(id));  //拿到商品信息
				
				//
				int goodid=goods_order.getGoodsId();//这个可以拿到goodid,打算之后用来更改库存的数量
				Param param = pi.queryBygoodsid(car_num.getGoods_id());
				String	car_color = pi.getcolorByimgurl(car_num.getImgurl());		//拿到商品颜色			
				sum += goods_order.getGoodsPrice()*car_num.getGoods_num();		//某种类型商品总价		
				carOrder = new CarOrder(car_num.getGoods_num(), goods_order.getGoodsPrice(), car_num.getCarid(), ids, sum, goods_order.getGoodsId(), car_num.getImgurl(), car_color, goods_order.getGoodsName(), goods_order.getGoodsInfo(),param.getCpu(),param.getRam(),param.getRom(),param.getSize(),param.getBattery());		
				
				int num=car_num.getGoods_num();//
				pi.updateGoodsnum(goodid,num);
				
				listcar.add(carOrder);		
				}
				request.setAttribute("carids", carids);
				request.setAttribute("listcar", listcar);
				request.setAttribute("sum", sum);
				
		}
		return  redirect+"/page/order.jsp";		
	}
	
	/*public String gomyorder(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return redirect + "/page/myorders.jsp";
		
	}*/
	public String updata(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result="";
		try {
			String[] ordernums = request.getParameterValues("ordernum");
			for (String string : ordernums){
				pi.updata(Integer.parseInt(string), 2);
			}
			result= "OrderServlet?method=listall";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}	
	public String listOrder(HttpServletRequest request, HttpServletResponse response){
		String result="";
		try {
			request.setCharacterEncoding("utf-8");
			OrderDao dao=new OrderImpl();
			int currPage=Integer.parseInt(request.getParameter("currPage"));
			Pager pager=dao.getPager(currPage, 10);
			request.setAttribute("pager", pager);
			result = redirect+"/massager/order_list.jsp";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	public String updateOrderstate(HttpServletRequest request, HttpServletResponse response){
		String result="";
		try {
			request.setCharacterEncoding("utf-8");
			OrderDao dao=new OrderImpl();
			int ordernum=Integer.parseInt(request.getParameter("ordernum"));
			dao.updateOrderstate(ordernum);
			result = redirect+"OrderServlet?method=listOrder&currPage=1";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
	public String deleteOrder(HttpServletRequest request, HttpServletResponse response){
		String result="";
		try {
			request.setCharacterEncoding("utf-8");
			OrderDao dao=new OrderImpl();
			int ordernum=Integer.parseInt(request.getParameter("ordernum"));
			dao.deleteOrder(ordernum);
			
			result = redirect+"OrderServlet?method=listOrder&currPage=1";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}	
	
	public String shanchuOrder(HttpServletRequest request, HttpServletResponse response){
		User user = (User) request.getSession().getAttribute("session_user");
		Integer ids = user.getUserid();
		String result="";
		try {
			request.setCharacterEncoding("utf-8");
			OrderDao dao=new OrderImpl();
			int ordernum=Integer.parseInt(request.getParameter("ordernum"));
			dao.deleteOrder(ordernum);
			
			OrderDao orderlist = new OrderImpl();	
			String currPage = request.getParameter("currPage");
			if(currPage==null){
				currPage = "1";
			}			
			Pager myorders = orderlist.getPager(Integer.parseInt(currPage), 6, ids);
			request.setAttribute("myorders", myorders);
			result = redirect + "/page/myorders.jsp";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}	
	
}
