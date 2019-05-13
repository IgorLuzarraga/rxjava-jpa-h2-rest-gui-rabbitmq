BOOK'S REACTIVE REPOSITORY WITH JPA-H2, REST, GUI AND RABBITMQ
==============

Spring Boot application that implements a book's repository using 
CRUD (Create, Read, Update, Delete) operations to create and 
recover objects (books) stored in a H2 data base using 
Spring Data JPA.
The CRUD operations are made via RESTful and/or the Vaadin framework.
When a CRUD operation is made, the application sends a message
to the Log Server via RabbitMQ, to log the operation.
Note: the Server Log is located in my repository "Log Server"

Modules:
========
- Spring Boot
- Spring Data JPA
- Spring Boot - HATEOAS for RESTful Services
- Spring Boot Web 
- H2 In-Memory Database
- Vaadin - Java web framework - https://vaadin.com
- RxJava2
- Spring Boot amqp
- RabbitMQ (https://www.rabbitmq.com/)

Build the jar:
-------------------------
./gradlew build

Run the jar:
-------------------------
java -jar build/libs/rxjava-jpa-h2-rest-gui-rabbitmq-0.0.1-SNAPSHOT.jar

Test the application:
-------------------------
In order to receive the sended log messages when a CRUD operation 
is made, you need:
1. download RabbitMQ, install and start the service
2. download the Server Log (receives the log messages) and 
start the service
Note: the Server Log is located in my repository "Log Server"
3. Start this application.
 
The project consists of two Http Serves:
1. http://localhost:8080/books - Restful web Service
2. http://localhost:8090 Log Server
RabbitMQ sends the messages between these two servers.

You can work with CRUD operations in two ways:

1. Connect to the server via http://localhost:8080/books using
for example a Restful API tester, like Postman, and check the 
CRUD operations.
Note: the json input for PUT or POST should be like:

{
	"author" : "book´s author",
	"title" : "book´s title"
}

2. Connect to the server http://localhost:8080 and use the GUI to
check the CRUD operations.

To check the logs sended to the Log server connect to
http://localhost:8090 using a web browser.

You can see that the application is reactive, opening more than 
one connections to the server http://localhost:8080 and, check that 
any time you realize a CRUD operation with one client (web browser
or postman) the others clients are automatically updated.