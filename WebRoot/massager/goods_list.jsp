<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.hello.beans.Goods"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'goods_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style type="text/css">
	ul li {
		height: 50px;
		list-style-image: url("images/image.png");
	}
	
	.text{
		font-size: 20px;
	}
	
</style>
  </head>
  
  <body>
    <h3>当前位置&gt;查询选项</h3>
	<ul>
		<li class="text"><a href="GoodsServlet?method=listGoods&currPage=1" target="_self">商品列表</a>
		</li>
		<!-- <li class="text"><a href="ParamServlet?method=listParam&currpage=1" target="_self">商品详情列表</a>
		</li> -->
		<li class="text"><a href="PictureServlet?method=listPicture&currpage=1" target="_self">图片列表</a>
		</li>
		<li class="text"><a href="GoodsTypeServlet?method=listGoodsType&currpage=1" target="_self">类别列表</a>
		</li>
		
	</ul>
  	
  </body>
</html>
