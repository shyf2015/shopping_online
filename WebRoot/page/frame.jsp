<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'frame.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <fieldset class="fie" style="font-size: 20px; font-family: '楷体';">
	  		<legend class="leg" style="font-family: '楷体';font-size: 25px">请选择您的地址：</legend>
	  		<c:forEach items="${address}" var="a" >
	  			<input type="hidden" name="address" value="${a}">
	  			<input  id="${a.user_id}" type="radio" name="addressid" value="${a.addressid}">${a.province}-${a.city}-${a.country}-${a.address}&nbsp;&nbsp;&nbsp;&nbsp;收件人姓名:${a.conname}&nbsp;&nbsp;&nbsp;&nbsp;收件人电话:${a.conphone}</br>
	  		</c:forEach>
			<p id="reload" onclick="window.location.reload();" style="color:red; font-family:楷体;cursor:pointer" >刷新地址</p>
	  	</fieldset>
  </body>
</html>
