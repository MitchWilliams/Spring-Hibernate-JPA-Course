<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Book Store</title>
</head>
<body>

    <form action ="/bookSearch" method="post">
	Title <input type = "text" name = "title"/> <br>
	<input type = "submit" value = "Search"/>
	</form>
<h2>Books in stock</h2>

 <table>
<thead>

<tr>

<th> Title </th>

<th> Author </th>

<th> Cost </th> 

 
</tr>
        </thead>
        <tbody>
        
			<c:forEach items="${bookList}" var="book">
			<tr>
			   <td> 
			   <a href ="/book_details?title=${book.title}">${book.title}</a>
			   </td> 
			   <td> ${book.author}</td>
			   <td>${book.cost}</td>
			   </tr>
			</c:forEach>
			
	        
        </tbody>
    </table>
    
<a href = "/viewCart">View Cart</a>
<a href = "/myAccountRedirect">My Account</a>
<a href = "/register">Register</a>



</body>
</html>