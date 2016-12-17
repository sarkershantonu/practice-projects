# Lean Stack Example Wenservice
This is just a small practice webservice from lean stack example . 
Initially i used Eclipse, but later on I used IntelliJ. 

# run from IDE or with code
mvn clean 
mvn spring-boot:run

# Deploy and run from jad
mvn clean package

=> this will generate a Jar file in target folder. The name of the jar file will be "spring-boot-webservice-1.0.SNAPSHOT.jar" 
so, you need to copy that and put in any folder you like. This is standalone runner (jetty server built in) . Now, from commandline 

java -jar spring-boot-webservice-1.0.SNAPSHOT.jar

# URL config 
Host : localhost
Port :8080
Paths : 
1. GET : /api/greetings
2. POST : /api/greetings
3. GET : /api/greetings/{id}
4. POST : /api/greetings/{id}
5. PUT : /api/greetings/{id}
6. DELETE : /api/greetings/{id}
7. POST : /api/greetings/{id}/send

# Authentication 
Basic Auth with spring boot module . See properties 

# Properties 
See , resources/config folder for configuration. 

# HSQL DB 
see resources/data folder
 
Initially only 2 record is included. 
 
# Tutorial by Lean Stack : 
 https://www.youtube.com/playlist?list=PLGDwUiT1wr6-Fn3N2oqJpTdhGjFHnIIKY