<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Account</title>
</head>
<body>

 <table>
<thead>

<tr>

<th> Name </th>

<th> Email </th>

 
</tr>
        </thead>
        <tbody>
        
			<c:forEach items="${custList}" var="cust">
			<tr>
			   <td> ${cust.firstName}  ${cust.surname } </td> 
			   <td> ${cust.email}</td>
			   </tr>
			</c:forEach>
			
	        
        </tbody>
    </table>

<a href ="/">Home</a> <br>
<a href ="/editAccount">Edit Account Details</a> <br>
<a href ="/orderHistory">Order History</a> <br>
<a href = "/logout"> Logout</a>
</body>
</html>