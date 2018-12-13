<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增class2,basic表</title>
</head>
<body>
	<form action="Add_class2Basic" method="post">
		name: <input type="text" name="name"><br>
		age: <input type="text" name="age"><br>
		gender: <input type="radio" name="gender" value="0">male 
				<input type="radio" name="gender" value="1">female<br>
				
		<input type="submit" value="submit">
	</form>
	
	<h2 align="center">
		<a href="Find_class2Basic">查看class2，basic表所有内容</a>
	</h2>
</body>
</html>