package com.hello.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter implements Filter{
	private FilterConfig config;
	public void init(FilterConfig filterconfig) throws ServletException {
		// TODO Auto-generated method stub
		this.config = filterconfig;
		
	}

	public void doFilter(ServletRequest servletrequest,
			ServletResponse servletresponse, FilterChain filterchain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)servletrequest;
		HttpServletResponse response = (HttpServletResponse)servletresponse;
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		String query = request.getQueryString();
		//System.out.println(session.getAttribute("gourl"));
		
		if(session.getAttribute("session_user")==null && !path.contains("UserAjaxServlet02")&& !path.contains("AjaxServlet")){
			if(query!=null){
				session.setAttribute("gourl", path+"?"+query);
				if(query.contains("flag=nologin")){
					request.getRequestDispatcher("/page/login.jsp").forward(servletrequest, servletresponse);
				}
			}else{
				session.setAttribute("gourl", path);
			}
		}
		
		if(path.contains("page/login.jsp")||(path+"?"+query).contains("UserServlet")||path.contains("page/zhuce.jsp")){
			session.setAttribute("gourl", "GoodsServlet?method=list");
		}
		System.out.println(session.getAttribute("gourl"));
		
	/*	String param = request.getQueryString();
		
		String contextpath = request.getContextPath();
		System.out.println(path);
		System.out.println(param);
//		System.out.println(contextpath);
		 if(path != null) {  
			 path =contextpath+path + "?" + param; //重新拼好请求地址+参数  
			 System.out.println(path);
         } 
		 request.getSession().setAttribute("path", path);*/
		 
		 
		if(path.contains("GoodsServlet")){
			filterchain.doFilter(servletrequest, servletresponse);
		}else
		if(session.getAttribute("session_admin")!= null){
			filterchain.doFilter(servletrequest, servletresponse);
		}else
		if(path.contains("massager")){
			//request.getRequestDispatcher("/admin/adminlogin.jsp").forward(servletrequest, servletresponse);
			response.sendRedirect("/Science_Museum/admin/adminlogin.jsp");
		}else
		if(session.getAttribute("session_user")!=null){
			filterchain.doFilter(servletrequest, servletresponse);
		}else
		if(path.contains("js")||path.contains("img")||path.contains("css")||path.contains("images")||path.contains("admin")||path.contains("uploadimg")){
			filterchain.doFilter(servletrequest, servletresponse);
		}else
		if(path.contains("VerCode.jsp")||path.contains("admin")||path.contains("zhuce.jsp")||path.contains("login.jsp")||path.contains("AdminLoginServlet")||path.contains("UserAjaxServlet02")||path.contains("AjaxServlet")||path.contains("UserServlet")||path.contains("SerachServlet")){
			filterchain.doFilter(servletrequest, servletresponse);
		}else{
			
			request.getRequestDispatcher("/page/login.jsp").forward(servletrequest, servletresponse);
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
