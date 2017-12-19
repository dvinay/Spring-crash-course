<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		alert("data");
		$("#id").change(function() {
			alert("check");
			$.ajax({
				url : 'validateEmail',
				data : {
					id : $("#id").val()
				},
				success : function(responseText) {
					$("#errMsg").text(responseText);
					if (responseText != "") {
						$("#id").focus();
					}
				}
			});
		});
	});
</script>
<title>User Registration</title>
</head>
<body>
	<form action="registerUser" method="POST">
		<pre>
			Id : <input type="text" name="id" id="id"><span id="errMsg"></span>
			Name : <input type="text" name="name">
			Email : <input type="text" name="email">
			<input type="submit" name="Create User">
		</pre>
	</form>
	<br /> ${result}
</body>
</html>