<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
<style type="text/css">
#tb {
	padding-top: 100px;
}

a:link {
	color: red;
}

a:visited {
	color: red;
}

body {
	background: #006eb0 url(../images/lgbg.png) center top no-repeat;
	clear: both;
	margin: 0 auto;
	width: 100%;
	min-width: 960px;
}
</style>
</head>
<body>
	<table id="tb" border="1" cellspacing="0" cellpadding="0"
		align="center">
		<tr style="background-color: silver">
			<td width="100">部门编号</td>
			<td width="200">用户名</td>
			<td width="150">学号</td>
			<td width="50">性别</td>
			<td width="60">年龄</td>
		</tr>

		<c:forEach items="${lists }" var="stu">
			<tr style="background-color: silver">
				<td width="100">${stu.depID }</td>
				<td width="200">${stu.userName}</td>
				<td width="150">${stu.userCode }</td>
				<td width="50">${stu.userSex}</td>
				<td width="60">${stu.userAge }</td>
			</tr>
		</c:forEach>
	</table>
	<div align="center">
		当前第${pagenow }/${pagetotal }页&nbsp;
		<c:choose>
			<c:when test="${pagenow != 1 }">
				<a
					href="${pageContext.request.contextPath }/StudentServlet?&pagenow=${1}">第一页</a>
			</c:when>
			<c:otherwise>
				第一页
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${pagenow eq 1 }">上一页</c:when>
			<c:otherwise>
				<a
					href="${pageContext.request.contextPath }/StudentServlet?&pagenow=${pagenow-1}">上一页</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${pagenow eq pagetotal }">下一页</c:when>
			<c:otherwise>
				<a
					href="${pageContext.request.contextPath }/StudentServlet?&pagenow=${pagenow+1}">下一页</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${pagenow != pagetotal }">
				<a
					href="${pageContext.request.contextPath }/StudentServlet?&pagenow=${pagetotal}">最后页</a>
			</c:when>
			<c:otherwise>
				最后页
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>