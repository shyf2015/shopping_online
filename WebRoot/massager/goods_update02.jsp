<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'goods_update02.jsp' starting page</title>
    
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
    <h3>当前位置&gt;修改商品详情</h3>
        <form action="ParamServlet?method=updateParam" method="post">
    	<input type="hidden" name = "paramid" value=${params.paramid }>
    	<input type="hidden" name = "goodsid" value=${params.goods_id }>
    	<table>
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
    				<input type="submit" value="完成">
    				<input type="reset" value="重置">
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
