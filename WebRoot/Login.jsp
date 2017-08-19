<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>个人成绩系统</title>
</head>
<body>
	<center>
		<h2>用户登录程序</h2>
	</center>
	<center>
		 
		<%
			request.setCharacterEncoding("UTF-8");
		%>
		
	</center>
	<center>
		
		<form action="LoginServlet" method="post"
			onSubmit="return validate(this)"><a >${info}</a><br>
			用户名:<input type="text" name="name"><br> 密 码：<input
				type="password" name="password"><br> <input
				type="submit" value="登录" > <input type="reset" value="重置">
		</form>
	</center>
</body>
</html>
