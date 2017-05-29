<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'goods_add03.jsp' starting page</title>
    
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
     <h3>当前位置&gt;添加商品类别</h3>
        <form action="GoodsTypeServlet?method=addType" method="post">
    	<table>
  
    		<tr>
    			<td>商品类别名称：</td>
    			<td><input type="text" required="required" name = "goodstypename"></td>
    		</tr>
    		<tr>
    			<td>商品类别类型：</td>
    			<td><input type="text" required="required" name = "supertype"></td>
    		</tr>
    		<tr>
    			<td>商品类别品牌：</td>
    			<td><input type="text" required="required" name = "brand"></td>
    		</tr>
    		<tr>
    			<td>操作：</td>
    			<td>
    				<input type="submit" value="提交" onclick="alert('添加成功')">
    				<input type="reset" value="重置">
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
