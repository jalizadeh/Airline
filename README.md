# Airline

Source: [The Java EE Course - Build a Java EE App From Scratch](https://www.udemy.com/the-java-ee-course/)

#### Web #1: Creating a Servlet for adding passengers to a flight
- very fisrt configs
- direct html data sent via response

#### Web #2: Creating a JSP for showing an add passenger form
- `views` added
- forwarding to `add_passenger.jsp`

#### Web #3: Creating an HTML form in our JSP for adding passengers
- POST & GET definition

#### Web #4: Adding static resources to our JSP for better styling
- normalize.css & theme.css added

#### Web #5: Creating a Java class that represents a passenger on a flight
- Passenger & Gender classes added

#### Web #6: Getting passenger form data into a new passenger object on form submission
- getting the data sent from the form

#### Web #7: Validating the form values the user submitted
- `request.setAttribute()`

#### Web #8: Showing form error messages
- `theme.css` > `li.error`

#### Web #9: Handling successfull form submission #1
- `response.sendRedirect("");`
- `MainPage`

#### Web #10: Creating a Servlet Context Listener and adding the passenger list to the context
- `AirlineListener`

#### Web #11: Synchronization and Thread Safety when adding new passengers
- BUG fixed: the `pList` creation was miswritten in `AirlineListener`

#### Web #12: Improving form validation
- Bug fixed: misspell in class `Passenger`, `dao` changed to `dob`

#### EJB #1: Creating a Stateless Session Bean
- `com.airline.service.FlightService`

#### EJB #2: Injecting an EJB into a Servlet
- `com.jalizadeh.controllers.FlightDetails` >	BUG: line #27 must be uncommented

#### EJB #3: Nature of Stateless Session Enterprise Java Beans - part I

#### EJB #4: Nature of Stateless Session Enterprise Java Beans - part II

#### EJB #5: Looking up EJBs through Java Naming and Directory Interface JNDI
- `@EJB` is commented

#### EJB #6: Session Beans Implementing a Local Interface
- `FlightService implements FlightLocal` inerface
- `FlightLocal` has `@Local` annotation
- `private FlightLocal fs;` has `@EJB` annotation

#### EJB #7: Session Beans Implementing a Remote Interface
- `FlightService implements FlightLocal, FlightRemote` interfaces
- `FlightRemote` has `@Remote` annotation
- `private FlightRemote fsRemote;` has `@EJB` annotation

#### EJB #8: Stateful Session Enterprise Java Beans
- `FlightRemote` deleted. not needed anymore
- `@Stateless (name = "flightStateless")` & `@Stateful (name = "flightStateful")`
- `@EJB (beanName = "...")`

#### EJB #9: Differences between Stateful and Stateless EJBs
- `fs2` & `fsStateful2`

#### EJB #10: Looking up Stateful EJBs through Java Naming and Directory Interface JNDI
- EDIT: `com.jalizadeh.controllers` -> `com.airline.controllers`