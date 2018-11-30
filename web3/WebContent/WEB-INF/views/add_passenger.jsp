<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Passenger</title>
</head>
<body>
	<div class="container" >
		<div class="title">Add a passenger</div>
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
					<label for="first-name">Gender</label>
					<select>
						<option value="male">Male</option>
						<option value="female">Female</option>
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