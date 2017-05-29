package com.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hello.beans.Admin;
import com.hello.dao.UserDao;
import com.hello.dao.impl.UserImpl;

public class AdminLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println(321);
   doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	System.out.println(321);
		HttpSession session = request.getSession();
		UserDao user = new UserImpl();
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String yanzhengma = request.getParameter("vercode");
	//	System.out.println(yanzhengma+"~~~~~~~~~");
		String code = (String)session.getAttribute("code");
		//System.out.println(code+"5555555555555555555");
		Admin admin = new Admin(name,password);
	//	System.out.println(admin);
		boolean b = user.selectadmin(admin);
	//	System.out.println(b);
		if(b==true){
			//System.out.println(123);
			if(code.equalsIgnoreCase(yanzhengma)){
				session.setAttribute("session_admin", "admin");
				session.setAttribute("username", name);		
				PrintWriter out = response.getWriter();
				out.print("yes");
				out.flush();
				out.close();
			}
			else
			{				
				PrintWriter out = response.getWriter();
				out.print("yanerr");
				out.flush();
				out.close();
			}
		}else{
		//	System.out.println(123);
			PrintWriter out = response.getWriter();
			out.print("usererr");
			out.flush();
			out.close();
					
		}
	
	}

}
