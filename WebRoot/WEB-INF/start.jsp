<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'start.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		p{
			display:inline-block;
			width:30px;
			height:30px;
		}
		img{
			width:100%;
			height:100%;
		}
	</style>
  </head>
  
  <body>
    <div>
    	<p><img src="img/gray.jpg"/></p>
    	<p><img src="img/gray.jpg"/></p>
    	<p><img src="img/gray.jpg"/></p>
    	<p><img src="img/gray.jpg"/></p>
    	<p><img src="img/gray.jpg"/></p>
    </div>
  </body>
</html>
