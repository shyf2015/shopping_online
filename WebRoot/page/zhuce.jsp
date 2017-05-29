<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'zhuce.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
	<script type="text/javascript">
		$(function(){
			var a = "";
			var b = "";
			var c = "";
		
			$("#id1").blur(function(){
					$(".user").animate(
						{bottom: '-3px'}, 500
					);
				if($('#id1').val()==""){
					$("#msg1").text("请输入用户名");
					$("#msg1").css({"color":"red"});
					
				}else{
					$.ajax({
						url:"AjaxServlet",
						type:"post",
						data:{username:$("#id1").val()
						},
						dataType:"json",
						success:function(msg){
								$("#msg1").text(msg.msg);
							if("合法" == msg.msg){
								$("#msg1").css({"color":"green"});
							}
							else{
								$("#msg1").css({"color":"red"});
							}
							a = msg.msg;
						}, 
					});
				}
			});
			
			//密码
			$("#id2").blur(function(){
				$(".id2_").animate(
					{bottom: '-3px'}, 500
				);
				if($('#id2').val()==""){
					$("#msg2").text("请输入密码");
					$("#msg2").css({"color":"red"});
				}else{
					$.ajax({
						url:"AjaxServlet",
						type:"post",
						data:{pwd:$("#id2").val()
						},
						dataType:"json",
						success:function(msg){
								$("#msg2").text(msg.pwd_msg);
							if("合法" == msg.pwd_msg){
								$("#msg2").css({"color":"green"});
							}
							else{
								$("#msg2").css({"color":"red"});
							}
							b = msg.pwd_msg;
						}, 
					});
				}
			});
			
			//确认密码
			$("#id3").blur(function(){
					$(".id3_").animate(
						{bottom: '-3px'}, 500
					);
				if($('#id3').val()==""){
					$("#msg3").text("请确认密码");
					$("#msg3").css({"color":"red"});
				}else{
					$.ajax({
						url:"AjaxServlet",
						type:"post",
						data:{conf_pwd:$("#id3").val(),pwd:$("#id2").val()
						},
						dataType:"json",
						success:function(msg){
							$("#msg3").text(msg.conf_msg);
							if("与之前输入的密码一致" == msg.conf_msg){
								$("#msg3").css({"color":"green"});
							}
							else{
								$("#msg3").css({"color":"red"});
							}
							c = msg.conf_msg;
							
						}, 
					});
				}
			});
			$("#sub").click(function(){
				if(a=="合法" && b=="合法" && c=="与之前输入的密码一致"){
					$("#form").submit();
				}
			});
			$("#id1").focus(function(){
				$("#msg1").text("");
				$(".user").animate(
					{bottom: '+10px'}, "500"
				);
			});
			$("#id2").focus(function(){
				$("#msg2").text("");
				$(".id2_").animate(
					{bottom: '+10px'}, "500"
				);
			});
			$("#id3").focus(function(){
				$("#msg3").text("");
				$(".id3_").animate(
					{bottom: '+10px'}, "500"
				);
			});
			$("#id4").focus(function(){
				$("#msg4").text("");
				$(".id4_").animate(
					{bottom: '+10px'}, "500"
				);
			});
			$("#id4").blur(function(){
				$(".id4_").animate(
					{bottom: '-2px'}, "500"
				);
			});
			$("#back").click(function(){
				javascript:history.go(-1)
			});
			
		});
	
	
	</script>
		<style type="text/css">
		.user{
			position:relative;
		}
		#all{
			margin:0 auto;
			background:white;
			height:350px;
			width:600px;
			
		}
			body{
				background:#eee;
			}
		</style>
  </head>
  
  <body>
   
  	<br><br><br><br><br>
  	 <div class="col-sm-offset-2 col-sm-10" style="left:145px;">
       <button type="reset" id="back" class="btn btn-default" >返回</button>
    </div>
  	<div id="all">
  	<br><br><br>
    <form id="form" class="col-sm-12 " action="UserServlet">
    <input type="hidden" name="method" value="add">
  <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label user" >用户名</label>
    <div class="col-sm-10">
      <input type="text" name="username" class="form-control" id="id1" placeholder="请输入用户名"><span id="msg1"></span>
    </div>
  </div>
  <br><br>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label id4_">真实姓名</label>
    <div class="col-sm-10">
      <input type="text" name="realname" class="form-control" id="id4" placeholder="请输入真实姓名">
    </div>
  </div>
 <br><br>
 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label id2_">密码</label>
    <div class="col-sm-10">
      <input type="password" name="password" class="form-control" id="id2" placeholder="请输入密码"><span id="msg2">
    </div>
  </div>
  <br><br>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label id3_">确认密码</label>
    <div class="col-sm-10">
      <input type="password" name="conf_pwd" class="form-control" id="id3" placeholder="请确认密码"><span id="msg3">
    </div>
  </div>
  <br><br>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <input type="button" id="sub" class="btn btn-default" value="注册"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <button type="reset" class="btn btn-default">重置</button>
    </div>
  </div>
</form>
</div>
  </body>
</html>
