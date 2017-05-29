package com.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello.beans.Address;
import com.hello.beans.User;
import com.hello.dao.impl.AddressImpl;

public class PersonServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("session_user");
		int userid = user.getUserid();
		String username = user.getUsername();
		String password = user.getPassword();
		String realname = user.getRealname();
		
		AddressImpl addressImpl = new AddressImpl();
		ArrayList<Address> list = addressImpl.query_address(userid);
		
		request.setAttribute("username", username);
//		request.setAttribute("password", password);
		request.setAttribute("realname", realname);
		request.setAttribute("address", list);
		request.getRequestDispatcher("page/person.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
		
	}

}
