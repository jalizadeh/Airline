# [Airline](#)

Source: [The Java EE Course - Build a Java EE App From Scratch](https://www.udemy.com/the-java-ee-course/)

# [Servlets and JSP](#)

#### Web #1: Creating a Servlet for adding passengers to a flight
- very first configurations
- direct html data sent via `response`

#### Web #2: Creating a JSP for showing an add passenger form
- `views` added
- forwarding to `add_passenger.jsp`

#### Web #3: Creating an HTML form in our JSP for adding passengers
- POST & GET definition

#### Web #4: Adding static resources to our JSP for better styling
- `normalize.css` & `theme.css` added

#### Web #5: Creating a Java class that represents a passenger on a flight
- `Passenger` & `Gender` classes added

#### Web #6: Getting passenger form data into a new passenger object on form submission
- getting the data sent from the form

#### Web #7: Validating the form values the user submitted
- `request.setAttribute(#)`

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
- BUG: misspell in class `Passenger`
- BUG: `dao` changed to `dob`



# [Enterprise Java Beans](#)

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


# [Java Persistence API JPA & Relational Databases](#)

#### JPA #0: Introduction to the Java Persistence API

#### JPA #0: Starting the Derby JavaDB Database
- [Windows] Run `.../glassfish5/javadb/bin/startNetworkServer.bat` as the DB server\
  As long as the window is open, communication to the DB is possible.

#### JPA 0: Creating a DataSource on the Glassfish server
- #1: `GlassFish Server Administration Console` -> `localhost:4848`

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

#### JPA 0: Connecting to the database with Eclipse
- Driver: `Derby Client JDBC Driver`  (check notes down)
- Database: `Airline`
- Host: `localhost`
- Port number: `1527` 
- User name: `Airline`
- Password: `Airline`
- [x] Create database (if required)
- [x] Save password
- URL: `jdbc:derby://localhost:1527/airline;create=true`


Notes\
- When you are creating a new DB Profile, yoou must have all the fields above, if you don't see exactly the same, everything will be wrong in the future. Make sure that the driver is `Derby Client JDBC Driver`, and by clicking on the "Triangle 🔺" button (Edit Driver Definition) & in the "Jar List" tab, check if the `driver file` is set to `derbyclient.jar`.
- If everything is fine, by pressing the button `Test Connection`, in the folder `...\glassfish5\javadb\bin`, a folder will be created with the name `airline` and a pop-up will tell you `Ping Succeeded`.
- If you don't see this folder, be sure something is wrong:
	- You didn't configure `Derby` properly. [click](https://db.apache.org/derby/papers/DerbyTut/install_software.html)
	- Update your IDE to have the latest drivers & JAR libraries. You may face [this problem](https://bugs.eclipse.org/bugs/show_bug.cgi?id=536970) in `JPA 2` and later
- After finishing creating a new DB Profile, in `Data Source Explorer` tab, if the database's name is like `Airline (Apache Derby v. 10.14.2.0 - (Unversioned))`, be sure you didn't configure Derby properly. Instead of `Unversioned` there must be a number like "1828579".

#### JPA 1: Creating a Persistence Unit
- creating `jpa1` project
- configuring `persistent.xml`

#### JPA 2: Creating a JPA Entity class for passengers
- `Passenger`, `Gender`, `FlightClass`
- `@Entity`
- `@Transient`
- `@Id` & `@GeneratedValue(strategy = GenerationType.AUTO)`
- `@Temporal(TemporalType.DATE)`
- `@Enumerated(EnumType.STRING)` & `@Enumerated(EnumType.STRING)`


Note:
- If you face `EJB Exception` or `JPAx can not be deployed`, try to remove the project from server and add it again.


#### JPA 3: Injecting an Entity Manager associated with out Persistence Unit
- `PassengerService`
- `@PersistenceContext(unitName="airline")`
- I don't know what's wrong with my DB or IDE or .... I did everything as the video said,\
	but, no data is saved in the DB.

#### JPA 4: Adding new JPA Entity classes for flight and airplane
- classes `FlightDestinations` & `Airplane` & `FlightDestinations` added


#### JPA 5: One to One relationship between Flight and Airplane
|`Flight`|`Airplane`|
|-|-|
|@OneToOne<br>@JoinColumn(name = "airplane_fk")<br>private Airplane airplaneDetail;|@OneToOne(mappedBy = "airplaneDetail")<br>private Flight flight;|


#### JPA 6: Persisting objects in a One to One relationship Flight and Airplane
- `FlightService`
- `AddFlight`


#### JPA 7: One to Many relationship annotations flights and its pilots
- `Pilot` & `PilotRank`

|`Pilot`|`Flight`|
|-|-|
|@ManyToOne<br>@JoinColumn(name = "flight_fk")<br>private Flight flightForPilot;|@OneToMany(mappedBy = "flightForPilot")<br>private List<Pilot> pilots;|


#### JPA 8: Persisting pilot objects - One to Many relationship groundwork
- `PilotService` & `AddPilot`


#### JPA 9: Named Queries on Entity classes
- `@NamedQuery(name="Flight.findById", query="SELECT f FROM Flight f WHERE f.id = :id")`
- `@NamedQuery(name="Pilot.findById", query="SELECT p FROM Pilot p WHERE p.id = :id")`

The query `SELECT f FROM Flight f WHERE f.id = :id` means:\
select the whole table `Flight` which will be called everywhere (from now) `f`. Then from it, select the row which it's `id -> (f.id)` is equal to given `id -> (:id)`.


#### JPA 10: Using named queries to query by id
- `FlightService`


#### JPA 11: Adding pilots to a flight - One to Many relationship completed
- `FlightService`
- `AddPilotToFlight`


#### JPA 12: Reading the list of available flights
- `getFlights(#)` added to `FlightService`


#### JPA 13: Creating a list of flights JSP
- `Flights`
- `flights_list.jpa`
	- NOTE:
	For printing some data in HTML, it must be put inside `<%= ... %>` and for running a code without any result being printed, use `<% ...; %>`. Take care of using `;` when needed.



#### JPA 14: Displaying in our flights JSP the pilots that belong to each flight
- `flights_list.jpa`



#### JPA 15: Cascading and propogation of persist and remove actions
- `Flight` > `@OneToOne (cascade = {CascadeType.PERSIST, CascadeType.REMOVE})`
- `FlightService`


#### JPA 16: Reading the list of all passengers
- `getPassengers(#)` added to `PassengerService`
- `Passengers`


#### JPA 17: Creating a list of passengers JSP
- `passengers_list.jpa`


#### JPA 18: Adding a JSP file of forms to add flights, passengers, pilots and airplanes
- `FancyForms` & `fancy_forms.jsp`


#### JPA 19: Adding a flight through our JSP form
- `AddFlight`


#### JPA 20: Adding pilots to flights through our JSP form
- `CreatePilotAndAddToFlight`
- `PilotService` > `addNewPilotToFlight`


#### JPA 21: Many to Many annotations flights and passengers
- `Flight`
```java
	@ManyToMany
	@JoinTable(name = "f_p_join" , joinColumns = @JoinColumn(name="flight_fk"), inverseJoinColumns = @JoinColumn(name="passenger_fk"))
	private List<Passenger> passengers;
```
- `Passenger`
```java
	@ManyToMany(mappedBy = "passengers")
	private List<Flight> flights;
```


# [How To Use](#)
- You need a [GlassFish](https://javaee.github.io/glassfish/) server for running the projects. 
- Import each project you need
- Add it to the server

Note:
 #1: It is better not to add more than one project at a time. I did not change all the configuration,\
 paths & ... of the projects, so there maybe there is some conflicts while running the application\
 on the server.\
 \
 #2: Use the application via your browser at the address `localhost:8080/project_name/servlet_name`\
 \
 #3: Try to exit the browser (to terminate the project's session), and open the newly deployed\
 project, in a new browser.


# [Technologies](#)
- Eclipse IDE
- Java 1.8
- GlassFish5
- Apche Derby DB [is included in GlassFish5]