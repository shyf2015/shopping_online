package com.hello.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;




public class CreateConnection {
	
	public static Connection getConnection(){
		
		try {
//			CreateConnection.class.getResourceAsStream("/JDBC.properties"));
			Properties properties = new Properties();
//			InputStream filein = new InputStream(CreateConnection.class.getResourceAsStream("/JDBC.properties")));
			properties.load(CreateConnection.class.getResourceAsStream("/JDBC.properties"));
			
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String name = properties.getProperty("name");
			String mima = properties.getProperty("mima");
			
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url,name,mima);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection connection){
		try {
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

