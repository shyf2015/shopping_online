package com.hello.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

public class FormtoObject {
	public Object form2Object(HttpServletRequest request,Class c) throws UnsupportedEncodingException{
		Object obj = null;
		request.setCharacterEncoding("utf-8");
		try {
			obj = c.newInstance();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		};

		Field[] fields = c.getDeclaredFields();
		for(Field field : fields){
			//System.out.println("field"+field);
			String fieldName = field.getName();
			String value = request.getParameter(fieldName);
			//System.out.println(fieldName+"===="+value);

			if(value!=null&&value!=""){

				String methodName = "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
				//System.out.println("方法名字"+methodName);

				try {
					Method method = c.getMethod(methodName,field.getType());
					//System.out.println(field.getType());
					String fieldType = field.getType().getSimpleName();
					//System.out.println(fieldType);

					if(fieldType.equals("String")){
						method.invoke(obj, value);
					}else if(fieldType.equals("int")){
						method.invoke(obj, Integer.parseInt(value));
					}else if(fieldType.equals("double")){
						method.invoke(obj, Double.parseDouble(value));
					}else if(fieldType.equals("Date")){
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						method.invoke(obj, format.parse(value));
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
		return obj;
	}
}
