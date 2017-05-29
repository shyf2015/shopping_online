package com.hello.servlet;


import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hello.beans.Address;
import com.hello.dao.OrderDao;
import com.hello.dao.impl.AddressImpl;
import com.hello.dao.impl.OrderImpl;
import com.hello.util.FormtoObject;
	
public class AddressServlet extends BaseServlet {
	FormtoObject f = new FormtoObject();
	AddressImpl addImpl = new AddressImpl();
	public String add(HttpServletRequest request,HttpServletResponse response) {
		Address address;
		try {
			address = (Address) f.form2Object(request, Address.class);
			addImpl.add(address);
			return redirect + "page/return.jsp";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public String update(HttpServletRequest request,HttpServletResponse response) {
		Address address;
		try {
			address = (Address) f.form2Object(request, Address.class);
			addImpl.update_address(address, address.getAddressid());
//			return redirect + "page/return.jsp";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}	
