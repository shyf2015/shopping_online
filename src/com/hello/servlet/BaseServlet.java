package com.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	protected final static String redirect="redirect:";
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			String method = request.getParameter("method");
			Method methodName = this.getClass().getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			
			String result = (String)methodName.invoke(this, request,response);
			if(result.startsWith(redirect)){
				request.getRequestDispatcher(result.substring(redirect.length())).forward(request, response);
			}
			else{
				response.sendRedirect(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
