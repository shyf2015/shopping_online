<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<style type="text/css">
		body{
			background:#eee;
		}
	</style>

  </head>
  
  <body>
  <br><br>
    <form class="col-sm-10 " >
  <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">用户名</label>
    <div class="col-sm-10">
      <input type="text" name="username" class="form-control" id="id1" placeholder="请输入用户名"><span id="msg">
    </div>
  </div>
  <br><br>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">真实姓名</label>
    <div class="col-sm-10">
      <input type="text" name="realname" class="form-control" id="lastname" placeholder="请输入真实姓名">
    </div>
  </div>
 <br><br>
 <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-10">
      <input type="text" name="password" class="form-control" id="id2" placeholder="请输入密码"><span id="msg2">
    </div>
  </div>
  <br><br>
  <div class="form-group">
    <label for="lastname" class="col-sm-2 control-label">确认密码</label>
    <div class="col-sm-10">
      <input type="text" name="conf_pwd" class="form-control" id="id3" placeholder="请确认密码"><span id="msg2">
    </div>
  </div>
  
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">保存</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       <button type="reset" class="btn btn-default">重置</button>
    </div>
  </div>
</form>
  </body>
</html>
