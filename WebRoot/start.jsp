<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'start.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
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
	</style>
  </head>
  
  <body>
    <div id="start">
    	<p class="start"><img src="img/gray.jpg"/></p>
    	<p class="start"><img src="img/gray.jpg"/></p>
    	<p class="start"><img src="img/gray.jpg"/></p>
    	<p class="start"><img src="img/gray.jpg"/></p>
    	<p class="start"><img src="img/gray.jpg"/></p>
    	<p class="grade"></p>
    </div>
  </body>
  <script type="text/javascript" src="js/jquery-1.8.2.js"></script>  
  <script>
  	(function(){
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
  			flag = 1;
  			grade = $(this).index()+1;
  			alert("你给的评分为"+grade+"分");
  		});
  	})();
  	
  	
  </script>
</html>
