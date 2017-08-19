<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="want.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>个人成绩系统</title>
</head>

<body>
	<center>
		<h2>年级增加界面</h2>
	</center>
	用户：<%=application.getAttribute("name") %>
	<form action="NianjizengjiaServlet" method="post"
		onSubmit="return validate(this)">
		<center>
			${info}<br>
			<td>年级名称</td>
		</center>
		<br>
		<center>
			<input type="text" name="xueqiming"><br> <input
				type="submit" value="提交">
		</center>
	</form>
	<form action="FanhuiServlet" method="get"
		onSubmit="return validate(this)">
		<input type="submit" value="返回">
	</form>

</body>
</html>
