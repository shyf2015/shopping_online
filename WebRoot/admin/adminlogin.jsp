<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>login.jsp</title>
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<script src="../js/jquery-1.8.2.js"></script>
<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
<style type="text/css">
	html,body{width:99%;height:98%}
	body{
		background-image: url("../images/222.jpg");
		background-repeat:no-repeat;
		background-size:100% 100%; 
		position:relative;
	}
	.fie{
		position:absolute;
		top:200px;
		left:50%;
		margin-left:-250px;		
		border-color: red;
	}
	.leg{
		font-size: 28px;
		font-weight:bold;
		color: red;
		font-family: '楷体';
	}
	/* a链接的初始状态，鼠标未悬停的时候 */
	a:LINK {
		font-size:15px;
		color:red;
		text-decoration: none;
	}
	/* a 鼠标悬停的时候 */
	a:HOVER {
		text-decoration: underline;
	}
	.text{
	font-weight:bolder;
	color:red;
	font-size: 20px;
	font-family: '楷体';
	}
	.inputDemo {
	width: 80px;
		}
</style>
</head>

<body>
	<fieldset class="fie" style="width: 520px">

		<legend class="leg">科技馆管理员登录</legend>
		<form action="../massager/msgmain.jsp" method="post">
			<div style="margin-left: 50px;">
			<br>
				<table style="padding-left: 1px;position: static;color: green;">
				<tr><td class="text" >用户名：</td><td><input type="text" id="username" name="username" ></td><td id="user"  ></td><tr>
			<tr><td class="text">密&nbsp;&nbsp;码：</td><td><input type="password" id="password"  name="password"></td><td id="pass"></td></tr>
				<tr><td class="text">验证码：</td><td><input type="text"  id="vercode"name="yanzhengma"></td><td id="yzm"></td>
				</table>
				<br>
				 <img
					style="cursor: pointer;margin-left: 100px;" src="VerCode.jsp"
					onclick="this.src = 'VerCode.jsp?'+new Date().getTime()"><a href = "" onclick="this.src = 'VerCode.jsp?'+new Date().getTime()">看不清？点击重试</a><br>
				<p><input id="login" type="button" value="登录" class="inputDemo" style="font-family: '楷体';font-size: 20px;margin-left: 140px"></p>
				${error}
			</div>
		</form>

	</fieldset>
</body>
<script type="text/javascript">
	
	$("#username").bind("focusin focusout",function(event){
		if(event.type=="focusout"){		
			if($("#username").val()==""){
				$("#user").html("用户名不能为空");
			}		
		}else{
			$("#user").html("");
		}
	});
	$("#password").bind("focusin focusout",function(event){
		if(event.type=="focusout"){
			if($("#password").val()==""){
				$("#pass").html("密码不能为空");
			}
		}else{
			$("#pass").html("");
		}
	});
	$("#vercode").bind("focusin focusout",function(event){
		if(event.type=="focusout"){
			if($("#vercode").val()==""){
				$("#yzm").html("验证码不能为空");
			}
		}else{
			$("#yzm").html("");
		}
	});
	
	$("#login").bind("click",function(){
		var username=$("#username").val();
		var password=$("#password").val();
		var vercode=$("#vercode").val();
		if(username == "" || password== "" || vercode== ""){
			alert("用户名、密码、验证码不能为空！");
			//window.location.href = "/Science_Museum/admin/adminlogin.jsp";
		}else{
			$.ajax({
				url:"/Science_Museum/AdminLoginServlet",
				type:"get",
				data:{username:username,password:password,vercode:vercode},
				
				success:function(a){
					if(a=="usererr"){
						alert("用户名或密码错误");
						
					}
					if(a=="yanerr"){
						alert("验证码错误");
						
					}
					if(a=="yes"){
						$("form").trigger("submit");
					}
				}
				
			});
				
		}
	});

</script>
</html>
