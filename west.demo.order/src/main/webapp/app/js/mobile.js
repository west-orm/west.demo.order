
$(document).on("pageinit","#main",function(){



/*定义全局变量*/
  var pWidth = $(".main").width();

$(window).resize(function(){
   pWidth = $(".main").width();
//   len = $(".tplb-con>li").length;
   $(".tplb-con").width(pWidth);
//   $(".tplb-con li").width(pWidth);
   
   zLen = $(".zxxt-main .zxxt-block").length;
   $(".zxxt-main").width(pWidth*zLen);
   $(".zxxt-block").width(pWidth);
   
   sWidth = pWidth;
   sLen = $(".qh-nr>ul").length;
   $(".qh-nr").width(pWidth*sLen);
   $(".qh-nr ul").width(sWidth);
   
   zxWidth = $(".main").width();
   zxLen = $(".lgsy-box .lgtj-sy").length;
   $(".lgsy-box").width(pWidth*zxLen);
   $(".lgtj-sy").width(zxWidth);
   
   tkWidth = $(".main").width()-20;
   tkLen = $(".zxym-con .zxym-box").length;
   $(".zxym-con").width(pWidth*tkLen);
   $(".zxym-box").width(tkWidth);
   ztLen = $(".zxxt-box").length;
   $(".zxxt-nav").width(pWidth*ztLen);
   $(".zxxt-box").width(pWidth);
   
    var screenWidth = document.body.offsetWidth;
    var pcWidth = (screenWidth-pWidth)/2;
    $(".tghd-spic").css("margin-right",pcWidth);
    $(".tghd-fddh").css("margin-right",pcWidth);
	$(".footer-pic").width(pWidth);
	
	/*头部广告横屏*/
	$(".head-pic").width(pWidth); 
	
});


 
  /*图库获取屏幕宽度*/  
   tkWidth = $(".main").width()-20;
   tkLen = $(".zxym-con .zxym-box").length;
   $(".zxym-con").width(pWidth*tkLen);
   $(".zxym-box").width(tkWidth);

  
  
/*导航下拉*/
$(".header-right img").on("tap",function(){
  var cds = $(".main-nav").css("display");
  if(cds == "none"){
  $(".main-nav").slideDown(1000);
  }else{
 $(".main-nav").slideUp(1000);
  }
  
});


/*投诉下拉*/
$(".ts-select").change(function(){
  var selValue = $(this).find("option:selected").text();
  $(this).parent().find("span").text(selValue);
})

/*想要此设计*/
$(".bd-mffa select").live("change",function(){
  var selValue = $(this).find("option:selected").text();
  $(this).parent().find("em").text(selValue);
})


/*点击触发下拉*/
$(".wyts-title").on("tap",function(){
  var cds = $(this).next().css("display");
  if(cds == "none"){
  $(this).next().slideDown(1000);
  }else{
  $(this).next().slideUp(1000);
  }
   
});


/*异步搜索框下拉*/
$(".pr input").on("focus",function(){
  var cds = $(this).next().css("display");
  if(cds == "none"){
  $(this).next().slideDown(1000);
  } 
});

$(".pr input").on("blur",function(){
  var cds = $(this).next().css("display");
  if(cds !== "none"){
  $(this).next().slideUp(1000);
  } 
});


/*获取值*/
$(".wyts-opt li").on("tap",function(){
  var svalue = $(this).text();
  var rid = $(this).attr('rid');
  $(".wyts-title span").text(svalue); 
  $("input[name='complain_reason']").val(rid);
  $(".wyts-opt").slideUp(1000);
});



/*输入框获取焦点*/
$(".wyts-sr input,.login input").focus(function(){
  $(this).parent().addClass("inp-cur");
  $(this).addClass("inp-bor");
  
})

$(".wyts-sr input,.login input").blur(function(){
  $(this).parent().removeClass("inp-cur");
  $(this).removeClass("inp-bor");
})



$(".zxym-bd li input").focus(function(){
  $(this).parent().addClass("inp-cur");
})

$(".zxym-bd li input").blur(function(){
  $(this).parent().removeClass("inp-cur");
})

/*满意度评价*/
$(".tousu-df img").on("tap",function(){
  var index = $(this).index();
  $(".tousu-df img").attr("src","../static/images/my_xxc.png")
  $(".tousu-df img:gt("+index+")").attr("src","../static/images/my_xx.png");
});

/*分类下拉*/
$(".wddd-xl").on("tap",function(){
   var cds = $(".wddd-xlcd").css("display");
  if(cds == "none"){
  $(".wddd-xlcd").slideDown(1000);
  }else{
 $(".wddd-xlcd").slideUp(1000);
  }
});

$(".wdbd-am").on("tap",function(event){
 $(".wdbd-xl").slideToggle(1000);
 event.stopPropagation(); 
});

$(".wdbd-title").on("tap",function(){
  var cds = $(".wdbd-xl").css("display");
  if(cds=="block"){
   $(".wdbd-xl").slideUp();
  }
});


$(".wddd-xlcd li,.wdbd-xl li").on("tap",function(){
 $(this).parent().parent().slideUp(1000);
});

$(".wdbd-nav,#feedList").on("tap",function(){
 if($(".wdbd-xl").css("display") == "block"){
   $(".wdbd-xl").slideUp(1000);
 }
});



/*想要此设计*/

$(".zxym-xy").live("tap",function(){
  var cds = $(".zxym-bd").css("display");
  if(cds == "none"){
  $(".zxym-bd").slideDown(1000);
  }else{
 $(".zxym-bd").slideUp(1000);
  }
});

/*3d转换*/
/*
       var din = 0;
      function d3(){
	      var dlen = $(".zx-icon .zx-block").length;
		  if(din<dlen){
		   $(".zx-icon .zx-block").eq(din).addClass("ydj-s");
            din++;
		  }else{
		  window.clearInterval(dTime);
		  }
	  }
	  
	  var dTime = window.setInterval(d3,1000);

*/



/*图集喜欢*/
/*$(".lgtj-title span,.lgxx-time span").on("tap",function(){
 $(this).addClass("lgtj-yxh");
 $(this).find("img").attr("src","images/xh-2.png");
});*/



$(".zkxx li").on("tap",function(){
  $(this).parent().parent().find("li").removeClass("zk-libj");
  $(this).addClass("zk-libj");
});

$(".wzbd-box").on("tap",function(){
  $(".wzbd-box").removeClass("zk-libj");
  $(this).addClass("zk-libj");
});

/*装修图集层*/
$(".zxym-sel").on("tap",function(){
  $(".zxym-nav").css("display","none");
  $(".zxxg-yc").slideDown(1000);
});


$(".sqcz").on("tap",function(){
  $(".zxxg-yc").slideUp(1000);
   $(".zxym-nav").fadeIn();
});

/*下拉框*/
$(".span-sel").on("tap",function(){
  var display = $(".page-select").css("display");
  if(display == "none"){
    $(".page-select").slideDown();
  }else{
     $(".page-select").slideUp();
  }
})

/*
$(".page-select a").on("tap",function(event){
  $(this).parent().slideUp();
})
*/

/*select框下拉*/
$(".con-select").change(function(){
  var selValue = $(this).find("option:selected").text();
  $(this).parent().find("span").text(selValue);
})


$(".zxxt-nav,.zxxt-li,.zxxt-xx,.lgtj-more,.lgtj-syy,.lgtj-xyy,.footer").on("tap",function(){
    $(".con-select").slideUp();
})


/*详细点击*/
 $(".order_detail").live("tap",function(){
		var id = $(this).attr("id");
		window.location.href='../order/orderdetail/orderId/'+id;
	});



/*分享自适应*/
$("#bdshare").css({"font-size":"1em"});


/*装修APP切换*/
 
$(".wx-bj").on("tap",function(){
  $(this).fadeOut();
 });
	
$(".xuanzhong").on("tap",function(){
	var flag = $(this).find("a").attr("val");
	if(flag == 1)
	{
		var height = $(".main").height();
		$(".wx-bj").height(height);
		$(".wx-bj").css("display","block");
		return false;
	}
 });
 
 
/*城市定位*/
/* var cImg = $("<img src='../static/images/p_city.png' alt='选中' />")
 $(".city-xx li").click(function(){
   $(this).append(cImg);
 }) */
 
 

 
/*底部导航*/
 $(".footer-pic").width(pWidth); 
 $(".head-pic").width(pWidth); 
 
 /*底部广告*/
 /*
   var pcWidth = (document.body.offsetWidth-pWidth)/2;
   $(".footer-pic").css("margin-right",pcWidth);
 */
 

 
 
 /*右侧导航弹出*/
 $(".tghd-spic").on("tap",function(){
    $(".tghd-fddh").fadeIn();
	return false;
 })
  
 /*导航关闭*/
  $(".tghd-gb").on("tap",function(event){
    $(".tghd-fddh").fadeOut();
    event.stopPropagation(); 
 })

 
 

  /*报名浮动层*/
  $(".tghd-ksbm").on("tap",function(){
  	var sheight = ($(window).height()-$(".tghd-tcon").height())/2+$(document).scrollTop()-$(".main-header").height();
	$(".tghd-tcon").css("top",sheight);
	$(".tgbm-tc").addClass("vb");
    $(".tgbm-tc").height($(".main-content").height()+$(".footer").height()+30);
    return false;
 })
 
 
  /*报名浮动层关闭*/
 $(".tgbm-tc").on("tap",function(){
   $(".tgbm-tc").removeClass("vb");
//   alert("这是父框");
   return false;
 })
 $(".tgbm-nr").on("tap",function(event){
 //   alert("这是子框");
    event.stopPropagation();
 })
 
/*团购活动弹出框*/
 $(".tgbm-dck").on("tap",function(){
	var sheight = ($(window).height()-$(".bmtc-win").height())/2+$(document).scrollTop()-$(".main-header").height();
	$(".bmtc-win").css("top",sheight);
	$(".bmtc-box").addClass("vb");
	$(".bmtc-box").height($(".main-content").height()+$(".footer").height()+30);
	return false;
 })
 
  
/*团购活动弹出框关闭*/
 $(".bmtc-box,.bmtc-qx").on("tap",function(){
   $(".bmtc-box").removeClass("vb");
     return false;
 })
 $(".bmtc-win").on("tap",function(event){
       event.stopPropagation();
 })


 /*解决PC端缩放相对窗口定位问题*/
 var screenWidth = document.body.offsetWidth;
 var pcWidth = (screenWidth-pWidth)/2;
 $(".tghd-spic").css("margin-right",pcWidth);
 $(".tghd-fddh").css("margin-right",pcWidth);
 
 
 	$(".tghd-fddh a").on("tap",function(){
	    $(".tghd-fddh").fadeOut();
		$("html,body").stop(true);
		var name = $(this).attr("name");
		if(name==""||name==null){
//			return false;
			}else{
			$("html,body").animate({scrollTop:$("#"+name).offset().top},1000);	
		}		
		})	
		
 /*分类筛选*/

/*  $(".wxtj-flsx").on("tap",function(){
   var display = $(".wxtj-con").css("display");
   if(display=="none"){
      $(".wxtj-con").show();
   }else{
      $(".wxtj-con").hide();
   }
   return false;
 })
 
   $(".wxtj-con a").on("tap",function(){
     $(".wxtj-con").hide();
	 return false;
   })*/
 
  $(".fenye-bottom").on("tap",function(){
    $(".fenye-bcon").slideToggle();
 })
 
 /*找装修公司输入框*/ 
  $(".zxbz-inp input").on("tap",function(){
    $("html,body").animate({scrollTop:$(this).offset().top-80},10);
  });
 
 
 /*seo设计添加代码*/
 /*装修效果图*/
 
	$(".xcom-nav li").live("tap",function(){
		var index = $(this).index();
		$(this).parent().find("li").removeClass("cfr");
		$(this).addClass("cfr");
		if(index == 0){
			$(".fenye-bcon").fadeOut();
			$(".zxxt-zep").fadeOut();
			$(".zxxg-xx").fadeIn();
		}else if(index == 2){
			$(".fenye-bcon").fadeIn();
			$(".zxxt-zep").fadeIn();
			$(".zxxg-xx").fadeOut();
		}
	});
 
 
 
    /*装修流程下面手滑切换计算尺寸*/
/*	
   (function(){
		var len = $(".zxlc-box a").size();
		var cwidth = 0;
		$(".zxlc-box a").each(function(){
			cwidth = cwidth + parseInt($(this).outerWidth(true));
		})
		var count = Math.ceil(cwidth/pWidth);
		$(".zxlc-box").width(pWidth*count);
		$(".zxlc-box").attr("count",count);
   })();
*/
	/*热门关键词页面手滑遍历包含a或者span标签*/
	 (function(){
		for(var i = 0 ; i < $(".zxlc-box").size(); i++){
			var len = $(".zxlc-box").eq(i).find("span,a").size();
			var cwidth = 0;
			$(".zxlc-box").eq(i).find("span,a").each(function(){
				cwidth = cwidth + parseInt($(this).outerWidth(true));
			})
			var count = Math.ceil(cwidth/pWidth);
			$(".zxlc-box").eq(i).width(pWidth*count);
			$(".zxlc-box").eq(i).attr("count",count);
		}
		})();

   /*字母手滑*/
       (function(){
		for(var i = 0 ; i < $(".letter-nav").size(); i++){
			var len = $(".letter-nav").eq(i).find("a").size();
			var cwidth = 0;
			$(".letter-nav").eq(i).find("a").each(function(){
				cwidth = cwidth + parseInt($(this).outerWidth(true));
			})
			var count = Math.ceil(cwidth/pWidth);
			$(".letter-nav").eq(i).width(pWidth*count);
			$(".letter-nav").eq(i).attr("count",count);
		}
		})();
		
    /*首页热门推荐词页面*/ 
	$(".xxg-nav li").on("tap",function(){
		var index = $(this).index();
		if(!$(this).parents(".xxg").find(".xxg-con").eq(index).hasClass("dis_none")){
			$(this).parents(".xxg").find(".xxg-con").eq(index).addClass("dis_none");
			$(this).parent().find("img").addClass("dis_none");
			return false;
		}
		$(this).parents(".xxg").find(".xxg-con").addClass("dis_none");
		$(this).parents(".xxg").find(".xxg-con").eq(index).removeClass("dis_none");
		$(this).parent().find("img").addClass("dis_none");
		$(this).find("img").removeClass("dis_none");
		return false;
	});

 
   /*首页seo新添加*/
  /*
   
   	$(".xxg-nav li").on("tap",function(){
		var flag = $(this).attr("flag");
		$(this).siblings().find("img").addClass("dis_none");
		if(flag == 0){
			$(".xxg-con").removeClass("dis_none");
			$(this).parent().find("li").attr("flag",0);
			$(this).attr("flag",1);
			$(this).find("img").removeClass("dis_none");
		}else{
			$(".xxg-con").addClass("dis_none");
			$(this).attr("flag",0);
			$(this).parent().find("img").addClass("dis_none");
		}		
		return false;
	});
 */ 
 
 
 /*底部推荐*/
	$(".xtj").on("tap",function(){
		$(this).find(".tjtc-box").toggleClass("dis_none");
	});
	
	$(".xtj a").on("tap",function(){
		window.location.href = $(this).attr("href");
		return false;
	});
	
	/*将热门推荐词二级标签切换*/
	$(".zxlc-box span").on("tap",function(){
		var index = $(this).index();
//		alert(index);
		$(this).parents(".rc-back").next().find(".letter-more").css("display","none");
		$(this).parents(".rc-back").next().find(".letter-more").eq(index).css("display","block");
	})
	
	/*热门推荐词更多点击*/
	$(".rmc-box .more-com").on("tap",function(){
		var length = $(this).prevAll().length;
		for(var i = 0 ;i < length ; i++){
			var display = $(this).prevAll().eq(i).css("display");
			if(display == "none"){
				setTimeout($(this).prevAll().eq(i).css("display","block"),1000);
				break;
			}
		}
		return false;
	});
 
   /*装修效果图新添加更多*/
   $(".xx-more").on("tap",function(){
		$(this).parent().prev().css("display","block");
		$(this).addClass("dis_none");
		$(this).next().removeClass("dis_none");
   })
   
   $(".xs-more").on("tap",function(){
		$(this).addClass("dis_none");
		$(this).parent().prev().css("display","none");
		$(this).prev().removeClass("dis_none");
   })
   
   
   /*1-12微信项目添加*/
	$(".wx_hdxcSub").on("tap",function(){
		var sheight = ($(window).height()-$(".errorMsg").height())/2+$(document).scrollTop()-$(".main-header").height();
		$(".errorMsg").css("top",sheight);
		$(".errorMsg").fadeIn();
		return false;
	})
	
	$(".errorMsg").on("tap",function(){
		$(this).fadeOut();
		return false;
	})
	
	/*底部定位*/
	 $(".wx_hdsmNav").width(pWidth); 
	 
	/*$(".wx_czsjNav li").on("tap",function(){
		$(this).addClass("wx_czsjNavCur").siblings().removeClass("wx_czsjNavCur");
	});*/
      
   
   /*微信搜索底部定位隐藏*/

    $("#search").on({
		focus:function(){
			$(".wx_hdsmNav").fadeOut();	   
		},
		blur:function(){
			$(".wx_hdsmNav").fadeIn();	   
		}
	});
   
   
   /*头部广告根据手机类型是否显示*/
   (function(){
	   var u = navigator.userAgent;
	    if (u.indexOf('iPhone') > -1){
			if(u.indexOf("Safari") > -1 && u.indexOf("Chrome") < 1 ){
			}else{
				$(".head-picBox").fadeIn();
			}
		}
   })();
   
   
 
	
	
   
   
 
   });