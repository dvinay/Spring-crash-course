<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="2px">
	<tr>
		<th>id</th>
		<th>name</th>
		<th>email</th>
	</tr>

	<c:forEach items="${users}" var="user">
	<tr>
		<th>${user.id}</th>
		<th>${user.name}</th>
		<th>${user.email}</th>
	</tr>
	</c:forEach>	
</table>

</body>
</html>