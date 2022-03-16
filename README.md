# Product Management Software Backend

## Project Description
A Java-based web backend for use in a warehouse environment. It allows for creating, updating, deleting, and querying information about products, shipments, customers, and orders. The API uses JSON for all inserting, updating, and deleting inputs. It also uses JSON for all outputs other than deletes. It also works with the front-end project at [Product Management Software React Front-End](https://github.com/nwarner31/RevatureProject1UI).

## Technologies Used

- Spring 2.6.4
- Log4j 1.2.17
- Java 8
- Microsoft Azure Database 

## Features
Implemented:
- Spring Annotations for ORM mapping
- Mapping of controllers to request inputs
- Repository queries for desired functionality

To-do list:
- Add checks for current stock for orders
- Add security for passwords with hashing

## Getting Started
- Have Java 8 or above installed
- Download and install Maven
- Have git installed
- Run `git clone https://github.com/nwarner31/RevatureProject1` to clone repository to local machine
- Change connection string, username, and password in the application.properties file
- If using a database other than SQL Server, update the driver in the pom.xml file

## Usage
This project is to be used with a program such as Postman that can make post, put, and delete requests or to develop a user interface that consumes the API methods.
