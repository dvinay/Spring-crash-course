<html>
<body>
	<%
		Integer id = (Integer) request.getAttribute("id");
		String name = (String) request.getAttribute("name");
		Integer salary = (Integer) request.getAttribute("salary");
		out.print("Id : " + id +" Name : " + name + " Salary : " + salary);
	%>
</body>
</html>
