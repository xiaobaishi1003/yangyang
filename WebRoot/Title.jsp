<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="want.*"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>个人成绩系统</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	<tr>
		用户：<%=application.getAttribute("name") %>
	</tr>
	<center>
		<tr>
			<center>
			<Button id="年级增加" onclick="window.location.href='Nianjizengjia.jsp'">年级增加</button>&#12288;&#12288;&#12288;
			<Button id="课目增加" onclick="window.location.href='AddKemu.jsp'">课目增加</button>&#12288;&#12288;&#12288;
			<Button id="年级删除" onclick="window.location.href='DeleteNianji.jsp'">年级删除</button>&#12288;&#12288;&#12288;
			<Button id="课目删除" onclick="window.location.href='DeleteKemu.jsp'">课目删除</button>&#12288;&#12288;&#12288;
			</center>
			<br>
			<form action="KemuQueryServlet" method="post" />
			<input type="submit" name="username" value="课目总成绩查询">
			</form>
			
			<td>综合成绩</td>
			<br>
			<form action="TitleServlet" method="post" />
			<input type="submit" name="username" value="成绩录入">
			</form>
			<form action="XiugaiServlet" method="post" />
			<input type="submit" name="username" value="成绩修改">
			</form>
			
			<form action="ZonghechengjiServlet" method="post"
				onSubmit="return validate(this)">
				<%
					List<Grade> list = (List<Grade>) request.getAttribute("xueqiming");
					for (int i = 0; i < list.size(); i++) {
				%>

				<input type="radio" name="grade_id"
					value=<%=list.get(i).getGradeid()%>
					style="width:100px;height:30px;">
				<%=list.get(i).getXueqiming()%><br>

				<%
					}
				%>
				<input type="submit" value="提交" style="width:100px;height:30px;">
				<br>
			</form>
			
			<center>
				<td>单元成绩</td> <br>
			</center>
			
			<form action="Title2Servlet" method="post" />
			<input type="submit" name="username" value="成绩录入">
			</form>
			
			<form action="Xiugai2Servlet" method="post" />
			<input type="submit" name="username" value="成绩修改">
			</form>
			
			<form action="DanyuanceshiServlet" method="post"
				onSubmit="return validate(this)">
				<%
					List<Grade> list1 = (List<Grade>) request.getAttribute("xueqiming");
					for (int i = 0; i < list1.size(); i++) {
				%>

				<input type="radio" name="grade_id"
					value=<%=list1.get(i).getGradeid()%>
					style="width:100px;height:30px;">
				<%=list.get(i).getXueqiming()%><br>

				<%
					}
				%>
				<input type="submit" value="提交" style="width:100px;height:30px;">
				<br>
			</form>
			
		</tr>
	</center>
</body>
</html>