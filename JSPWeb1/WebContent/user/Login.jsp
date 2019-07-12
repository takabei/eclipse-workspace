<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
    <title>登陆页</title>            	
	<link href="${pageContext.request.contextPath }/css/main.css" media="screen" rel="stylesheet" type="text/css" />
</head>
<body>	
<div class="login-bg-plain stain">
	<div class="form-basic" id="login">
				<div class="form-content">
		<div class="login-header">
			<div class="logo"><span class="color">${err }</span> </div>
		</div>
		<form name="form1" action="${pageContext.request.contextPath }/UserServlet?method=Login" method="post">			
			<table>
			<tr>
				<td><input id="email" type="text" name="username" placeholder="用户名" value="${error.username }" tabindex="1"></td>
			</tr>
			<tr>
				<td><input type="password" name="password" placeholder="密码" value="" tabindex="2"></td>
			</tr>
			<tr>
				<td class="remember-me-td">
					<label class="remember-me" for="remember_me"><input type="checkbox" id="remember_me" tabindex="3" name="data[remember]" value="1" />记住帐号</label><span class="forgot-pass"><a href="/auth/password-recovery" class="" tabindex="5">点击注册</a></span>
				</td>
			</tr>
				<td style="text-align: center;">
					<input type="submit" class="login-btn" name="login" value="登录" tabindex="4" />
				</td>
			<tr>
			</tr>
			</table>
		</form>
		<div class="separator"><div class="separator-line"></div><span>OR</span><div class="separator-line"></div></div>
			<form name="googleloginform" class="oauth2form" id="googlelogin" action="" method="post">			
				<table>
					<tr>
						<td style="text-align: center; color: #b9b9b9;">
							<input type="hidden" name="data[provider_id]" value="1" />
							<input type="submit" class="google-btn" value="Sign in with Google" tabindex="4" />
						</td>
					</tr>
				</table>
			</form>
			<div class="login-footer">
			
		</div>
		</div>
	</div>
</div>
</body>
</html>