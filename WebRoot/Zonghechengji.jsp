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
		<h2>年级成绩</h2>
	</center>
	<center>
		<%
			request.setCharacterEncoding("UTF-8");
		%>
	</center>
	用户：<%=application.getAttribute("name") %>
	<center>
		<td>课目名称</td>&#12288; &#12288;
		<td>课目成绩</td>&#12288; &#12288;
		<td>图片地址</td>&#12288; &#12288;
		<td>成绩备注</td> <br>

		<form action="ExportServlet" method="post"
			onSubmit="return validate(this)">


			<%
				List<Zonghechengji> list1 = (List<Zonghechengji>) request
						.getAttribute("chengji");
				for (int i = 0; i < list1.size(); i++) {
			%>
			<td><%=list1.get(i).getKemumingcheng()%></td>&#12288;
			&#12288;&#12288; &#12288;
			<td><%=list1.get(i).getChengji()%></td> &#12288; &#12288;&#12288;
			&#12288;
			<td><%=list1.get(i).getTupian()%></td>&#12288; &#12288;&#12288;
			&#12288;
			<td><%=list1.get(i).getBeizhu()%></td>&#12288; &#12288;&#12288;
			&#12288; <br>
			<%
				}
			%>
			
			<td colspan="2" align="center"><input type="submit" value="成绩导出" />
			</td>
		</form>


	</center>
	<form action="FanhuiServlet" method="get"
		onSubmit="return validate(this)">
		<input type="submit" value="返回">
	</form>

</body>
</html>
