<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
	<meta charset="utf-8">
    <title>登录html</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/dmaku.css" />   
	<script type="text/javascript">
		function submit(){
			var username = document.getElementById("loginName").value;//获取文本框中的用户名
			var password = document.getElementById("Possword").value;//获取文本框中的密码
			location = "${pageContext.request.contextPath}/UserServlet?&username="+username + "&password="+password;
		}
	</script>
</head>

<body>
    <div class="main">
    	<div class="mainin">
        	<h1>${error }</h1>
            <div class="mainin1">
            	<ul>
                	<li><span>用户名：</span><input name="username" type="text" id="loginName" placeholder="登陆名" class="SearchKeyword"></li>
                    <li><span>密码：</span><input type="password" name="Possword" id="Possword" placeholder="密码"/ class="SearchKeyword2"></li>
                    <li><button class="tijiao" onclick="javascript:submit();">提交</button></li>
                </ul>
            </div>
           
        </div>
    </div>
<img src="${pageContext.request.contextPath }/images/loading.gif" id="loading" style=" display:none;position:absolute;" />
<div id="POPLoading" class="cssPOPLoading">
    <div style=" height:110px; border-bottom:1px solid #9a9a9a">
        <div class="showMessge"></div>
    </div>
    <div style=" line-height:40px; font-size:14px; letter-spacing:1px;">
        <a onclick="puc()">确定</a>
    </div>
</div>
</body>
</html></html>