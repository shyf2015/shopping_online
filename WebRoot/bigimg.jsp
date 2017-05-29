<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bigimg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
		.yuantu{
			position:relative;
			width:200px;
			height:200px;
		}
		.yuantu img{
			width:100%;
			height:100%;
		}
		.yuantu .fangdajin{
			position:absolute;
			width:100px;
			height:100px;
			border:1px solid red;
			background-image: linear-gradient(45deg,#666 20%,rgba(0, 0, 255, 0.2) 20%,rgba(255, 255, 255, 0) 100%);
  			background-size: 4px 4px;
		}
		.yuantu .fangda{
			position:absolute;
			background-image:url("../img/bg.png");
			width:250px;
			height:250px;
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
  
  <body>
    <div class="yuantu">
    	<div class="fangdajin"></div>
    	<img src="https://img03.sogoucdn.com/net/a/04/link?url=http%3A%2F%2Fimg01.sogoucdn.com%2Fapp%2Fa%2F100520024%2Fae63bb09e0d415c3a157f7f70195f869&appid=122"/>
    	<div class="fangda">
    		<img src=""/>
    	</div>
    </div>
    <script src="js/jquery-1.8.2.js"></script>
    <script>
    	$(".fangdajin").hide();
    	$(".fangda").hide();
    	$(".yuantu").on("mouseover",function(){
    		$(".fangdajin").show();
    		$(".fangda").show();
    		$(".fangda img").attr("src",$(this).find("img").attr("src"));
    	});
    	$(".yuantu").on("mouseout",function(){
    		$(".fangdajin").hide();
    		$(".fangda").hide();
    	});
    	$(".yuantu").on("mousemove",function(e){
    		var left = $('.yuantu').offset().left;
			var top = $('.yuantu').offset().top;
    		var x = e.clientX-left;
			var y = e.clientY-top;
			console.log(x,y);
			if(x<50){x=50;}
			if(x>150){x=150;}
			if(y>150){y=150;}
			if(y<50){y=50;}
			$(".yuantu .fangdajin").css({"left":x-50+"px","top":y-50+"px"});
			$(".yuantu .fangda img").css({"left":(50-x)*2+"px","top":(50-y)*2+"px"})
    	});
    </script>
  </body>
</html>
