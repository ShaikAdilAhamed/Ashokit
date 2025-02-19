<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration</title>
</head>
<body>
	<h1>Page under construction</h1>
	
	<a href="/">Add new Student</a>
	<table border="1">
	   <thead>
	      <tr>
	         <th>S.No</th>
	         <th>Name</th>
	         <th>Email</th>
	         <th>Gender</th>
	         <th>Course</th>
	         <th>Timings</th>    
	      </tr>
	   </thead>
	   
	   
	   <tbody>
	   
	   <c:forEach var="student" items="${students}">
	    <tr>
	            <td>${student.sid}</td>
	            <td>${student.name}</td>
	            <td>${student.email}</td>
	            <td>${student.gender}</td>
	            <td>${student.course}</td>
	            <td>${student.timings}</td>
	         </tr>
	   </c:forEach>
	    
	   </tbody>
	</table>
</body>
</html>