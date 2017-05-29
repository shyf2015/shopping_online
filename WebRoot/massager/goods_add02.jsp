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
    
    <title>My JSP 'goods_add01.jsp' starting page</title>
    
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
    <h3>当前位置&gt;添加商品图片跟颜色</h3>
        <form action="PictureServlet?method=addPicture" method="post" enctype="multipart/form-data">
    	
    	<table>
    		<%-- <tr>
    			<td>品牌类型：</td>
    			<td>
    			<select name="goodsname">
    				<option value="0">---请选择商品---</option>
    				<c:forEach items="${lists}" var="l">
    					<option  value="${l.goodsId}">${l.goodsName}</option>
    				</c:forEach>
    			</select>
    			</td>
    		</tr> --%>
    		<tr>
    			<td>商品名称：</td>
    			<td>${goods2.goodsName }</td>
    			<%-- <input type="hidden" name="goodsname" value="${goods2.goo }"/> --%>
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
    				<input type="submit" value="提交" >
    				<input type="reset" value="重置">
    				
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
