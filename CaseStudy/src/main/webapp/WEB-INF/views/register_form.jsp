<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
<form action ="/registerProcess" method="post">
	First Name <input type = "text" name = "firstName"/> <br>
	Last Name <input type ="text" name = "surname" /> <br>
	Email <input type = "email" name = "email"/> <br>
	Password <input type ="password" name = "password" /> <br>

	<input type = "submit" value = "Register"/>
</form>
</body>
</html>