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
    
    <title>My JSP 'goods_list02.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.text{
			color:red;
		}
	</style>
  </head>
  
  <body>
     <h3>当前位置&gt;商品详情列表</h3>
     <h5 class="text">注：商品详情无法修改或删除，如需操作请在商品列表中进行</h5>
    <table border="1px" style="border-collapse: collapse;">
    	<tr>
    		<td>商品编号</td>
    		<td>商品名称</td>
    		<td>处理器</td>
    		<td>运行内存</td>
    		<td>存储内存</td>
    		<td>商品尺寸</td>
    		<td>电池容量</td>
    		<td>操作系统</td>
    		
    	</tr>
    		
    		<c:forEach items="${pager.allparam}" var="ps" varStatus="p">
    		<input type="hidden" name="goodstypeid" value="${ps.goods_id}">
    		<tr>
    			<td>${p.count+(pager.currPage-1)*pager.pageSize}</td>
    			<td>${ps.goodsname}</td>
    			<td>${ps.cpu}</td>
    			<td>${ps.ram}</td>
    			<td>${ps.rom}</td>
    			<td>${ps.size}</td>
    			<td>${ps.battery}</td>
    			<td>${ps.os}</td>
    			
    			<%-- <td><input type="hidden" name="goodstype_id" value="${ps.goodStype_id} "></td> --%>
    			<%-- <td><a href="ParamServlet?method=updateParam&paramid=${ps.paramid}">修改</a></td> --%>
    		</tr>
    		</c:forEach>
    </table>
    
    <c:if test="${pager.currPage==1}">
    	首页   上一页
    </c:if>
    <c:if test="${pager.currPage>1}">
    	<a href="ParamServlet?method=listParam&currpage=1">首页</a> 
    	&nbsp;   
    	<a href="ParamServlet?method=listParam&currpage=${pager.currPage-1}">上一页</a>
    </c:if>
    
    <c:if test="${pager.currPage==pager.pageCount}">
    	下一页    尾页
    </c:if>
    <c:if test="${pager.currPage<pager.pageCount}">
    	<a href="ParamServlet?method=listParam&currpage=${pager.currPage+1}">下一页</a>
    	&nbsp;    
    	<a href="ParamServlet?method=listParam&currpage=${pager.pageCount}">尾页</a>
    </c:if>
    当前是: 第${pager.currPage}页,共${pager.pageCount}页,共${pager.dataCount}条数据
  </body>
</html>
