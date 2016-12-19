# Bug web service 
TBD 

# run from IDE or with code
mvn clean 
mvn spring-boot:run

# Deploy and run from jad
mvn clean package

=> this will generate a Jar file in target folder. The name of the jar file will be "spring-boot-webservice-1.0.SNAPSHOT.jar" 
so, you need to copy that and put in any folder you like. This is standalone runner (jetty server built in) . Now, from commandline 

java -jar <generated jar>

# URL config 
Host : localhost
Port :9100
Paths : (TBD)
1. GET : /table/bugs
2. POST : /table/bugs
3. GET : /table/bugs/{id}
4. POST : /table/bugs/{id}
5. PUT : /table/bugs/{id}
6. DELETE : /table/bugs/{id}
7. POST : /table/bugs/{id}/send

# Authentication 
Basic Auth with spring boot module . See properties 

# Properties 
See , resources/config folder for configuration. 

# HSQL DB 
see resources/data folder
 
Initially only 2 record is included. 
 