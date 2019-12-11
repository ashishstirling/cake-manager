# cake-manager
Cake Manager based on requirements at https://github.com/Waracle/cake-manager

Requirements:
* By accessing the root of the server (/) it should be possible to list the cakes currently in the system. This must be presented in an acceptable format for a human to read.

* It must be possible for a human to add a new cake to the server.

* By accessing an alternative endpoint (/cakes) with an appropriate client it must be possible to download a list of
the cakes currently in the system as JSON data.

* The /cakes endpoint must also allow new cakes to be created.

Comments:
* We feel like the software stack used by the original developer is quite outdated, it would be good to migrate the entire application to something more modern.
* Would be good to change the application to implement proper client-server separation via REST API.

Process adopted:

* I cloned the original project from https://github.com/Waracle/cake-manager.git to understand what the project was doing and what it was supposed to do
* I studied the code
* Assumptions based on code analysis:
    * Project is supposed to list out data held on cakes in an in-memory database
    * Example data - https://gist.githubusercontent.com/hart88/198f29ec5114a3ec3460/raw/8dd19a88f9b8d24c23d9960f3300d0c917a4f07c/cake.json
    * Example data consists of 5 cakes repeated 4 times
    * The repetition is not required and just displaying data once will be ideal
    * Data needs to be saved in an in-memory database which will be refreshed every time the application is restarted
* I created a repository at - https://github.com/ashishstirling/cake-manager
* I cloned this locally and opened it as a project in intelliJ idea
* Next, I went to Spring Initializr - https://start.spring.io/ - to create a shell for the application
* I imported the application code into my local copy of the repository
* I planned my approach as follows:
    * I would need an in-memory database, a schema and a single table
    * I would need test data which I could copy from the Example JSON data
    * I would need a Model class, REST controller class, service class, and a Dao class
    * I would need to create Test classes to test the Model, the REST controller, the service and the Dao first
    * Lowest in the rung would be the Model Test class
    * Then the Dao Test class
    * Then the Service Test class
    * Then the Controller Test class
    * At the outset, the tests would fail
    * I would then write code to satisfy the failing tests in true TDD spirit
    * I proceeded to create the Model Test and Model classes CakeTest and Cake
    * Next, I did the same for Dao, Service and Controller layers
    * As per requirements, I needed to be able to do the following:
        * Return all the cake rows
        * Add one additional cake row
    * For testing, I also added ability to delete all cakes
    * Once I had the ability to return all cakes at GET /cakes and create a new cake at POST /cakes, I was ready to present the data to the user
    * At this point, I worked on index.html and index.js
        * index.html has a button to newcake.html and a table that displays all cakes
        * index.js makes an AJAX call to GET /cakes to get a JSON list of cakes when index.html is loaded
        * index.js then populates the cakes table with list of cakes
    * newcake.html displays a simple bootstrap form
        * Once the user fills out title, description and image URL of a new cake and clicks on "Save Cake" button, the savecake() function in newcake.js is executed
        * savecake() function does very basic validation to ensure that title, description and image URL have been filled
        * savecake() then makes an AJAX POST call to /cakes with JSON representing the new cake
        * Upon success, savecake() forwards the control back to index.html which loads the list of cakes and displays it
    * Once the project was tested, was building and was running locally as expected, I proceeded to circleci.com to enable continuous integration
    * Create Docker container for the application

URLs:
* Project github: https://github.com/ashishstirling/cake-manager
* CircleCI: https://circleci.com/gh/ashishstirling/cake-manager

Bonus features implemented:
* Tests
* Continuous Integration via any cloud CI system
* Containerization

To run:
* git clone project to local computer from https://github.com/ashishstirling/cake-manager.git
* At terminal window, change directory to the project folder
* Here, run following command:
```
mvnw spring-boot:run
```
* Next, visit http://localhost:8080 to view list of cakes
* Visiting http://localhost:8080/cakes will display list of cakes in JSON format as per requirements
* http://localhost:8080 has a "New Cake" button. Clicking on that will take the user to http://localhost:8080/newcake.html - user can create a new cake here

Containerization:
* I have added Dockerfile to the project to run the spring-boot application within a Docker container. In order to use this at your end, please do the following:
* At terminal window, change directory to the project folder (please ensure that you shutdown the application started above first)
```
docker build -t spring-boot-app:latest .
docker run -d -p 8080:8080 spring-boot-app:latest
```
* This will build the container with name spring-boot-app and will run an image of it
* You can visit http://localhost:8080 and view the application as before
