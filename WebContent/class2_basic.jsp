<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import ="bean.class2_basic" %>  
<%@ page import ="java.util.List" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>class2_basic</title>
<style>
	* {
		margin: 50px;
		padding: 0;
	}
	form input {
		margin: 10px auto;
	}
</style>
</head>
<body>
	<form action="class2Basic_Servlet" method="post">
		name: <input type="text" name="name"><br>
		age: <input type="text" name="age"><br>
		gender: <input type="radio" name="gender" value="0">male 
				<input type="radio" name="gender" value="1">female<br>
				
		<input type="submit" value="submit">
	</form>
	
	<table width="40%" border="1" style="margin-top:50px">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>age</th>
			<th>gender</th>
			<th>删除</th>
		</tr>
		<% List<class2_basic> class2Basic=(List<class2_basic>)request.getAttribute("class2Basic");
			if(class2Basic != null && !class2Basic.isEmpty()) {
				for(class2_basic basic : class2Basic) {
		%>
			<tr>
				<td><%=basic.getID() %></td>
				<td><%=basic.getName() %></td>
				<td><%=basic.getAge() %></td>
				<td><%=basic.getGender() %></td>
				<td> <a href="class2Basic_Delete?id=basic.getId()">删除</a> </td>
			</tr>
		<%  	}
			}
		%>
	</table>
</body>
</html>