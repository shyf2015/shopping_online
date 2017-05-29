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

<title>My JSP 'goods_list01.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="js/jquery-1.8.2.js"></script>
<style type="text/css">

.text {
	color: red;
}

.tb2 {
	/* position:absolute;
	left: 708px;
	top: 78px; */
	table-layout:fixed;
}
.tb1{
	table-layout:fixed;
}
td,th{
	word-break: break-all; 
	word-wrap:break-word;
	border-right: 1px;
	border-color: black;
}


 

</style>
</head>

<body>
	<h3>当前位置&gt;商品列表</h3>
	<h class="text" style="font-size: 25px;font-family: '楷体'">注：修改或删除商品是会联动修改或删除商品参数及对应的商品图片，请注意！</h>
	<table>
		<tr>
			<td>
				<table class="tb1" width="700px" border="1px" style="border-collapse: collapse; border-right:none">
		<tr>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th><p>商品描述</p>
			</th>
			<th>商品库存</th>
			<th>商品类型</th>
			
			<th>商品参数</th>
		</tr>

		<c:forEach items="${pager.allgoods}" var="ps" varStatus="p">
			<tr class="table1">
				<td>${p.count+(pager.currPage-1)*pager.pageSize}</td>
				<td>${ps.goodsName}</td>
				<td>${ps.goodsPrice}</td>
				<td><p>${ps.goodsInfo}</p>
				</td>
				<td>${ps.goodsNum}</td>
				<td>${ps.goodsTypeName}</td>
				
				<td>商品参数</td>
			</tr>
		</c:forEach>
	</table>
			</td>
			<td>
				<table class="tb2" width="1000px" border="1px" style="border-collapse: collapse;border-left:1px solid black;margin-left:-5px;">
		<tr >

			<th width="35%">处理器</th>
			<th>运行内存</th>
			<th width="120px">存储内存</th>
			<th width="120px">商品尺寸</th>
			<th width="120px">电池容量</th>
			<th width="120px">操作系统</th>
			<th>操作</th>


		</tr>

		<c:forEach items="${pager.allparam}" var="ps" varStatus="p">
			<tr class="table2">
				<td class="td1">${ps.cpu}</td>
				<td>${ps.ram}</td>
				<td>${ps.rom}</td>
				<td>${ps.size}</td>
				<td>${ps.battery}</td>
				<td>${ps.os}</td>
				<td><a
					href="GoodsServlet?method=updataGoods&goodsid=${ps.goods_id}&paramid=${ps.paramid }">修改</a><a
					href="GoodsServlet?method=deleteGoods&goodsid=${ps.goods_id}"
					onclick="return confirm('删除会将相应的商品详情删除，您确定要删除吗？')">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
			</td>
		</tr>
	</table>
	
	






	<c:if test="${pager.currPage==1}">
    	首页   上一页
    </c:if>
	<c:if test="${pager.currPage>1}">
		<a href="GoodsServlet?method=listGoods&currPage=1">首页</a> 
    	&nbsp;   
    	<a
			href="GoodsServlet?method=listGoods&currPage=${pager.currPage-1}">上一页</a>
	</c:if>

	<c:if test="${pager.currPage==pager.pageCount}">
    	下一页    尾页
    </c:if>
	<c:if test="${pager.currPage<pager.pageCount}">
		<a href="GoodsServlet?method=listGoods&currPage=${pager.currPage+1}">下一页</a>
    	&nbsp;    
    	<a href="GoodsServlet?method=listGoods&currPage=${pager.pageCount}">尾页</a>
	</c:if>
	当前是: 第${pager.currPage}页,共${pager.pageCount}页,共${pager.dataCount}条数据
<script>
	var len = $(".table1").length;
	for(var i=0;i<len;i++){
		$(".table2").eq(i).height($(".table1").eq(i).height());
	}
</script>
</body>
</html>
