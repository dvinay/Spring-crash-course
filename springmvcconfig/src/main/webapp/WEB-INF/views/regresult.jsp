<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page isELIgnored="false" %>  --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC Example</title>
</head>
<body>
	User registered successfully. User details are :
	<%= request.getAttribute("user")%>
</body>
</html>