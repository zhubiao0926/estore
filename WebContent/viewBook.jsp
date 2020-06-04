<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>briup电子商务-首页</title>
<base href="<%=basePath%>">

<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#add").on("click",function(){
			var diva = this.parentNode.parentNode;
			var input = $(diva).find("input");
			var value = Number(input.val())+1;
			input.val(value);
			
		});
		$("#minus").on("click",function(){
			var diva = this.parentNode.parentNode;
			var input = $(diva).find("input");
			var value = Number(input.val())-1;
			
			if(value>0){
				input.val(value);
			}else{
				input.val(0);
			}
			
		});
		
		
	});
</script>
<script type="text/javascript">
function addShopCart(bookname){
	var	name="${loginUser.username}";
	if(name=="")
		{
		alert("请先登录");
		window.location.href = "/estore/login.jsp"
		}
	var remain="${productInfo.remain}";
	if(remain==0){
		alert("库存不足，请重新选择！");
	}else{
		//获取商品ID
		var productId="${productInfo.id}";
		//商品的数量
		var productNum=$("#productNum").val();
		if(productNum<=0){
			alert("请重新选择数量");
		}else{
			$.ajax({
				url:"user/addShopCartServlet",
				//给servlet传递商品ID参数
				data:"productId="+productId+"&productNum="+productNum,
				success:function(data){
					alert(data);
				}	
			});
		}	
	}
}
$(function(){
	$("#searchByName").bind("click",function(e){
		var keyword=$("#search_keyword").val();
		$.ajax({
			url:"listProduct",
			//给servlet传递商品ID参数
			data:"keyword="+keyword,
			success:function(data){
				window.location.href="list.jsp";
			}	
		});
	});
	
});
</script>

