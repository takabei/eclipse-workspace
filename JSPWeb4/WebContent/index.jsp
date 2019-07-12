<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
<style type="text/css">body, td, th, input {font-size:12px; text-align:center; }</style>
</head>
<body>
<table border="1" cellspacing="0" cellpadding="0" align="center">
		<tr style="background-color: silver">
			<td width="200">部门编号</td>
			<td width="400">用户名</td>
			<td width="300">学号</td>
			<td width="100">性别</td>
			<td width="120">年龄</td>
		</tr>
		
		<c:forEach items="${pageBean.list }" var="stu">
		<tr style="background-color: wheat">
			<td width="200">${stu.depID }</td>
			<td width="400">${stu.userName}</td>
			<td width="300">${stu.userCode }</td>
			<td width="100">${stu.userSex}</td>
			<td width="120">${stu.userAge }</td>
		</tr>
		</c:forEach>
	</table>
	<div align="center">
		当前第${pageBean.pageCode }/${pageBean.pageTotal }页&nbsp;
		<c:choose>
			<c:when test="${pageBean.pageCode != 1 }">
				<a
					href="${pageContext.request.contextPath }/ListServlet?&pageCode=${1}">第一页</a>
			</c:when>
			
		</c:choose>
		<c:choose>
			<c:when test="${pageBean.pageCode eq 1 }">上一页</c:when>
			<c:otherwise>
				<a
					href="${pageContext.request.contextPath }/ListServlet?&pageCode=${pageBean.pageCode-1}">上一页</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${pageBean.pageCode eq pageBean.pageTotal }">下一页</c:when>
			<c:otherwise>
				<a
					href="${pageContext.request.contextPath }/ListServlet?&pageCode=${pageBean.pageCode+1}">下一页</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${pageBean.pageCode != pageBean.pageTotal }">
				<a
					href="${pageContext.request.contextPath }/ListServlet?&pageCode=${pageBean.pageTotal}">最后页</a>
			</c:when>
			
		</c:choose>
	</div>
</body>
</html>