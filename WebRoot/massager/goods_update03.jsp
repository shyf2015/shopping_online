<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'goods_update03.jsp' starting page</title>
    
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
    <h3>当前位置&gt;修改商品颜色和图片</h3>
    <form action="PictureServlet?method=updatePicture" method="post" enctype="multipart/form-data">
    	<input type="hidden" name="pictureid" value="${picture.pictureid}"/>
    	<table>
    		<tr>
    			<td>商品名称：</td>
    			<td>${picture.goodsname }</td>
    			<input type="hidden" name="goodsname" value="${picture.goods_id}"/>
    		</tr>
    		<tr>
    			<td>商品颜色：</td>
    			<td><input type="text" required="required" name = "color"></td>
    		</tr>
    		<tr>
    			<td>上传图片：</td>
    			<td><input type="file" required="required" name="file"/></td>
    		</tr>
    		<tr>
    			<td>操作：</td>
    			<td>
    				<input type="submit" value="修改">
    				<input type="reset" value="重置">
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
