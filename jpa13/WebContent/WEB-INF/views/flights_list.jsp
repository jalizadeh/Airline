<%@page import="com.airline.models.Flight"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Flight List</title>
	
	<link rel="stylesheet" href="resources/css/jpaStyles.css">
</head>
<body>
	<h1>List of Flights</h1>
	<table>
		<tr>
			<th>From</th>
			<th>To</th>
			<th>Time</th>
			<th>Price</th>
			<th>Airplane</th>
			<th>Seating</th>
			<th>Number of Pilots</th>
			<th>Pilot Names</th>
		</tr>
		<%
			List<Flight> fList = (List<Flight>) request.getAttribute("flight_list");
			for(Integer i = 0; i < fList.size(); i++){
		%>
			
			<tr>
				<td><%= fList.get(i).getFlightOrigin() %></td>
				<td><%= fList.get(i).getFlightDestination() %></td>
				<td><%= fList.get(i).getFlightTime() %></td>
				<td><%= fList.get(i).getPrice() %></td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
				<td>-</td>
			</tr>
			
		<%
			}
		%>
	</table>
</body>
</html>