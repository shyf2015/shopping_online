<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'goods_add.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
	<h3>当前位置&gt;添加选项</h3>
	<ul>
		<li class="text"><a href="GoodsTypeServlet?method=Typelist" target="_self">添加商品</a>
		</li>
		<!-- <li class="text"><a href="GoodsServlet?method=listGoodsIdAndGoodsName" target="_self">添加商品图片</a>
		</li> -->
		<li class="text"><a href="massager/goods_add03.jsp" target="_self">添加商品类别</a>
		</li>
		
	</ul>
</body>
</html>
