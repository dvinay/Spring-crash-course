<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="registerUser" method="POST">
		<pre>
			Id : <input type="text" name="id">
			Name : <input type="text" name="name">
			Email : <input type="text" name="email">
			<input type="submit" name="Create User">
		</pre>
	</form>
	<br/>
	${result}
</body>
</html>