# Airline

Source: [The Java EE Course - Build a Java EE App From Scratch](https://www.udemy.com/the-java-ee-course/)

##### Web #1:
- very fisrt configs
- direct html data sent via response

##### Web #2:
- `views` added
- forwarding to `add_passenger.jsp`

##### Web #3:
- form added
- POST & GET definition

##### Web #4:
- normalize.css & theme.css added

##### Web #5:
- Passenger & Gender classes added

##### Web #6:
- getting the data sent from the form

##### Web #7:
- form validation
- `request.setAttribute()`

##### Web #8:
- showing form error messages
- `theme.css` > `li.error`

##### Web #9:
- handling successfull form submission #1
- `response.sendRedirect("");`
- `MainPage`

##### Web #10:
- creating a Servlet Context Listener and adding the passenger list to the context
- `AirlineListener`

##### Web #11:
- Synchronization and Thread Safety when adding new passengers
- BUG fixed: the `pList` creation was miswritten in `AirlineListener`

##### Web #12:
- Improving form validation
- Bug fixed: misspell in class `Passenger`, `dao` changed to `dob`

##### EJB #1:
- Creating a Stateless Session Bean
- `com.airline.service.FlightService`

##### EJB #2:
- Injecting an EJB into a Servlet
- `com.jalizadeh.controllers.FlightDetails` >	BUG: line #27 must be uncommented

##### EJB #3:
- Nature of Stateless Session Enterprise Java Beans - part I

##### EJB #4:
- Nature of Stateless Session Enterprise Java Beans - part II