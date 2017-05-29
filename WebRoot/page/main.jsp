<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/jquery-1.8.2.js"></script>
  <style>
  	
  </style>
  <script type="text/javascript">
  </script>
  </head>
 	
  <body>
  
  <div style="height:60px;background:#ddf;overflow:hidden" class="row">
    <div class="col-sm-2">
    	<img class="col-sm-12" style="height:100%" src="images/logo.png"/>
    </div>
    <div class="col-sm-8">
    	<div class="col-sm-2"></div>
    	<form action="SerachServlet" class="col-sm-8 form-inline pull-right">
    		<input type="hidden" name="method" value="list" />
    		<input class="col-sm-10" type="text" required="required" name="searchinfo"/>
    		
    		<input class="col-sm-2 btn" style="background:#bbb" type="submit" value="搜索"/>
    	</form>
    	<div class="col-sm-2"></div>
    </div>
    <div class="col-sm-2">
    	
    	<c:if test="${not empty session_user.username}">
    		<a href="PersonServlet"><button class="btn" style="background:#ccc;height:40px;margin:10px; margin-left:30px;">
    		${session_user.username}
    		</button></a>
    		
    		 
    	<a href="GoodsServlet?method=exit">退出</a>

    		
    	</c:if>
    	<c:if test="${empty session_user.username}">
    	<label><a href="page/login.jsp">
    		<button class="btn" style="background:#ccc;height:40px;margin:10px; margin-left:30px;">
    		登录
    		</button></a></label>
    	</c:if>
    	
    	
    </div>
  </div>
  <div class="">
  	<div  class="col-sm-2">
  		<ul class="menu">
  			<li style="position:relative"><a href="GoodsServlet?method=list">全部商品</a>
  				
  			</li>
  			<c:forEach items="${supertypesAndBrands}" var="sab">
  			<li style="position:relative" ><a href="SerachServlet?method=list&searchinfo=${sab.supertypes}">${sab.supertypes}</a>
		  		<ul class="brand">
		  		<c:forEach items="${sab.brands}" var="b">
		  			<li><a href="SerachServlet?method=list&searchinfo=${b}&st=${sab.supertypes}">${b}</a></li>
		  		</c:forEach>
		  		</ul>
  			</li>
  			</c:forEach>
  			
  			
  		</ul>
  	</div>
  	<div class="col-sm-9">
  		<%-- ${pager }${searchpager } --%>
		<c:if test="${not empty pager }">
			<c:forEach items="${pager.allgoods }" var="s">
				<div class="img col-sm-3">
					<a href="GoodsServlet?method=query&goodsid=${s.goodsId }">
					<img src="${s.goodsImgurl }"/>
					<p style="text-ailgn:center;" class="col-sm-12">${s.goodsName }</p>
					</a>
				</div>
			</c:forEach>
		</c:if>
		<c:if test="${not empty searchpager }">
			<c:forEach items="${searchpager.allgoods }" var="s">
				<div class="img col-sm-3">
					<a href="GoodsServlet?method=query&goodsid=${s.goodsId }">
					<img src="${s.goodsImgurl }"/>
					<p style="text-ailgn:center;" class="col-sm-12">${s.goodsName }</p>
					</a>
				</div>
			</c:forEach>
		</c:if>
		<c:if test="${searchpager.pageCount==0}">
				<h1>没有搜索到相关内容</h1>
		</c:if>
			
			<c:if test="${not empty pager }">
			<div style="text-align:center" class="col-sm-12">
				<c:if test="${pager.currPage==1 and pager.currPage<pager.pageCount}">
					
					<span class="glyphicon glyphicon-chevron-left"></span><a href="GoodsServlet?method=list&currPage=${pager.currPage+1 }"><span class="glyphicon glyphicon-chevron-right"></span></a>
				</c:if>
				<c:if test="${pager.currPage>1 and pager.currPage<pager.pageCount}">
					<a href="GoodsServlet?method=list&currPage=${pager.currPage-1 }">
						<span class="glyphicon glyphicon-chevron-left"></span>
					</a><a href="GoodsServlet?method=list&currPage=${pager.currPage+1 }">
						<span class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</c:if>
				<c:if test="${pager.currPage>1 and pager.currPage==pager.pageCount }">
					<a href="GoodsServlet?method=list&currPage=${pager.currPage-1 }"><span class="glyphicon glyphicon-chevron-left"></span></a>
					<span class="glyphicon glyphicon-chevron-right"></span>
				</c:if>
				<c:if test="${pager.currPage==1 and pager.currPage==pager.pageCount }">
					<span class="glyphicon glyphicon-chevron-left"></span>
					<span class="glyphicon glyphicon-chevron-right"></span>
				</c:if>
			</div>
			
			</c:if>
			
			<c:if test="${not empty searchinfo }">
			<div style="text-align:center" class="col-sm-12">
				<c:if test="${searchpager.currPage==1 and searchpager.currPage<searchpager.pageCount}">
					
						<span class="glyphicon glyphicon-chevron-left"></span>
					<a href="SerachServlet?method=list&currPage=${searchpager.currPage+1 }&searchinfo=${searchinfo }">
						<span class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</c:if>
				<c:if test="${searchpager.currPage>1 and searchpager.currPage<searchpager.pageCount}">
					<a href="SerachServlet?method=list&currPage=${searchpager.currPage-1 }&searchinfo=${searchinfo }">
						<span class="glyphicon glyphicon-chevron-left"></span>
					</a><a href="SerachServlet?method=list&currPage=${searchpager.currPage+1 }&searchinfo=${searchinfo }">
						<span class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</c:if>
				<c:if test="${searchpager.currPage>1 and searchpager.currPage==searchpager.pageCount }">
					<a href="SerachServlet?method=list&currPage=${searchpager.currPage-1 }&searchinfo=${searchinfo }"><span class="glyphicon glyphicon-chevron-left"></span></a>
					<span class="glyphicon glyphicon-chevron-right"></span>
				</c:if>
				<c:if test="${searchpager.currPage==1 and searchpager.currPage==searchpager.pageCount }">
					<span class="glyphicon glyphicon-chevron-left"></span>
					<span class="glyphicon glyphicon-chevron-right"></span>
				</c:if>
			</div>
			
			</c:if>
			
			
			<c:if test="${not empty brand }">
			<div style="text-align:center" class="col-sm-12">
				<c:if test="${searchpager.currPage==1 and searchpager.currPage<searchpager.pageCount}">
					
						<span class="glyphicon glyphicon-chevron-left"></span>
					<a href="SerachServlet?method=list&currPage=${searchpager.currPage+1 }&brand=${brand}&st=${supertype}">
						<span class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</c:if>
				<c:if test="${searchpager.currPage>1 and searchpager.currPage<searchpager.pageCount}">
					<a href="SerachServlet?method=list&currPage=${searchpager.currPage-1 }&brand=${brand}&st=${supertype}">
						<span class="glyphicon glyphicon-chevron-left"></span>
					</a><a href="SerachServlet?method=list&currPage=${searchpager.currPage+1 }&brand=${brand}&st=${supertype}">
						<span class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</c:if>
				<c:if test="${searchpager.currPage>1 and searchpager.currPage==searchpager.pageCount }">
					<a href="SerachServlet?method=list&currPage=${searchpager.currPage-1 }&brand=${brand}&st=${supertype}"><span class="glyphicon glyphicon-chevron-left"></span></a>
					<span class="glyphicon glyphicon-chevron-right"></span>
				</c:if>
				<c:if test="${searchpager.currPage==1 and searchpager.currPage==searchpager.pageCount }">
					<span class="glyphicon glyphicon-chevron-left"></span>
					<span class="glyphicon glyphicon-chevron-right"></span>
				</c:if>
			</div>
			
			</c:if>
			
			
		</div>
  	</div>
  	<div class="col-sm-1">
  		<div class="pull-right">
  		<div style="margin-top:50px;" class="pull-right">
  			<c:if test="${empty session_user }">
 			<a href="CarServlet?method=list" onclick="return confirm('需要先登录，要登录吗?');"><img style="width:52px;height:52px;border-radius:50%;" src="img/Gou.jpg"/></a>
  			</c:if>
  			<c:if test="${not empty session_user }">
 			<a href="CarServlet?method=list"><img style="width:52px;height:52px;border-radius:50%;" src="img/Gou.jpg"/></a>
  			</c:if>
  		</div>
  		<div style="margin-top:20px;" class="pull-right">
  		<c:if test="${empty session_user }">
 			<a href="OrderServlet?method=listall" onclick="return confirm('需要先登录，要登录吗?');"><img style="width:50px;height:50px;border-radius:50%;" src="img/Ding.jpg"/></a>
  		</c:if>
  		<c:if test="${not empty session_user }">
 			<a href="OrderServlet?method=listall"><img style="width:50px;height:50px;border-radius:50%;" src="img/Ding.jpg"/></a>
  		</c:if>
  		</div>
  		<div style="margin-top:20px;" class="pull-right">
  			<c:if test="${empty session_user }">
	 			<a href="PersonServlet" onclick="return confirm('需要先登录，要登录吗?');"><img style="width:50px;height:50px;border-radius:50%;" src="images/个人中心.png"/></a>
  			</c:if>
  			<c:if test="${not empty session_user }">
	 			<a href="PersonServlet""><img style="width:50px;height:50px;border-radius:50%;" src="images/个人中心.png"/></a>
  			</c:if>
  		</div>
  		</div>
  	</div>
  </div>
  <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
  <script>
  	/* (function(){
  		location.href = "GoodsServlet?method=list";
  	})(); */
  	$(".menu li").on("mouseover",function(){
  		$(this).find(".brand").css({"display":"block"});
  	});
  	$(".menu li").on("mouseout",function(){
  		$(".brand").css("display","none");
  	});
  	
  </script>
  </body>
</html>
