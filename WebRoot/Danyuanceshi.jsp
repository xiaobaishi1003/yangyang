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
		<h2>单元成绩</h2>
	</center>
	用户：<%=application.getAttribute("name") %>
	<center>
		<%
			request.setCharacterEncoding("UTF-8");
		%>
	</center>
	<center>
		<td>课目名称</td>&#12288; &#12288;
		<td>单元名称</td>&#12288; &#12288;
		<td>卷面名称</td>&#12288; &#12288;
		<td>写话成绩</td>&#12288; &#12288;
		<td>背诵成绩</td><br>

		<form action="DanyuanchengjiServlet" method="post"
			onSubmit="return validate(this)">


			<%
				List<Danyuanceshi> list = (List<Danyuanceshi>) request
						.getAttribute("chengji");
				for (int i = 0; i < list.size(); i++) {
			%>
			<td><%=list.get(i).getName()%></td>&#12288;
			&#12288;&#12288; &#12288;
			<td><%=list.get(i).getDanyuan()%></td>&#12288; &#12288;&#12288;
			&#12288;
			<td><%=list.get(i).getJuanmian()%></td>&#12288; &#12288;&#12288;
			&#12288;
			<td><%=list.get(i).getXiehua()%></td>&#12288; &#12288;&#12288;
			&#12288;
			<td><%=list.get(i).getBeisong()%></td>&#12288; &#12288;&#12288;
			&#12288;
			 <br>
			<%
				}
			%>
			
			
		</form>


	</center>
	<form action="FanhuiServlet" method="get"
		onSubmit="return validate(this)">
		<input type="submit" value="返回">
	</form>

</body>
</html>
