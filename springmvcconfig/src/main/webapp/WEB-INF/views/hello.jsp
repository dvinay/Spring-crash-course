<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC Example</title>
</head>
<body>
	<%
		Integer id = (Integer) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		Integer salary = (Integer) request.getAttribute("salary");
		out.print("Id : " + id +" Name : " + name + " Salary : " + salary);
	%>
	<br/>
	Id : <b> ${id} </b>
	Name : <b> ${name} </b>
	Salary : <b> ${salary} </b>
</body>
</html>