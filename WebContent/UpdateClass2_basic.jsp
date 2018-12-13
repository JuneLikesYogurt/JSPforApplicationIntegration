<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import ="bean.class2_basic" %>  
<%@ page import ="java.util.List" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update class2,basic2表</title>
</head>
<body>
	<form action="Update_class2Basic" method="post">
		<% List<class2_basic> list =(List<class2_basic>)request.getAttribute("list");
			//System.out.println(list);
			
			if(list != null && !list.isEmpty()) {
				for(class2_basic basic : list) {
			//id也需要构造，传给updateServlet,再传给update时的查询语句。并把id隐藏
		%>
		id:<input type="text" name="id" value=<%=basic.getID() %> style="display:none">
		name: <input type="text" name="name" value=<%=basic.getName() %>><br>
		age: <input type="text" name="age" value=<%=basic.getAge() %>><br>
		
		<script type="text/javascript">
			var a = <%=basic.getGender() %>;
			console.log(a);
			//alert(a===0);
			if (a===0) {
				var div = document.getElementById("male");
				console.log(div);
				console.log(document.getElementById("male").checked);
				 document.getElementById("male").checked =true
				//$('#male').attr("checked","checked");
				//$('#female').removeAttr("checked");
			} else {
				document.getElementById("female").checked = true
				//$('#female').attr("checked","checked");
				//$('#male').removeAttr("checked");
			}
		</script>
		gender: <input type="radio" name="gender" value="0" id="male" />male 
				<input type="radio" name="gender" value="1" id="female" />female<br>
		
		<%  	}
			}
		%>		
		<input type="submit" value="update">
	</form>
</body>
</html>