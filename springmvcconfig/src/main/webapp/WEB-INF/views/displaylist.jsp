<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List , com.fuppino.spring.springmvc.dto.Employee"%>
<%-- <%@ page isELIgnored="false" %>  --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring MVC Example</title>
</head>
<body>
	<%
	List<Employee> employees = (List<Employee>)request.getAttribute("employees");
	for(Employee e : employees) {
		out.println(e.getId());
		out.println(e.getName());
		out.println(e.getSalary());
	}
	%>
</body>
</html>