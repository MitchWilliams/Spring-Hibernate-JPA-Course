<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
</head>
<body>

<h2>Order Overview</h2>

<table>
<thead>

<tr>

<th> Title </th>

<th> Author </th>

<th> Cost </th> 

<th> Type </th> 
 
</tr>
        </thead>
        <tbody>
			<c:forEach items="${bookList}" var="book">
			<tr>
			   <td>${book.title}</td> 
			   <td>${book.author}</td>
			   <td>${book.cost}</td>
			   <td>${book.bookType}</td>
		   </tr>
			</c:forEach>       
        </tbody>
    </table>
    
    
    <h2>Payment/Delivery Details</h2>

	<form action ="/orderCompleted" method="post">
		Street <input type = "text" name = "street"/> <br>
		City <input type = "text" name = "city"/> <br>
		Postcode <input type = "text" name = "postcode"/> <br><br><br>
		
		Card Number <input type = "text" name = "cardNumber"/> <br>
		Expiry Date <input type = "text" name = "expDate"/> <br>

	
		<input type = "submit" value = "Submit"/>
	</form>
	
	<a href = "/">Home Page</a>
</body>
</html>