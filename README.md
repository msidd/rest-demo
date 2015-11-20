# Rest Demo
Sample application to demo Spring-Data-Rest-Mongo capabilities. To run , make sure that you have java 8 , and maven 3.x installed
Once fired, this application instantiate in memory mongo db and populate 10 users in the database. And exposes following end ponints as rest


Do the following
* git clone https://github.com/msidd/rest-demo.git
*  run  mvn spring-boot:run
*  To see users in the embeded mongo curl http://localhost:8080/users  or for pagination  something like http://localhost:8080/users?size=2&page=2
*  To see list of files in the current working directory do curl http://localhost:8080/directoryList or specify directory like http://localhost:8080/directoryList?dirname=/tmp
*  To check the health of system do curl http://localhost:8080/health , it will respond with health of the system as well as the DB
*  To authenticate using json payload do curl http://localhost:8080/login -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"username":"msidd1","password":"user1"}'
