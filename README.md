# Airline

Source: [The Java EE Course - Build a Java EE App From Scratch](https://www.udemy.com/the-java-ee-course/)

# Servlets and JSP

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



# Enterprise Java Beans

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

#### EJB #11: Singleton Session Enterprise Java Beans
- Definition of `Singleton`
- `CounterBean`, `ShowCount`, `AddOne`

#### EJB #12: Differences between Singleton and Stateful Enterprise Java Beans
- `@Singleton` --> `CounterSingletonBean`
- `@Stateful` --> `CounterStatefulBean`

#### EJB #13: Adding a Stateful bean to the Session Context through Session Context Listener
- A bean can become availabe for all servlets in the application, via storing it in `session`\
 but before keeping it, it is needed to be created for each session among the application and\
 the use (browser), so we need a `SessionListener` and put the `@Stateful` EJB, inside it.\
\
 Then, the EJB is available, via `session.getAttribute(x,y)`


# Java Persistence API JPA & Relational Databases

#### JPA #0: Introduction to the Java Persistence API

#### JPA #0: Starting the Derby JavaDB Database
- [Windows] Run `.../glassfish5/javadb/bin/startNetworkServer.bat` as the DB server\
  As long as the window is open, communication to the DB is possible.

#### JPA 0: Creating a DataSource on the Glassfish server
- #1: "GlassFish Server Administration Console" -> `localhost:4848`

- #2: `Resources` -> `JDBC` -> `JDBC Connection Pools` : `New`
	- Pool Name: `AirlineDB`
	- Resource Type: `javax.sql.DataSource`
	- Database Driver Vendor: `Derby`
	- [ ] Introspect (leave it unchecked)

- #3: `Next`
	- In `Additional Properties` table:
		- Select and delete these from the table
			1. "RetrieveMessageText"
			2. "ShutdownDatabase"
			3. "CreateDatabase"
			4. "SSL"
			5. "TraceFile"
			6. "DataSourceName"
			7. "TraceDirectory"
			8. "SecurityMechanism"
			9. "TraceLevel"
			10. "TraceFileAppend"
			11. "LoginTimeout"
		- User: `Airline`
		- DatabseName: `airline`
		- Description: `Database for airline application`
		- Password: `Airline`
		- PortNumber: `1527` (according to DB server)
		- ConnectionAttributes: `;create=true`

- #4: `Finish`

- #5: `Resources` -> `JDBC` -> `JDBC Connection Pools` -> `AirlineDB` : `General`
	- `Ping` to test if everything is fine

- #6: `Resources` -> `JDBC` -> `JDBC Resources` : `New`
	- JNDI Name: `jdbc/airline`
	- Pool Name: `AirlineDB`

- #7: `OK`





# How To Use
- You need a [GlassFish](https://javaee.github.io/glassfish/) server for running the projects. 
- Import each project you need
- Add it to the server

Note:\
 #1: It is better not to add more than one project at a time. I did not change all the configuration,\
 paths & ... of the projects, so there maybe there is some conflicts while running the application\
 on the server.\
 \
 #2: Use the application via your browser at the address `localhost:8080/project_name/servlet_name`\
 \
 #3: Try to exit the browser (to terminate the project's session), and open the newly deployed\
 project, in a new browser.


# Technologies
- Eclipse IDE
- Java 1.8
- GlassFish5
- Apche Derby DB [included in GlassFish5]