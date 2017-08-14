<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="${pageContext.request.contextPath}/loginController/index">
				<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.jpg" width="100" alt="农业电商"/>
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
	<img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障"/>
</div>
</div>
<div class="span10 last">
	<div class="topNav clearfix">
		<ul>
		<c:choose>
			<c:when test="${sessionScope.existUser == null}">
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				<a href="${ pageContext.request.contextPath }/loginController/login">登录</a>|</li>
			<li id="headerRegister" class="headerRegister"
				style="display: list-item;"><a href="${ pageContext.request.contextPath }/loginController/regist">注册</a>|
			</li>
			</c:when>
			<c:otherwise>
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				${sessionScope.existUser.name }
				|</li>
			<li id="headerLogin" class="headerLogin" style="display: list-item;">
				<a href="/loginController/order">我的订单</a>
			|</li>
			<li id="headerRegister" class="headerRegister"
				style="display: list-item;"><a href="${ pageContext.request.contextPath }/loginController/quit">退出</a>|
			</li>
			</c:otherwise>
		</c:choose>
			<li><a>会员中心</a> |</li>
			<li><a>购物指南</a> |</li>
			<li><a>关于我们</a></li>
		</ul>
	</div>
	<div class="cart">
		<a href="${ pageContext.request.contextPath }/loginController/shopCar">购物车</a>
	</div>
	<div class="phone">
		客服热线: <strong>96008/53277764</strong>
	</div>
</div>

<div class="span24">
	<ul class="mainNav">
		<li><a href="${ pageContext.request.contextPath }/loginController/index">首页</a> |</li>
		<c:forEach items="${sessionScope.cList}" var="c">
			<li><a href="${ pageContext.request.contextPath }/product_findByCid.action?cid=${c.cid }&page=1">${c.cname }</a> |</li>
		</c:forEach>

					<li>
						<a href="${ pageContext.request.contextPath }/loginController/classify">商品分类</a>
						|
					</li>
					<li>
						<a >安全频道</a>
						|
					</li>
					<li>
						<a >蔬菜基地</a>
						|
					</li>
					<li>
						<a>节气养生</a>
						|
					</li>
					<li>
						<a >便民服务</a>
						|
					</li>
	</ul>
</div>
</div>