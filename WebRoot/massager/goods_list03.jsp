<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'goods_list03.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	td{
		
		height: 50px;
		width: 150px;
		font-size: 20px;
		font-family:'楷体';
		text-align:center; 
	}
</style>
</head>

<body>
	 <h3>当前位置&gt;商品图片颜色列表</h3>
	<table border="1px" style="border-collapse: collapse;">
		<tr>
			<th>商品名称</th>
			<th>商品颜色</th>
			<th>商品图片</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${pager.allpicture }" var="pa">
		<input type="hidden" name="pictureid" value="${pa.pictureid}">
		<tr>
			<td>${pa.goodsname }</td>
			<td>${pa.color }</td>
			<td><img width="100px" height="110px" src="${pa.imgurl }" /></td>
			<td><a href="PictureServlet?method=updatePicture01&pictureid=${pa.pictureid}">修改</a><a href="PictureServlet?method=deletePicture&pictureid=${pa.pictureid}" onclick="return confirm('您确定要删除吗？')">删除</a></td>
		</tr>
		</c:forEach>
	</table>

	<c:if test="${pager.currPage==1}">
    	首页   上一页
    </c:if>
    <c:if test="${pager.currPage>1}">
    	<a href="PictureServlet?method=listPicture&currpage=1">首页</a> 
    	&nbsp;   
    	<a href="PictureServlet?method=listPicture&currpage=${pager.currPage-1}">上一页</a>
    </c:if>
    
    <c:if test="${pager.currPage==pager.pageCount}">
    	下一页    尾页
    </c:if>
    <c:if test="${pager.currPage<pager.pageCount}">
    	<a href="PictureServlet?method=listPicture&currpage=${pager.currPage+1}">下一页</a>
    	&nbsp;    
    	<a href="PictureServlet?method=listPicture&currpage=${pager.pageCount}">尾页</a>
    </c:if>
   	 当前是: 第${pager.currPage}页,共${pager.pageCount}页,共${pager.dataCount}条数据
</body>
</html>
