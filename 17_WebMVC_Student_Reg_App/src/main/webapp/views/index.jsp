<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>${msg }</h2>
	<h3>Student Registration Form</h3>
	<!-- action="" which controller method to call when it is submitted -->
	<!-- modelAttribute  what is the binding class -->
	<form:form action="/save" modelAttribute="student" method="POST">

		<table>

			<tr>
				<td>Name:</td>
				<td><form:input path="name" /></td><!-- path="name"  ->  student binding class name varible -->
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td><!-- path="email"  ->  student binding class email varible -->
			</tr>
			<tr>
				<td>Gender:</td>
			    <!--path="gender"  ->  student binding class gender varible -->
				<td><form:radiobutton path="gender" value="male" />Male 
				    <form:radiobutton path="gender" value="female"/>Female
				</td>
			</tr>

			<tr>
				<td>Course:</td>
				<!-- path="course"  ->  student binding class course varible -->
				<td><form:select path="course">
                        <form:options items="${courses}"/><!-- ${courses} this data is getting from controller -->
					</form:select></td>
			</tr>
			
			<tr>
                <td>Timings:</td>
                <td>
                    <form:checkboxes items="${timing}" path="timings" />
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Save"></td>
            </tr>

		</table>

	</form:form>
	<a  href="viewStudents"> View Students</a>
</body>
</html>