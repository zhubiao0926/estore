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
            			<li><a href="${pageContext.request.contextPath}/Logout">退出</a>|</li>
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
    	<a href="index.jsp"><img src="images/logo.png"></a>
    	<div class="h3_center">
        	<div class="search_box">
            	<input type="text" id="search_keyword"/>
                <span id="searchByName">搜索</span>
            </div>
            <p>
            		<c:forEach items="${cateDets }" var="cate">
            			<a href="listProduct?cateId=${cate.key.id }&cateName=${cate.key.name}">${cate.key.name}</a>|
            		</c:forEach>
            </p>
        </div>
        <div class="h3_right">
        	<div class="myyy">
            	<a href="user/userinfo.jsp">个人信息</a>
                <span class="sj_down"></span>
             </div>
            <div class="tsc">
           	  <a href="user/showShopCartServlet">去购物车结算</a>
              <span class="sj_right"> </span>
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
            		<c:forEach items="${cateDets }" var="cate">
            			<li><a href="listProduct?cateId=${cate.key.id }&cateName=${cate.key.name}">${cate.key.name}</a></li>
            		</c:forEach>
            </ul>
        </div>
    </div>
    
	<div class="container3">
    	<div class="c3_b1">
        	<div class="c3_b1_left">
            	<dl>
               	<c:forEach items="${cateDets }" var="cateDet">
            			 <dd>
	                    	<h1>${cateDet.key.name }</h1>
	                    	<p>
                   			<c:forEach items="${cateDet.value}" var="cd">
                   				<a href="listProduct?catedetId=${cd.id }&catedetName=${cd.name }&cateName=${cateDet.key.name}">${cd.name } </a>
                   			</c:forEach>
	                      </p>
	                  </dd>
            		</c:forEach>
               
                </dl>
            </div>
            <div class="c3_b1_center">
            	<div>
                	<a href="viewBook.jsp"><img src="images/ad1.png"></a>
                </div>
                <div class="c3_b1_c_bottom">
                    <ul>
                       <c:forEach items="${allProducts}"  var="product">
                    			<li>
	                           <a href="${pageContext.request.contextPath}/ShowProduct?id=${product.id }"><img width="150px" height="170px" src="${product.img.split('[#]')[0] }"/></a>
	                           <a href="${pageContext.request.contextPath}/ShowProduct?id=${product.id }">${product.name}</a>  
	                        </li>
                    		</c:forEach>            
                       
                    </ul>
            	</div>
            </div>
            <div class="c3_b1_right">
            	<h1>杰普快报</h1>
            	<ul>
            		<c:forEach items="${reports }" var="report">
            				<li><a href="detailReportServlet?reportId=${report.id }">〈${report.publish_writer }〉${report.name } </a></li>
            		</c:forEach>
                </ul>
            </div>
            <div style="clear:both"></div>
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
            <p>沪ICP备14033591号-8 杰普briup.com版权所有杰普软件科技有限公司 </p>
          	<img src="images/police.png">
        </div>
    </div>

</body>
</html>
