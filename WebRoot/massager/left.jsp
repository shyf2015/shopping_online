<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
<head>
 <base href="<%=basePath%>">
<title>left.jsp</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
<style type="text/css">
a:LINK {
	font-size: 20px;
	color:black;
	text-decoration: none;
}

a:HOVER {
	text-decoration: underline;
}

ul li {
	height:50px; 
	list-style-image: url("images/image.png");
				}		
			a:VISITED {
				color: red;
				background: yellow;
			}
</style>
</head>

<body>
	<ul>
		<li><a href="massager/goods_add.jsp" target="right" style="color: black;font-size: 20px;font-family: '楷体'">添加商品</a>
		</li>
		<li><a href="massager/goods_list.jsp" target="right" style="color: black;font-size: 20px;font-family: '楷体'">查询商品</a>
		</li>
		<li><a href="OrderServlet?method=listOrder&currPage=1" target="right" style="color: black;font-size: 20px;font-family: '楷体'">订单详情</a>
		</li>
		<li><a href="PingJiaServlet?method=listPingJia&currPage=1" target="right" style="color: black;font-size: 20px;font-family: '楷体'">顾客评价详情</a>
		</li>
		<li><a href="UserServlet?method=listUser&currPage=1" target="right" style="color: black;font-size: 20px;font-family: '楷体'">user用户管理</a>
		
		</li>
	</ul>
	
</body>
</html>
