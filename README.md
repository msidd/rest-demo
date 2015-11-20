# Rest Demo
Sample application to demo Spring-Data-Rest-Mongo Capabilities
To run , make sure that you have java 8 , and maven 3.x installed
Do the following
* git clone https://github.com/msidd/rest-demo.git
*  run mvn `./mvnw spring-boot:run` or mvn spring-boot:run
*  To see users in the embeded mongo curl http://localhost:8080/users  or for pagination  something like http://localhost:8080/users?size=2&page=2
*  To see list of files in the current working directory do curl http://localhost:8080/directoryList or specify directory like http://localhost:8080/directoryList?dirname=/tmp

