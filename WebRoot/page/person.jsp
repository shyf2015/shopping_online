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
    
    <title>My JSP 'person.jsp' starting page</title>
    
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
	<style type="text/css">
		#address_div{
			border:1px solid #eee; 
			width:250px;
			height:160px;
		}	
		#add_address{
			border:1px solid #eee; 
			width:250px;
			height:160px;
		}
		#address div{
			float:left;
			margin-left:8px;	
			margin-top:8px;
		}
		#contain{
			margin-left:100px;
			margin-right:100px;
		}
		#address_div a{
			color:orange;
			float:right;
			font-size:8pt;
			
		}
		#inner_div{
			width:230px;
			height:150px;
			margin:5px;
		}
		#inner_div a{
			margin-left:5px;
		}
		#inner_div p{
			display:inline-block;
		}
		#addressid{
			display:none;
		}
		#plus{
			position:absolute;
			/* margin-left:200px; */
			left:210px;
			top:180px;
			width:50px;
			height:50px;
			border-radius:50%;
			background:#eee;
		}
	</style>
  </head>
  	
  <body>
  <div id="contain">
  	<ul id="myTab" class="nav nav-tabs">
  <li><a  data-toggle="tab" style="font-size:15pt" id="return_main">首页</a></li>
	<li class="active">
		<a href="#user" data-toggle="tab" style="font-size:15pt">
			 个人信息
		</a>
	</li>
	<li><a href="#address" data-toggle="tab" style="font-size:15pt">收货地址</a></li>
	<li><a  data-toggle="tab" style="font-size:15pt;cursor:pointer;" onclick="window.location.reload();">刷新地址</a></li>
	
</ul>

<br><br><br><br>

<div id="myTabContent" class="tab-content" >
	<div class="tab-pane fade in active" id="user">
		<form class="col-sm-8 role="form">
		  <div class="form-group">
		    <label for="" class="col-sm-2 control-label">用户名</label>
		    <div class="col-sm-8">
		      <input type="text" id="disabledInput" class="form-control"  value="${session_user.username}" disabled>
		    </div>
		  </div>
		  <br><br><br>
		  <div class="form-group">
		    <label for="lastname" class="col-sm-2 control-label">真实姓名</label>
		    <div class="col-sm-8">
		      <input type="text" class="form-control" id="disabledInput" value="${realname}" disabled>
		    </div>
		  </div>
		</form>	
	</div>
	<div class="tab-pane fade" id="address">
		<div id="all_address">
			
			<div id="add_address">
				<div id="plus">
					<p style="font-size:25pt;margin-left:15px;color:white;" >+</p>
				</div>
				<p style="font-size:5pt;margin-left:95px;margin-top:97px">添加新地址</p>
				
			</div>
			<c:forEach items="${address}" var="a">
				<div id="address_div" onmouseover="mouseover(this)" onmouseout="mouseout(this)">
					<div id="inner_div">
						<p style="font-size:15pt;font-weight:bold" class="conname">${a.conname}</p><br>
						<p class="conphone">${a.conphone}</p><br>
						<p class="province">${a.province}-</p><p class="city">${a.city}-</p><p class="country">${a.country}</p><br>
						<p class="address">${a.address}</p>
						<span hidden id="addressid" class="addressid">${a.addressid}</span>
						<span hidden id="user_id" class="user_id">${session_user.userid}</span>
						<br>
						<a class="update" href="page/updateAddress.jsp?addressid=${a.addressid}
						&conname=${a.conname}&conphone=${a.conphone}&province=${a.province}
						&city=${a.city}&country=${a.country}&address=${a.address}">修改</a>
						
						<a class="delete">删除</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	
</div>
</div>




	<script type="text/javascript">
	function mouseover(obj){
		obj.style.border="1px solid orange";
		obj.style.cursor="pointer";
	}
	function mouseout(obj){
		obj.style.border="1px solid #eee";
	}
	$(function(){
		/* $(".address_div").click(function(){
			$(this).css({"border":"1px solid orange"});
			$(".address_div").css("background","red");
		}); */
		$("#add_address").mouseover(function(){
			$(this).css({"border":"1px solid orange"});
			$("#plus").css("background","orange");
			$(this).css({"cursor":"pointer"});
		});
		$("#add_address").mouseout(function(){
			$(this).css({"border":"1px solid #eee"});
			$("#plus").css("background","#eee");
		});
		$("#add_address").click(function(){
			window.location.href="page/address.jsp";
		});
		
		
		
		$(".delete").click(function(){
			/* $(this).parent().find(".name").html(); */
			
			$.ajax({
				url:"DeleteAddressServlet",
				type:"post",
				data:{addressid:$(this).parent().find(".addressid").html()},
				success:function(data){
					location=location;
				}
			});
			
		});
		$(".update").click(function(){
			/* $.ajax({
				url:"DeleteAddressServlet",
				type:"post",
				data:{addressid:$(this).parent().find(".addressid").html()},
				success:function(data){
					location=location;
				}
			}); */
			
			
		});
		
		
		$("#return_main").click(function(){
			location.href="GoodsServlet?method=list";	
		});
		$("#return_main").mouseover(function(){
			$(this).css("cursor","pointer");
		});
		
	});
	</script>
  </body>
</html>
