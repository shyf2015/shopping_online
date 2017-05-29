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
    <!-- <meta http-equiv="refresh" content="5"> -->
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>我的订单</title>
	<link href="css/myCart.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<script src="js/jquery-1.8.2.js"></script>
  </head>
  <body>
<div id="header"><img src="img/logo.gif" alt="logo" /></div><br>
<div id="nav" style="font-family: '楷体';font-size: 20px">您的位置：<a href="GoodsServlet?method=list" style="color:red;font-size:27px;">首页</a> &gt;我的订单</div><br>
<div id="navlist">
  <ul>
    <li class="navlist_gray">1. 查看购物车</li> 
    <li class="navlist_gray_arrow"></li> 
    <li class="navlist_gray">2. 确认订单信息</li> 
    <li class="navlist_gray_arrow"></li> 
     <li class="navlist_gray">3. 付款到支付宝</li> 
    <li class="navlist_red_left"></li>   
     <li class="navlist_red">4. 我的订单</li> 
    <li class="navlist_red_arrow"></li> 
    <li class="navlist_gray">5. 评价</li> 
    <li class="navlist_gray_right"></li>   
  </ul>
  </br>
  </br>
  <ul id="state">
    <li class="state"><a href="OrderServlet?method=listall&state=0">所有订单</a></li> 
    <li class="state"><a href="OrderServlet?method=listall&state=1">待付款</a></li> 
    <li class="state"><a href="OrderServlet?method=listall&state=2">待发货</a></li> 
    <li class="state"><a href="OrderServlet?method=listall&state=3">待评价</a></li>
    <li class="state"><a href="OrderServlet?method=listall&state=4">已完成</a></li> 
  </ul>
</div>
<br>


<script type="text/javascript" src="js/myCart.js"></script>
<style>
		table tr td{
			vertical-align: middle !important;
		}
	</style>
<style type="text/css">
	
	body{
	margin: 0px;
	}
	#state{
		float:left;
		width: 97%;
		height:30px;
		margin: 10px auto 20px;
		font-size:20px;
		line-height:30px;
		background:#E4E4E4;
		font-family:"楷体";
	}
	#state a{
		text-decoration: none;
	}
	#state .state{
		width:20%;
		height:30px;
		text-align:center;
		cursor:pointer;
	}
	#state .state:hover{
		background:white;
	}
		.fie{	
		margin-left:50px;		
		border-style:solid;
		width:90%;		
		overflow:auto;
		}

			
			th td{
			
			}
			#select .option{
				float:left;
				margin:50px;
				
			}
			
	</style>
	
	<body id="body">
	
  <form action="OrderServlet">
  	<fieldset class="fie" style="font-size: 20px; font-family: '楷体';">		
    	<table style="text-align:center;font-size: 20px;" class="biaoge table table-bordered table-hover" >
    		<tr><th width="8%">序号</th><th width="9%">订单编号</th><th width="12%">下单时间</th><th width="10%">商品</th><th width="12%">商品名称</th><th width="6%">数量</th><th width="8%">收件人</th><th width="11%">联系电话</th><th width="12%">收货地址</th><th width="14%">订单状态</th></tr>
    		<c:forEach items="${myorders.orders }" var="order" varStatus="s">
    			<tr>
	    			<td>${s.count }<div style="display:none">${order.sumprice}</div></td>
	    			<td>${order.ordernum }</td>
	    			<td>${order.ordertime }</td>
	    			<td>
	    				<img width="50px" height="50px" src="${order.orderimgurl }"/>	
	    				<div style="display:none">${order.orderimgurl }</div>
	    			</td>
	    			<td>${order.goods_name }<br/></td>
	    			<td>${order.goods_number }<br/></td>
	    			<td>${order.conname }<br/></td>
	    			<td>${order.conphone }</td>
	    			
	    			<td width="80px">${order.address }</td>
	    			<td>
	    			<c:if test="${order.orderstate==1 }">
	    				<a href="page/pay.jsp?sum=${order.sumprice}&ordernums=${order.ordernum}" style="font-size:20px; color:red;">待付款</a>
	    				<%-- <a href="OrderServlet?method=shanchuOrder&ordernum=${order.ordernum }"  onclick="alert('删除成功!')" style="font-size: 20px;">删除订单</a><!--  --> --%>
	    			</c:if>
	    			<c:if test="${order.orderstate==2 }">
	    				<p style="color:blue">待发货</p>
	    			</c:if>
	    			<c:if test="${order.orderstate==3 }">
	    				<a href="page/pingjia.jsp?imgurl=${order.orderimgurl}&name=${order.goods_name}&userid=${userid}&ordernum=${order.ordernum }"  style="font-size:20px; color: green;">待评价</a>
	    			</c:if>
	    			<c:if test="${order.orderstate==4 }">
	    				已完成
	    			</c:if>
	    			</td>
	    	
    			</tr>
    		</c:forEach>
    		<div id="user" style="display:none">${session_user.userid }</div>
    	</table>  		
  	</fieldset> 	
