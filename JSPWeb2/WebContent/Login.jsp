<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>登录页面</title>
<link rel="stylesheet" href="css/dmaku.css">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Lambent Login Form Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
	<style type="text/css">
		span{
			color: wheat;
			font-size: xx-large;
		}
	</style>
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
</head>

<body>
	<h1>登录表单</h1>
	<div class="main-agileinfo">
		<span>${err }</span>
		<form action="${pageContext.request.contextPath }/UserServlet" method="post">
			<input type="text" name="username" class="name" placeholder="Usename"
				required="">
			<input type="password" name="password"
				class="password" placeholder="Password" required="">
			<ul>
				<li><input type="checkbox" id="brand1" value=""> <label
					for="brand1"><span></span>记得我</label></li>
			</ul>
			<a href="#">立即注册</a><br>
			<div class="clear"></div>
			<input type="submit" value="Login">
		</form>
	</div>

</body>
</html>