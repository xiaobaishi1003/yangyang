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
		<td>课目成绩查询</td>
	</center>
	用户：<%=application.getAttribute("name") %>
	<form action="KemuchengjiServlet" method="post"
		onSubmit="return validate(this)">
		<td>年级</td> <select name="grade_id">
			<option value="-1">全部</option>

			<%
				List<Grade> list = (List<Grade>) request.getAttribute("xueqiming");
				for (int i = 0; i < list.size(); i++) {
			%>
			<option value=<%=list.get(i).getGradeid()%>><%=list.get(i).getXueqiming()%></option>
			<%
				}
			%>
		</select>
		<td>课目</td> <select name="kemu_id">
			<option value="-1">全部</option>

			<%
				List<Kemu> list1 = (List<Kemu>) request.getAttribute("kemu");
				for (int i = 0; i < list1.size(); i++) {
			%>
			<option value=<%=list1.get(i).getKemuid()%>><%=list1.get(i).getName()%></option>
			<%
				}
			%>
		</select> <br>
		<td>成绩区间</td> <input type="text" name="chengji1"> <input
			type="text" name="chengji2"> <input type="submit" value="查询">
	</form>
	<form action="FanhuiServlet" method="get"
		onSubmit="return validate(this)">
		<input type="submit" value="返回">
	</form>

</body>
</html>
