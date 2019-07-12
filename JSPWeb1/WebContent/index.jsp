<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
</head>
<body>
	<h1>欢迎来到主页</h1>
	<c:import url="/StudentServlet?method=findList"></c:import>
</body>
</html>