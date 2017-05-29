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
<div id="nav" style="font-family: '楷体';font-size: 20px">您的位置：<a href="GoodsServlet?method=list">首页</a> &gt;评价</div><br>
<div id="navlist">
  <ul>
	    <li class="navlist_gray">1. 查看购物车</li> 
	    <li class="navlist_gray_arrow"></li>
	    <li class="navlist_gray">2. 确认订单信息</li> 
	    <li class="navlist_gray_arrow"></li> 
	     <li class="navlist_gray">3. 付款</li> 
	    <li class="navlist_gray_arrow"></li>   
	     <li class="navlist_gray">4. 我的订单</li> 
	    <li class="navlist_gray_right"></li> 
	    <li class="navlist_red">5. 评价</li> 
	    <li class="navlist_red_right"></li>   
	  </ul>
  </br>
</div>
<br>
<style type="text/css">
	body{
	margin: 0px;
	}
		.text{
		font-family: '楷体';
		font-size: 15px;
		}

		.divdemo{
		margin-left:220px;		
		border-style:solid;
		border-width:2px;
		width: 65%;
		margin-top:30px;
		border-color:#E4E4E4;
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
			
			#start{
			width:200px;
			height:32px;
			
		}
		#start p{
			float:left;
			margin:0;
		}
		.start{
			width:30px;
			height:30px;
			
		}
		.grade{
			width:50px;
			font-size:22px;
			line-height:30px;
			text-align:center;
			
		}
		.start img{
			width:100%;
			height:100%;
			}
	table {
	font-family: '楷体';
	font-size: 25px;
	}
	textarea {
	resize:none;
	}
	
	.inputDemo{
			border-style:solid;
			border-color:#FF6600;
			margin-left: 70%;
			font-size: 25px;
			font-family: '楷体';
			width: 100px;
		}
	
	</style>
	
	<body>
	<br><br>
	
    <hr color="orange" width="65%" style="margin-left: 220px;">	
  <form id="form" action="EvaluateServlet">  
  <input type="hidden"  name="method" value="addEvaluate">
  <div class="divdemo">
    <table > 
    		<tr>
    		<th>店铺宝贝</th>
    		<th></th>
    		<th>评价</th>
    		</tr>
      		 <tr>     			          
            	 <td ><img width="180px" height="180px" src="${param.imgurl}"/></td> 
             <td>
  			   	<table  class="tableDemo" id="order">
  			   		<tr><td>订单编号：</td>
						<td>${param.ordernum}</td> 
						<input type="hidden" name="ordernum" value="${param.ordernum}"> 			   		
  			   		</tr>
  			   		<tr ><td>宝贝名称：</td>
  			   		     <td>${param.name}</td>  			   		
  			   		</tr>
  			   		<tr><td>您的评价：</td>
  			   		
						<td >
						<input type="hidden" id="star" name="star" value="5">
						<input type="hidden"  name="userid" value="${param.userid}">
						<input type="hidden" name="goodsname" value="${param.name}">
		
						<div id="start">
    					<p class="start"><img src="img/gray.jpg"/></p>
    					<p class="start"><img src="img/gray.jpg"/></p>
    					<p class="start"><img src="img/gray.jpg"/></p>
    					<p class="start"><img src="img/gray.jpg"/></p>
    					<p class="start"><img src="img/gray.jpg"/></p>
    					<p class="grade"></p>
   						 </div>						
						</td>  			   		
  			   		</tr>
  			     		
  			   	</table>  			   
  			   </td>
  			   <td>	 
  				 <textarea  name="evaluate"  class="pingjia" rows="7" cols="30" placeholder="请输入您的评价内容" style="font-family: '楷体';font-size:15pt;"></textarea>		 
  			   </td>           	                       
            </tr> 
        
  		</table>  		
  		</div>
  		<br>
			<input type="button" value="提交" class="inputDemo" style="cursor:pointer;">		
  	</form>
  	<script type="text/javascript" src="js/myCart2.js"></script>  
  	<script type="text/javascript" src="js/jquery-1.8.2.js"></script>  
  	
  	<script>
  	$(function(){
  		$(".start").css("cursor","pointer");
  		var flag = 0;
  		var grade = 0;
  		$(".start").on("mouseover",function(){
  			var index = $(this).index();
  			if(flag==0){
  				for(var i=0;i<=index;i++){
  					$(".start img").eq(i).attr("src","img/yellow.jpg");
  					$(".grade").html(index+1+"分");
  				}
  			}
  			$(this).attr("src","img/yellow.jpg");
  		});
  		$(".start").on("mouseout",function(){
  			if(flag==0){
  				for(var i=0;i<5;i++){
  					$(".start img").eq(i).attr("src","img/gray.jpg");
  					$(".grade").html("");
  				}
  			}
  		});
  		
  		$(".start").on("click",function(){
  			if(flag==1){return}
  			flag = 1;
  			grade = $(this).index()+1;
  			
  		});
  	
  		
  		$(".start").on("click",function(){
  			if(flag==1){return;}
  			flag = 1;
  			grade = $(this).index()+1;
  			$("#star").val(grade);
  		});
  		//评论时,用户没有写任何评价,设置默认值.
  		$(".inputDemo").click(function(){
  			if($(".pingjia").val() == null || $(".pingjia").val() == ""){
  				$(".pingjia").val("好评");
  				alert("您没有做出任何评价,默认好评!");
  			}
  			$("#form").submit();
  			alert("评价成功!");
  		});
  	});
  	
  	

  	
  	
  </script>
  		 	
</body>
  
</html>
 