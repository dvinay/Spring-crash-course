<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page isELIgnored="false" %>  --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Registration</title>
</head>
<body>
	<form action="registerUser" method="POST">
		<pre>
			ID: <input type="text" name="id"/>
			Name: <input type="text" name="name"/>
			Email: <input type="text" name="email"/>
			<input type="submit" name="Register">
		</pre>
	</form>
</body>
</html>