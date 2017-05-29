<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	
	<script type="text/javascript">
		$(function(){
			$("#id1").blur(function(){
				$(".name").animate(
					{bottom: '-3px'}, 500
				);
				
				if($('#id1').val() == ""){
					$("#msg1").text("请输入用户名");
				}
			});
			$("#id2").blur(function(){
				
				$(".pass").animate(
					{bottom:'-3px'},500
				);
				
				if($('#id2').val() == ""){
					$("#msg2").text("请输入密码");
				}
			});
			$("#id1").focus(function(){
				$("#msg1").text("");
				$(".name").animate(
					{bottom: '+10px'}, 500
				);
			});
			$("#id2").focus(function(){
				$("#msg2").text("");
				$(".pass").animate(
					{bottom:'+10px'},500
				);
			});
		
		
		
			$("#sub").click(function(){
				$.ajax({
					url:"UserAjaxServlet02",
					type:"post",
					data:{
					username:$("#id1").val(),
					password:$("#id2").val()
					},
					dataType:"json",
					success:function(msg){
						/* $("#msg2").text(msg.msg); */
						
						if(msg.msg != null){
							$("#msg2").text(msg.msg);
						}
						if(msg.msg3 != null){
							$("#msg2").text(msg.msg3);
						}
						
						if(msg.msg2 != null){
							if(msg.msg2 = "登录"){
								window.location.href="/Science_Museum/<%=session.getAttribute("gourl")%>";
								
								//window.location.href="/Science_Museum/
							 
								//window.location.href="CarServlet?method=list";
								/* window.location.href=$("#path").val(); */
								//window.location.href="GoodsServlet?method=list";
								//window.location.href="GoodsServlet?method=query&goodsid=2";
								//self.location=document.referrer;
								/* window.location.href="GoodsServlet?method=list&username="+$('#id1').val(); */
								/* window.history.go(-1); */
								
							}
						}
					},
				});
			});
			
			
			
		});
	</script>
	<style type="text/css">
		#all{
			margin:0 auto;
			background:white;
			border:1px solid black;
			height:260px;
			width:600px;
			
		}
		body{
				background:#eee;
			}
		span{
			color:red;
		}
	</style>
  </head>
  
  <body>
  <br><br><br><br><br>
  <div id="all">
  <br><br><br>
  		<form action="" class="col-sm-12">
  		<%-- <input type="text" name="path" id="path" value="${path}"> --%>
  			<div class="form-group">
  				<label class="col-sm-2 control-label name">用户名</label>
  				<div class="col-sm-10">
  					<input type="text" id="id1" name="username" class="form-control " placeholder="请输入用户名"><span id="msg1">
  				</div>
  			</div>
  			
  	 <br><br>	
  			<div class="form-group">
  				<label class="col-sm-2 control-label pass">密码</label>
  				<div class="col-sm-10">
  					<input type="password" id="id2" name="password" class="form-control" placeholder="请输入密码"><span id="msg2">
  				</div>
  			</div>
  			
  			
  	 <br><br>
  	
	  	 <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		    <a href="page/zhuce.jsp" class="form-control-static">点击注册</a><br><br>
		      <input type="button" value="登录" id="sub" class="btn btn-default">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		       <button type="reset" class="btn btn-default">重置</button>
			 </div>
  		</div>
  		
 </form>
 </div>
</body>
</html>