</form>

<div style="text-align:center;width:100%;" id="abianqian">
				<c:if test="${myorders.currPage==1 and myorders.currPage<myorders.pageCount}">
					<a><button disabled="disabled">首页</button></a>
					<a><button disabled="disabled">上一页</button></a>
					<a href="OrderServlet?method=listall&currPage=${myorders.currPage+1 }&state=${state }"><button>下一页</button></a>
					<a href="OrderServlet?method=listall&currPage=${ myorders.pageCount }&state=${state }"><button>尾页</button></a>
					<p style="font-family: '楷体';font-size: 18px;">当前是第${myorders.currPage}页，共${myorders.pageCount}页</p>
				</c:if>
				<c:if test="${myorders.currPage>1 and myorders.currPage<myorders.pageCount}">
					<a href="OrderServlet?method=listall&currPage=1&state=${state }"><button>首页</button></a>
					<a href="OrderServlet?method=listall&currPage=${myorders.currPage-1 }&state=${state }"><button>上一页</button></a>
					<a href="OrderServlet?method=listall&currPage=${myorders.currPage+1 }&state=${state }"><button>下一页</button></a>
					<a href="OrderServlet?method=listall&currPage=${ myorders.pageCount }&state=${state }"><button>尾页</button></a>
										<p style="font-family: '楷体';font-size: 18px;">当前是第${myorders.currPage}页，共${myorders.pageCount}页</p>
				</c:if>
				<c:if test="${myorders.currPage>1 and myorders.currPage==myorders.pageCount }">
					<a href="OrderServlet?method=listall&currPage=1&state=${state }"><button>首页</button></a>
					<a href="OrderServlet?method=listall&currPage=${myorders.currPage-1 }&state=${state }"><button>上一页</button></a>
					<a><button disabled="disabled">下一页</button></a>
					<a><button disabled="disabled">尾页</button></a>
					<p style="font-family: '楷体';font-size: 18px;">当前是第${myorders.currPage}页，共${myorders.pageCount}页</p>
				</c:if>
				<c:if test="${myorders.currPage==1 and myorders.currPage==myorders.pageCount }">
					<button>上一页</button>
					<button>下一页</button>
					<p style="font-family: '楷体';font-size: 18px;">当前是第${myorders.currPage}页，共${myorders.pageCount}页</p>
				</c:if>
			</div>

  	<script type="text/javascript" src="js/myCart2.js"></script>  
  	<script>
  	function refresh(){
  		//console.log(1);
  		var len = $(".biaoge tr").length;
  		for(var i=1;i<len;i++){
  			var orderid = $(".biaoge tr").eq(i).find("td").eq(1).html();
  			var goodsprice = $(".biaoge tr").eq(i).find("td").eq(0).find("div").html();
  			var userid = $("#user").html();
  			var imgurl = $(".biaoge tr").eq(i).find("td").eq(3).find("div").html();
  			var goodsname = $(".biaoge tr").eq(i).find("td").eq(4).html();
  			var $obj = $(".biaoge tr").eq(i).find("td").eq(9);
  			$.ajax({
  				url:"RefreshServlet",
  				type:"get",
  				async:false,
  				data:{orderid:orderid},
  				success:function(e){
  					if(e=="1"){
  						$obj.html("<a href='page/pay.jsp?sum="+goodsprice+"&ordernums="+orderid+"' style='font-size:20px; color:red;'>待付款</a>");
  					}
  					if(e=="2"){
  						$obj.html("<p style='color:blue;'>待发货</p>");
  					}
  					if(e=="3"){
  						$obj.html("<a href='page/pingjia.jsp?imgurl="+imgurl+"&name="+goodsname+"&userid="+userid+"&ordernum="+orderid+"'  style='font-size:20px; color: green;'>待评价</a>");
  					}
  					if(e=="4"){
  						$obj.html("已完成");
  					}
  				}
  			});
  		}
  	}
  	setInterval(refresh,5000);
  		
  	</script>	 	
</body>
  
</html>
 