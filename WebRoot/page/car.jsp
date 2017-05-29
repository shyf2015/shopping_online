<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
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
	<title>购物车页面</title>
	<link href="css/myCart.css" type="text/css" rel="stylesheet" />
	<script src="js/jquery-1.8.2.js"></script>
	<style type="text/css">
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
	
	</style>
  </head>
  <body>
<div id="header"><img src="img/logo.gif" alt="logo" /></div><br>
<div id="nav" style="font-family: '楷体';font-size: 20px">您的位置：<a href="GoodsServlet?method=list">首页</a> &gt;购物车</div><br>
<div id="navlist">
  <ul>
    <li class="navlist_red_left"></li> 
    <li class="navlist_red">1. 查看购物车</li> 
    <li class="navlist_red_arrow"></li>
    <li class="navlist_gray">2. 确认订单信息</li> 
    <li class="navlist_gray_arrow"></li> 
     <li class="navlist_gray">3. 付款到支付宝</li> 
    <li class="navlist_gray_arrow"></li>   
     <li class="navlist_gray">4. 我的订单</li> 
    <li class="navlist_gray_arrow"></li> 
    <li class="navlist_gray">5. 评价</li> 
    <li class="navlist_gray_right"></li>   
  </ul>
</div>
 <form name="myform" action="" method="post">
<c:forEach items="${carids }" var="s">
	<input class="newcar" name="cartCheckBox" checked='checked' type="hidden" value="${s }" />
</c:forEach>
<div id="content">
 <table width="100%" border="0" cellspacing="0" cellpadding="0" id="shopping">
 	<!-- <input type="hidden" name="goodsids" value="">
 	<input type="hidden" name="nums" value=""> -->
 	
  <tr>
    <td class="title_1"><input id="allCheckBox" type="checkbox" value="" onclick="selectAll()"/>全选当前商品</td>
    <td class="title_2" colspan="2">店铺宝贝</td>
    
    <td class="title_3">单价 (元)</td>
    <td class="title_4">数量</td>
    <td class="title_5">小计 (元)</td>
    <td class="title_6">操作</td>
  </tr>
  <tr>
    <td colspan="8" class="line"></td>
  </tr>
	
  <c:forEach items="${pager.cars}" var="c"  >
  
	<tr id="product1">
	    <td class="cart_td_1"><input class="cartCheckBox" name="cartCheckBox" type="checkbox"  value="${c.carid}"  onclick="selectSingle()" /></td>
	    <td class="cart_td_2"><img width="100px" height="100px" name="imgurl" src="${c.imgurl}" alt="shopping"/></td>
	   	<td class="cart_td_3"><a href="GoodsServlet?method=query&goodsid=${c.goods.goodsId}" name="goodsid" >${c.goods.goodsName}</a><br/>
	       	cup:${c.params.cpu} <%-- 颜色：${c.params.color} --%> 运行内存：${c.params.ram} 内存：${c.params.rom}  尺码：${c.params.size} 电池容量：${c.params.battery} 操作系统：${c.params.os}<br />
       	</td>
	    
	    <td class="cart_td_4">${c.goods.goodsPrice}</td>
	    <td class="cart_td_5">
	    	<img class="hand" src="images/taobao_minus.jpg" alt="minus" <%-- onclick="changeNum('num_${c.carid}','minus')" --%> /> 
	    	<input id="num_${c.carid}"  name="goodsnum" type="text" value="${c.goods_num}" class="num_input" readonly="readonly"/>
	    	<img class="hand" src="images/taobao_adding.jpg" alt="add" <%-- onclick="changeNum('num_${c.carid}','add')"  --%> /></td>
	    <td class="cart_td_6"></td>
	    <td class="cart_td_7"><a href="CarServlet?method=delete&carid=${c.carid}">删除</a></td>
	</tr>
  
  </c:forEach>
 
  
 
  
  
   <tr>
	   <td  colspan="3"><input  type="button"  value="删除所选" id="del"></td>
	    <td colspan="5" class="shopend">商品总价：<label id="total" class="yellow"></label> 元<br />
	    <input id="buy" type="image" onclick="myform.action='OrderServlet?method=listcar'" src="images/taobao_subtn.jpg" /></td>
  </tr>
