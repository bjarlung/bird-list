# Bird List

JavaEE school project. Birder list web page for users to create, save and update their bird lists.

## Getting started

### Prerequisites
* Eclipse Oxygen
* MongoDB 3.4.2
* XAMPP 3.2.2
* TomEE 8.5
* Git, github

### Install and Run

* Clone project https://github.com/bjarlung/bird-list.git
* Import project to eclipse
* Set up TomEE server
* Create SQL database in XAMPP console as follows:  
  CREATE DATABASE bird_list;  
  USE bird_list;  
  CREATE TABLE users(user_id int(11) NOT NULL AUTO_INCREMENT, username varchar(32) NOT NULL UNIQUE, password varchar(32), fname varchar(32), lname varchar(32), PRIMARY KEY (user_id));
 * If you have a custom login on Xampp, adjust database login in JDBCUtil class
* Start MongoDB
* Run program on server
* Enter http://localhost:8080/BirdListJSF into web browser

## Technologies / Frameworks

* Java 8
* Maven 4.0.0
* JSF
* Primefaces 6.0
* JDBC, mysql connector 5.1.6

## References
* The data table in profile was inspired by Chad Darbys (luv2code) videos on JSF, css was copied 

## Author
* Beatrice Järlung



