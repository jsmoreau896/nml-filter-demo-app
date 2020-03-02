# Search Filter Demo Application

### Assignent Details ###
Create a responsive (phone, tablet, desktop) web application that allows the user to quick filter a list of things.  The top of the page will have a search input field and then below that a list of things in response to the filter. The things should be sorted alphabetically.  The things could be anything, but should be AJAX pulled from a backend service that you write and should ultimately be pulled from an open public API.  
 
 
 
## Spring Backend (API / Fronend) ##
This is a Spring Boot with MVC.  It has both a frontend for the traditional JSP approach.  It also exposes an API for the ReactJS application to call into to retrieve the data.

### Run Application ###
To run jar from cmd line:
java -jar target/springbootweb-0.0.1-SNAPSHOT.jar

To run using Maven
mvn spring-boot:run


### Spring URL ###

http://localhost:8080/demo/home



## React Frontend ##
This is a ReactJS application that calls to the Spring Boot application's API. 

### Start Application ###
CD to /react-frontend-app directory. Open a Git Bash terminal and type the following command:
yarn start


### ReactJS Default URL ###
http://localhost:3000/
