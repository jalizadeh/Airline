<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Add Passenger</title>
	
	<link rel="stylesheet" href="resource/css/normalize.css">
	<link rel="stylesheet" href="resource/css/theme.css">
</head>
<body>
	<div class="container" >
		<div class="title">Add a passenger</div>
		
		<% 
			//there is any error? show it
			if(request.getAttribute("errors") != null) { 
		%>
			<fieldset>
				<legend>Errors in Fields</legend>
				<ul>
					<% if(request.getAttribute("firstname_error") != null) { %>
						<li class="error">First name is empty</li> 	
					<% } %>
					
					<% if(request.getAttribute("lastname_error") != null) { %>
						<li class="error">Last name is empty</li> 	
					<% } %>
					
					<% if(request.getAttribute("date_format_error") != null) { %>
						<li class="error">Date format is not valid. It must be "month/day/year"</li> 	
					<% } %>
				</ul>
			</fieldset>
			
		<% } %>
		
		<fieldset>
			<legend>Passenger details:</legend>
			
			<form action="AddPassenger" method="post">
				<div class="inputField">
					<label for="first-name">First name</label>
					<input name="first-name" type="text"/>
				</div>
				<div class="inputField">
					<label for="last-name">Last name</label>
					<input name="last-name" type="text"/>
				</div>
				<div class="inputField">
					<label for="dob">Date of Birth</label>
					<input name="dob" type="text"/>
				</div>
				<div class="inputField">
					<label for="gender">Gender</label>
					<select name="gender">
						<option value="Male">Male</option>
						<option value="Female">Female</option>
					</select>
				</div>
			</fieldset>
		
			<div class="inputField" id="submitField">
				<input type="submit" id="submitBtn" value="Add new passenger"/>
			</div>
		</form>
		
	</div>
</body>
</html>