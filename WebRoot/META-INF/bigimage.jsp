<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bigimage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		.yuantu{
			position:relative;
			width:200px;
			height:200px;
		}
		.yuantu img{
			width:100%;
			height:100%;
		}
		.fangdaing{
			position:absolute;
			
			border:1px solid red;
		}
		.fangda{
			position:absolute;
			width:250px;
			height:250x;
			left:100%;
			top:0;
			border:1px solid red;
		}
		.fangda img{
			width:200%;
			height:200%;
		}
		
	</style>
  </head>
  
  <body>
    <div class="yuantu">
    	<div class="fangdajin"></div>
    	<img src="img/Ciphone1gold.jpg"/>
    	<div class="fangda"></div>
    </div>
  </body>
</html>
