<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
  <head>
    <title>left.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
		<style type="text/css">
		.demo1{
			text-align: center;
			font-family: '楷体';
			font-size: 32px;
		}
		
		
		</style>




  </head>
  
    
  
  <body >
  
  	<table style="margin-left: 60px;">
  		<tr>
  			<td class="demo1">欢迎来到科技博物馆后台管理界面</td>
  			<td><img src="../images/jiemian.jpg" height="400px;">
  			</td>
  		</tr>
  	
  	</table>
   	
   <!-- 	<div class="demo1">
   		欢迎来到科技博物馆后台管理界面！
   	
   	</div>
   	
    <img  src="../images/jiemian.jpg" style="text-align: right;"> -->
   
  </body>
</html>
