<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" import="com.hello.beans.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'address.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
	
	<script type="text/javascript">
	$(function(){
		var a = false;
		var b = false;
		var c = false;
		var d = false;
		var e = false;
		
		var id1 = $("#id1");
		var id2 = $("#id2");
		var id3 = $("#id3");
		var id4 = $("#id4");
		var msg1 = $("#msg1");
		var msg2 = $("#msg2");
		var msg3 = $("#msg3");
		var msg4 = $("#msg4");
		function retu ( obj){
			obj.text("");
		}
		
		id1.blur(function(){
			$(".id1_").animate(
				{bottom:'-3px'},500
			);
			if($(this).val() == ""){
				msg1.text("请输入收件人");
			}
		});
		id2.blur(function(){
			$(".id2_").animate(
				{bottom:'-3px'},500
			);
			if($(this).val() == ""){
				msg2.text("请输入联系方式");
			}
		});
		id4.blur(function(){
			$(".id4_").animate(
				{bottom:'-3px'},500
			);
			
			if($(this).val() == ""){
				msg4.text("请输入详细地址");
			}
		});
		id1.focus(function(){
			$(".id1_").animate(
				{bottom:'+10px'},500
			);
			msg1.text("");
		});
		id2.focus(function(){
			$(".id2_").animate(
				{bottom:'+10px'},500
			);
			msg2.text("");
		});
		id4.focus(function(){
			$(".id4_").animate(
				{bottom:'+10px'},500
			);
			msg4.text("");
		});
		
		
		id2.blur(function(){
			if($(this).val() != ""){
				if(!(/^1[34578]\d{9}$/.test($(this).val()))){
					msg2.text("手机号格式有误");
				}else{
					a = true;
				}
			}
		});
		id4.blur(function(){
			var len = id4.val().length;
			if($(this).val() != ""){
				if(len < 5 || len > 16){
					msg4.text("详细地址长度不对,最小5个字,最大16个字");
				}else{
					b = true;
				}
			}
		});
		
		$("select").focus(function(){
			$("#msg3").text("");
		});
		
		
		$("#sub").click(function(){
			var pro = $("#s_province").val();
			var city = $("#s_city").val();
			var country = $("#s_county").val();
			if("省份" == pro || "地级市" == city || "市、县级市" == country){
				$("#msg3").text("请选择家庭住址");
			}else{
				c = true;
			}	
			if(a && b && c){
				$("#form").submit();
			}
		});
		
		$("#select").click(function(){
			$(".select_").animate(
				{bottom:'+10px'},500
			);
		});
		$("#select").mouseout(function(){
			$(".select_").animate(
				{bottom:'-3px'},500
			);
		});
		
});
	</script>
	
	<style type="text/css">
	#all{
			margin:0 auto;
			background:white;
			border:1px solid black;
			height:400px;
			width:600px;
			
		}
		
		body{
			background:#eee;
		}
		span{
			color:red;
		}
		#return{
			margin:0 auto;
			left:500px;
		}
	</style>

  </head>
  
  <body>
  <br><br><br><br><br>
  <div id="all">
    <br><br>
    <form class="col-sm-12 " id = "form" action="AddressServlet" >	
    <input type="hidden" name="method" value="add">
    
    
    <input type="hidden" name="user_id" value="${session_user.userid}">
    
  <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label id1_">收件人</label>
    <div class="col-sm-10">
      <input type="text" name="conname" class="form-control" id="id1" maxLength="8" placeholder="请输入收件人名字">
      <span id="msg1"></span>
    </div>
  </div>
  <br><br>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label id2_">联系方式</label>
    <div class="col-sm-10">
      <input type="text" name="conphone" class="form-control" id="id2" placeholder="请输入收件人联系方式">
   	  <span id="msg2"></span>
    </div>
  </div>
 <br><br>
  <div class="form-group">
   	<label  class="col-sm-2 control-label select_">家庭住址</label>
   	<div class="col-sm-10" id="select">
   			<select id="s_province" name="province"></select>
		    
		    <select id="s_city" name="city" ></select>
		    
		    <select id="s_county" name="country"></select>
	</div>
	<span id="msg3"></span>
  </div>
  <br><br>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label id4_" >详细地址</label>
    <div class="col-sm-10">
      <textarea  resize="none" name="address" class="form-control" id="id4" placeholder="请输入详细地址"></textarea>
   	  <span id="msg4"></span>
    </div>
  </div>
  <br><br>
  <br><br>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <input type="button" id="sub" class="btn btn-default" value="保存" >
      <input type="button" id="su" class="btn btn-default" value="取消" onclick="window.history.go(-1)">
    </div>
  </div>
    <script class="resources library" src="http://sandbox.runjs.cn/uploads/rs/267/g3ugugjp/area.js" type="text/javascript"></script>
	 <script type="text/javascript">_init_area();</script>
</form>
</div>
  </body>
</html>
