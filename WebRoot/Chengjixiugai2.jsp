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
		<h2>单元成绩修改界面</h2>
	</center>
	用户：<%=application.getAttribute("name") %>
	<form action="Chengjixiugai2Servlet" method="post"
		onSubmit="return validate(this)">
		<center><a >${info}</a></center><br>
		
		<td>年级名称</td>&#12288; &#12288; &#12288; 
		<td>课目名称</td>&#12288; &#12288; &#12288; 
		<td>卷面成绩</td>&#12288; &#12288; &#12288; 
		<td>写话成绩</td>&#12288; &#12288; &#12288; 
		<td>背诵成绩</td>&#12288; &#12288; &#12288; 
		<td>修改成绩</td>&#12288; &#12288; &#12288; 
		<br>
		
	</form>
	
	<form action="Chengjixiugai2Servlet" method="post"
			onSubmit="return validate(this)">
			
			
			<%
				List<Danyuanceshi> list1 = (List<Danyuanceshi>) request.getAttribute("chengji");
				for (int i = 0; i < list1.size(); i++) {
			%>
			<td><%=list1.get(i).getXueqiming()%></td>
			<td><%=list1.get(i).getName()%></td>
			<td><%=list1.get(i).getJuanmian()%></td>
			<td><%=list1.get(i).getXiehua()%></td>
			<td><%=list1.get(i).getBeisong()%></td>
	
			<input type="text" name="chengji">
			<input type="submit" value="提交"><br>
			<%
				}
			%>
			
			
	</form>
	<form action="FanhuiServlet" method="get"
		onSubmit="return validate(this)">
		<input type="submit" value="返回">
	</form>
  </body>
</html>
