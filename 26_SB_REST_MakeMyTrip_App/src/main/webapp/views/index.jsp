<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Enter Passenger Info</h3>
	<form action="/bookTicket" method="post">
		<table>
			<tr>
				<td>Fname:</td>
				<td><input type="text" name="fname"></td>
			</tr>

			<tr>
				<td>Lname:</td>
				<td><input type="text" name="lname"></td>
			</tr>

			<tr>
				<td>DOJ:</td>
				<td><input type="text" name="doj"></td>
			</tr>

			<tr>
				<td>From:</td>
				<td><input type="text" name="from"></td>
			</tr>
			<tr>
				<td>To:</td>
				<td><input type="text" name="to"></td>
			</tr>

			<tr>
				<td>Train number</td>
				<td><input type="text" name="trainNum"></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="Submit" value="Book Ticket"></td>
			</tr>
		</table>
		<a href="search">Search Ticket</a>
	</form>
</body>
</html>