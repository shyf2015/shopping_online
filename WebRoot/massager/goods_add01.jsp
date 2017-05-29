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
  		<h3>当前位置&gt;添加商品</h3>
        <form action="GoodsServlet?method=add" method="post">
    	<table>
    		<tr>
    			<td>商品名称：</td>
    			<td><input type="text" required="required" name = "goodsname"></td>
    		</tr>
    		<tr>
    			<td>商品价格：</td>
    			<td><input type="number" min="1" required="required"  name = "goodsprice"></td>
    		</tr>
    		<tr>
    			<td>商品描述：</td>
    			<td><textarea required="required" rows="5" cols="15" name="goodsinfo"></textarea></td>
    		</tr>
    		<tr>
    			<td>库存：</td>
    			<td><input type="number"  min="1" required="required" name = "goodsnum"></td>
    		</tr>
    		
    		<tr>
    			<td>品牌类型：</td>
    			<td>
    			<select name="goodstypename">
    				<option value="0">---请选择品牌---</option>
    				<c:forEach items="${goodsType}" var="t">
    					<option  value="${t.goodstypeid}">${t.goodstypename}</option>
    				</c:forEach>
    			</select>
    			</td>
    		</tr>
    	
    		<tr>
    			<td>处理器：</td>
    			<td><input type="text" required="required" name = "cpu"></td>
    		</tr>
    		<tr>
    			<td>运行内存：</td>
    			<td><input type="text" required="required" name = "ram"></td>
    		</tr>
    	
    		<tr>
    			<td>存储内存：</td>
    			<td><input type="text" required="required" name = "rom"></td>
    		</tr>
    	
    		<tr>
    			<td>商品尺寸：</td>
    			<td><input type="text" required="required" name = "size"></td>
    		</tr>
    	
    		<tr>
    			<td>电池容量：</td>
    			<td><input type="text" required="required" name = "battery"></td>
    		</tr>
    	
    		<tr>
    			<td>操作系统：</td>
    			<td><input type="text" required="required" name = "os"></td>
    		</tr>
    	
    		<tr>
    			<td>操作：</td>
    			<td>
    				<input type="submit" value="下一步">
    				<input type="reset" value="重置">
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
