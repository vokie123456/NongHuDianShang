<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0080)http://localhost:8080/mango/login.jhtml?redirectUrl=%2Fmango%2Fcart%2Flist.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>会员登录</title>
<link rel="icon" href="${pageContext.request.contextPath}/image/title.ico" type="image/x-icon"/>
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/login.css"
	rel="stylesheet" type="text/css" />

<script type="text/javascript">
<!--

//-->
function checkForm(){
	// 校验用户名:
	// 获得用户名文本框的值:
	var username = document.getElementById("username").value;
	if(username == null || username == ''){
		alert("账号不能为空!");
		return false;
	}
	// 校验密码:
	// 获得密码框的值:
	var password = document.getElementById("password").value;
	if(password == null || password == ''){
		alert("密码不能为空!");
		return false;
	}
	var valCode=document.getElementById("fontCode").innerHTML;
	if(valCode!="验证码正确！"){
		alert(valCode);
		return false;
	}
}
function checkCode(){
	// 获得文件框值:
	var checkcode = document.getElementById("checkcode").value;
	// 1.创建异步交互对象
	var xhr = createXmlHttp();
	// 2.设置监听
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				document.getElementById("span3").innerHTML = xhr.responseText;
			}
		}
	}
	// 3.打开连接
	xhr.open("GET","${pageContext.request.contextPath}/userController/checkCode?time="+new Date().getTime()+"&checkcode="+checkcode,true);
	// 4.发送
	xhr.send(null);
}
function createXmlHttp(){
	   var xmlHttp;
	   try{ // Firefox, Opera 8.0+, Safari
	        xmlHttp=new XMLHttpRequest();
	    }
	    catch (e){
		   try{// Internet Explorer
		         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		      }
		    catch (e){
		      try{
		         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		      }
		      catch (e){}
		      }
	    }

		return xmlHttp;
	 }
function change(){
	var img1 = document.getElementById("checkImg");
	img1.src="${pageContext.request.contextPath}/authCode?date="+new Date().getTime();
}
</script>

</head>
<body>


	<%@ include file="menu.jsp"%>

	<div class="container login">
		<div class="span12">
			<div class="ad">
				<img src="${pageContext.request.contextPath}/image/login.jpg"
					width="500" height="330" alt="会员登录" title="会员登录"/>
			</div>
		</div>
		<div class="span12 last">
			<div class="wrap">
				<div class="main">
					<div class="title">
						<strong>会员登录</strong>USER LOGIN

					</div>
					<div>
						<%-- <c:import url=""></c:import> --%>
					</div>
					<form id="loginForm"
						action="${ pageContext.request.contextPath }/loginController/loginUser"
						onsubmit="return checkForm()" method="post" novalidate="novalidate">
						<table>
							<tbody>
								<tr>
									<th>手机号或邮箱:</th>
									<td><input type="text" id="username" name="phonenumber"
										class="text" maxlength="20" /></td>
								</tr>
								<tr>
									<th>密&nbsp;&nbsp;码:</th>
									<td><input type="password" id="password" name="password"
										class="text" maxlength="20" /></td>
								</tr>
								<tr>
									<th><span class="requiredField">*</span>验证码:</th>
									<td><span class="fieldSet"> <input type="text"
											id="checkcode" name="checkcode" onblur="checkCode()" onmouseout="checkCode()"
											class="text captcha" maxlength="5" /><img id="checkImg"
											class="captchaImage"
											src="${pageContext.request.contextPath }/authCode"
											onclick="change()" title="点击更换验证码" />
									</span> <span id="span3"></span></td>
								</tr>
								<tr>
									<th>&nbsp;</th>
									<td><label> <input type="checkbox"
											id="isRememberUsername" name="isRememberUsername"
											value="true" />记住用户名
									</label> <label> &nbsp;&nbsp;<a>找回密码</a>
									</label></td>
								</tr>
								<tr>
									<th>&nbsp;</th>
									<td><input type="submit" class="submit" value="登 录" /></td>
								</tr>
								<tr class="register">
									<th>&nbsp;</th>
									<td>
										<dl>
											<dt>还没有注册账号？</dt>
											<dd>
												立即注册即可体验在线购物！ <a
													href="${ pageContext.request.contextPath }/loginController/regist">立即注册</a>
											</dd>
										</dl>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="container footer">
		<div class="span24">
			<div class="footerAd">
				<img src="${pageContext.request.contextPath}/image/footer.jpg"
					width="950" height="52" alt="我们的优势" title="我们的优势" />
			</div>
		</div>
		<div class="span24">
			<ul class="bottomNav">
				<li><a>关于我们</a> |</li>
				<li><a>联系我们</a> |</li>
				<li><a>招贤纳士</a> |</li>
				<li><a>法律声明</a> |</li>
				<li><a>友情链接</a> |</li>
				<li><a target="_blank">支付方式</a> |</li>
				<li><a target="_blank">配送方式</a> |</li>
				<li><a>服务声明</a> |</li>
				<li><a>广告声明</a></li>
			</ul>
		</div>
		<div class="span24">
			<div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
		</div>
	</div>
</body>
</html>