</head>
<body>
	<!--顶部-->
	<div class="top">
    	<div class="top_center">
    			<ul class="top_lr">
    			 	<li>
            		<c:if test="${loginUser.username==null}">
            			<a href="login.jsp" style="color: red;">亲,请登入</a>
            			<li><a href="register.jsp">免费注册</a></li>
            		</c:if>
            		<c:if test="${loginUser.username!=null}">
            			<a>欢迎 ${loginUser.username}</a>
            		</c:if>
            	</li>
            </ul>
            <ul class="top_bars">
            		<c:if test="${loginUser.username!=null}">
            			<li><a href="logoutServlet">退出</a>|</li>
               		 <li><a href="user/showShopCartServlet">我的购物车<span class="jt_down"></span></a>|</li>
            		</c:if>
            		 <li><a href="user/listConfirmListServlet">我的订单<span class="jt_down"></span></a>|</li>
                <li><a href="#">关注杰普<span class="jt_down"></span></a>|</li>
                <li><a href="#">网站导航<span class="jt_down"></span></a></li>
            </ul>
        </div>
    </div>
    <!--头部-->
    <div class="header3">
    	<a href="#"><img src="images/logo.png"></a>
    	<div class="h3_center">
        	<div class="search_box">
            	<input type="text" id="search_keyword"/>
                <span id="searchByName">搜索</span>
            </div>
        </div>
        <div class="h3_right">
        	<div class="myyy">
            	<a href="user/userinfo.jsp">个人信息</a>
                <span class="sj_down"></span>
             </div>
            <div class="tsc">
            	<a href="user/showShopCartServlet">去购物车结算</a>
                <span class="sj_right"></span>
            </div>
        </div>
    </div>
    <!--头部导航-->
    <div class="nav_top">
    	<div class="nav_top_center">
            <div>
                全部图书分类
            </div>
            <ul>
               <c:forEach items="${cates }" var="cate">
            			<li><a href="listProduct?cateId=${cate.id }&cateName=${cate.name}">${cate.name}</a></li>
            		</c:forEach>
            </ul>
        </div>
    </div>
    
	<div class="container5">
    	<div class="cn5_top">
            <div class="cn5_top_x center01">
            	<a class="font20" href="#">书籍</a> >
                <a href="#">${productInfo.cate_detail.name}</a>
            </div>
            <div class="cn5_top_y center01">
            	<div class="cn5topy_1">
                	<div class="cn5topy_imgview">
                    	<img src="${productInfo.img.split('[#]')[0] }"/>
                        <ul class="cn5topy_imglist">
                        		<li><a href="#"><img src="${productInfo.img.split('[#]')[1] }"></a></li>
                            <li class="current"><a href="#"><img src="${productInfo.img.split('[#]')[1] }"></a></li>
                            <li><a href="#"><img src="${productInfo.img.split('[#]')[1] }"></a></li>
                            <li><a href="#"><img src="${productInfo.img.split('[#]')[1] }"></a></li>
                            <li><a href="#"><img src="${productInfo.img.split('[#]')[1] }"></a></li>
                        </ul>
                    </div>
                </div>
                <div class="cn5topy_2">
                	<h1 class="pro_title font15">${productInfo.name }</h1>
                    <div class="pro_price">
                            <div class="pro_price_x">
                                <p> briup价：<b>￥${productInfo.price }</b> <a href="#">(降价通知)</a></p>
                            </div>
                            
                    </div>
                    <div class="pro_ship">
                        <div>
                        	<div class="pro_key fl">服&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务：</div>
                            <ul class="pro_service f1">
                                <li class="service_fq">分期付款</li>
                                <li class="service_myf">免运费</li>
                                <li class="service_zt">自提</li>
                                <li class="service_th">7天无理由退换货</li>
                            </ul>
                        </div>
                    </div>
                    <div class="pro_ship">
                        <div>
                        	<div class="pro_key fl">剩&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;余：${productInfo.remain}</div>
                        </div>
                    </div>
                    <div class="pro_buy">
                    	<div class="pro_buy_nums">
                        	<input id="productNum" type="text" value="1"/>
                            <dl>
                            	<dd id="add">+</dd>
                                <dd id="minus">-</dd>
                            </dl>
                        </div>
                        <div class="pro_addshop"> <a href="javascript:void(0)" onclick="addShopCart('${productInfo.name}')">加入购物车 </a></div>
                    </div>
                    
                </div>
            </div>
        </div>
    	<div class="c5_b2">
        	
            <div class="c5_b2_right">
            	<!--选项卡-->
            	<ul class="c5_b2_tabs">
                	<li>商品介绍</li>
                    <li class="current">规格参数</li>
                    <li>包装清单</li>
                    <li>商品评价</li>
                </ul>
                <!--内容-->
              	<div class="c5_b2_right_1 box">
                        <div class="introduce_item">
                          <ul>
                        	<li>商品名称：${productInfo.name}</li>
                            <li>商品编号：${productInfo.id }</li>
                            <li class="fr"><a class="color_link1" href="#">更多参数>></a></li>
                          </ul>
                        </div>
               		</div>
                    <div class="intro_pics">
                    	<img class="intro_pic" src="${productInfo.img.split('[#]')[0] }">
                    </div>
                </div>
                
                
            <div class="c5_b2_right">
              	<div class="c5_b2_right_2">
                    	<h1>正品行货</h1>
                        <p>briup网上商城向您保证所售商品均为正品，briup自营商品开具机打发票或电子发票。</p>
                        
                        <h1>全国联保</h1>
                        <p>凭质保证书及briup网上商城发票，可享受全国联保服务，与您亲临商场选购的商品享受相同的质量保证。briup网上商城还为您提供具有竞争力的商品价格和运费政策，请您放心购买！</p>
                        
                        <h1>正品行货</h1>
                        <p>briup网上商城向您保证所售商品均为正品，briup自营商品开具机打发票或电子发票。</p>
                        
                        <h1>全国联保</h1>
                        <p>凭质保证书及briup网上商城发票，可享受全国联保服务，与您亲临商场选购的商品享受相同的质量保证。briup网上商城还为您提供具有竞争力的商品价格和运费政策，请您放心购买！</p>
                        
            		</div> 
            </div>
            
            <!--左侧栏-->
            <div class="c5_b2_left_container">
                <div class="c5_b2_left box">
                    <h1>服务时间 早9：00~凌晨1：00</h1>
                    <p>
                    <a href="#">
                        <img class="callmebyqq" src="images/icon_qq_03.png"/>
                    </a>
                    </p>
                </div>
                
                <div class="c5_b2_left box">
                    <h1>其他种类</h1>
                    <dl>
                        <dd>文学类</dd>
                        <dd>漫画类</dd>
                        <dd>通书类</dd>
                    </dl>
                    <dl>
                        <dd>文学类</dd>
                        <dd>漫画类</dd>
                        <dd>通书类</dd>
                    </dl>
                </div>
            </div> 
        </div>
    </div>
    	
    <div class="c20"></div>
    <!--脚部-->
    <div class="footer3">
    	<div class="f3_top">
        	<div class="f3_center">
                <div class="ts1">品目繁多 愉悦购物</div>
                <div class="ts2">正品保障 天天低价</div>
                <div class="ts3">极速物流 特色定制</div>
                <div class="ts4">优质服务 以客为尊</div>
            </div>
        </div>
        <div class="f3_middle">
        	<ul class="f3_center">
            	<li class="f3_mi_li01">
                	<h1>购物指南</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>配送方式</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>支付方式</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>售后服务</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>服务保障</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li06">
                	<h1>客服中心</h1>
                    <img src="images/qrcode_jprj.jpg" width="80px" height="80px">
                    <p>抢红包、疑问咨询、优惠活动</p>
                </li>
            </ul>
        </div>
        <div class="f3_bottom">
        	<p class="f3_links">
                <a href="#">关于我们</a>|
                <a href="#">联系我们</a>|
                <a href="#">友情链接</a>|
                <a href="#">供货商入驻</a> 
           	</p>
            <p>沪ICP备14033591号-8 杰普briup.com版权所有 杰普软件科技有限公司 </p>
          	<img src="images/police.png">
        </div>
    </div>

</body>
</html>
