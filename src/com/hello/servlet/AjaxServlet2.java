package com.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello.dao.impl.CarImpl;

public class AjaxServlet2 extends HttpServlet {
	private CarImpl ci = new CarImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			try {
				PrintWriter out = response.getWriter();
				request.setCharacterEncoding("utf-8");
				String carid = request.getParameter("carid");
				String goodsnum = request.getParameter("goodsnum");
				int num = Integer.parseInt(goodsnum);
				int kucun=ci.getKucun(Integer.parseInt(carid));
				if(num>kucun){
					int i=1;
					out.print(i);
					out.close();
				}else{
					ci.updata(Integer.parseInt(carid), num);
					out.print(num);
					out.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
