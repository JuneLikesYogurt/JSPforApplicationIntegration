<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import ="bean.class2_basic" %>  
<%@ page import ="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Class2,basic表</title>
</head>
<body>
	<table width="40%" border="1" style="margin-top:50px">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>age</th>
			<th>gender</th>
			<th>修改</th>
			<th>删除</th>
		</tr>
		<% List<class2_basic> list =(List<class2_basic>)request.getAttribute("list");
			if(list != null && !list.isEmpty()) {
				for(class2_basic basic : list) {
		%>
			<tr>
				<td><%=basic.getID() %></td>
				<td><%=basic.getName() %></td>
				<td><%=basic.getAge() %></td>
				<td><%=basic.getGender() %></td>
				<td> <a href="FindOne_class2Basic?id=<%=basic.getID()%>">修改</a> </td>
				<td> <a href="Delete_class2Basic?id=<%=basic.getID()%>">删除</a> </td>
			</tr>
		<%  	}
			}
		%>
	</table>
	
	<h2 align="center">
		<a href="AddClass2_basic.jsp">新增一条class2,basic表内容</a>
	</h2>
	<h2 align="center">
		<a href="index.jsp">返回index</a>
	</h2>
</body>
</html>