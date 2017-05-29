// 放大镜
$(".fangdajin").hide();
$(".fangda").hide();
$(".yuantu").on("mouseover", function() {
			$(".fangdajin").show();
			$(".fangda").show();
			$(".fangda img").attr("src", $(this).find("img").attr("src"));
		});
$(".yuantu").on("mouseout", function() {
			$(".fangdajin").hide();
			$(".fangda").hide();
		});
$(".yuantu").on("mousemove", function(e) {
			var left = $('.yuantu').offset().left;
			var top = $('.yuantu').offset().top;
			var x = e.clientX - left;
			var y = e.clientY - top;
			if (x < 100) {
				x = 100;
			}
			if (x > 300) {
				x = 300;
			}
			if (y > 300) {
				y = 300;
			}
			if (y < 100) {
				y = 100;
			}
			$(".yuantu .fangdajin").css({
						"left" : x - 100 + "px",
						"top" : y - 100 + "px"
					});
			$(".yuantu .fangda img").css({
						"left" : (100 - x) * 2 + "px",
						"top" : (100 - y) * 2 + "px"
					})
		});

// 点击立即购买
$("#buy").on("click", function() {
			var flag = 0;
			for (var i = 0; i < $('.color').length; i++) {
				if ($('.color').eq(i).prop("checked")) {

					var num = $(".goodsnum").val();
					if (num < 1) {
						$(".goodsnum").val(1);
//						alert("商品数量不能少于1");
//						return false;
					}
					if (num > Number($(".kucun").html())) {
						$(".goodsnum").val(Number($(".kucun").html()));
//						alert("库存没有这么多商品");
//						return false;
					}
					
						$("form").trigger("submit");
					
				} else {
					flag++;
				}
			}
			if (flag == $('.color').length) {
				alert("请选择一个颜色");
				return false;
			}
		});
// 选择图片
$(".selectimg").on("mouseover", function() {
			$("#goodsimg").attr("src", $(this).attr("src"));
		});
// 选择颜色
$(".color").on("click", function() {
			$("#goodsimg").attr("src", $(this).val());
		});
//
$(".submit").on("click", function() {
			var num = $(".goodsnum").val();
			if (num < 1) {
				$(".goodsnum").val(1);
				return false;
			}
			if (num > Number($(".kucun").html())) {
				$(".goodsnum").val(Number($(".kucun").html()));
				return false;
			}
		});
// 减少购买数量
$("#jie").on("click", function() {
			var num = $(".goodsnum").val();
			if (num < 1) {
				$(".goodsnum").val(1);
				num = $(".goodsnum").val();
			}
			if (num == 1) {
				return;
			}
			$(".goodsnum").val(num - 1);
		});
// 增加购买数量
$("#zeng").on("click", function() {
			var num = $(".goodsnum").val();
			if (num < 1) {
				$(".goodsnum").val(1);
				num = $(".goodsnum").val();
			}
			if (num >= Number($(".kucun").html())) {
				$(".goodsnum").val($(".kucun").html());
				return;
			}
			$(".goodsnum").val(Number(num) + 1);
		});
// 加入购物车

$("#addcar").on("click", function(e) {

			var flag = 0;
			var imgurl;
			var uid = $("#uid").val();
			if (false) {
				alert("请登录");
			} else {
				for (var i = 0; i < $('.color').length; i++) {
					if ($('.color').eq(i).prop("checked")) {
						imgurl = $(".color").eq(i).val();
						var num = $(".goodsnum").val();
						if (num < 1) {
							$(".goodsnum").val(1);
							alert("商品数量不能少于1");
							return;
						}
						if (num > Number($(".kucun").html())) {
							$(".goodsnum").val(Number($(".kucun").html()));
							alert("库存没有这么多商品");
							return;
						}
					} else {
						flag++;
					}
				}
				if (flag == $('.color').length) {
					alert("请选择一个颜色");
					return;
				} else {

					var goodsid = $(".goodsid").val();
					var goodsnum = $(".goodsnum").val();

					$.ajax({
								url : "CarServlet",
								type : "get",
								data : {
									method : "add",
									goods_id : goodsid,
									goods_num : goodsnum,
									user_id : uid,
									imgurl : imgurl
								},
								success : function() {
									alert("添加成功");
								}
							});
				}
			}

		});
