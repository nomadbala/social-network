# Spring Boot Social Network

## Description
This is a little pet project that i made with my good friend Ilya. This project represents a simple rest api for social network. To access the features, user need to register on the website. Then they can modify their user pages and make, read, like posts of other peoples.
For authentication mechanism we used a JWT based Spring Security authentication. The project follows a SOLID and Clean Code principals

### Technologies used
* Spring ( Boot, Framework, Security )
* Java
* Liquibase
* Lombok
* Spring Data JPA ( Hibernate )
* json-web-token
* PostgreSQL
* OpenApi
* SwaggerUI

### Features
* Authentic user registration with implemented JWT token based authorization
* ORM using Hibernate
* Database migration with Liquibase
* Create, read, like and etc. with posts
* Included OpenApi and SwaggerUI to see all project`s endpoints and get an example how to use it

### Getting started
To get started with this project, you can run it locally or Using Docker

#### Running Locally
1. Clone this repository to your local machine.
2. Configure the database settings in application.yml and liquibase.properties.
3. Build and run the application using Maven or Gradle.
4. Access the API endpoints to interact with the service.
   
#### Running with Docker
1. Clone this repository to your local machine.
2. Make sure you have Docker and Docker Compose installed on your system.
3. Open a terminal and navigate to the project directory.
4. Run the following command to build and start the application:
```
docker-compose up --build
```
5. Once the containers are up and running, the application will be accessible at http://localhost:8080.
6. Access the API endpoints to interact with the service.
By default, the Docker Compose configuration will spin up a PostgreSQL container alongside the Spring Boot application.


### API Endpoints
```
/api/auth
  POST /api/auth/register - Register a new user
  POST /api/auth/login - Login to the application and receive a JWT Token
```

And also you can see all endpoints and examples to use, by running your project and visit localhost:8080/swagger-ui.html

### Contributing
Conribution are welcome! Feel free to open issues or pull requests to suggest improvements or report bugs.

### License
This project doesn`t have any license yet.
