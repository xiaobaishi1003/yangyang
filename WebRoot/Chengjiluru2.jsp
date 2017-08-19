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
    <center>单元测试成绩修改页面</center>
    用户：<%=application.getAttribute("name") %>
    <form action="Chengjiluru2Servlet" method="post"
		onSubmit="return validate(this)">
		<center><a >${info}</a></center><br>
		<td>年级名称</td>
		<td>课目名称</td>
		<td>单元名称</td>
		<td>卷面成绩</td>
		<td>写话成绩</td>
		<td>背诵成绩</td><br>
		
		<select name="grade_id">
	    <%
					List<Grade> list = (List<Grade>) request.getAttribute("xueqiming");
					for (int i = 0; i < list.size(); i++) {
				%>
	    	<option value=<%=list.get(i).getGradeid() %>><%=list.get(i).getXueqiming()%></option>
	    <%} %>
	    </select>
	    <select name="kemu_id">
	    <%
				List<Kemu> list1 = (List<Kemu>) request.getAttribute("kemu");
				for (int i = 0; i < list1.size(); i++) {
			%>
			<option value=<%=list1.get(i).getKemuid()%>><%=list1.get(i).getName()%></option>
			<%} %>     
	    </select> 
	    <input type="text" name = "danyuan">
	    <input type="text" name = "juanmian">
	    <input type="text" name = "xiehua">
	    <input type="text" name = "beisong"><br>
		<input type="submit" value="提交">	
	</form>
	<form action="FanhuiServlet" method="get"
		onSubmit="return validate(this)">
		<input type="submit" value="返回">
	</form>
  </body>
</html>
