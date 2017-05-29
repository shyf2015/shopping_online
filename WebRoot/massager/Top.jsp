<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<style type="text/css">
	
	
	
	</style>
	
  </head>
  
  <body >
  
  <table>
  	<tr>
  	<td><img  style="height:100%" src="images/logo.png"/></td>
  	<td>
  	<h1 align="center" style="font-family: '楷体';font-size: 35px;">欢迎来到科技博物馆管理系统</h1>
  	<p >
    	
    	<a href="massager/right.jsp" target="right" style="margin-left: 80px">返回主页面</a>
    	<b style="padding-left: 770px;">欢迎${username}登录</b>
    	<a  target="_parent" href="LoginExitServlet" onclick="return confirm('您确定退出吗？')" >退出</a>
    	</p>
  	</td>
  	</tr>
  
  </table>
  
  
    
    	
  </body>
</html>
