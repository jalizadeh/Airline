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
	<title>Flight List</title>
	
	<link rel="stylesheet" href="resources/css/jpaStyles.css"/>
</head>
<body>
	<h1>List of Flights</h1>
	<table>
		<tr>
			<th>Id</th>
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
				<td><%= fList.get(i).getId() %></td>
				<td><%= fList.get(i).getFlightOrigin() %></td>
				<td><%= fList.get(i).getFlightDestination() %></td>
				<td><%= fList.get(i).getFlightTime() %></td>
				<td><%= fList.get(i).getPrice() %></td>
				
				<td><%= fList.get(i).getAirplaneDetail().getPlaneMake() + " " + fList.get(i).getAirplaneDetail().getModelName() %></td>
				<td><%= fList.get(i).getAirplaneDetail().getSeatingCapacity() %></td>

				<td>
					<!-- I have to check if there is any pilot or not -->
					<% if(fList.get(i).getPilots() != null){ %>
						<%= fList.get(i).getPilots().size() %>
					<% } else { %>
						No pilot
					<% } %>
				</td>				
				<td>
					<% 
						if(fList.get(i).getPilots() != null){ 
							List<Pilot> pList = (List<Pilot>) fList.get(i).getPilots();
							for(Integer j = 0; j < pList.size(); j++){
					%>
							<%= 
								(j+1) + ") " + pList.get(j).getFirstName() + " " + pList.get(j).getLastName() 
								+ " {" + pList.get(j).getPilotRank() + "}<br/>"   
							 %>
					<% 
							}//for j
						}//if
					%>
				</td>
			</tr>
			
			<tr>
				<td colspan="9">
					<%
						if(fList.get(i).getPassengers().size() > 0) {
							List<Passenger> pList = (List<Passenger>)fList.get(i).getPassengers(); 
							for(int k = 0; k < pList.size(); k++){
					%>
						<%= (k+1) + ") " + pList.get(k).getFirstName() + " " + pList.get(k).getLastName() + "<br/>"  %>
					<%
							}//for
						} else {
					%>
						There is no passenger in this flight.
					<%
						}//else if
					 %>
				</td>
			</tr>
			
		<%
			}//for i
		%>
	</table>
</body>
</html>