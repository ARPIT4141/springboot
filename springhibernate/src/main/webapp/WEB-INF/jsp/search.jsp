<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix="c"%>
<%@page isELIgnored="false"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
	<div align=center>

		<h1>Search Records</h1>
		<form:form action="search" method="post" modelAttribute="bean">
Enter color :
		<input name="colour" /> &nbsp;
Enter size :
		<input name="size" />
Enter gender
		<input name="gender" />
Preferences :		
			<select name="preference">
				<option value="price">price</option>
				<option value="rating">rating</option>
			</select>

			<input type="submit" value="Search" />

			<br />
			<br />

		</form:form>


		<table border="2" width="90%">

			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Color</th>
				<th>Gender</th>
				<th>Size</th>
				<th>Price</th>
				<th>Rating</th>
				<th>Availability</th>
			</tr>
			<c:forEach var="tab" items="${li }">
				<tr class="dataitems">
					<td align=center>${tab.id }</td>
					<td align=center>${tab.name }</td>
					<td align=center>${tab.colour }</td>
					<td align=center>${tab.gender }</td>
					<td align=center>${tab.size }</td>
					<td align=center>${tab.price }</td>
					<td align=center>${tab.rating }</td>
					<td align=center>${tab.availability }</td>
				</tr>
			</c:forEach>
		</table>


		<h2>${msg }</h2>

	</div>

</body>
</html>