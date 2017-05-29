// JavaScript Document
$(function(){
	
	$(".hand").bind("mousedown",function(){
		var carid = $(this).parent().parent().find(".cartCheckBox").val();
		var $obj = $(this).parent().find(".num_input");
		
		
		if($(this).index()==2){
			//当下标等于2时，得知点的是“+”
			if($(".goodsnum")==Number($(this).parent().find(".num_input").val())){
			}else{
				var goodsnum = Number($(this).parent().find(".num_input").val())+1;
				//alert(goodsnum);
				$.ajax({
					url:"AjaxServlet2",
					type:"get",
					data:{carid:carid,goodsnum:goodsnum},
					success:function(num){
						//alert(num);
						if(num==1){
							alert("不能超过库存");
						}else{
							$obj.val(num);
						}
					}
				});
				productCount();
			}
			
			
		}
		if($(this).index()==0){
			//当下标等于0时，     -
			if(1==Number($(this).parent().find(".num_input").val())){
				alert("商品数量不能小于1");
			}else{
				var goodsnum = Number($(this).parent().find(".num_input").val())-1;
				//alert(goodsnum);
				$.ajax({
					url:"AjaxServlet2",
					type:"get",
					data:{carid:carid,goodsnum:goodsnum},
					success:function(num){
						//alert(num);
						$obj.val(num);
					}
				});
				productCount();
			}
		}
		
	});
	$("#buy").on("click",function(e){
		//$("form[name='myForm']").attr("action","/test/List");
		if ( e && e.preventDefault ){
			e.preventDefault(); 
		}else{
			window.event.returnValue = false; 
		}
		var len = $("input[name='cartCheckBox']").length;
		var flag=0;
		for(var i=0;i<len;i++){
			if($("input[name='cartCheckBox']").eq(i).prop("checked")){
				flag++;
			}
		}
		if(flag==0){
			alert("请选择商品");
			return;
		}else{
			$("form").trigger("submit");
		}
	});
	
	
	$("#del").click(function(){
		var carids = [];
		var oInput=document.getElementsByName("cartCheckBox");
		 for (var i=oInput.length-1;i>=0;i--){
		   if(oInput[i].checked==true){
			 	carids.push(oInput[i].value);
		    }
		}
		var data = [{
			"name":"method",
			"value":"delete"
		},{
			"name":"carids",
			"value":carids
		}];
		$.ajax({
			url:"CarServlet",
			type:"post",
			data:data,
			success: function(s){
				location=location;
			}
		});
		productCount();
	});
	
});

/*改变所购商品的数量*/
function changeNum(numId,flag){/*numId表示对应商品数量的文本框ID，flag表示是增加还是减少商品数量*/
	var numId=document.getElementById(numId);
	if(flag=="minus"){/*减少商品数量*/
		if(numId.value<=1){
			alert("宝贝数量必须是大于0");
			return false;
			}
		else{
			numId.value=parseInt(numId.value)-1;
			productCount();
			}
		}
	else{/*flag为add，增加商品数量*/
		numId.value=parseInt(numId.value)+1;
		productCount();
		}
	}
	
/*自动计算商品的总金额、总共节省的金额和积分*/
function productCount(){
	var total=0;      //商品金额总计
	var integral=0;   //可获商品积分
	
	var price;     //每一行商品的单价
	var number;    //每一行商品的数量
	var subtotal;  //每一行商品的小计

     /*访问ID为shopping表格中所有的行数*/
	var myTableTr=document.getElementById("shopping").getElementsByTagName("tr"); 
	if(myTableTr.length>0){
	for(var i=1;i<myTableTr.length;i++){/*从1开始，第一行的标题不计算*/
	    if(myTableTr[i].getElementsByTagName("td").length>2){ //最后一行不计算
		
		price=myTableTr[i].getElementsByTagName("td")[3].innerHTML;
		number=myTableTr[i].getElementsByTagName("td")[4].getElementsByTagName("input")[0].value;
		
		myTableTr[i].getElementsByTagName("td")[5].innerHTML=price*number;
		if(myTableTr[i].getElementsByTagName("td")[0].getElementsByTagName('input')[0].checked==true){
			total+=price*number;
		}
		}
	}
	
	}
	document.getElementById("total").innerHTML=total;
}
window.onload=productCount;

/*复选框全选或全不选效果*/
function selectAll(){
	var oInput=document.getElementsByName("cartCheckBox");
 for (var i=0;i<oInput.length;i++){
 	    oInput[i].checked=document.getElementById("allCheckBox").checked;
 	    productCount();
	}
}
	
/*根据单个复选框的选择情况确定全选复选框是否被选中*/
function selectSingle(){
	//alert(1);
	var k=0;
	var oInput=document.getElementsByName("cartCheckBox");
	 for (var i=0;i<oInput.length;i++){
	 	if(oInput[i].checked==true){
	 		productCount();
	 	}
	   if(oInput[i].checked==false){
	   	  //alert(oInput[i].value);
	   	  productCount();
		  k=1;
		  break;
	    }
	}
	if(k==0){
		document.getElementById("allCheckBox").checked=true;
			productCount();
		}
	else{
		document.getElementById("allCheckBox").checked=false;
		}
}

/*删除单行商品*/
function deleteRow(rowId){
	var Index=document.getElementById(rowId).rowIndex; //获取当前行的索引号
	document.getElementById("shopping").deleteRow(Index);
	document.getElementById("shopping").deleteRow(Index-1);
	productCount();
	}

/*删除选中行的商品*/
function deleteSelectRow(){
	var oInput=document.getElementsByName("cartCheckBox");
	var Index;
	 for (var i=oInput.length-1;i>=0;i--){
	   if(oInput[i].checked==true){
		 Index=document.getElementById(oInput[i].value).rowIndex; /*获取选中行的索引号*/
		 document.getElementById("shopping").deleteRow(Index);
	     document.getElementById("shopping").deleteRow(Index-1);
	    }
	}
	productCount();
	}

