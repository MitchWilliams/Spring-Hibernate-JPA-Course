<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Successful</title>
</head>
<body>
			<c:forEach items="${logged_in_user}" var="user">
			
			<h4>Welcome <c:out value="${user.firstName}"/></h4>

			</c:forEach>
			
     <a href ="/">Home</a> <br>
     <a href = "/viewCart">View Cart</a>
     <a href = "/checkoutRedirect">Checkout</a>
</body>
</html>