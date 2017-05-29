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
    
    <title>My JSP 'user_list.jsp' starting page</title>
    
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
    <h3>当前位置&gt;顾客列表</h3>
    <table border="1px" style="border-collapse: collapse;">
    	<tr>
    		<th>用户编号</th>
    		<th>用户名</th>
    		<th>登录密码(已加密)</th>
    		<th>真实姓名</th>
    		<th>操作</th>
    	</tr>
    		
    		<c:forEach items="${pager.alluser}" var="pu" varStatus="p">
    		<input type="hidden" name="userid" value="${pu.userid}">
    		<tr>
    			<td>${p.count+(pager.currPage-1)*pager.pageSize}</td>
    			<td>${pu.username}</td>
    			<td>${pu.password}</td>
    			<td>${pu.realname}</td>
    			
    			<%-- <td><input type="hidden" name="goodstype_id" value="${ps.goodStype_id} "></td> --%>
    			<td><a href="UserServlet?method=deleteUser&userid=${pu.userid}" onclick="return confirm('您确定要删除该用户吗？')">删除</a></td>
    		</tr>
    		</c:forEach>
    </table>
    <c:if test="${pager.currPage==1}">
    	首页   上一页
    </c:if>
    <c:if test="${pager.currPage>1}">
    	<a href="UserServlet?method=listUser&currPage=1">首页</a> 
    	&nbsp;   
    	<a href="UserServlet?method=listUser&currPage=${pager.currPage-1}">上一页</a>
    </c:if>
    
   <c:if test="${pager.currPage==pager.pageCount}">
    	下一页    尾页
    </c:if>
    <c:if test="${pager.currPage<pager.pageCount}">
    	<a href="UserServlet?method=listUser&currPage=${pager.currPage+1}">下一页</a>
    	&nbsp;    
    	<a href="UserServlet?method=listUser&currPage=${pager.pageCount}">尾页</a>
    </c:if>
    	当前是: 第${pager.currPage}页,共${pager.pageCount}页,共${pager.dataCount}条数据

  </body>
</html>
