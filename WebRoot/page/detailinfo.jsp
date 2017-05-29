<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'detailinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style>
		img{
			width:100%;
		}
		.yuantu{
			position:relative;
			width:400px;
			height:400px;
		}
		.yuantu img{
			width:100%;
			height:100%;
		}
		.yuantu .fangdajin{
			position:absolute;
			z-index:999;
			width:200px;
			height:200px;
			background-image: linear-gradient(45deg,#666 20%,rgba(0, 0, 255, 0.2) 20%,rgba(255, 255, 255, 0) 100%);
  			background-size: 4px 4px;
		}
		.yuantu .fangda{
			position:absolute;
			z-index:9;
			width:300px;
			height:300px;
			left:100%;
			top:0;
			overflow:hidden;
		}
		.yuantu .fangda img{
			position:absolute;
			width:200%;
			height:200%;
		}
		
		
	</style>
  </head>
  <div class="container" class="col-sm-12">
  	<h3>当前位置 &gt <a href="GoodsServlet?method=list">首页</a> &gt 商品详情 </h3>
  </div>
 <div style="margin-top:10px" class="container">
		<div class="col-sm-1"></div>
		<div class="col-sm-5">
			<div class="col-sm-12 yuantu">
				<div class="fangdajin"></div>
				<img id="goodsimg" style="height:350px;" src="${goods.goodsImgurl }" />
				<div class="fangda">
    				<img src="${goods.goodsImgurl }"/>
    			</div>
			</div>
			<div style="margin-top:5px;position:relative;" class="col-sm-12">
				<c:forEach items="${picture.imgurls }" var="imgurl">
					<div class="col-sm-3"><img class="selectimg" style="height:60px" src="${imgurl }"/></div>
				</c:forEach>
			</div>
		</div>
		<div class="col-sm-5" style="z-index:1;">
		<form id="form" action="OrderServlet">
			<table class="table col-sm-12" >
				<tr><td>产品名称</td><td>${goods.goodsName }</td></tr>
				<tr><td>商品简单描述</td><td>${goods.goodsInfo }</td></tr>
				<tr><td>产品价格</td><td>${goods.goodsPrice }</td></tr>
				<tr><td>请选择颜色</td><td>
					<c:forEach items="${picture.colors }" var="color" varStatus="num">
						<label style="cursor:pointer;"><input class="color" type="radio" name="imgurl" value="${picture.imgurls[num.count-1] }"/>${color }</label>
					</c:forEach>
				<input type="hidden" name="method" value="listcar">
					<input type="hidden" id="uid" name="uid" value="${session_user.userid}">
					
					<input class="goodsid" type="hidden" name="goodsid" value="${goods.goodsId }">
			
				</td></tr>
				<tr><td>CPU</td><td>${_param.cpu}</td></tr>
				<tr><td>运行内存</td><td>${_param.ram}</td></tr>
				<tr><td>内存</td><td>${_param.rom}</td></tr>
				<tr><td>电池</td><td>${_param.battery}</td></tr>
				<tr><td>尺寸</td><td>${_param.size}</td></tr>
				<tr><td>操作系统</td><td>${_param.os}</td></tr>
				
				<tr><td colspan="2">
				<span id="jie" style="cursor:pointer;" class="glyphicon glyphicon-minus" style="font-size:50px;"></span>
				<input class="goodsnum" name="goodsnum" type="number" min="1" max="${goods.goodsNum }" value="1" style="width:80px"/>
				<span id="zeng" style="cursor:pointer;" class="glyphicon glyphicon-plus"></span> 库存（<span class="kucun">${goods.goodsNum }</span>）</td></tr>
			</table>
			<c:if test="${empty session_user }">
				<a href="GoodsServlet?method=query&goodsid=${goods.goodsId }&flag=nologin" onclick="return confirm('需要先登录,要登录吗？');"><input class="btn" type="button" value="立即购买"></a>
			</c:if>
			<c:if test="${not empty session_user }">
				<c:if test="${goods.goodsNum==0 }">
					<a onclick="alert('没有库存了');"><input class="btn disabled" title="没有库存了" type="button" value="立即购买"></a>
				</c:if>
				<c:if test="${goods.goodsNum>0 }">
					<a id="buy"><input class="btn btn-info" type="submit" value="立即购买"></a>
				</c:if>
			</c:if>
			<c:if test="${empty session_user }">
				<a href="GoodsServlet?method=query&goodsid=${goods.goodsId }&flag=nologin" onclick="return confirm('需要先登录,要登录吗？');"><input type="button" class="btn" value="加入购物车 "></a>
			</c:if>
			<c:if test="${not empty session_user }">
				<c:if test="${goods.goodsNum==0 }">
					<a onclick="alert('没有库存了');"><input type="button" class="btn disabled" title="没有库存了" value="加入购物车 "></a>
				</c:if>
				<c:if test="${goods.goodsNum>0 }">
					<a id="addcar"><input type="button" class="btn btn-info" value="加入购物车 "></a>
				</c:if>
			</c:if>
			</form>
		</div>
		
		<div class="col-sm-1">
			<div style="margin-top:50px;" class="pull-right">
				<c:if test="${empty session_user }">
					<a onclick="return confirm('需要先登录,要登录吗?');" href="CarServlet?method=list"><img style="width:50px;height:50px;border-radius:50%;" src="img/Gou.jpg"/></a>
				</c:if>
				<c:if test="${not empty session_user }">
	 				<a href="CarServlet?method=list"><img style="width:50px;height:50px;border-radius:50%;" src="img/Gou.jpg"/></a>
				</c:if>
  			</div>
		</div>
		
		
</div>
<script src="js/jquery-1.8.2.js"></script>
<script src="js/detailinfo.js">
	
</script>
<script type="text/javascript">
	
</script>
</body>
</html>