</table>

</div>
  <div style="text-align:center;width:100%;">
				<c:if test="${pager.currPage==1 and pager.currPage<pager.pageCount}">
					<input type="button" value="首页"/>
					<input type="button" value="上一页"/>
					<input type="submit" value="下一页" onclick="myform.action='CarServlet?method=list&currPage=${pager.currPage+1}'">
					<input type="submit" value="尾页" onclick="myform.action='CarServlet?method=list&currPage=${pager.pageCount}'">
					<p style="font-family: '楷体';font-size: 18px;">当前是第${pager.currPage}页，共${pager.pageCount}页</p>
				</c:if>
				<c:if test="${pager.currPage>1 and pager.currPage<pager.pageCount}">
					<input type="submit" value="首页" onclick="myform.action='CarServlet?method=list&currPage=1'">
					<input type="submit" value="上一页" onclick="myform.action='CarServlet?method=list&currPage=${pager.currPage-1}'">
					<input type="submit" value="下一页" onclick="myform.action='CarServlet?method=list&currPage=${pager.currPage+1}'">
					<input type="submit" value="尾页" onclick="myform.action='CarServlet?method=list&currPage=${pager.pageCount}'">
					<p style="font-family: '楷体';font-size: 18px;">当前是第${pager.currPage}页，共${pager.pageCount}页</p>
				</c:if>
				<c:if test="${pager.currPage>1 and pager.currPage==pager.pageCount }">
					<input type="submit" value="首页" onclick="myform.action='CarServlet?method=list&currPage=1'">
					<input type="submit" value="上一页" onclick="myform.action='CarServlet?method=list&currPage=${pager.currPage-1}'">
					<input type="button" value="下一页"/>
					<input type="button" value="尾页"/>
					<p style="font-family: '楷体';font-size: 18px;">当前是第${pager.currPage}页，共${pager.pageCount}页</p>
				</c:if>
  </form>
				<c:if test="${pager.currPage==1 and pager.currPage==pager.pageCount }">
					<input type="button" value="首页"/>
					<input type="button" value="上一页"/>
					<input type="button" value="下一页"/>
					<input type="button" value="尾页"/>
					<p style="font-family: '楷体';font-size: 18px;">当前是第${pager.currPage}页，共${pager.pageCount}页</p>
				</c:if>
			</div>
<script type="text/javascript" src="js/myCart.js"></script>
<script>

	var arr = [];
	function fun(){
		var len = $(".newcar").length;
		for(var i=0;i<len;i++){
			arr.push($(".newcar").eq(i).val());
		}
		
		var len2 = $(".cartCheckBox").length;
		for(var i=0;i<len2;i++){
			var id = $(".cartCheckBox").eq(i).val();
			for(var j=0;j<len;j++){
				if(id==arr[j]){
					$(".cartCheckBox").eq(i).prop("checked",true);
				}
			}
		}
	}
	function fun2(){
		var len2 = $(".cartCheckBox").length;
		for(var i=0;i<len2;i++){
			if($(".cartCheckBox").eq(i).prop("checked")==false){
				for(var j=0;j<arr.length;j++){
					var id = $(".cartCheckBox").eq(i).val();
					if(id==arr[j]){
						console.log(1);
						$(".newcar[value='"+id+"']").remove();
					}
				}
			}
			/* var id = $(".cartCheckBox").eq(i).val();
			for(var j=0;j<len;j++){
				if(id==arr[j]){
					$(".cartCheckBox").eq(i).prop("checked",true);
				}
			} */
		}
	}
	setInterval(fun2,500);
	fun();
</script>
</body>
  
</html>
