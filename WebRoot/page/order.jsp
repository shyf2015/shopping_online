<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>确认订单</title>
	<link href="css/myCart.css" type="text/css" rel="stylesheet" />
	<script src="js/jquery-1.8.2.js"></script>
  </head>
  <body>
<div id="header"><img src="img/logo.gif" alt="logo" /></div><br>
<div id="nav" style="font-family: '楷体';font-size: 20px">您的位置：<a href="GoodsServlet?method=list">首页</a> &gt;确认订单</div><br>
<div id="navlist">
  <ul>
    <li class="navlist_gray">1. 查看购物车</li> 
    <li class="navlist_red_left"></li> 
    <li class="navlist_red">2. 确认订单信息</li> 
    <li class="navlist_red_arrow"></li> 
     <li class="navlist_gray">3. 付款到支付宝</li> 
    <li class="navlist_gray_arrow"></li>   
     <li class="navlist_gray">4. 我的订单</li> 
    <li class="navlist_gray_arrow"></li> 
    <li class="navlist_gray">5. 评价</li> 
    <li class="navlist_gray_right"></li>   
  </ul>
  </br>
</div>
<br>


<script type="text/javascript" src="js/myCart.js"></script>
<style type="text/css">
	body{
	margin: 0px;
	}
		.fie{	
		margin-left:160px;		
		border-style:solid;
		width: 75%;
		height: 150px;
		border-color: red;		
		}
		.divde{
		width: 100%;
		height: 130px;
		overflow:auto;
		}
		.text{
		font-family: '楷体';
		font-size: 15px;
		}
		p{
		margin-right:  5px;
		}
		.divdemo{
		margin-left:160px;		
		border-style:solid;
		border-width:2px;
		width: 77%;
		margin-top:30px;
		border-color: red;
		}
		.tableDemo{
		    text-align:left;
			font-size: 20px;
			font-family: '楷体';
			
		}
		.inputDemo{
			border-width: 20px;
			border-style:outset;
			
			border-color: red;
			margin-left: 70px;
			
		}
			a:LINK {
				font-size:25px;
				font-family: '楷体';
				color:red;
				text-decoration: none;
			}
			/* a 鼠标悬停的时候 */
			a:HOVER {
				color: orange;
				text-decoration: underline;
				
			}
			
			a:VISITED {
				color: red;
				background: yellow;
			}
	</style>
	
	<body>
	
  <form action="PayServlet">
  	<a name="top" id="top"></a>
  	
  	<fieldset class="fie" style="font-size: 20px; font-family: '楷体';">
  		<legend class="leg" style="font-family: '楷体';font-size: 25px;padding-top: 6px;">请选择您的地址：</legend>
  		<div class="divde">
  		<c:forEach items="${address}" var="a" >
  			<input type="hidden" name="address" value="${a}">
  			<label style="cursor:pointer;"><input  id="addre" type="radio" name="addressid" value="${a}">${a.province}-${a.city}-${a.country}-${a.address}&nbsp;&nbsp;&nbsp;&nbsp;收件人姓名:${a.conname}&nbsp;&nbsp;&nbsp;&nbsp;收件人电话:${a.conphone}</label></br>
  		</c:forEach>
		<p id="reload" onclick="window.location.reload();" style="color:red; font-family:楷体;cursor:pointer" >刷新地址</p>
  		</div>
  	</fieldset><br>
  		<a href="page/address.jsp?uid" style="margin-left:80%;">添加新地址</a>
  
  <div class="divdemo">
    <table >
  			<c:forEach items="${listcar}" var="car" varStatus="vs">  
      		<input type="hidden" name="listcar" value="${car}">
      		<input type="hidden" name="method" value="list">
      		 <tr>
      			 <td><s:property value="#vs.index+1"/></td>             
            	 <td ><img width="280px" height="280px" src="${car.img}"/></td> 
             <td>
  			   	<table  class="tableDemo" id="order">
  			   		<tr ><td>产品名称：</td>
  			   		     <td><a href="GoodsServlet?method=query&goodsid=${car.goodsid}">${car.goodsname }</td>  			   		
  			   		</tr>
  			   		<tr><td>产品颜色：</td>
						<td>${car.color}</td>  			   		
  			   		</tr>
  			   		<tr><td>产品描述：</td>
						<td >${car.goodsinfo}</td>  			   		
  			   		</tr>
  			   		<tr><td>产品单价：</td>
						<td>${car.goodprice }</td>  			   		
  			   		</tr>
  			   		<tr><td>购买数量：</td>
						<td>${car.goodshopnum}</td>  			   		
  			   		</tr>	   		
  			   	</table>  			   
  			   </td>
  			   <td>
  			   		<table  class="tableDemo" id="order">
	  			   		<tr ><td>cpu：</td>
	  			   		     <td>${car.cpu }</td>  			   		
	  			   		</tr>
	  			   		<tr><td>ram：</td>
							<td>${car.ram}</td>  			   		
	  			   		</tr>
	  			   		<tr><td>rom：</td>
							<td >${car.rom}</td>  			   		
	  			   		</tr>
	  			   		<tr><td>尺寸：</td>
							<td>${car.size }</td>  			   		
	  			   		</tr>
	  			   		<tr><td>电池容量：</td>
							<td>${car.battery}</td>  			   		
	  			   		</tr>
  			   	</table>  			 
  			   </td>
            </tr>  
           
         </c:forEach>
	</table>
  		<br><br>
  		<div>
  			<table>
  				<tr>
		         <c:forEach items="${carids}" var="s">
		         	<input type="hidden" name="carids" value="${s}"/>
		         </c:forEach>
  				<p  style="font-family: '楷体';font-size: 30px;margin-left: 70%;" >总价：${sum }	元</p>
  				<input type="hidden" name="sumprice" value="${sum}">
  				<input class="inputDemo"  type="button" value="确认订单" style="font-family: '楷体';font-size: 23px;margin-left: 73%; cursor:pointer;"></a>
  				</tr>  				
  			</table>
  		  <br><br>
  		</div>
  	</div>
  	</form>
  	<script type="text/javascript" src="js/myCart2.js"></script>  
  	<script type="text/javascript" src="js/jquery-1.8.2.js"></script>  
  	<script>
  		$(".inputDemo").on("click",function(e){
  			if ( e && e.preventDefault ){
				e.preventDefault(); 
			}else{
				window.event.returnValue = false; 
			}
  			var len = $("input[name='addressid']").length;
  			var flag = 0;
  			for(var i=0;i<len;i++){
  				if($("input[name='addressid']").eq(i).prop("checked")){
  					flag++;
  					$("form").trigger("submit");
  					return;
  				}
  			}
  			if(flag==0){
  				alert("请选择一个地址");
  				return true;
  			}
  		});
  	</script>	 	
</body>
  
</html>
 