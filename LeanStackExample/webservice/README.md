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
localhost:8080/api/greetings
