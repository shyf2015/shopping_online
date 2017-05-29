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
    
    <title>My JSP 'pingjia_list.jsp' starting page</title>
    
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
			font-family: '楷体';
			font-size: 20px;
		}
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
     <h3>当前位置&gt;评价详情列表</h3>
     <h5 class="text">每一条顾客评价都是我们进步的动力，不要试着去修改删除！</h5>
    <table border="1px" style="border-collapse: collapse;" >
    	<tr>
    		<th>评价详情编号</th>
    		<th>评价的用户</th>
    		<th>评价的物品</th>
    		<th>评价内容</th>
    		<th>评价等级</th>
    		
    	</tr>
    		
    		<c:forEach items="${pager.allpj}" var="pp" varStatus="p">
    		<tr>
    			<td>${p.count+(pager.currPage-1)*pager.pageSize}</td>
    			<td>${pp.user_name }</td>
    			<td>${pp.goods_name }</td>
    			<td>${pp.evaluate }</td>
    			<td>${pp.dengji}星级</td>
    			
    			<%-- <td><input type="hidden" name="goodstype_id" value="${ps.goodStype_id} "></td> --%>
    			
    		</tr>
    		</c:forEach>
    </table>
    <c:if test="${pager.currPage==1}">
    	首页   上一页
    </c:if>
    <c:if test="${pager.currPage>1}">
    	<a href="PingJiaServlet?method=listPingJia&currPage=1">首页</a> 
    	&nbsp;   
    	<a href="PingJiaServlet?method=listPingJia&currPage=${pager.currPage-1}">上一页</a>
    </c:if>
    
   <c:if test="${pager.currPage==pager.pageCount}">
    	下一页    尾页
    </c:if>
    <c:if test="${pager.currPage<pager.pageCount}">
    	<a href="PingJiaServlet?method=listPingJia&currPage=${pager.currPage+1}">下一页</a>
    	&nbsp;    
    	<a href="PingJiaServlet?method=listPingJia&currPage=${pager.pageCount}">尾页</a>
    </c:if>
    	当前是: 第${pager.currPage}页,共${pager.pageCount}页,共${pager.dataCount}条数据
    
  </body>
</html>
