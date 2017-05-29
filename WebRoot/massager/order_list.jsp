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
    
    <title>My JSP 'order_list.jsp' starting page</title>
    
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
     <h3>当前位置&gt;订单详情列表</h3>
    <table border="1px" style="border-collapse: collapse;">
    	<tr>
    		<th>订单编号</th>
    		<th>下单时间</th>
    		<th>购买物品</th>
    		<th>物品图片</th>
    		<th>商品单价</th>
    		<th>购买数量</th>
    		<th>商品总价</th>
    		<th>购买用户姓名</th>
    		<th>收货地址</th>
    		<th>收货人姓名</th>
    		<th>收货人电话</th>
    		<th>订单状态</th>
    		<th>操作</th>
    	</tr>
    		
    		<c:forEach items="${pager.allorder}" var="po" varStatus="p">
    		
    		<tr>
    			<td>${p.count+(pager.currPage-1)*pager.pageSize}</td>
    			<td>${po.ordertime }</td>
    			<td>${po.goods_name }</td>
    			<td><img width="50px" height="80px" src="${po.orderimgurl }" /></td>
    			<td>${po.goods_price }</td>
    			<td>${po.goods_number }</td>
    			<td>${po.sumprice }</td>
    			<td>${po.username }</td>
    			<td>${po.address }</td>
    			<td>${po.conname }</td>
    			<td>${po.conphone }</td>
    			<c:if test="${po.orderstate==1 }">
    				<td>待付款</td>
    				<td>等待付款</td>
    			</c:if>
    			<c:if test="${po.orderstate==2 }">
    				<td>待发货</td>
    				<td><a href="OrderServlet?method=updateOrderstate&ordernum=${po.ordernum }">发货</a></td>
    			</c:if>
    			<c:if test="${po.orderstate==3 }">
    				<td>货物已收到</td>
    				<td>等待用户评价</td>
    				
    			</c:if>
    		
    			<c:if test="${po.orderstate==4 }">
    				<td>已完成</td>
    				<td><a href="OrderServlet?method=deleteOrder&ordernum=${po.ordernum }"onclick="return confirm('您确定要删除该订单吗？')">删除</a></td>
    			</c:if>
    			
    			
    			
    			<%-- <td><input type="hidden" name="goodstype_id" value="${ps.goodStype_id} "></td> --%>
    			<%-- <td><a href="">发货</a><a href="UserServlet?method=deleteUser&userid=${pu.userid}" onclick="return confirm('您确定要删除该用户吗？')">删除</a></td> --%>
    		</tr>
    		</c:forEach>
    </table>
    <c:if test="${pager.currPage==1}">
    	首页   上一页
    </c:if>
    <c:if test="${pager.currPage>1}">
    	<a href="OrderServlet?method=listOrder&currPage=1">首页</a> 
    	&nbsp;   
    	<a href="OrderServlet?method=listOrder&currPage=${pager.currPage-1}">上一页</a>
    </c:if>
    
   <c:if test="${pager.currPage==pager.pageCount}">
    	下一页    尾页
    </c:if>
    <c:if test="${pager.currPage<pager.pageCount}">
    	<a href="OrderServlet?method=listOrder&currPage=${pager.currPage+1}">下一页</a>
    	&nbsp;    
    	
    	<a href="OrderServlet?method=listOrder&currPage=${pager.pageCount}">尾页</a>
    </c:if>
    	当前是: 第${pager.currPage}页,共${pager.pageCount}页,共${pager.dataCount}条数据

  </body>
  </body>
</html>
