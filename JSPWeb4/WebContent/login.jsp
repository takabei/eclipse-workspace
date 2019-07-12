<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

</style>
</head>
<body>
	<p align="center">${error }</p>
	<form
		action="${pageContext.request.contextPath }/UserServlet"
		method="post">
		<table align="center" border="1">
			
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="name" value=""></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;码:</td>
				<td><input type="text" name="pass" value=""></td>
			</tr>
			<tr>
				<td><input type="submit" value="登录" name="login"></td>
				<td><input type="reset" value="重置" name="reset"></td>
			</tr>
		</table>
		
	</form>
</body>
</html>