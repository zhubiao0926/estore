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
<title>订单列表页面</title>
<base href="<%=basePath%>">
<link rel="stylesheet" href="css/fullCar.css" />
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
<style type="text/css">
a{
	text-decoration:none;
}
input{
	width: 30px;
}


.divs .span{
	cursor: pointer;
	border:1px solid #ccc;

}

.empty{
	border:1px solid #ccc;
	width: 80%;
	margin:-10px auto;
	height: 5px;
	overflow: auto;
	margin-bottom: 10px
	
}
.c_header{
	overflow: hidden;
	height: 40px;
	line-height: 40px;
	background-color: #EEEEEE;
	border-bottom: 1px solid #ccc

}
.c_header .leftt{
	float: left;

}
.c_header .rightt{
	float: right
}

.c_header div,.c_header span{
	font-size: 14px;
	margin-right: 70px
}
.c_book .row{
	height: 85px;
	border-top: 2px solid red;
	line-height: 85px;
	background-color: #FFFDF0
}
.c_book .row>div{
	/* float: left;
	border:1px solid red; */
	/* width: 300px; */
	margin-right: 28px;


}
.c_book .row>div div{
	float: left;
	
	
}

.row_right div{
	width: 110px;
	text-align: center;
}

#jian,#sum{
	cursor: pointer;
	font-size: 16px;
}

.center_bottom{
	width: 530px;
	position: relative;
	left: 900px;

}
.center_bottom span{
	margin-left: 30px
}
.center_bottom font{
	color: red;
	font-size: 20px
}
.center_bottom button{
	background-color: red;
	width: 90px;
	height: 30px;
	font-size: 16px
}

</style>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	function delOrder(orderid){
		$.ajax({
			url:"user/deleOrderServlet",
			data:"orderid="+orderid,
			success:function(data){
// 				alert(data);
				window.location.href="user/listConfirmListServlet";
			}	
		});

	}
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
            		<!--  style="background-color:#70A3CE" -->
                 <li><a href="user/listConfirmListServlet">我的订单<span class="jt_down"></span></a>|</li>
                <li><a href="#">关注杰普<span class="jt_down"></span></a>|</li>
                <li><a href="#">网站导航<span class="jt_down"></span></a></li>
            </ul>
        </div>
    </div>
    <!--头部-->
    <div class="header3">
    	<a href="index.jsp"><img src="images/logo.png"  class="oneImg"></a>
       
    </div>
    
<!--中间部分div-->

<c:forEach items="${orderList }" var="order">
	
	<div class="empty">
		<div class="c_header">
			<div class="leftt">
				<span style="margin-left: 70px">订单号:${order.key }</span>
			</div>
			<div class="rightt">
				<span>
					<c:if test="${order.value[0].paystatus==1 }">
						<button>已支付</button>
					</c:if>
					<c:if test="${order.value[0].paystatus==2 }">
						<a href="javascript:alert('跳转到付款页面')">
							<button>去支付</button>
						</a>
					</c:if>
					
					
				</span>
				<span><a href="javascript:delOrder(${order.key })"><button>删除订单</button></a></span>
				<span>数量</span>
				<span  style="margin-right: 0px">总价</span>
			</div>
		</div>
	
		<div class="c_book">
			<c:forEach items="${order.value }" var="info">
				<div class="row">
					<div style="float: left">
						<div style="margin-left: 80px;">
							<img width="80px" height="80px" src="${info.img.split('[#]')[0]} " style="float: left">
							<span>${info.name} </span>
						</div>
					</div>
					<div style="float: right" class="row_right">
						<div style="margin-right: 10px">${info.num }</div>
						<div>
							${info.price }
						</div>
						
					</div>
				</div>
			</c:forEach>
		</div>
	
	</div>
</c:forEach>

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
            <p>沪ICP备14033591号-8 杰普软件briup.com版权所有 杰普软件科技有限公司 </p>
          	<img src="images/police.png">
        </div>
    </div>
</body>
</html>