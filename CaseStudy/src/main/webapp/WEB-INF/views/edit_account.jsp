<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Account</title>
</head>
<body>
	<c:forEach items="${custList}" var="cust">
		<form action ="/editProcess" method="post">
			First Name <input type = "text" name = "firstName" value="${cust.firstName}"/> <br>
			Last Name <input type ="text" name = "surname" value="${cust.surname}" /> <br>
			Email <input type = "email" name = "email" value="${cust.email}" /><br>
			Password <input type ="password" name = "password" value="${cust.password}"/> <br>
		
			<input type = "submit" value = "Submit"/>
		</form>
	
	</c:forEach>
			
</body>
</html>