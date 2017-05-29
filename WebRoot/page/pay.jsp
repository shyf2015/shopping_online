<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>支付页面</title>
	<link href="css/myCart.css" type="text/css" rel="stylesheet" />
	<script src="js/jquery-1.8.2.js"></script>
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  </head>
  <body>
<div id="header"><img src="img/logo.gif" alt="logo" /></div><br>
<div id="nav" style="font-family: '楷体';font-size: 20px">您的位置：<a href="GoodsServlet?method=list" style="color:red;">首页</a>&gt;确认支付</div><br>
<div id="navlist">
  <ul >
    <li class="navlist_gray">1. 查看购物车</li> 
    <li class="navlist_gray_arrow"></li> 
     <li class="navlist_gray">2. 确认订单信息</li> 
    <li class="navlist_red_right"></li>   
    <li class="navlist_red">3. 付款到支付宝</li> 
    <li class="navlist_red_arrow"></li> 
     <li class="navlist_gray">4. 我的订单</li> 
    <li class="navlist_gray_arrow"></li> 
    <li class="navlist_gray">5. 评价</li> 
    <li class="navlist_gray_right"></li>   
  </ul>
  </br>
</div>
<br>


<script type="text/javascript" src="js/myCart.js"></script>
<style>
		.content p{margin-bottom:10px;}
</style>
<style type="text/css">
	body{
	margin: 0px;
	}
		.fie{	
		margin-left:150px;		
		border-style:solid;
		width: 75%;
		height: 150px;
		border-color: red;
		overflow:auto;
		}
	
			a:LINK {
				font-size:25px;
				font-family: '楷体';
				
				text-decoration: none;
			}
			/* a 鼠标悬停的时候 */
			a:HOVER {
				color: orange;
				text-decoration: underline;
			}
			a:VISITED {
				
				background: yellow;
			}
	</style>
	<body>
	

  <div style="width:600px;margin:100px auto;border:3px solid #66e;padding:40px;margin-top:10px; padding-top:5px; padding-left:100px;  font-family: '楷体';font-size: 26px;" class="content">
	<p><span style="color:green" class="glyphicon glyphicon-ok"></span>恭喜您！订单已生成 <br/></p>
	
	<c:if test="${param.sum != null}">
		<p id="sum1">应付总金额:${param.sum}元</p>
	</c:if>
	<c:if test="${sum != null}">
		<p id="sum2">应付总金额:${sum}元</p>
	</c:if>
	
	<p style="margin-bottom:20px;">付款后卖家开始发货</p>
	<form action="OrderServlet">
		<input type="hidden" name="method" value="updata">
	<%-- <input type="hidden" name="ordernum" value="${order.ordernum }"/> --%>
	<c:forEach items="${param.ordernums}" var="ordernum">
		<input type="hidden" name="ordernum" value="${ordernum}"/>
	</c:forEach>
	<c:forEach items="${ordernums}" var="ordernum">
		<input type="hidden" name="ordernum" value="${ordernum}"/>
	</c:forEach>
	<a><input type="submit" value="确认付款" class="btn" style="font-family: '楷体';font-size: 23px;"/></a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="OrderServlet?method=listall"><input type="button" value="稍后付款" class="btn" style="font-family: '楷体';font-size: 23px;"/></a>
	</form>
</div>

 
  	</form>
  	<script type="text/javascript" src="js/myCart2.js"></script>  	 	
</body>
  
</html>
 