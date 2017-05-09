<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>
	
</title>
</head>
<body>
<table>
<thead>

<tr>

<th> Title </th>

<th> Author </th>

<th> Cost </th> 


<th> ISBN </th> 

<th> Type </th> 
 
</tr>
        </thead>
        <tbody>
        



        
			<c:forEach items="${bookList}" var="book">
			<tr>
			   <td>${book.title}</td> 
			   <td>${book.author}</td>
			   <td>${book.cost}</td>
			   <td>${book.isbnNumber}</td>
			   <td>${book.bookType}</td>
			   </tr>
			   
			  <a href ="/addToCart?title=${book.title}">Add To Cart</a>
			  <br>
			  <a href ="/">Back</a>
			   	
			</c:forEach>
			
	        
        </tbody>
    </table>
</body>
</html>