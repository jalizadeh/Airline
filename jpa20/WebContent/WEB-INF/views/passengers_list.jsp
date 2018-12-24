<%@page import="com.airline.models.Passenger"%>
<%@page import="com.airline.models.Pilot"%>
<%@page import="com.airline.models.Flight"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Passengers List</title>
	
	<link rel="stylesheet" href="resources/css/jpaStyles.css"/>
</head>
<body>
	<h1>List of Flights</h1>
	<table>
		<tr>
			<th>Id</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Date of Birth</th>
			<th>Gender</th>
		</tr>
		<%
			List<Passenger> pList = (List<Passenger>) request.getAttribute("passengers_list");
			for(Integer i = 0; i < pList.size(); i++){
		%>
			
			<tr>
				<td><%= pList.get(i).getId() %></td>
				<td><%= pList.get(i).getFirstName() %></td>
				<td><%= pList.get(i).getLastName() %></td>
				<td><%= pList.get(i).getDob() %></td>
				<td><%= pList.get(i).getGender() %></td>
			</tr>
			<tr>
				<td colspan="4">No flight ticket yet.</td>
			</tr>
			
		<%
			}//for i
		%>
	</table>
</body>
</html>