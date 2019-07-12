<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String bool = request.getParameter("bool");//用于标识该次请求的用途
	String sql  = "";//sql语句
	Connection conn = null;//连接
	PreparedStatement pstmt = null;//
	ResultSet rs = null;//结果集
	String driverClassName = "com.mysql.jdbc.Driver";//驱动
	String url = "jdbc:mysql://localhost:3306/test";//访问的数据库
	String user = "root";//用户名
	String psd = "54894liuyi";//密码
	String username = request.getParameter("username");//获取登陆用户名
	String password = request.getParameter("password");//获取登陆密码
	Class.forName("com.mysql.jdbc.Driver");
	try {
		conn = DriverManager.getConnection(url, user, psd);
		if(null == bool){//登陆
			sql = "select username,password from user where username = ? and password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				username = rs.getString("username");
				password = rs.getString("password");
				session.setAttribute("SessionUser", username);
			}
		}else if(Integer.parseInt(bool) == -1){//退出登陆
			session.removeAttribute("SessionUser");
			response.sendRedirect("index.jsp");
		}  else if(Integer.parseInt(bool) == 0){//跳转至注册页面
			request.setAttribute("bool", 0);
			//response.sendRedirect("index.jsp");
		} else if(Integer.parseInt(bool) == 1){//进行注册
			sql = "insert into user (username,password) values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.executeUpdate();
			response.sendRedirect("index.jsp");
		}
	} catch (SQLException e) {
		throw new RuntimeException(e);
	} finally {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
	<c:when test="${bool eq 0 }">
			<form action="index.jsp" method="post">
			<input type="hidden" name="bool" value="1">
				<table align="center">
					<tr align="right">
						<td>请输入用户名:</td>
						<td><input type="text" name=username autofocus="autofocus"></td>
					</tr>
					<tr align="right">
						<td>请输入密码:</td>
						<td><input type="text" name=password></td>
					</tr>
					<tr>
						<td><input type="submit" name=register value="注册"> </td>
						<td><input type="reset" name=refill value="重填"></td>
					</tr>
				</table>
			</form>
		</c:when>
		<c:when test="${SessionUser != null}">
			<h1>hello</h1>
			<h3>欢迎您 ${SessionUser } 来到我们的主页</h3>
			<a href="index.jsp?bool=-1">退出</a>
			<a href="index.jsp?bool=0">注册</a>
		</c:when>
		<c:when test="${SessionUser eq null && bool eq null}">
			<form action="#" method="post">
				<table align="center" border="1">
					<tr>
						<td>用户名:</td>
						<td><input type="text" name="username"></td>
					</tr>
					<tr>
						<td>密&nbsp;&nbsp;码:</td>
						<td><input type="text" name="password"></td>
					</tr>
					<tr>
						<td><input type="submit" value="登录" name="login"></td>
						<td><input type="reset" value="重置" name="reset"></td>
					</tr>
				</table>
				<p align="center">
					<a href="index.jsp?bool=0" color=blue>注册用户</a>
				</p>
			</form>
		</c:when>		
	</c:choose>
</body>
</html>