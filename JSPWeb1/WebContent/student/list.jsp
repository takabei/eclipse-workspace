<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:directive.page import="utils.Pagination" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body, td, th, input {
	font-size: 12px;
	text-align: center;
}
a{
	a:link{color:#34c950;}
}
</style>
</head>
<body>
	<table bgcolor="#34c950" cellspacing=1 cellpadding=5 width=100%>
		<tr bgcolor=#34c950>
			<th>部门编号</th>
			<th>用户名</th>
			<th>学号</th>
			<th>性别</th>
			<th>年龄</th>
		</tr>
		<c:forEach items="${pb.beanList }" var="student">
			<tr bgcolor=#FFFFFF>
				<td>${student.depID }</td>
				<td>${student.userName }</td>
				<td>${student.id }</td>
				<td>${student.userSex }</td>
				<td>${student.userAge }</td>
		</c:forEach>

		<table align=right>
			<tr>
				<td>${page }</td>
			</tr>
		</table>
</body>
</html>