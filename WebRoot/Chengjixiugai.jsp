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
		<h2>成绩修改界面</h2>
	</center>
	用户：<%=application.getAttribute("name") %>
	<form action="ChengjixiugaiServlet" method="post"
		onSubmit="return validate(this)">
		<center>
			<a>${info}</a>
		</center>
		<br>

		<td>年级名称</td>&#12288; &#12288; &#12288; &#12288;
		&#12288;&#12288;&#12288;
		<td>课目名称</td>&#12288; &#12288; &#12288; &#12288;
		&#12288;&#12288;&#12288;&#12288;
		<td>课目成绩</td>&#12288; &#12288; &#12288; &#12288;
		&#12288;&#12288;&#12288;
		<td>修改成绩</td>&#12288; &#12288; &#12288; &#12288;
		&#12288;&#12288;&#12288;<br>

	</form>

	<form action="ChengjixiugaiServlet" method="post"
		onSubmit="return validate(this)">


		<%
			List<Zonghechengji> list1 = (List<Zonghechengji>) request
					.getAttribute("chengji");
			for (int i = 0; i < list1.size(); i++) {
		%>
		<input type="hidden" name="grade_kemu_id"
			value=<%=list1.get(i).getGrade_id() + ","
						+ list1.get(i).getKemu_id()%>
			style="width:100px;height:30px;">
		<td><%=list1.get(i).getXueqiming()%></td>
		<td><%=list1.get(i).getKemumingcheng()%></td>
		<td><%=list1.get(i).getChengji()%></td> 
		<input type="text"	name="newchengji"><br>

		<%
			}
			//session.setAttribute("chengjilist", list1);
		%>


		<input type="submit" value="提交">
	</form>
	<form action="FanhuiServlet" method="get"
		onSubmit="return validate(this)">
		<input type="submit" value="返回">
	</form>
</body>
</html>
