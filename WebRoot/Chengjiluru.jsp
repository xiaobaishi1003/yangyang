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
		<h2>成绩录入界面</h2>
	</center>
	用户：<%=application.getAttribute("name") %>
	<form action="ChengjiluruServlet" method="post"
		onSubmit="return validate(this)" enctype="multipart/form-data">
		<center>${info}</center><br>
		<td>年级名称</td>&#12288; &#12288; &#12288; &#12288; &#12288;&#12288;&#12288;
		<td>课目名称</td>&#12288; &#12288; &#12288; &#12288; &#12288;&#12288;&#12288;&#12288;
		<td>课目成绩</td>&#12288; &#12288; &#12288; &#12288; &#12288;&#12288;&#12288;
		<td>图片上传</td>&#12288; &#12288; &#12288; &#12288; &#12288;&#12288;&#12288;
		<td>备注</td> <br>
	     <select name="grade_id">
	    <%
					List<Grade> list = (List<Grade>) request.getAttribute("xueqiming");
					for (int i = 0; i < list.size(); i++) {
				%>
	    	<option value=<%=list.get(i).getGradeid() %>><%=list.get(i).getXueqiming()%></option>
	    <%} %>
	    </select>&#8195;&#8195;&#8195;&#8195;
	    <select name="kemu_id">
	    <%
				List<Kemu> list1 = (List<Kemu>) request.getAttribute("kemu");
				for (int i = 0; i < list1.size(); i++) {
			%>
			<option value=<%=list1.get(i).getKemuid()%>><%=list1.get(i).getName()%></option>
			<%} %> 
	    
	    
	    </select>&#8195;&#8195;&#8195;&#8195;
		
		<input type="text" name="chengji">
		<input type="file" name="tupian"> 
		<input type="text" name="beizhu"/><br>
		<input type="submit" value="提交">
	</form>
	<form action="FanhuiServlet" method="get"
		onSubmit="return validate(this)">
		<input type="submit" value="返回">
	</form>
</body>
</html>
